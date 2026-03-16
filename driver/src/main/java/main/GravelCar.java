package main;

/**
 * Car optimized for gravel rally stages.
 */
public class GravelCar extends RallyCar {

    public GravelCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return horsepower * 1.35 + 18.5;
    }
}