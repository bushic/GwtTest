package gwtTest.client.views;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import gwtTest.client.presenter.ContractViewPresenter;

import java.util.Date;

public class ContractView extends Composite implements ContractViewPresenter.Display {

    private VerticalPanel container;
    private VerticalPanel calculationPanel;
    public TextBox sumInsuredTextBox;
    private DateBox validityStartDate;
    private DateBox validityFinishDate;
    private ListBox propertyType;
    private TextBox constructionYearTextBox;
    private TextBox squareTextBox;
    private Button calculateButton;
    private DateBox calculateDateTextBox;
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

        init();
        addCheckHandlers();
    }

    private void init() {
        DateBox.Format format = new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd.MM.yyyy"));

        container = new VerticalPanel();
        container.setSpacing(10);
        calculationPanel = new VerticalPanel();
        calculationPanel.setTitle("Расчет");

        sumInsuredTextBox = new TextBox();
        sumInsuredTextBox.setMaxLength(11);
        sumInsuredTextBox.getElement().getStyle().setBorderColor("red");
        validityStartDate = new DateBox();
        validityStartDate.setFormat(format);
        validityStartDate.getElement().getStyle().setBorderColor("red");
        validityStartDate.setValue(new Date());
        validityFinishDate = new DateBox();
        validityFinishDate.getElement().getStyle().setBorderColor("red");
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
        propertyType.addItem("Квартира");
        propertyType.addItem("Дом");
        propertyType.addItem("Комната");
        propertyType.getElement().getStyle().setBorderColor("red");
        HorizontalPanel horizontalPanel1 = new HorizontalPanel();
        horizontalPanel1.add(new Label("Тип недвижимости"));
        horizontalPanel1.add(propertyType);
        horizontalPanel1.setSpacing(10);
        calculationPanel.add(horizontalPanel1);

        constructionYearTextBox = new TextBox();
        constructionYearTextBox.setMaxLength(4);
        constructionYearTextBox.getElement().getStyle().setBorderColor("red");
        HorizontalPanel horizontalPanel2 = new HorizontalPanel();
        horizontalPanel2.add(new Label("Год постройки"));
        horizontalPanel2.add(constructionYearTextBox);
        horizontalPanel2.setSpacing(10);
        calculationPanel.add(horizontalPanel2);

        squareTextBox = new TextBox();
        squareTextBox.getElement().getStyle().setBorderColor("red");
        HorizontalPanel horizontalPanel3 = new HorizontalPanel();
        horizontalPanel3.add(new Label("Площадь, кв.м."));
        horizontalPanel3.add(squareTextBox);
        horizontalPanel3.setSpacing(10);
        calculationPanel.add(horizontalPanel3);

        calculateButton = new Button();
        calculateButton.setText("Рассчитать");
        calculationPanel.add(calculateButton);

        calculateDateTextBox = new DateBox();
        calculateDateTextBox.setEnabled(false);
        calculateDateTextBox.setFormat(format);
        calculateDateTextBox.getElement().getStyle().setBorderColor("red");
        bonusTextBox = new TextBox();
        bonusTextBox.setMaxLength(20);
        bonusTextBox.getElement().getStyle().setBorderColor("red");
        HorizontalPanel horizontalPanel4 = new HorizontalPanel();
        horizontalPanel4.add(new Label("Дата расчета"));
        horizontalPanel4.add(calculateDateTextBox);
        horizontalPanel4.add(new Label("Премия"));
        horizontalPanel4.add(bonusTextBox);
        horizontalPanel4.setSpacing(10);
        calculationPanel.add(horizontalPanel4);

        container.add(calculationPanel);

        contractNumber = new TextBox();
        contractNumber.getElement().getStyle().setBorderColor("red");
        contractNumber.setMaxLength(6);
        conclusionDate = new DateBox();
        conclusionDate.getElement().getStyle().setBorderColor("red");
        conclusionDate.setFormat(format);
        conclusionDate.setEnabled(false);
        conclusionDate.setValue(new Date());
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
        fullNameClient.getElement().getStyle().setBorderColor("red");
        fullNameClient.setEnabled(false);
        fullNameClient.setWidth("300");
        HorizontalPanel horizontalPanel6 = new HorizontalPanel();
        horizontalPanel6.add(chooseClient);
        horizontalPanel6.add(new Label("ФИО"));
        horizontalPanel6.add(fullNameClient);
        horizontalPanel6.add(editClient);
        horizontalPanel6.setSpacing(10);
        container.add(horizontalPanel6);

        birthdayClient = new DateBox();
        birthdayClient.getElement().getStyle().setBorderColor("red");
        birthdayClient.setFormat(format);
        passportNumber = new TextBox();
        passportNumber.setWidth("80");
        passportNumber.setMaxLength(6);
        passportNumber.getElement().getStyle().setBorderColor("red");
        passportSeries = new TextBox();
        passportSeries.setWidth("50");
        passportSeries.setMaxLength(4);
        passportSeries.getElement().getStyle().setBorderColor("red");
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
        countryTextBox.getElement().getStyle().setBorderColor("red");
        indexTextBox = new TextBox();
        indexTextBox.setTitle("Индекс");
        republicTextBox = new TextBox();
        republicTextBox.getElement().getStyle().setBorderColor("red");
        republicTextBox.setTitle("Республика, край, область");
        areaTextBox = new TextBox();
        areaTextBox.setTitle("Район");
        HorizontalPanel horizontalPanel8 = new HorizontalPanel();
        horizontalPanel8.add(new Label("Страна"));
        horizontalPanel8.add(countryTextBox);
        horizontalPanel8.add(new Label("Индекс"));
        horizontalPanel8.add(indexTextBox);
        horizontalPanel8.add(new Label("Республика, край, область"));
        horizontalPanel8.add(republicTextBox);
        horizontalPanel8.add(new Label("Район"));
        horizontalPanel8.add(areaTextBox);
        horizontalPanel8.setSpacing(10);
        container.add(horizontalPanel8);

        localityTextBox = new TextBox();
        localityTextBox.getElement().getStyle().setBorderColor("red");
        localityTextBox.setTitle("Населенный пункт");
        streetTextBox = new TextBox();
        streetTextBox.getElement().getStyle().setBorderColor("red");
        streetTextBox.setTitle("Улица");
        houseTextBox = new TextBox();
        houseTextBox.setWidth("80");
        houseTextBox.setTitle("Дом");
        houseTextBox.setMaxLength(6);
        housingTextBox = new TextBox();
        housingTextBox.setWidth("80");
        housingTextBox.setTitle("Корпус");
        buildingTextBox = new TextBox();
        buildingTextBox.setWidth("80");
        buildingTextBox.setTitle("Строение");
        flatTextBox = new TextBox();
        flatTextBox.setTitle("Квартира");
        flatTextBox.setMaxLength(6);
        flatTextBox.setWidth("80");
        flatTextBox.getElement().getStyle().setBorderColor("red");
        HorizontalPanel horizontalPanel9 = new HorizontalPanel();
        horizontalPanel9.add(new Label("Населенный пункт"));
        horizontalPanel9.add(localityTextBox);
        horizontalPanel9.add(new Label("Улица"));
        horizontalPanel9.add(streetTextBox);
        horizontalPanel9.add(new Label("Дом"));
        horizontalPanel9.add(houseTextBox);
        horizontalPanel9.add(new Label("Корпус"));
        horizontalPanel9.add(housingTextBox);
        horizontalPanel9.add(new Label("Строение"));
        horizontalPanel9.add(buildingTextBox);
        horizontalPanel9.add(new Label("Квартира"));
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
        commentTextArea.setHeight("100");
        commentTextArea.setWidth("750");
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

        editDatePickers();
    }

    private void editDatePickers() {

        editDateBox(validityStartDate);
        editDateBox(validityFinishDate);
        editDateBox(calculateDateTextBox);
        editDateBox(conclusionDate);
        editDateBox(birthdayClient);
    }

    private void editDateBox(DateBox dateBox) {
        dateBox.getDatePicker().setYearAndMonthDropdownVisible(true);
    }

    private void addCheckHandlers(){
        sumInsuredTextBox.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (!Character.isDigit(event.getCharCode())){
                    sumInsuredTextBox.cancelKey();
                }
            }
        });
        validityStartDate.addValueChangeHandler(new ValueChangeHandler<Date>() {
            public void onValueChange(ValueChangeEvent<Date> event) {
                if (event.getValue().before(new Date())){
                    validityStartDate.setValue(new Date());
                }
            }
        });
        validityFinishDate.addValueChangeHandler(new ValueChangeHandler<Date>() {
            public void onValueChange(ValueChangeEvent<Date> event) {
                long start = validityStartDate.getValue().getTime();
                long finish = event.getValue().getTime();
                if (finish < start){
                    validityFinishDate.setValue(new Date(start + 1000*60*60*30));
                }
                else if((finish-start)/86400 > 365000){
                    validityFinishDate.setValue(new Date(start + 365000*86400));
                }
            }
        });
        constructionYearTextBox.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (!Character.isDigit(event.getCharCode())){
                    constructionYearTextBox.cancelKey();
                }
                Date date = new Date();
                boolean isFuture = Integer.valueOf(constructionYearTextBox.getText() + event.getCharCode()) > date.getYear() + 1900;
                if (isFuture){
                    constructionYearTextBox.cancelKey();
                }
            }
        });
        squareTextBox.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (!Character.isDigit(event.getCharCode())){
                    constructionYearTextBox.cancelKey();
                }
            }
        });
        contractNumber.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (!Character.isDigit(event.getCharCode())){
                    contractNumber.cancelKey();
                }
            }
        });
        houseTextBox.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (!Character.isDigit(event.getCharCode())){
                    houseTextBox.cancelKey();
                }
            }
        });
        flatTextBox.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (!Character.isDigit(event.getCharCode())){
                    flatTextBox.cancelKey();
                }
            }
        });
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

    public HasValue<String> getBonusTextBox() {
        return bonusTextBox;
    }

    public HasValue<Date> getBonusDateBox() {
        return calculateDateTextBox;
    }

    public HasValue<String> getSumTextBox() {
        return sumInsuredTextBox;
    }

    public HasValue<Date> getDatestart() {
        return validityStartDate;
    }

    public HasValue<Date> getDatefinish() {
        return validityFinishDate;
    }

    public HasValue<String> getConstructionYear() {
        return constructionYearTextBox;
    }

    public HasValue<String> getSquareTextBox() {
        return squareTextBox;
    }

    public HasValue<String> getContractNumber() {
        return contractNumber;
    }

    public HasValue<Date> getContractDate() {
        return conclusionDate;
    }

    public HasValue<String> getFullName() {
        return fullNameClient;
    }

    public HasValue<Date> getBirthday() {
        return birthdayClient;
    }

    public HasValue<String> getPassportSeries() {
        return passportSeries;
    }

    public HasValue<String> getPassportNumber() {
        return passportNumber;
    }

    public HasValue<String> getCountry() {
        return countryTextBox;
    }

    public HasValue<String> getIndex() {
        return indexTextBox;
    }

    public HasValue<String> getRepublic() {
        return republicTextBox;
    }

    public HasValue<String> getArea() {
        return areaTextBox;
    }

    public HasValue<String> getLocality() {
        return localityTextBox;
    }

    public HasValue<String> getStreet() {
        return streetTextBox;
    }

    public HasValue<String> getHouse() {
        return houseTextBox;
    }

    public HasValue<String> getHousing() {
        return housingTextBox;
    }

    public HasValue<String> getBuilding() {
        return buildingTextBox;
    }

    public HasValue<String> getFlat() {
        return flatTextBox;
    }

    public HasValue<String> getComment() {
        return commentTextArea;
    }

    public ListBox getPropertyType() {
        return propertyType;
    }

}
