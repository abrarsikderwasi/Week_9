package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class containing only static statistics methods.
 */
public class ChampionshipStatistics {

    public static double averagePointsPerDriver() {

        ChampionshipManager manager = ChampionshipManager.getInstance();

        if (manager.getDrivers().isEmpty()) {
            return 0;
        }

        return (double) ChampionshipManager.getTotalChampionshipPoints()
                / manager.getDrivers().size();
    }

    public static String mostSuccessfulCountry() {

        ChampionshipManager manager = ChampionshipManager.getInstance();
        Map<String, Integer> pointsByCountry = new HashMap<>();

        for (Driver driver : manager.getDrivers()) {

            pointsByCountry.put(
                    driver.getCountry(),
                    pointsByCountry.getOrDefault(driver.getCountry(), 0)
                            + driver.getTotalPoints()
            );
        }

        return pointsByCountry.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public static int totalRacesHeld() {
        return ChampionshipManager.getInstance().getTotalRaces();
    }
}