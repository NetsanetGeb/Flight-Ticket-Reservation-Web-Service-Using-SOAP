
package ticket.reservation.test.client;
 import javax.xml.soap.*;
public class TestBookItineary {
 public static void main(String args[]) {
        /*
            The example below requests from the Web Service at:
             http://www.webservicex.net/uszip.asmx?op=GetInfoByCity


            To call other WS, change the parameters below, which are:
             - the SOAP Endpoint URL (that is, where the service is responding from)
             - the SOAP Action

            Also change the contents of the method createSoapEnvelope() in this class. It constructs
             the inner part of the SOAP envelope that is actually sent.
         */
        String soapEndpointUrl = "http://desktop-5p2aca9:8080/Ticket_Reservation_WebService/FlightReservationServiceContractFirst";
        String soapAction = "http://desktop-5p2aca9:8080/Ticket_Reservation_WebService/FlightReservationServiceContractFirst/bookTicket";

        callSoapWebService(soapEndpointUrl, soapAction);
    }
     
      private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace ="tnss";
        String myNamespaceURI ="http://topdown.reservation.ticket/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

            /*
            Constructed SOAP Request Message:
            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.webserviceX.NET">
                <SOAP-ENV:Header/>
                <SOAP-ENV:Body>
                    <myNamespace:GetInfoByCity>
                        <myNamespace:USCity>New York</myNamespace:USCity>
                    </myNamespace:GetInfoByCity>
                </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>
            */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("bookTicket", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("authToken");
        soapBodyElem1.addTextNode("AuthorizedSecretTokenWhichAllowsAccess");
         SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("itineary");
         SOAPElement soapBodyElem3 = soapBodyElem2.addChildElement("departureCity");
         soapBodyElem3.addTextNode("Stockholm");
          SOAPElement soapBodyElem4 = soapBodyElem2.addChildElement("destinationCity");
         soapBodyElem4.addTextNode("Copenhagen");
         SOAPElement soapBodyElem5 = soapBodyElem2.addChildElement("flights");
          SOAPElement soapBodyElem6 = soapBodyElem5.addChildElement("date");
         soapBodyElem6.addTextNode("2018-02-10");
          SOAPElement soapBodyElem7 = soapBodyElem5.addChildElement("departureCity");
         soapBodyElem7.addTextNode("Stockholm");
          SOAPElement soapBodyElem8 = soapBodyElem5.addChildElement("destinationCity");
         soapBodyElem8.addTextNode("Copenhagen");
         SOAPElement soapBodyElem9 = soapBodyElem5.addChildElement("price");
         soapBodyElem9.addTextNode("380");
         SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("cardNumber");
         soapBodyElem10.addTextNode("card1");
    }

       private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
           // System.out.println("-----"+soapResponse);
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }
       
       private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
       // System.out.println("-----"+soapMessage);
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
    
}
