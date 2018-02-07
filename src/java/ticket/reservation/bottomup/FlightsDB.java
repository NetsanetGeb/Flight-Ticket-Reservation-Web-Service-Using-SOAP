package ticket.reservation.bottomup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FlightsDB {

    public static final String SECRET_TOKEN = "AuthorizedSecretTokenWhichAllowsAccess";

    private static Map<String, String> users;
    private static List<Flight> flights;

    public FlightsDB() {
    }

    public static void init() {
        generateUsers();
        generateFlights();
    }

    private static void generateUsers() {
        users = new HashMap<>();

        users.put("Netsi", "Netsi");
        users.put("Adisu", "Adisu");
        users.put("Beti", "Beti");
    }

    private static void generateFlights() {
        flights = new ArrayList<>();

        for (int i = 0; i < 80; i++) {
            String departureCity = "";
            String destinationCity = "";
            String date = "";
            int price = (int) (Math.random() * 500) + 200;

            switch (((int) (Math.random() * 5))) {
                case 0:
                    departureCity = "Stockholm";
                    break;
                case 1:
                    departureCity = "Copenhagen";
                    break;
                case 2:
                    departureCity = "Amsterdam";
                    break;
                case 3:
                    departureCity = "Rome";
                    break;
                case 4:
                    departureCity = "Adis Abeba";
                    break;
            }

            switch (((int) (Math.random() * 5))) {
                case 0:
                    destinationCity = "Stockholm";
                    break;
                case 1:
                    destinationCity = "Copenhagen";
                    break;
                case 2:
                    destinationCity = "Amsterdam";
                    break;
                case 3:
                    destinationCity = "Rome";
                    break;
                case 4:
                    destinationCity = "Addis Abeba";
                    break;
            }

            switch (((int) (Math.random() * 5))) {
                case 0:
                    date = "2018-02-10";
                    break;
                case 1:
                    date = "2018-02-11";
                    break;
                case 2:
                    date = "2018-02-12";
                    break;
                case 3:
                    date = "2018-02-13";
                    break;
                case 4:
                    date = "2018-02-14";
                    break;
            }

            if (!departureCity.equals(destinationCity)) {
                flights.add(new Flight(departureCity, destinationCity, date, price));
            }
        }
    }

    public static List<Itineary> getIntinearies(String departureCity, String destinationCity, String date) {
        List<Itineary> itinearies = new ArrayList<>();

        //Find direct flights
        for (Flight flight : flights) {
            if (flight.getDepartureCity().equals(departureCity)
                    && flight.getDestinationCity().equals(destinationCity)
                    && (date == null || flight.getDate().equals(date))) {
                List<Flight> flightsOfItineary = new ArrayList<>();
                flightsOfItineary.add(flight);
                Itineary itineary = new Itineary(departureCity, destinationCity, flightsOfItineary);
                itinearies.add(itineary);
            }
        }

        //Find flights with 1 stop
        for (Flight flight : flights) {
            if (flight.getDepartureCity().equals(departureCity)
                    && (date == null || flight.getDate().equals(date))) {
                List<Flight> flightsOfItineary = new ArrayList<>();
                flightsOfItineary.add(flight);
                for (Flight flightTwo : flights) {
                    if (flightTwo.getDepartureCity().equals(flight.getDestinationCity())
                            && flightTwo.getDestinationCity().equals(destinationCity)
                            && ((date == null && flightTwo.getDate().compareTo(flight.getDate()) >= 0) || flightTwo.getDate().equals(date))) {
                        flightsOfItineary.add(flightTwo);
                        Itineary itineary = new Itineary(departureCity, destinationCity, flightsOfItineary);
                        itinearies.add(itineary);
                        break;
                    }
                }
            }
        }

        return itinearies;
    }

    public static boolean authorize(String username, String password) {
        return users.containsKey(username) && password.equals(users.get(username));
    }
    
    public static List<Flight> listFlight(){
       return flights;
    }

}
