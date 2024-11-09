package java_Airline;

 class Reservation {
    private Passenger passenger;
    private Flight flight;
    private String reservationId;
    private boolean isRefunded; // Track refund status

    public Reservation(String reservationId, Passenger passenger, Flight flight) {
        this.reservationId = reservationId;
        this.passenger = passenger;
        this.flight = flight;
        this.isRefunded = false;
    }

    public String getReservationDetails() {
        if (isRefunded) {
            return "This reservation has been refunded.";
        }
        return "Reservation ID: " + reservationId + "\n" +
               "Passenger Information:\n" + passenger.getPassengerInfo() + "\n" +
               "Flight Information:\n" + flight.getFlightInfo();
    }

    public boolean processRefund() {
        if (!isRefunded) {
            isRefunded = true;
            System.out.println("Reservation " + reservationId + " has been refunded.");
            return true;
        } else {
            System.out.println("This reservation has already been refunded.");
            return false;
        }
    }
}
