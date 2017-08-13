package gwtTest.client.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import gwtTest.client.presenter.MainViewPresenter;

import java.util.Iterator;

public class MainView extends Composite implements  MainViewPresenter.Display {

    private VerticalPanel container;
    private FlexTable mainTable;
    private HorizontalPanel horizontalPanel;
    private Button createButton;
    private Button openButton;

    public MainView(){

        container = new VerticalPanel();
        mainTable = new FlexTable();
        horizontalPanel = new HorizontalPanel();
        createButton = new Button("Создать договор");
        openButton = new Button("Открыть договор");

        horizontalPanel.add(createButton);
        horizontalPanel.add(openButton);

        mainTable.setText(0,0,"Серия-Номер");
        mainTable.setText(0,1,"Дата заключения");
        mainTable.setText(0,2,"Страхователь");
        mainTable.setText(0,3,"Премия");
        mainTable.setText(0,4,"Срок действия");
        mainTable.setBorderWidth(1);
        mainTable.setCellPadding(5);

        container.add(horizontalPanel);
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
}
