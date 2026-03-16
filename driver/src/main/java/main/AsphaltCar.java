[21:00, 16/03/2026] Sanjida apu LUT: package main;

/**
 * Car optimized for asphalt rally stages.
 */
public class AsphaltCar extends RallyCar {

    public AsphaltCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return horsepower * 1.40 + 31;
    }
}
[21:00, 16/03/2026] Sanjida apu LUT: package main;

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