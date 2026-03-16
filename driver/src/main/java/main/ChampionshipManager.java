package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Singleton class responsible for managing the championship.
 */
public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers = new ArrayList<>();
    private List<RaceResult> raceResults = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRaceResult(RaceResult result) {
        raceResults.add(result);
    }

    public List<Driver> getStandings() {
        drivers.sort(Comparator.comparingInt(Driver::getTotalPoints).reversed());
        return drivers;
    }

    public static Driver getLeadingDriver() {
        ChampionshipManager manager = getInstance();

        return manager.drivers.stream()
                .max(Comparator.comparingInt(Driver::getTotalPoints))
                .orElse(null);
    }

    public static int getTotalChampionshipPoints() {
        ChampionshipManager manager = getInstance();

        return manager.drivers.stream()
                .mapToInt(Driver::getTotalPoints)
                .sum();
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public int getTotalRaces() {
        return raceResults.size();
    }

    public List<Driver> getDrivers() {
        return drivers;
    }
}