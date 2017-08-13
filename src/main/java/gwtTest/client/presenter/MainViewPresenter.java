package gwtTest.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import gwtTest.client.GwtTestServiceAsync;
import gwtTest.client.events.CreateContractEvent;
import gwtTest.client.events.OpenContractEvent;
import gwtTest.client.views.MainView;

public class MainViewPresenter implements Presenter {
    public interface Display{
        Widget asWidget();
        HasClickHandlers getCreateButton();
        HasClickHandlers getOpenButton();
    }

    final Display display;
    final HandlerManager eventBus;
    final GwtTestServiceAsync rpcService;

    public MainViewPresenter(GwtTestServiceAsync rpcService, Display display, HandlerManager eventBus){
        this.display = display;
        this.eventBus = eventBus;
        this.rpcService = rpcService;
    }

    public void init(){
        display.getCreateButton().addClickHandler(new ClickHandler(){
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new CreateContractEvent());
            }
        });
        display.getOpenButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new OpenContractEvent());
            }
        });
    }

    public void go(final HasWidgets container){
        init();
        container.clear();
        container.add(display.asWidget());
    }


    public Display getView(){

        return display;
    }
}
