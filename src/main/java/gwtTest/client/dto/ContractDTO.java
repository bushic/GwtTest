package gwtTest.client.dto;

import java.io.Serializable;
import java.sql.Date;

public class ContractDTO implements Serializable {

    private int id;
    private double sum;
    private Date datestart;
    private Date datefinish;
    private String propertytype;
    private int constructionyear;
    private double square;
    private Date calculatedate;
    private double bonus;
    private int number;
    private Date contractdate;
    private String country;
    private String index;
    private String republic;
    private String area;
    private String locality;
    private String street;
    private String house;
    private String housing;
    private String building;
    private String flat;
    private String comment;
    private int client;
    private ClientDTO clientsByClient;


    public ContractDTO(int id, double sum, Date datestart, Date datefinish,
                       String propertytype, int constructionyear, double square,
                       Date calculatedate, double bonus, int number, Date contractdate,
                       String country, String index, String republic, String area,
                       String locality, String street, String house, String housing,
                       String building, String flat, String comment, int client, ClientDTO clientsByClient) {
        this.id = id;
        this.sum = sum;
        this.datestart = datestart;
        this.datefinish = datefinish;
        this.propertytype = propertytype;
        this.constructionyear = constructionyear;
        this.square = square;
        this.calculatedate = calculatedate;
        this.bonus = bonus;
        this.number = number;
        this.contractdate = contractdate;
        this.country = country;
        this.index = index;
        this.republic = republic;
        this.area = area;
        this.locality = locality;
        this.street = street;
        this.house = house;
        this.housing = housing;
        this.building = building;
        this.flat = flat;
        this.comment = comment;
        this.client = client;
        this.clientsByClient = clientsByClient;
    }

    public ContractDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(Date datefinish) {
        this.datefinish = datefinish;
    }

    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }

    public int getConstructionyear() {
        return constructionyear;
    }

    public void setConstructionyear(int constructionyear) {
        this.constructionyear = constructionyear;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public Date getCalculatedate() {
        return calculatedate;
    }

    public void setCalculatedate(Date calculatedate) {
        this.calculatedate = calculatedate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getContractdate() {
        return contractdate;
    }

    public void setContractdate(Date contractdate) {
        this.contractdate = contractdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getRepublic() {
        return republic;
    }

    public void setRepublic(String republic) {
        this.republic = republic;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public ClientDTO getClientsByClient() {
        return clientsByClient;
    }

    public void setClientsByClient(ClientDTO clientsByClient) {
        this.clientsByClient = clientsByClient;
    }
}
