package businesslogic;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.airport.NoAirportException;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightFactory;
import persistence.NoDBConnectionException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoDBConnectionException, NoAirportException {
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(AirplaneFactory.createAirplane("boeing-737", "Boeing 737", 32,6));
        airplanes.add(AirplaneFactory.createAirplane("boeing-747", "Boeing 747", 200,1));
        airplanes.add(AirplaneFactory.createAirplane("boeing-777", "Boeing 777", 250,1));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the airplane ID: (boeing-737, boeing-747, boeing-777)");
        Airplane airplane =
                airplanes.stream().filter(a -> a.getId().equals(scanner.nextLine())).findFirst().orElse(null);
        System.out.println("Enter the departure place: ");
        String departurePlace = scanner.nextLine();
        System.out.println("Enter the arrival place: ");
        String arrivalPlace = scanner.nextLine();
        System.out.println("Enter the departure local date time: (yyyy-mm-ddThh:mm:ss)");
        String departureLocalDateTime = scanner.nextLine();
        LocalDateTime departure = LocalDateTime.parse(departureLocalDateTime);
        System.out.println("Enter the arrival local date time: (yyyy-mm-ddThh:mm:ss)");
        String arrivalLocalDateTime = scanner.nextLine();
        LocalDateTime arrival = LocalDateTime.parse(arrivalLocalDateTime);
        Flight flight = FlightFactory.createFlight(AirportFactory.createAirport(departurePlace),
                AirportFactory.createAirport(arrivalPlace), departure, arrival, airplane);
        System.out.println("Flight " + flight.getId() + " created");
        System.out.println(flight);
    }
}