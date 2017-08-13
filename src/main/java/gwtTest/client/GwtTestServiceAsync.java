package gwtTest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GwtTestServiceAsync {
    void getMessage(AsyncCallback<String> async);
}
