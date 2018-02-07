package ticket.reservation.topdown;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "FlightReservationServiceContractFirst", portName = "FlightReservationServiceContractFirstPort", endpointInterface = "ticket.reservation.topdown.FlightReservationServiceContractFirst", targetNamespace = "http://topdown.reservation.ticket/", wsdlLocation = "WEB-INF/wsdl/FlightReservationServiceContractFirstService/FlightReservationServiceContractFirst.wsdl")
public class FlightReservationServiceContractFirstService {
    
     public FlightReservationServiceContractFirstService() {
        TicketService.init();
    }

    public java.lang.String bookTicket(
            @WebParam(name = "authToken") java.lang.String authToken, 
            @WebParam(name = "itineary") ticket.reservation.topdown.Itineary itineary, 
            @WebParam(name = "cardNumber")java.lang.String cardNumber) throws UnauthorizedException {
        
         if (!authToken.equals(TicketService.SECRET_TOKEN)) {
            throw new UnauthorizedException("Not authorized", null);
        }

        if (cardNumber != null && !cardNumber.isEmpty()) {
            String ticketNumber = TicketService.bookTicket(itineary, cardNumber);

            return ticketNumber;
        }

        return null;
    }

    public ticket.reservation.topdown.Ticket issueTicket(
             @WebParam(name = "authToken") java.lang.String authToken, 
             @WebParam(name = "ticketNumber")java.lang.String ticketNumber) throws UnauthorizedException {
       
            if (!authToken.equals(TicketService.SECRET_TOKEN)) {
                throw new UnauthorizedException("Not authorized", null);
            }

            Ticket ticket = TicketService.getTicket(ticketNumber);

            return ticket;
    }
    
}
