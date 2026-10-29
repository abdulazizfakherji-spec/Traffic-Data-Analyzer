
# Traffic Data Analyzer

A Java console application for analyzing vehicle traffic data from CSV files.

## Features

- Load vehicle data from a CSV file
- Calculate the total number of vehicles
- Calculate average vehicle speed
- Identify the maximum recorded speed
- Count vehicles exceeding a configurable speed limit
- Handle invalid CSV records
- Display traffic statistics in the console

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Java Collections
- Java Streams
- File I/O
- CSV Data Processing

## Project Structure

Traffic-Data-Analyzer/
├── src/
│   ├── Main.java
│   ├── Vehicle.java
│   └── TrafficAnalyzer.java
├── traffic.csv
└── README.md

## Example Output

Traffic data loaded successfully.

=== Traffic Data Analyzer ===
Total vehicles: 8
Average speed: 93.75 km/h
Maximum speed: 130.0 km/h
Speed limit: 80.0 km/h
Speeding vehicles: 5

## How to Run

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java 17 or newer is installed.
4. Run Main.java.

The application reads vehicle data from traffic.csv
in the project root directory.
