package java_Airline;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sample airline setup
        Airline airIndia = new Airline("a", "Air India Airlines");
        airIndia.addDestinations(Map.of(1, "Singapore", 2, "Mumbai", 3, "Paris"));

        Airline indigo = new Airline("i", "Indigo Airlines");
        indigo.addDestinations(Map.of(1, "Hong Kong", 2, "Tokyo", 3, "Bangkok"));

        // Map of airlines
        Map<String, Airline> airlines = new HashMap<>();
        airlines.put(airIndia.getCode(), airIndia);
        airlines.put(indigo.getCode(), indigo);

        Scanner scan = new Scanner(System.in);
        Passenger passenger = null;
        Flight selectedFlight = null;

        System.out.println("Welcome to Airline Reservation System!");

        // Main menu loop
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Choose Airline and Destination");
            System.out.println("2. Enter Passenger Details");
            System.out.println("3. Book a Ticket");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scan.nextInt();
            scan.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Choose an Airline:");
                    for (Airline airline : airlines.values()) {
                        System.out.println(airline.getCode() + ". " + airline.getName());
                    }
                    System.out.print("Enter airline code: ");
                    String airlineCode = scan.nextLine();

                    Airline selectedAirline = airlines.get(airlineCode);
                    if (selectedAirline != null) {
                        System.out.println("You selected: " + selectedAirline.getName());
                        selectedAirline.displayDestinations();
                        System.out.print("Choose a destination number: ");
                        int destChoice = scan.nextInt();
                        scan.nextLine();  // Consume newline
                        String selectedDestination = selectedAirline.chooseDestination(destChoice);
                        System.out.println("Selected destination: " + selectedDestination);

                        // Assume a flight is available for the selected destination
                        selectedFlight = new Flight("AI123", "Delhi", selectedDestination, "10:00 AM", "2:00 PM");
                    } else {
                        System.out.println("Invalid airline code.");
                    }
                    break;

                case 2:
                    // Collecting passenger details
                    System.out.print("Enter Passenger ID: ");
                    String passengerId = scan.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scan.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String dob = scan.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scan.nextLine();
                    System.out.print("Enter Passport Number: ");
                    String passportNumber = scan.nextLine();
                    System.out.print("Enter Passport Expiry Date: ");
                    String passportExpDate = scan.nextLine();
                    System.out.print("Enter Nationality: ");
                    String nationality = scan.nextLine();
                    System.out.print("Enter Emergency Contact: ");
                    String emergencyContact = scan.nextLine();

                    passenger = new Passenger(passengerId, name, email, phoneNumber, dob, passportNumber, passportExpDate, nationality, emergencyContact);
                    System.out.println("\nPassenger Details Collected:");
                    System.out.println(passenger.getPassengerInfo());
                    break;

                case 3:
                    if (passenger == null || selectedFlight == null) {
                        System.out.println("Please select an airline and enter passenger details before booking a ticket.");
                    } else {
                        Ticket ticket = Ticket.bookTicket();  // Book ticket with flight and passenger information
                        if (ticket != null) {
                            System.out.println("Ticket booking completed successfully!");
                            ticket.displayTicketInfo();
                        } else {
                            System.out.println("Ticket booking was not successful. Please try again.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Airline Reservation System!");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}