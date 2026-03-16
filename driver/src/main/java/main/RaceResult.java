package main;

import java.util.Map;

/**
 * Interface defining how race results should behave.
 */
public interface RaceResult {

    void recordResult(Driver driver, int position);

    Map<Driver, Integer> getResults();

    String getRaceName();
}