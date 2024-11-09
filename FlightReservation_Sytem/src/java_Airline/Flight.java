package java_Airline;

public class Flight {
    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private String departureTime;
    private String arrivalTime;

    public Flight(String flightNumber, String departureCity, String destinationCity, String departureTime, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFlightInfo() {
        return String.format("Flight Number: %s\nDeparture City: %s\nDestination City: %s\nDeparture Time: %s\nArrival Time: %s",
                flightNumber, departureCity, destinationCity, departureTime, arrivalTime);
    }
}
