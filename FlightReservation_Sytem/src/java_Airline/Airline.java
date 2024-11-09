package java_Airline;

import java.util.HashMap;
import java.util.Map;

public class Airline {
    private String code;
    private String name;
    private Map<Integer, String> destinations;

    public Airline(String code, String name) {
        this.code = code;
        this.name = name;
        this.destinations = new HashMap<>();
    }

    public void addDestinations(Map<Integer, String> newDestinations) {
        destinations.putAll(newDestinations);
    }

    public void displayDestinations() {
        System.out.println("Destinations for " + name + ":");
        destinations.forEach((key, value) -> System.out.println(key + ". " + value));
    }

    public String chooseDestination(int choice) {
        return destinations.getOrDefault(choice, "Invalid destination choice");
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
