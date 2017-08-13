package gwtTest.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import gwtTest.client.GwtTestServiceAsync;
import gwtTest.client.events.*;
import gwtTest.client.views.ContractView;

public class ContractViewPresenter implements Presenter {
    public interface Display{
        Widget asWidget();
        HasClickHandlers getChooseClientButton();
        HasClickHandlers getBackToContractsButton();
        HasClickHandlers getEditClientButton();
        HasClickHandlers getCalculateButton();
        HasClickHandlers getSaveContractButton();
    }

    final ContractViewPresenter.Display display;
    final HandlerManager eventBus;
    final GwtTestServiceAsync rpcService;

    public ContractViewPresenter(GwtTestServiceAsync rpcService, Display display, HandlerManager eventBus){
        this.display = display;
        this.eventBus = eventBus;
        this.rpcService = rpcService;
    }

    public void init(){
        display.getChooseClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new OpenChooseClientViewEvent());
            }
        });
        display.getBackToContractsButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new OpenContractListEvent());
            }
        });
        display.getEditClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new EditClientEvent("111111111"));
            }
        });
        display.getCalculateButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new CalculateEvent());
            }
        });
        display.getSaveContractButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new SaveContractEvent());
            }
        });
    }

    public void go(final HasWidgets container){
        init();
        container.clear();
        container.add(display.asWidget());
    }

    public ContractViewPresenter.Display getView(){
        return display;
    }
}
