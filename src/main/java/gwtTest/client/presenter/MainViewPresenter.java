package gwtTest.client.presenter;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import gwtTest.client.GwtTestServiceAsync;
import gwtTest.client.dto.ContractDTO;
import gwtTest.client.events.CreateContractEvent;
import gwtTest.client.events.OpenContractEvent;

import java.util.List;

public class MainViewPresenter implements Presenter {
    public interface Display{
        Widget asWidget();
        HasClickHandlers getCreateButton();
        HasClickHandlers getOpenButton();
        CellTable<ContractDTO> getMainTable();
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

        getContracts();

        SingleSelectionModel<ContractDTO> selectionModel = new SingleSelectionModel<ContractDTO>();
        display.getMainTable().setSelectionModel(selectionModel);
        display.getMainTable().addDomHandler(new DoubleClickHandler() {
            public void onDoubleClick(DoubleClickEvent event) {
                ContractDTO selectedItem = (ContractDTO) ((SingleSelectionModel)display.getMainTable().getSelectionModel()).getSelectedObject();
                if (selectedItem != null)
                    eventBus.fireEvent(new OpenContractEvent(selectedItem));
            }
        },DoubleClickEvent.getType());
        display.getCreateButton().addClickHandler(new ClickHandler(){
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new CreateContractEvent(new ContractDTO()));
            }
        });
        display.getOpenButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ContractDTO selectedItem = (ContractDTO) ((SingleSelectionModel)display.getMainTable().getSelectionModel()).getSelectedObject();
                if (selectedItem != null)
                    eventBus.fireEvent(new OpenContractEvent(selectedItem));
                else Window.alert("Договор не выбран");
            }
        });
    }

    private void getContracts() {
        rpcService.getContracts(new AsyncCallback<List<ContractDTO>>() {
            public void onFailure(Throwable caught) {
                Window.alert("Не удалось загрузить договоры");
            }

            public void onSuccess(List<ContractDTO> result) {
                display.getMainTable().setRowCount(result.size(),true);
                display.getMainTable().setRowData(0,result);
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
