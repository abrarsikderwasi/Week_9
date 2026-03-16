package main;

/**
 * Driver class stores information about a rally driver.
 */
public class Driver {

    private String name;
    private String country;
    private int totalPoints;
    private RallyCar currentCar;

    private static int totalDrivers = 0;

    public Driver(String name, String country, RallyCar currentCar) {
        this.name = name;
        this.country = country;
        this.currentCar = currentCar;
        this.totalPoints = 0;
        totalDrivers++;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public RallyCar getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(RallyCar currentCar) {
        this.currentCar = currentCar;
    }

    public void addPoints(int pointsToAdd) {
        totalPoints += pointsToAdd;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }
}