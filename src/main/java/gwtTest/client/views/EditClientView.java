package gwtTest.client.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import gwtTest.client.presenter.EditClientViewPresenter;

public class EditClientView extends Composite implements EditClientViewPresenter.Display {

    private VerticalPanel container;
    private TextBox surnameTextBox;
    private TextBox nameTextBox;
    private TextBox middleNameTextBox;
    private DateBox clientBirthday;
    private Button saveNewClient;
    private Button closeCreateClientView;
    private TextBox passportSeries;
    private TextBox passportNumber;

    private String type;

    public EditClientView(String type){

        this.type = type;

        DateBox.Format format = new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd.MM.yyyy"));
        container = new VerticalPanel();
        container.setSpacing(10);

        surnameTextBox = new TextBox();
        surnameTextBox.setTitle("Фамилия");
        nameTextBox = new TextBox();
        nameTextBox.setTitle("Имя");
        middleNameTextBox = new TextBox();
        middleNameTextBox.setTitle("Отчество");
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(new Label("ФИО"));
        horizontalPanel.add(surnameTextBox);
        horizontalPanel.add(nameTextBox);
        horizontalPanel.add(middleNameTextBox);
        horizontalPanel.setSpacing(10);
        container.add(horizontalPanel);

        clientBirthday = new DateBox();
        clientBirthday.setFormat(format);
        HorizontalPanel horizontalPanel1 = new HorizontalPanel();
        horizontalPanel1.add(new Label("Дата рождения"));
        horizontalPanel1.add(clientBirthday);
        horizontalPanel1.setSpacing(10);
        container.add(horizontalPanel1);

        if (type.equals("edit")){
            passportSeries = new TextBox();
            passportNumber = new TextBox();
            HorizontalPanel horizontalPanel3 = new HorizontalPanel();
            horizontalPanel3.add(new Label("Паспорт"));
            horizontalPanel3.add(new Label("Серия"));
            horizontalPanel3.add(passportSeries);
            horizontalPanel3.add(new Label("Номер"));
            horizontalPanel3.add(passportNumber);
            horizontalPanel3.setSpacing(10);
            container.add(horizontalPanel3);
        }

        saveNewClient = new Button();
        saveNewClient.setText("Сохранить");
        closeCreateClientView = new Button();
        closeCreateClientView.setText("Закрыть");
        HorizontalPanel horizontalPanel2 = new HorizontalPanel();
        horizontalPanel2.add(saveNewClient);
        horizontalPanel2.add(closeCreateClientView);
        horizontalPanel2.setSpacing(10);
        container.add(horizontalPanel2);

    }

    public Widget asWidget() {
        return  container;
    }

    public HasClickHandlers getSaveClientButton() {
        return saveNewClient;
    }

    public HasClickHandlers getCloseCreateClientView() {
        return closeCreateClientView;
    }
}
