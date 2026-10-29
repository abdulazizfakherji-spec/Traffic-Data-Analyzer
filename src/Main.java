
public class Main {

    public static void main(String[] args) {

        TrafficAnalyzer analyzer = new TrafficAnalyzer();

        analyzer.loadFromCSV("traffic.csv");

        double speedLimit = 80;

        System.out.println("\n=== Traffic Data Analyzer ===");
        System.out.println("Total vehicles: "
                + analyzer.getTotalVehicles());
        System.out.println("Average speed: "
                + analyzer.getAverageSpeed() + " km/h");
        System.out.println("Maximum speed: "
                + analyzer.getMaxSpeed() + " km/h");
        System.out.println("Speed limit: "
                + speedLimit + " km/h");
        System.out.println("Speeding vehicles: "
                + analyzer.countSpeedingVehicles(speedLimit));
    }
}
