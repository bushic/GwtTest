package gwtTest.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import gwtTest.client.dto.ClientDTO;
import gwtTest.client.dto.ContractDTO;
import gwtTest.client.events.*;
import gwtTest.client.presenter.*;
import gwtTest.client.views.ChooseClientView;
import gwtTest.client.views.ContractView;
import gwtTest.client.views.EditClientView;
import gwtTest.client.views.MainView;

public class AppController implements ValueChangeHandler<String> {

    private HandlerManager eventBus;
    private HasWidgets container;
    private GwtTestServiceAsync rpcService;
    private ContractDTO currentContract;

    public AppController(GwtTestServiceAsync rpcService,HandlerManager manager){
        this.rpcService = rpcService;
        this.eventBus = manager;
        bindEvents();
    }
    public void bindEvents(){

        History.addValueChangeHandler(this);

        eventBus.addHandler(CreateContractEvent.TYPE, new CreateContractEventHandler(){
            public void onCreateContract(CreateContractEvent event) {
                currentContract = event.getContractDTO();
                History.newItem("addcontract");
            }
        });
        eventBus.addHandler(OpenContractListEvent.TYPE, new OpenContractListEventHandler() {
            public void onOpenContractList(OpenContractListEvent event) {
                History.newItem("list");
            }
        });
        eventBus.addHandler(OpenChooseClientViewEvent.TYPE, new OpenChooseClientViewEventHandler() {
            public void onOpenChooseClientView(OpenChooseClientViewEvent event) {
                History.newItem("chooseclient");
            }
        });
        eventBus.addHandler(OpenContractEvent.TYPE, new OpenContractEventHandler() {
            public void onOpenContract(OpenContractEvent event) {
                currentContract = event.getContractDTO();
                History.newItem("opencontract");
            }
        });
        eventBus.addHandler(CreateClientEvent.TYPE, new CreateClientEventHandler() {
            public void onCreateClient(CreateClientEvent event) {
                History.newItem("newclient");
            }
        });
        eventBus.addHandler(EditClientEvent.TYPE, new EditClientEventHandler() {
            public void onEditClient(EditClientEvent event) {
                History.newItem("editclient");
            }
        });

    }
    public void goTo(HasWidgets page){
        this.container = page;
        if ("".equals(History.getToken())) {
            History.newItem("list");
        }
        else {
            History.fireCurrentHistoryState();
        }
    }

    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();

        if (token != null) {
            Presenter presenter = null;
            if (token.equals("addcontract")) {
                presenter = new ContractViewPresenter(rpcService, new ContractView(), eventBus, currentContract);
            }
            else if (token.equals("list")) {
                presenter = new MainViewPresenter(rpcService, new MainView(), eventBus);
            }
            else if (token.equals("opencontract")) {
                presenter = new ContractViewPresenter(rpcService, new ContractView(), eventBus, currentContract);
            }
            else if (token.equals("chooseclient")){
                presenter = new ChooseClientViewPresenter(rpcService, new ChooseClientView(), eventBus, currentContract);
            }
            else if (token.equals("newclient")){
                presenter = new EditClientViewPresenter(rpcService, new EditClientView("create"), eventBus, currentContract, "create");
            }
            else if (token.equals("editclient")){
                presenter = new EditClientViewPresenter(rpcService, new EditClientView("edit"), eventBus, currentContract,"edit");
            }
            if (presenter != null)
                presenter.go(container);
        }
    }
}
