package gwtTest.client.presenter;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SingleSelectionModel;
import gwtTest.client.GwtTestServiceAsync;
import gwtTest.client.dto.ClientDTO;
import gwtTest.client.dto.ContractDTO;
import gwtTest.client.events.CreateClientEvent;
import gwtTest.client.events.OpenContractEvent;

import java.util.List;

public class ChooseClientViewPresenter implements Presenter {

    public interface Display {
        Widget asWidget();
        HasClickHandlers getCloseChooseClientViewButton();
        HasClickHandlers getChooseClientButton();
        HasClickHandlers getNewClientButton();
        HasClickHandlers getSearchButton();
        HasValue<String> getSurName();
        HasValue<String> getFirstName();
        HasValue<String> getMiddleName();
        CellTable<ClientDTO> getMainTable();
    }

    final Display display;
    final HandlerManager eventBus;
    final GwtTestServiceAsync rpcService;
    ContractDTO contractDTO;

    public ChooseClientViewPresenter(GwtTestServiceAsync rpcService, Display display, HandlerManager eventBus, ContractDTO contractDTO) {
        this.rpcService = rpcService;
        this.display = display;
        this.eventBus = eventBus;
        this.contractDTO = contractDTO;
    }

    private void init() {
        SingleSelectionModel<ClientDTO> selectionModel = new SingleSelectionModel<ClientDTO>();
        display.getMainTable().setSelectionModel(selectionModel);
        display.getMainTable().addDomHandler(new DoubleClickHandler() {
            public void onDoubleClick(DoubleClickEvent event) {
                ClientDTO selectedItem = (ClientDTO) ((SingleSelectionModel)display.getMainTable().getSelectionModel()).getSelectedObject();
                contractDTO.setClientsByClient(selectedItem);
                eventBus.fireEvent(new OpenContractEvent(contractDTO));
            }
        },DoubleClickEvent.getType());
        display.getCloseChooseClientViewButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new OpenContractEvent(contractDTO));
            }
        });
        display.getNewClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new CreateClientEvent());
            }
        });
        display.getChooseClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ClientDTO selectedItem = (ClientDTO) ((SingleSelectionModel)display.getMainTable().getSelectionModel()).getSelectedObject();
                if (selectedItem != null) {
                    contractDTO.setClientsByClient(selectedItem);
                    eventBus.fireEvent(new OpenContractEvent(contractDTO));
                }else Window.alert("Клиент не выбран");
            }
        });
        display.getSearchButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event){
                searchClients();
            }
        });
    }

    private void searchClients() {
        AsyncCallback<List<ClientDTO>> callback = new AsyncCallback<List<ClientDTO>>() {
            public void onFailure(Throwable caught) {

            }

            public void onSuccess(List<ClientDTO> result) {
                display.getMainTable().setRowCount(result.size(),true);
                display.getMainTable().setRowData(0,result);
            }
        };
        rpcService.getClients(display.getSurName().getValue(),display.getFirstName().getValue(),
                display.getMiddleName().getValue(),callback);
    }

    public void go(HasWidgets container) {
        init();
        container.clear();
        container.add(display.asWidget());
        searchClients();
    }
}
