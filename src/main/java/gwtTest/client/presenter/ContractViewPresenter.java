package gwtTest.client.presenter;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import gwtTest.client.GwtTestServiceAsync;
import gwtTest.client.dto.ClientDTO;
import gwtTest.client.dto.ContractDTO;
import gwtTest.client.events.*;

import java.util.Date;

public class ContractViewPresenter implements Presenter {
    public interface Display{
        Widget asWidget();
        HasClickHandlers getChooseClientButton();
        HasClickHandlers getBackToContractsButton();
        HasClickHandlers getEditClientButton();
        HasClickHandlers getCalculateButton();
        HasClickHandlers getSaveContractButton();
        HasValue<String> getBonusTextBox();
        HasValue<Date> getBonusDateBox();
        HasValue<String> getSumTextBox();
        HasValue<Date> getDatestart();
        HasValue<Date> getDatefinish();
        HasValue<String> getConstructionYear();
        HasValue<String> getSquareTextBox();
        HasValue<String> getContractNumber();
        HasValue<Date> getContractDate();
        HasValue<String> getFullName();
        HasValue<Date> getBirthday();
        HasValue<String> getPassportSeries();
        HasValue<String> getPassportNumber();
        HasValue<String> getCountry();
        HasValue<String> getIndex();
        HasValue<String> getRepublic();
        HasValue<String> getArea();
        HasValue<String> getLocality();
        HasValue<String> getStreet();
        HasValue<String> getHouse();
        HasValue<String> getHousing();
        HasValue<String> getBuilding();
        HasValue<String> getFlat();
        HasValue<String> getComment();
        ListBox getPropertyType();
    }

    final ContractViewPresenter.Display display;
    final HandlerManager eventBus;
    final GwtTestServiceAsync rpcService;
    ContractDTO contractDTO;

    public ContractViewPresenter(GwtTestServiceAsync rpcService, Display display, HandlerManager eventBus, ContractDTO contractDTO){
        this.display = display;
        this.eventBus = eventBus;
        this.rpcService = rpcService;
        this.contractDTO = contractDTO;
    }

    public void init(){
        display.getChooseClientButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                updateContractDTO();
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
                eventBus.fireEvent(new EditClientEvent());
            }
        });
        display.getCalculateButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                AsyncCallback<String> callback = new AsyncCallback<String>() {
                    public void onFailure(Throwable caught) {
                        Window.alert("Премия не рассчитана");
                    }

                    public void onSuccess(String result) {
                        contractDTO.setBonus(result);
                        Date newDate = new Date();
                        contractDTO.setCalculatedate(new java.sql.Date(newDate.getTime()));
                        display.getBonusDateBox().setValue(newDate);
                        display.getBonusTextBox().setValue(result);
                    }
                };
                updateContractDTO();
                rpcService.calculateBonus(contractDTO,callback);
            }
        });
        display.getSaveContractButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                AsyncCallback<String> callback = new AsyncCallback<String>() {
                    public void onFailure(Throwable caught) {
                        Window.alert("Договор не сохранен");
                    }

                    public void onSuccess(String result) {
                        Window.alert(result);
                        if (result.equals("Договор сохранен"))
                            eventBus.fireEvent(new OpenContractListEvent());
                    }
                };
                String check = checkFields();
                if (check.equals("Проверьте заполнение полей:\n")) {
                    updateContractDTO();
                    rpcService.saveContract(contractDTO, callback);
                }else Window.alert(check);
            }
        });
        if (contractDTO != null)
            fillForm();
    }

    private String checkFields() {
        String s = "Проверьте заполнение полей:\n";

        if (display.getSumTextBox().getValue().equals(""))
            s += "Страховая сумма\n";
        if (display.getDatestart().getValue() == null || display.getDatefinish().getValue() == null)
            s += "Сроки действия договора\n";
        if (display.getConstructionYear().getValue().equals(""))
            s += "Год постройки\n";
        if (display.getSquareTextBox().getValue().equals(""))
            s += "Площадь\n";
        if (display.getBonusDateBox().getValue() == null)
            s += "Дата рассчета\n";
        if (display.getBonusTextBox().getValue().equals(""))
            s += "Премия\n";
        if (display.getContractNumber().getValue().equals(""))
            s += "Номер договора\n";
        if (display.getContractDate().getValue() == null)
            s += "Дата договора\n";
        if (display.getFullName().getValue().equals(""))
            s += "ФИО клиента\n";
        if (display.getBirthday().getValue() == null)
            s += "Дата рождения клиента\n";
        if (display.getPassportSeries().getValue().equals(""))
            s += "Серия паспорта клиента\n";
        if (display.getPassportNumber().getValue().equals(""))
            s += "Номер паспорта клиента\n";
        if (display.getCountry().getValue().equals(""))
            s += "Страна\n";
        if (display.getRepublic().getValue().equals(""))
            s += "Республика, область, край\n";
        if (display.getLocality().getValue().equals(""))
            s += "Населенный пункт\n";
        if (display.getStreet().getValue().equals(""))
            s += "Улица\n";
        if (display.getFlat().getValue().equals(""))
            s += "Квартира\n";

        return s;
    }

    private void updateContractDTO() {
        if (!display.getSumTextBox().getValue().equals(""))
            contractDTO.setSum(Integer.valueOf(display.getSumTextBox().getValue()));
        if (display.getDatestart().getValue() != null)
            contractDTO.setDatestart(new java.sql.Date(display.getDatestart().getValue().getTime()));
        if (display.getDatefinish().getValue() != null)
            contractDTO.setDatefinish(new java.sql.Date(display.getDatefinish().getValue().getTime()));
        contractDTO.setPropertytype(display.getPropertyType().getSelectedValue());
        contractDTO.setConstructionyear(display.getConstructionYear().getValue());
        contractDTO.setSquare(display.getSquareTextBox().getValue());
        contractDTO.setBonus(display.getBonusTextBox().getValue());
        if (display.getBonusDateBox().getValue() != null)
            contractDTO.setCalculatedate(new java.sql.Date(display.getBonusDateBox().getValue().getTime()));
        if (display.getContractDate().getValue() != null)
            contractDTO.setContractdate(new java.sql.Date(display.getContractDate().getValue().getTime()));
        if(!display.getContractNumber().getValue().equals(""))
            contractDTO.setNumber(Integer.valueOf(display.getContractNumber().getValue()));
        contractDTO.setCountry(display.getCountry().getValue());
        contractDTO.setIndex(display.getIndex().getValue());
        contractDTO.setRepublic(display.getRepublic().getValue());
        contractDTO.setArea(display.getArea().getValue());
        contractDTO.setLocality(display.getLocality().getValue());
        contractDTO.setStreet(display.getStreet().getValue());
        if(!display.getHouse().getValue().equals(""))
            contractDTO.setHouse(Integer.valueOf(display.getHouse().getValue()));
        contractDTO.setHousing(display.getHousing().getValue());
        contractDTO.setBuilding(display.getBuilding().getValue());
        if (!display.getFlat().getValue().equals(""))
            contractDTO.setFlat(Integer.valueOf(display.getFlat().getValue()));
        contractDTO.setComment(display.getComment().getValue());
    }

    private void fillForm() {
        display.getSumTextBox().setValue(String.valueOf(contractDTO.getSum()));
        if (contractDTO.getDatestart() != null)
            display.getDatestart().setValue(contractDTO.getDatestart());
        display.getDatefinish().setValue(contractDTO.getDatefinish());
        display.getConstructionYear().setValue(contractDTO.getConstructionyear());
        display.getSquareTextBox().setValue(contractDTO.getSquare());
        display.getBonusTextBox().setValue(contractDTO.getBonus());
        display.getBonusDateBox().setValue(contractDTO.getCalculatedate());
        display.getContractNumber().setValue(String.valueOf(contractDTO.getNumber()));
        if (contractDTO.getContractdate() != null)
            display.getContractDate().setValue(contractDTO.getContractdate());
        if (contractDTO.getClientsByClient() != null) {
            ClientDTO clientDTO = contractDTO.getClientsByClient();
            display.getFullName().setValue(clientDTO.toString());
            display.getBirthday().setValue(clientDTO.getBirthday());
            if (clientDTO.getPassportseries() != null)
                display.getPassportSeries().setValue(String.valueOf(clientDTO.getPassportseries()));
            if (clientDTO.getPassportnumber() != null)
                display.getPassportNumber().setValue(String.valueOf(clientDTO.getPassportnumber()));
            ((Button)display.getEditClientButton()).setEnabled(true);
        } else ((Button)display.getEditClientButton()).setEnabled(false);
        display.getCountry().setValue(contractDTO.getCountry());
        display.getIndex().setValue(contractDTO.getIndex());
        display.getRepublic().setValue(contractDTO.getRepublic());
        display.getArea().setValue(contractDTO.getArea());
        display.getLocality().setValue(contractDTO.getLocality());
        display.getStreet().setValue(contractDTO.getStreet());
        if (contractDTO.getHouse() != null)
            display.getHouse().setValue(String.valueOf(contractDTO.getHouse()));
        display.getHousing().setValue(contractDTO.getHousing());
        display.getBuilding().setValue(contractDTO.getBuilding());
        display.getFlat().setValue(String.valueOf(contractDTO.getFlat()));
        display.getComment().setValue(contractDTO.getComment());

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
