package main;

/**
 * Abstract base class for rally cars.
 */
public abstract class RallyCar {

    protected String make;
    protected String model;
    protected int horsepower;

    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public abstract double calculatePerformance();

    @Override
    public String toString() {
        return make + " " + model + " (" + horsepower + " HP)";
    }
}