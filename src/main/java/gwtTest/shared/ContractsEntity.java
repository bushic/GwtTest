package gwtTest.shared;

import gwtTest.client.dto.ContractDTO;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "contracts", schema = "gwt", catalog = "")
public class ContractsEntity {
    private int id;
    private int sum;
    private Date datestart;
    private Date datefinish;
    private String propertytype;
    private String constructionyear;
    private String square;
    private Date calculatedate;
    private String bonus;
    private int number;
    private Date contractdate;
    private String country;
    private String index;
    private String republic;
    private String area;
    private String locality;
    private String street;
    private Integer house;
    private String housing;
    private String building;
    private int flat;
    private String comment;
    private ClientsEntity clientsByClient;

    public ContractsEntity(ContractDTO contractDTO){
        id = contractDTO.getId();
        sum = contractDTO.getSum();
        datestart = contractDTO.getDatestart();
        datefinish = contractDTO.getDatefinish();
        propertytype = contractDTO.getPropertytype();
        constructionyear = contractDTO.getConstructionyear();
        square = contractDTO.getSquare();
        calculatedate = contractDTO.getCalculatedate();
        bonus = contractDTO.getBonus();
        number = contractDTO.getNumber();
        contractdate = contractDTO.getContractdate();
        country = contractDTO.getCountry();
        index = contractDTO.getIndex();
        republic = contractDTO.getRepublic();
        area = contractDTO.getArea();
        locality = contractDTO.getLocality();
        street = contractDTO.getStreet();
        house = contractDTO.getHouse();
        housing = contractDTO.getHousing();
        building = contractDTO.getBuilding();
        flat = contractDTO.getFlat();
        comment = contractDTO.getComment();
        clientsByClient = new ClientsEntity(contractDTO.getClientsByClient());
    }

    public ContractsEntity() {
    }

    public void update(ContractDTO contractDTO){
        sum = contractDTO.getSum();
        datestart = contractDTO.getDatestart();
        datefinish = contractDTO.getDatefinish();
        propertytype = contractDTO.getPropertytype();
        constructionyear = contractDTO.getConstructionyear();
        square = contractDTO.getSquare();
        calculatedate = contractDTO.getCalculatedate();
        bonus = contractDTO.getBonus();
        number = contractDTO.getNumber();
        contractdate = contractDTO.getContractdate();
        country = contractDTO.getCountry();
        index = contractDTO.getIndex();
        republic = contractDTO.getRepublic();
        area = contractDTO.getArea();
        locality = contractDTO.getLocality();
        street = contractDTO.getStreet();
        house = contractDTO.getHouse();
        housing = contractDTO.getHousing();
        building = contractDTO.getBuilding();
        flat = contractDTO.getFlat();
        comment = contractDTO.getComment();
        clientsByClient = new ClientsEntity(contractDTO.getClientsByClient());
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sum", nullable = false)
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "datestart", nullable = false)
    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    @Basic
    @Column(name = "datefinish", nullable = false)
    public Date getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(Date datefinish) {
        this.datefinish = datefinish;
    }

    @Basic
    @Column(name = "propertytype", nullable = false, length = 45)
    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }

    @Basic
    @Column(name = "constructionyear", nullable = false, length = 4)
    public String getConstructionyear() {
        return constructionyear;
    }

    public void setConstructionyear(String constructionyear) {
        this.constructionyear = constructionyear;
    }

    @Basic
    @Column(name = "square", nullable = false, length = 45)
    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    @Basic
    @Column(name = "calculatedate", nullable = false)
    public Date getCalculatedate() {
        return calculatedate;
    }

    public void setCalculatedate(Date calculatedate) {
        this.calculatedate = calculatedate;
    }

    @Basic
    @Column(name = "bonus", nullable = false, length = 20)
    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "contractdate", nullable = false)
    public Date getContractdate() {
        return contractdate;
    }

    public void setContractdate(Date contractdate) {
        this.contractdate = contractdate;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "indexfield", nullable = true, length = 45)
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Basic
    @Column(name = "republic", nullable = false, length = 45)
    public String getRepublic() {
        return republic;
    }

    public void setRepublic(String republic) {
        this.republic = republic;
    }

    @Basic
    @Column(name = "area", nullable = true, length = 45)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "locality", nullable = false, length = 45)
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Basic
    @Column(name = "street", nullable = false, length = 45)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "house", nullable = true)
    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    @Basic
    @Column(name = "housing", nullable = true, length = 45)
    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    @Basic
    @Column(name = "building", nullable = true, length = 45)
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "flat", nullable = false)
    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 145)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractsEntity that = (ContractsEntity) o;

        if (id != that.id) return false;
        if (sum != that.sum) return false;
        if (number != that.number) return false;
        if (flat != that.flat) return false;
        if (datestart != null ? !datestart.equals(that.datestart) : that.datestart != null) return false;
        if (datefinish != null ? !datefinish.equals(that.datefinish) : that.datefinish != null) return false;
        if (propertytype != null ? !propertytype.equals(that.propertytype) : that.propertytype != null) return false;
        if (constructionyear != null ? !constructionyear.equals(that.constructionyear) : that.constructionyear != null)
            return false;
        if (square != null ? !square.equals(that.square) : that.square != null) return false;
        if (calculatedate != null ? !calculatedate.equals(that.calculatedate) : that.calculatedate != null)
            return false;
        if (bonus != null ? !bonus.equals(that.bonus) : that.bonus != null) return false;
        if (contractdate != null ? !contractdate.equals(that.contractdate) : that.contractdate != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (index != null ? !index.equals(that.index) : that.index != null) return false;
        if (republic != null ? !republic.equals(that.republic) : that.republic != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (locality != null ? !locality.equals(that.locality) : that.locality != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (house != null ? !house.equals(that.house) : that.house != null) return false;
        if (housing != null ? !housing.equals(that.housing) : that.housing != null) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sum;
        result = 31 * result + (datestart != null ? datestart.hashCode() : 0);
        result = 31 * result + (datefinish != null ? datefinish.hashCode() : 0);
        result = 31 * result + (propertytype != null ? propertytype.hashCode() : 0);
        result = 31 * result + (constructionyear != null ? constructionyear.hashCode() : 0);
        result = 31 * result + (square != null ? square.hashCode() : 0);
        result = 31 * result + (calculatedate != null ? calculatedate.hashCode() : 0);
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (contractdate != null ? contractdate.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (republic != null ? republic.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (housing != null ? housing.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + flat;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id", nullable = false)
    public ClientsEntity getClientsByClient() {
        return clientsByClient;
    }

    public void setClientsByClient(ClientsEntity clientsByClient) {
        this.clientsByClient = clientsByClient;
    }
}
