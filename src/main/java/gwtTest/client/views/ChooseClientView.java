package gwtTest.client.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import gwtTest.client.presenter.ChooseClientViewPresenter;

public class ChooseClientView extends Composite implements ChooseClientViewPresenter.Display {
    private VerticalPanel container;
    private TextBox surnameTextBox;
    private TextBox nameTextBox;
    private TextBox middleNameTextBox;
    private PushButton searchClientButton;
    private FlexTable clientTable;
    private Button chooseClientButton;
    private Button newClientButton;
    private Button closeChooseClientViewButton;

    public ChooseClientView(){

        container = new VerticalPanel();
        container.setSpacing(10);

        surnameTextBox = new TextBox();
        surnameTextBox.setTitle("Фамилия");
        nameTextBox = new TextBox();
        nameTextBox.setTitle("Имя");
        middleNameTextBox = new TextBox();
        middleNameTextBox.setTitle("Отчество");
        Image image = new Image("http://s1.iconbird.com/ico/2013/10/464/w512h5121380984834search.png");
        image.setHeight("20");
        image.setWidth("20");
        searchClientButton = new PushButton(image);
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(new Label("ФИО"));
        horizontalPanel.add(surnameTextBox);
        horizontalPanel.add(nameTextBox);
        horizontalPanel.add(middleNameTextBox);
        horizontalPanel.add(searchClientButton);
        horizontalPanel.setSpacing(10);
        container.add(horizontalPanel);

        clientTable = new FlexTable();
        clientTable.setText(0,0,"ФИО");
        clientTable.setText(0,1,"Дата рождения");
        clientTable.setText(0,2,"Паспортные данные");
        clientTable.setBorderWidth(1);
        clientTable.setCellPadding(5);
        container.add(clientTable);

        chooseClientButton = new Button();
        chooseClientButton.setText("Выбрать");
        newClientButton = new Button();
        newClientButton.setText("Новый");
        closeChooseClientViewButton = new Button();
        closeChooseClientViewButton.setText("Закрыть");
        HorizontalPanel horizontalPanel1 = new HorizontalPanel();
        horizontalPanel1.add(chooseClientButton);
        horizontalPanel1.add(newClientButton);
        horizontalPanel1.add(closeChooseClientViewButton);
        horizontalPanel1.setSpacing(10);
        container.add(horizontalPanel1);
    }

    public Widget asWidget() {
        return  container;
    }

    public HasClickHandlers getCloseChooseClientViewButton() {
        return closeChooseClientViewButton;
    }

    public HasClickHandlers getChooseClientButton() {
        return chooseClientButton;
    }

    public HasClickHandlers getNewClientButton() {
        return newClientButton;
    }
}
