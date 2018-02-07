
package ticket.reservation.topdown.generated;

import ticket.reservation.topdown.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 *  WSDL File for FlightReservationServiceContractFirst
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FlightReservationServiceContractFirst", targetNamespace = "http://topdown.reservation.ticket/", wsdlLocation = "file:/C:/Users/Ma%20Star/Documents/NetBeansProjects/Ticket_Reservation_WebService/src/conf/xml-resources/web-services/FlightReservationServiceContractFirstService/wsdl/FlightReservationServiceContractFirst.wsdl")
public class FlightReservationServiceContractFirst_Service
    extends Service
{

    private final static URL FLIGHTRESERVATIONSERVICECONTRACTFIRST_WSDL_LOCATION;
    private final static WebServiceException FLIGHTRESERVATIONSERVICECONTRACTFIRST_EXCEPTION;
    private final static QName FLIGHTRESERVATIONSERVICECONTRACTFIRST_QNAME = new QName("http://topdown.reservation.ticket/", "FlightReservationServiceContractFirst");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Ma%20Star/Documents/NetBeansProjects/Ticket_Reservation_WebService/src/conf/xml-resources/web-services/FlightReservationServiceContractFirstService/wsdl/FlightReservationServiceContractFirst.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FLIGHTRESERVATIONSERVICECONTRACTFIRST_WSDL_LOCATION = url;
        FLIGHTRESERVATIONSERVICECONTRACTFIRST_EXCEPTION = e;
    }

    public FlightReservationServiceContractFirst_Service() {
        super(__getWsdlLocation(), FLIGHTRESERVATIONSERVICECONTRACTFIRST_QNAME);
    }

    public FlightReservationServiceContractFirst_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), FLIGHTRESERVATIONSERVICECONTRACTFIRST_QNAME, features);
    }

    public FlightReservationServiceContractFirst_Service(URL wsdlLocation) {
        super(wsdlLocation, FLIGHTRESERVATIONSERVICECONTRACTFIRST_QNAME);
    }

    public FlightReservationServiceContractFirst_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FLIGHTRESERVATIONSERVICECONTRACTFIRST_QNAME, features);
    }

    public FlightReservationServiceContractFirst_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FlightReservationServiceContractFirst_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FlightReservationServiceContractFirst
     */
    @WebEndpoint(name = "FlightReservationServiceContractFirstPort")
    public FlightReservationServiceContractFirst getFlightReservationServiceContractFirstPort() {
        return super.getPort(new QName("http://topdown.reservation.ticket/", "FlightReservationServiceContractFirstPort"), FlightReservationServiceContractFirst.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FlightReservationServiceContractFirst
     */
    @WebEndpoint(name = "FlightReservationServiceContractFirstPort")
    public FlightReservationServiceContractFirst getFlightReservationServiceContractFirstPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://topdown.reservation.ticket/", "FlightReservationServiceContractFirstPort"), FlightReservationServiceContractFirst.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FLIGHTRESERVATIONSERVICECONTRACTFIRST_EXCEPTION!= null) {
            throw FLIGHTRESERVATIONSERVICECONTRACTFIRST_EXCEPTION;
        }
        return FLIGHTRESERVATIONSERVICECONTRACTFIRST_WSDL_LOCATION;
    }

}