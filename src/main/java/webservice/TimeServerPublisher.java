package webservice;

import javax.xml.ws.Endpoint;

/**
 * This application publishes the web service
 * The application runs indefinitely, awaiting service requests.
 * Service is available by link
 *     http://127.0.0.1:9876/time?wsdl
 */

public class TimeServerPublisher {

    public static void main(String[ ] args) {

       Endpoint.publish("http://127.0.0.1:9876/time", new TimeServerImpl());

    }

}