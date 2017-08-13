package gwtTest.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import gwtTest.client.GwtTestServiceAsync;
import gwtTest.client.events.ChooseClientEvent;
import gwtTest.client.events.CreateClientEvent;
import gwtTest.client.events.OpenContractEvent;

public class ChooseClientViewPresenter implements Presenter {

    public interface Display {
        Widget asWidget();
        HasClickHandlers getCloseChooseClientViewButton();
        HasClickHandlers getChooseClientButton();
        HasClickHandlers getNewClientButton();
    }

    final Display display;
    final HandlerManager eventBus;
    final GwtTestServiceAsync rpcService;

    public ChooseClientViewPresenter(GwtTestServiceAsync rpcService, Display display, HandlerManager eventBus) {
        this.rpcService = rpcService;
        this.display = display;
        this.eventBus = eventBus;
    }

    private void init() {
        display.getCloseChooseClientViewButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new OpenContractEvent());
            }
        });
        display.getNewClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new CreateClientEvent());
            }
        });
        display.getChooseClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new ChooseClientEvent("1111111"));
            }
        });
    }

    public void go(HasWidgets container) {
        init();
        container.clear();
        container.add(display.asWidget());
    }
}
