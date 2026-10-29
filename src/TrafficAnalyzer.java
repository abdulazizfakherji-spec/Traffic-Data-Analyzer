
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TrafficAnalyzer {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void loadFromCSV(String fileName) {
        vehicles.clear();

        try (BufferedReader reader =
                     Files.newBufferedReader(Path.of(fileName))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length != 2) {
                    System.out.println(
                            "Skipping invalid row: " + line);
                    continue;
                }

                try {
                    String type = parts[0].trim();
                    double speed =
                            Double.parseDouble(parts[1].trim());

                    if (type.isEmpty()
                            || speed < 0
                            || !Double.isFinite(speed)) {

                        System.out.println(
                                "Skipping invalid row: " + line);
                        continue;
                    }

                    addVehicle(new Vehicle(type, speed));

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Skipping invalid row: " + line);
                }
            }

            System.out.println(
                    "Traffic data loaded successfully.");

        } catch (IOException e) {
            System.out.println(
                    "Error reading CSV: " + e.getMessage());
        }
    }

    public int getTotalVehicles() {
        return vehicles.size();
    }

    public double getAverageSpeed() {
        if (vehicles.isEmpty()) {
            return 0;
        }

        double totalSpeed = 0;

        for (Vehicle vehicle : vehicles) {
            totalSpeed += vehicle.getSpeed();
        }

        return totalSpeed / vehicles.size();
    }

    public double getMaxSpeed() {
        double maxSpeed = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getSpeed() > maxSpeed) {
                maxSpeed = vehicle.getSpeed();
            }
        }

        return maxSpeed;
    }

    public long countSpeedingVehicles(double speedLimit) {
        return vehicles.stream()
                .filter(vehicle ->
                        vehicle.getSpeed() > speedLimit)
                .count();
    }
}
