package java_Airline;

public class Passenger {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String passportNumber;
    private String passportExpiryDate;
    private String nationality;
    private String emergencyContact;

    public Passenger(String id, String name, String email, String phoneNumber, String dateOfBirth, String passportNumber,
                     String passportExpiryDate, String nationality, String emergencyContact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
        this.passportExpiryDate = passportExpiryDate;
        this.nationality = nationality;
        this.emergencyContact = emergencyContact;
    }

    public String getPassengerInfo() {
        return String.format("ID: %s\nName: %s\nEmail: %s\nPhone: %s\nDOB: %s\nPassport: %s\nExpiry Date: %s\nNationality: %s\nEmergency Contact: %s",
                id, name, email, phoneNumber, dateOfBirth, passportNumber, passportExpiryDate, nationality, emergencyContact);
    }
}
