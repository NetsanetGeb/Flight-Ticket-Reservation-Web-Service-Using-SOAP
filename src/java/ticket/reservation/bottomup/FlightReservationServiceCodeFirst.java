 package ticket.reservation.bottomup;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;


@WebService(serviceName = "FlightReservationServiceCodeFirst")
//@Stateless()
public class FlightReservationServiceCodeFirst {

    public FlightReservationServiceCodeFirst() {
        FlightsDB.init();
    }

    /**
     * Authorizes the user for future use of the service.
     *
     * @param username Username for user account
     * @param password Password for user account
     * @return Authorization token used in other operations
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username,
            @WebParam(name = "password") String password) throws UnauthorizedException {
        if (FlightsDB.authorize(username, password)) {
            return FlightsDB.SECRET_TOKEN;
        }

        throw new UnauthorizedException("Not authorized");
    }

    /**
     * Returns an itineary for provided details.
     *
     * @param authToken Authorization token for granting access to operation.
     * @param departureCity Departure city
     * @param destinationCity Destination city
     * @return Itineary for provided details
     * @throws java.lang.Exception If unauthorized
     */
    @WebMethod(operationName = "getItinearies")
    public List<Itineary> getItinearies(@WebParam(name = "authToken") String authToken,
            @WebParam(name = "departureCity") String departureCity,
            @WebParam(name = "destinationCity") String destinationCity,
            @WebParam(name = "date") String date) throws UnauthorizedException {
        if (!authToken.equals(FlightsDB.SECRET_TOKEN)) {
            throw new UnauthorizedException("Not authorized");
        }

        return FlightsDB.getIntinearies(departureCity, destinationCity, date);
    }

    // @WebMethod(operationName = "listItinearies" )
     @WebMethod(exclude=true)
    public List<Flight> listFlights() throws UnauthorizedException {
        return FlightsDB.listFlight();
    }
}
