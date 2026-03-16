package main;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelCar = new GravelCar("Toyota", "GR Yaris", 300);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20", 315);

        Driver ogier = new Driver("Sébastien Ogier", "France", gravelCar);
        Driver rovanpera = new Driver("Kalle Rovanperä", "Finland", gravelCar);
        Driver tanak = new Driver("Ott Tänak", "Estonia", asphaltCar);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        RallyRaceResult firstRace = new RallyRaceResult("Rally Finland (Jyväskylä)");
        firstRace.recordResult(ogier, 1);
        firstRace.recordResult(tanak, 2);
        firstRace.recordResult(rovanpera, 3);
        firstRace.recordResult(neuville, 4);

        manager.addRaceResult(firstRace);

        RallyRaceResult secondRace = new RallyRaceResult("Monte Carlo Rally (Monaco)");
        secondRace.recordResult(rovanpera, 1);
        secondRace.recordResult(neuville, 2);
        secondRace.recordResult(ogier, 3);
        secondRace.recordResult(tanak, 4);

        manager.addRaceResult(secondRace);

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");

        int standingPosition = 1;
        for (Driver driver : manager.getStandings()) {
            System.out.println(standingPosition++ + ". " + driver.getName()
                    + " (" + driver.getCountry() + "): "
                    + driver.getTotalPoints() + " points");
        }

        Driver leadingDriver = ChampionshipManager.getLeadingDriver();

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(leadingDriver.getName()
                + " with "
                + leadingDriver.getTotalPoints()
                + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");

        System.out.println("Total Drivers: " + Driver.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.totalRacesHeld());

        String averagePoints = String.format("%.2f",
                ChampionshipStatistics.averagePointsPerDriver()).replace('.', ',');

        System.out.println("Average Points Per Driver: " + averagePoints);

        System.out.println("Most Successful Country: "
                + ChampionshipStatistics.mostSuccessfulCountry());

        System.out.println("Total Championship Points: "
                + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");

        for (RaceResult raceResult : manager.getRaceResults()) {
            System.out.println("Race: " + raceResult.getRaceName());

            int racePosition = 1;
            for (Map.Entry<Driver, Integer> entry : raceResult.getResults().entrySet()) {
                System.out.println(" Position " + racePosition++
                        + ": " + entry.getKey().getName()
                        + " - " + entry.getValue()
                        + " points");
            }
        }

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");

        System.out.println("Gravel Car Performance: "
                + gravelCar.calculatePerformance());

        System.out.println("Asphalt Car Performance: "
                + asphaltCar.calculatePerformance());
    }
}