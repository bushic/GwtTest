package gwtTest.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import gwtTest.client.GwtTestServiceAsync;
import gwtTest.client.dto.ClientDTO;
import gwtTest.client.dto.ContractDTO;
import gwtTest.client.events.OpenChooseClientViewEvent;
import gwtTest.client.events.OpenContractEvent;

import java.util.Date;

public class EditClientViewPresenter implements Presenter {

    public interface Display {
        Widget asWidget();
        HasClickHandlers getSaveClientButton();
        HasClickHandlers getCloseCreateClientView();
        HasValue<String> getFirstName();
        HasValue<String> getMiddleName();
        HasValue<String> getSurName();
        HasValue<Date> getBirthDay();
        HasValue<String> getPassportSeries();
        HasValue<String> getPassportNumber();
    }

    final Display display;
    final HandlerManager eventBus;
    final String type;
    ContractDTO contractDTO;
    final GwtTestServiceAsync rpcService;

    public EditClientViewPresenter(GwtTestServiceAsync rpcService, Display display, HandlerManager eventBus, ContractDTO contractDTO, String type) {
        this.rpcService = rpcService;
        this.display = display;
        this.eventBus = eventBus;
        this.contractDTO = contractDTO;
        this.type = type;
    }

    private void init() {
        fillForm();

        display.getCloseCreateClientView().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (type.equals("create"))
                    eventBus.fireEvent(new OpenChooseClientViewEvent());
                else eventBus.fireEvent(new OpenContractEvent(contractDTO));
            }
        });
        display.getSaveClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                String check = checkFields();
                if (!check.equals("Проверьте заполнение полей:\n")){
                    Window.alert(check);
                    return;
                }
                ClientDTO clientDTO = null;
                if (type.equals("create"))
                    clientDTO = new ClientDTO();
                else clientDTO = contractDTO.getClientsByClient();
                clientDTO.setFirstname(display.getFirstName().getValue());
                clientDTO.setMiddlename(display.getMiddleName().getValue());
                clientDTO.setSurname(display.getSurName().getValue());
                if (!display.getPassportNumber().getValue().equals(""))
                    clientDTO.setPassportnumber(Integer.valueOf(display.getPassportNumber().getValue()));
                if (!display.getPassportSeries().getValue().equals(""))
                    clientDTO.setPassportseries(Integer.valueOf(display.getPassportSeries().getValue()));
                Date date = display.getBirthDay().getValue();
                if (date != null)
                    clientDTO.setBirthday(new java.sql.Date(date.getTime()));

                final ClientDTO finalClientDTO = clientDTO;
                AsyncCallback<String> callback = new AsyncCallback<String>() {
                    public void onFailure(Throwable caught) {
                        Window.alert("Не удалось сохранить клиента");
                    }

                    public void onSuccess(String result) {
                        Window.alert("Клиент сохранен");
                        contractDTO.setClientsByClient(finalClientDTO);
                        eventBus.fireEvent(new OpenContractEvent(contractDTO));
                    }
                };

                rpcService.saveClient(clientDTO, callback);

            }
        });
    }

    private String checkFields() {
        String s = "Проверьте заполнение полей:\n";
        if (display.getSurName().getValue().equals(""))
            s += "Фамилия\n";
        if (display.getFirstName().getValue().equals(""))
            s += "Имя\n";
        if (display.getBirthDay().getValue() == null)
            s += "Дата рождения\n";
        return s;
    }

    private void fillForm() {
        ClientDTO clientDTO = contractDTO.getClientsByClient();
        if (type.equals("create"))
            clientDTO = new ClientDTO();
        if (clientDTO != null) {
            display.getFirstName().setValue(clientDTO.getFirstname());
            if (clientDTO.getMiddlename() != null)
                display.getMiddleName().setValue(clientDTO.getMiddlename());
            display.getSurName().setValue(clientDTO.getSurname());
            display.getBirthDay().setValue(clientDTO.getBirthday());
            if (clientDTO.getPassportseries() != null)
                display.getPassportSeries().setValue(String.valueOf(clientDTO.getPassportseries()));
            if (clientDTO.getPassportnumber() != null)
                display.getPassportNumber().setValue(String.valueOf(clientDTO.getPassportnumber()));
        }
    }

    public void go(HasWidgets container) {
        init();
        container.clear();
        container.add(display.asWidget());
    }
}
