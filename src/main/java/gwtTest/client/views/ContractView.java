package gwtTest.client.views;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import gwtTest.client.presenter.ContractViewPresenter;

public class ContractView extends Composite implements ContractViewPresenter.Display {

    private VerticalPanel container;
    private VerticalPanel calculationPanel;
    private TextBox sumInsuredTextBox;
    private DateBox validityStartDate;
    private DateBox validityFinishDate;
    private ListBox propertyType;
    private TextBox constructionYearTextBox;
    private TextBox squareTextBox;
    private Button calculateButton;
    private TextBox calculateDateTextBox;
    private TextBox bonusTextBox;
    private TextBox contractNumber;
    private DateBox conclusionDate;
    private Button chooseClient;
    private Button editClient;
    private TextBox fullNameClient;
    private DateBox birthdayClient;
    private TextBox passportSeries;
    private TextBox passportNumber;
    private TextBox countryTextBox;
    private TextBox indexTextBox;
    private TextBox republicTextBox;
    private TextBox areaTextBox;
    private TextBox localityTextBox;
    private TextBox streetTextBox;
    private TextBox houseTextBox;
    private TextBox housingTextBox;
    private TextBox buildingTextBox;
    private TextBox flatTextBox;
    private TextArea commentTextArea;
    private Button saveContractButton;
    private Button backToContractListButton;

    public ContractView(){

        DateBox.Format format = new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd.MM.yyyy"));

        container = new VerticalPanel();
        container.setSpacing(10);
        calculationPanel = new VerticalPanel();
        calculationPanel.setTitle("Расчет");

        sumInsuredTextBox = new TextBox();
        validityStartDate = new DateBox();
        validityStartDate.setFormat(format);
        validityFinishDate = new DateBox();
        validityFinishDate.setFormat(format);
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(new Label("Страховая сумма"));
        horizontalPanel.add(sumInsuredTextBox);
        horizontalPanel.add(new Label("Срок действия с"));
        horizontalPanel.add(validityStartDate);
        horizontalPanel.add(new Label("по"));
        horizontalPanel.add(validityFinishDate);
        horizontalPanel.setSpacing(10);
        calculationPanel.add(horizontalPanel);

        propertyType = new ListBox();
        HorizontalPanel horizontalPanel1 = new HorizontalPanel();
        horizontalPanel1.add(new Label("Тип недвижимости"));
        horizontalPanel1.add(propertyType);
        horizontalPanel1.setSpacing(10);
        calculationPanel.add(horizontalPanel1);

        constructionYearTextBox = new TextBox();
        HorizontalPanel horizontalPanel2 = new HorizontalPanel();
        horizontalPanel2.add(new Label("Год постройки"));
        horizontalPanel2.add(constructionYearTextBox);
        horizontalPanel2.setSpacing(10);
        calculationPanel.add(horizontalPanel2);

        squareTextBox = new TextBox();
        HorizontalPanel horizontalPanel3 = new HorizontalPanel();
        horizontalPanel3.add(new Label("Площадь, кв.м."));
        horizontalPanel3.add(squareTextBox);
        horizontalPanel3.setSpacing(10);
        calculationPanel.add(horizontalPanel3);

        calculateButton = new Button();
        calculateButton.setText("Рассчитать");
        calculationPanel.add(calculateButton);

        calculateDateTextBox = new TextBox();
        bonusTextBox = new TextBox();
        HorizontalPanel horizontalPanel4 = new HorizontalPanel();
        horizontalPanel4.add(new Label("Дата расчета"));
        horizontalPanel4.add(calculateDateTextBox);
        horizontalPanel4.add(new Label("Премия"));
        horizontalPanel4.add(bonusTextBox);
        horizontalPanel4.setSpacing(10);
        calculationPanel.add(horizontalPanel4);

        container.add(calculationPanel);

        contractNumber = new TextBox();
        conclusionDate = new DateBox();
        conclusionDate.setFormat(format);
        HorizontalPanel horizontalPanel5 = new HorizontalPanel();
        horizontalPanel5.add(new Label("№ договора"));
        horizontalPanel5.add(contractNumber);
        horizontalPanel5.add(new Label("Дата заключения"));
        horizontalPanel5.add(conclusionDate);
        horizontalPanel5.setSpacing(10);
        container.add(horizontalPanel5);

        Label label = new Label("СТРАХОВАТЕЛЬ");
        label.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
        label.getElement().getStyle().setFontSize(1.3, Style.Unit.EM);
        container.add(label);

        chooseClient = new Button();
        chooseClient.setText("Выбрать");
        editClient = new Button();
        editClient.setText("Изменить");
        fullNameClient = new TextBox();
        HorizontalPanel horizontalPanel6 = new HorizontalPanel();
        horizontalPanel6.add(chooseClient);
        horizontalPanel6.add(new Label("ФИО"));
        horizontalPanel6.add(fullNameClient);
        horizontalPanel6.add(editClient);
        horizontalPanel6.setSpacing(10);
        container.add(horizontalPanel6);

        birthdayClient = new DateBox();
        birthdayClient.setFormat(format);
        passportNumber = new TextBox();
        passportSeries = new TextBox();
        HorizontalPanel horizontalPanel7 = new HorizontalPanel();
        horizontalPanel7.add(new Label("Дата рождения"));
        horizontalPanel7.add(birthdayClient);
        horizontalPanel7.add(new Label("Паспорт"));
        horizontalPanel7.add(new Label("Серия"));
        horizontalPanel7.add(passportSeries);
        horizontalPanel7.add(new Label("Номер"));
        horizontalPanel7.add(passportNumber);
        horizontalPanel7.setSpacing(10);
        container.add(horizontalPanel7);

        Label label1 = new Label("Адрес недвижимости");
        label1.getElement().getStyle().setFontSize(1.3, Style.Unit.EM);
        label1.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
        container.add(label1);

        countryTextBox = new TextBox();
        countryTextBox.setTitle("Государство");
        indexTextBox = new TextBox();
        indexTextBox.setTitle("Индекс");
        republicTextBox = new TextBox();
        republicTextBox.setTitle("Республика, край, область");
        areaTextBox = new TextBox();
        areaTextBox.setTitle("Район");
        HorizontalPanel horizontalPanel8 = new HorizontalPanel();
        horizontalPanel8.add(countryTextBox);
        horizontalPanel8.add(indexTextBox);
        horizontalPanel8.add(republicTextBox);
        horizontalPanel8.add(areaTextBox);
        horizontalPanel8.setSpacing(10);
        container.add(horizontalPanel8);

        localityTextBox = new TextBox();
        localityTextBox.setTitle("Населенный пункт");
        streetTextBox = new TextBox();
        streetTextBox.setTitle("Улица");
        houseTextBox = new TextBox();
        houseTextBox.setTitle("Дом");
        housingTextBox = new TextBox();
        housingTextBox.setTitle("Корпус");
        buildingTextBox = new TextBox();
        buildingTextBox.setTitle("Строение");
        flatTextBox = new TextBox();
        flatTextBox.setTitle("Квартира");
        HorizontalPanel horizontalPanel9 = new HorizontalPanel();
        horizontalPanel9.add(localityTextBox);
        horizontalPanel9.add(streetTextBox);
        horizontalPanel9.add(houseTextBox);
        horizontalPanel9.add(housingTextBox);
        horizontalPanel9.add(flatTextBox);
        horizontalPanel9.setSpacing(10);
        container.add(horizontalPanel9);

        Label label2 = new Label("КОММЕНТАРИЙ");
        label2.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
        label2.getElement().getStyle().setFontSize(1.3, Style.Unit.EM);
        container.add(label2);

        Label label3 = new Label("Комментарий к договору (не печатается на полисе)");
        label3.setWidth("100");
        commentTextArea = new TextArea();
        HorizontalPanel horizontalPanel10 = new HorizontalPanel();
        horizontalPanel10.add(label3);
        horizontalPanel10.add(commentTextArea);
        horizontalPanel10.setSpacing(10);
        container.add(horizontalPanel10);

        saveContractButton = new Button();
        saveContractButton.setText("Сохранить");
        backToContractListButton = new Button();
        backToContractListButton.setText("К списку договоров");
        HorizontalPanel horizontalPanel11 = new HorizontalPanel();
        horizontalPanel11.add(saveContractButton);
        horizontalPanel11.add(backToContractListButton);
        horizontalPanel11.setSpacing(10);
        container.add(horizontalPanel11);
    }

    public Widget asWidget() {
        return  container;
    }

    public HasClickHandlers getChooseClientButton() {
        return chooseClient;
    }

    public HasClickHandlers getBackToContractsButton() {
        return backToContractListButton;
    }

    public HasClickHandlers getEditClientButton() {
        return editClient;
    }

    public HasClickHandlers getCalculateButton() {
        return calculateButton;
    }

    public HasClickHandlers getSaveContractButton() {
        return saveContractButton;
    }

}
