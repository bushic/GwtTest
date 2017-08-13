package gwtTest.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import gwtTest.client.GwtTestServiceAsync;
import gwtTest.client.events.CreateContractEvent;
import gwtTest.client.events.OpenChooseClientViewEvent;
import gwtTest.client.events.OpenContractEvent;
import gwtTest.client.events.SaveClientEvent;

public class EditClientViewPresenter implements Presenter {

    public interface Display {
        Widget asWidget();
        HasClickHandlers getSaveClientButton();
        HasClickHandlers getCloseCreateClientView();
    }

    final Display display;
    final HandlerManager eventBus;
    final String type;
    final GwtTestServiceAsync rpcService;

    public EditClientViewPresenter(GwtTestServiceAsync rpcService, Display display, HandlerManager eventBus, String type) {
        this.rpcService = rpcService;
        this.display = display;
        this.eventBus = eventBus;
        this.type = type;
    }

    private void init() {
        display.getCloseCreateClientView().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (type.equals("create"))
                    eventBus.fireEvent(new OpenChooseClientViewEvent());
                else eventBus.fireEvent(new OpenContractEvent());
            }
        });
        display.getSaveClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new SaveClientEvent());
                eventBus.fireEvent(new CreateContractEvent());
            }
        });
    }

    public void go(HasWidgets container) {
        init();
        container.clear();
        container.add(display.asWidget());
    }
}
