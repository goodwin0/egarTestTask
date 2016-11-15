package webservice;

import javax.jws.WebService;
import java.util.Date;

/**
 * Implementation of TimeServer
 * @see TimeServer
 */

@WebService(endpointInterface = "webservice.TimeServer")

public class TimeServerImpl implements TimeServer {

    public String getTimeAsString() { return new Date().toString(); }
    public long getTimeAsElapsed() { return new Date().getTime(); }

}