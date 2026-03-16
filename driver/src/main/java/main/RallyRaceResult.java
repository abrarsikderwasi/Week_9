package main;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Concrete implementation of RaceResult.
 * Stores positions and points for a rally race.
 */
public class RallyRaceResult implements RaceResult {

    private String raceName;
    private Map<Driver, Integer> driverPoints = new LinkedHashMap<>();

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public void recordResult(Driver driver, int position) {

        int points;

        switch (position) {
            case 1: points = 25; break;
            case 2: points = 18; break;
            case 3: points = 15; break;
            case 4: points = 12; break;
            default: points = 0;
        }

        driver.addPoints(points);
        driverPoints.put(driver, points);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return driverPoints;
    }

    @Override
    public String getRaceName() {
        return raceName;
    }
}