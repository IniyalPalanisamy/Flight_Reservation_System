package java_Airline;
import java.util.Date;
import java.util.Scanner;

enum FlightClass {
    ECONOMY, BUSINESS, FIRST_CLASS;
}

public class Ticket {

    private static int idCounter = 1; // Static counter for unique ticket IDs
    private static final Scanner scanner = new Scanner(System.in); // Single scanner instance

    private String ticketId;
    private String reservationId;
    private String flightNumber;
    private String passengerId;
    private double price;
    private String seatNumber;
    private Date issueDate;
    private FlightClass flightClass;

    // Prices for each class
    private static final double ECONOMY_PRICE = 100.0;
    private static final double BUSINESS_PRICE = 250.0;
    private static final double FIRST_CLASS_PRICE = 500.0;

    // Seating layout (for simplicity, we'll assume a small flight with 3 rows and 4 seats per row)
    private static String[][] seatingChart = new String[3][4]; // 3 rows, 4 seats per row

    static {
        // Initialize seating chart with "Available" for all seats
        for (int i = 0; i < seatingChart.length; i++) {
            for (int j = 0; j < seatingChart[i].length; j++) {
                seatingChart[i][j] = "Available";
            }
        }
    }

    public Ticket(String reservationId, String flightNumber, String passengerId, String seatNumber, FlightClass flightClass) {
        this.ticketId = generateTicketId();
        this.reservationId = reservationId;
        this.flightNumber = flightNumber;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
        this.flightClass = flightClass;
        this.issueDate = new Date();
        this.price = calculatePrice(flightClass);
        reserveSeat(seatNumber);
    }

    private String generateTicketId() {
        return "TICKET-" + idCounter++;
    }

    private double calculatePrice(FlightClass flightClass) {
        switch (flightClass) {
            case BUSINESS:
                return BUSINESS_PRICE;
            case FIRST_CLASS:
                return FIRST_CLASS_PRICE;
            default:
                return ECONOMY_PRICE;
        }
    }

    public static void displaySeatingChart() {
        System.out.println("Seating Chart (Available seats are shown as 'Available'): ");
        for (int i = 0; i < seatingChart.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < seatingChart[i].length; j++) {
                System.out.print(seatingChart[i][j] + "\t| ");
            }
            System.out.println();
        }
    }

    public static void reserveSeat(String seatNumber) {
        int row = Integer.parseInt(seatNumber.substring(0, 1)) - 1;
        int col = seatNumber.charAt(1) - 'A';
        if (seatingChart[row][col].equals("Available")) {
            seatingChart[row][col] = "Reserved";
        } else {
            System.out.println("Error: Seat " + seatNumber + " is already reserved!");
        }
    }

    public void displayTicketInfo() {
        System.out.println("------------------------");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Passenger ID: " + passengerId);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Flight Class: " + flightClass);
        System.out.println("Price: $" + price);
        System.out.println("Issue Date: " + issueDate);
    }

    public static Ticket bookTicket() {
        displaySeatingChart();
        System.out.println("Select your flight class: \n1. Economy\n2. Business\n3. First Class");
        int classChoice = scanner.nextInt();
        FlightClass selectedClass = classChoice == 2 ? FlightClass.BUSINESS : classChoice == 3 ? FlightClass.FIRST_CLASS : FlightClass.ECONOMY;
        System.out.print("Enter Reservation ID: ");
        String reservationId = scanner.next();
        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.next();
        System.out.print("Enter Passenger ID: ");
        String passengerId = scanner.next();
        System.out.print("Enter Seat Number (e.g., 1A, 2B): ");
        String seatNumber = scanner.next();
        if (!seatingChart[Integer.parseInt(seatNumber.substring(0, 1)) - 1][seatNumber.charAt(1) - 'A'].equals("Available")) {
            System.out.println("Error: Seat " + seatNumber + " is already reserved.");
            return null;
        }
        Ticket ticket = new Ticket(reservationId, flightNumber, passengerId, seatNumber, selectedClass);
        ticket.displayTicketInfo();
        return processPayment(ticket) ? ticket : null;
    }

    public static boolean processPayment(Ticket ticket) {
        System.out.println("Your total ticket price is: $" + ticket.price);
        System.out.print("Enter payment amount: $");
        double paymentAmount = scanner.nextDouble();
        if (paymentAmount >= ticket.price) {
            System.out.println("Payment successful. Change to be returned: $" + (paymentAmount - ticket.price));
            return true;
        } else {
            System.out.println("Insufficient payment. Try again.");
            return false;
        }
    }
}
