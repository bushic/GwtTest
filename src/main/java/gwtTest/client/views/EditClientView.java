package gwtTest.client.views;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import gwtTest.client.presenter.EditClientViewPresenter;

import java.util.Date;

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

        init(type);
        addCheckHandlers();
    }

    private void addCheckHandlers() {
        passportNumber.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (!Character.isDigit(event.getCharCode())){
                    passportNumber.cancelKey();
                }
            }
        });
        passportSeries.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (!Character.isDigit(event.getCharCode())){
                    passportSeries.cancelKey();
                }
            }
        });
    }

    private void init(String type) {
        this.type = type;

        DateBox.Format format = new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd.MM.yyyy"));
        container = new VerticalPanel();
        container.setSpacing(10);

        surnameTextBox = new TextBox();
        surnameTextBox.setTitle("Фамилия");
        surnameTextBox.getElement().getStyle().setBorderColor("red");
        nameTextBox = new TextBox();
        nameTextBox.setTitle("Имя");
        nameTextBox.getElement().getStyle().setBorderColor("red");
        middleNameTextBox = new TextBox();
        middleNameTextBox.setTitle("Отчество");
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(new Label("Фамилия"));
        horizontalPanel.add(surnameTextBox);
        horizontalPanel.add(new Label("Имя"));
        horizontalPanel.add(nameTextBox);
        horizontalPanel.add(new Label("Отчество"));
        horizontalPanel.add(middleNameTextBox);
        horizontalPanel.setSpacing(10);
        container.add(horizontalPanel);

        DatePicker datePicker = new DatePicker();
        datePicker.getElement().getStyle().setBackgroundColor("white");
        datePicker.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
        datePicker.setYearAndMonthDropdownVisible(true);
        datePicker.setVisibleYearCount(20);
        clientBirthday = new DateBox(datePicker,new Date(), format);
        clientBirthday.getElement().getStyle().setBorderColor("red");
        HorizontalPanel horizontalPanel1 = new HorizontalPanel();
        horizontalPanel1.add(new Label("Дата рождения"));
        horizontalPanel1.add(clientBirthday);
        horizontalPanel1.setSpacing(10);
        container.add(horizontalPanel1);

        passportSeries = new TextBox();
        passportSeries.setMaxLength(4);
        passportNumber = new TextBox();
        passportNumber.setMaxLength(6);

        if (type.equals("edit")){
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

    public HasValue<String> getFirstName() {
        return nameTextBox;
    }

    public HasValue<String> getMiddleName() {
        return middleNameTextBox;
    }

    public HasValue<String> getSurName() {
        return surnameTextBox;
    }

    public HasValue<Date> getBirthDay() {
        return clientBirthday;
    }

    public HasValue<String> getPassportSeries() {
        return passportSeries;
    }

    public HasValue<String> getPassportNumber() {
        return passportNumber;
    }

}
