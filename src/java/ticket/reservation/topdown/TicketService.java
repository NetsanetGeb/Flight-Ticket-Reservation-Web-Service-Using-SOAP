
package ticket.reservation.topdown;

import java.util.HashMap;
import java.util.Map;



public class TicketService {

    public static final String SECRET_TOKEN ="AuthorizedSecretTokenWhichAllowsAccess";

    private static Map<String, Ticket> tickets;

    public TicketService() {
    }

    public static void init() {
        tickets = new HashMap<>();
    }

    public static String bookTicket(ticket.reservation.topdown.Itineary itineary, String cardNumber) {
        Ticket ticket = new Ticket();
        ticket.setItineary(itineary);
        ticket.setCardNumber(cardNumber);
        ticket.setTicketNumber(String.valueOf((long) (Math.random() * Long.MAX_VALUE)));

        tickets.put(ticket.getTicketNumber(), ticket);

        return ticket.getTicketNumber();
    }

    public static Ticket getTicket(String ticketNumber) {
        return tickets.get(ticketNumber);
    }

}