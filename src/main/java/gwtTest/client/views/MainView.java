package gwtTest.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import gwtTest.client.dto.ClientDTO;
import gwtTest.client.dto.ContractDTO;
import gwtTest.client.presenter.MainViewPresenter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainView extends Composite implements  MainViewPresenter.Display {

    private VerticalPanel container;
    private CellTable<ContractDTO> mainTable;
    private Button createButton;
    private Button openButton;

    public MainView(){

        container = new VerticalPanel();
        container.setSpacing(10);

        createButton = new Button("Создать договор");
        openButton = new Button("Открыть договор");
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(createButton);
        horizontalPanel.add(openButton);
        horizontalPanel.setSpacing(10);
        container.add(horizontalPanel);

        mainTable = new CellTable<ContractDTO>();
        TextColumn<ContractDTO> passportColumn = new TextColumn<ContractDTO>(){
            @Override
            public String getValue(ContractDTO contract) {
                ClientDTO client = contract.getClientsByClient();
                return client.getPassportseries() + "-" + client.getPassportnumber();
            }
        };

        TextColumn<ContractDTO> dateColumn = new TextColumn<ContractDTO>(){
            @Override
            public String getValue(ContractDTO contract) {
                return contract.getContractdate().toString();
            }
        };
        TextColumn<ContractDTO> clientColumn = new TextColumn<ContractDTO>(){
            @Override
            public String getValue(ContractDTO contract) {
                ClientDTO client = contract.getClientsByClient();
                return client.getSurname() + " " + client.getFirstname() + " " + client.getMiddlename();
            }
        };
        TextColumn<ContractDTO> bonusColumn = new TextColumn<ContractDTO>(){
            @Override
            public String getValue(ContractDTO contract) {
                return String.valueOf(contract.getBonus());
            }
        };
        TextColumn<ContractDTO> datesColumn = new TextColumn<ContractDTO>(){
            @Override
            public String getValue(ContractDTO contract) {
                return contract.getDatestart().toString() + "-" + contract.getDatefinish().toString();
            }
        };
        mainTable.addColumn(passportColumn,"Серия-Номер");
        mainTable.addColumn(dateColumn,"Дата заключения");
        mainTable.addColumn(clientColumn, "Страхователь");
        mainTable.addColumn(bonusColumn, "Премия");
        mainTable.addColumn(datesColumn, "Срок действия");

        container.add(mainTable);
    }

    public Widget asWidget(){
        return container;
    }

    public HasClickHandlers getCreateButton() {
        return createButton;
    }

    public HasClickHandlers getOpenButton() {
        return openButton;
    }

    public CellTable<ContractDTO> getMainTable() {
        return mainTable;
    }
}
