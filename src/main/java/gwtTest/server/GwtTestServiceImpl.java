package gwtTest.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import gwtTest.client.GwtTestService;

public class GwtTestServiceImpl extends RemoteServiceServlet implements GwtTestService {
    // Implementation of sample interface method
    public String getMessage() {
        return "Hi";
    }
}