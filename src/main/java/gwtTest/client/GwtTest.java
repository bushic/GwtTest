package gwtTest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GwtTest implements EntryPoint {

    public void onModuleLoad() {
        GwtTestServiceAsync gwtTestServiceAsync = GWT.create(GwtTestService.class);
        HandlerManager eventBus = new HandlerManager(null);
        AppController app = new AppController(gwtTestServiceAsync,eventBus);
        app.goTo(RootPanel.get());

    }

}
