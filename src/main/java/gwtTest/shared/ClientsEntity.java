package gwtTest.shared;

import gwtTest.client.dto.ClientDTO;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clients", schema = "gwt", catalog = "")
public class ClientsEntity {
    private int id;
    private String surname;
    private String firstname;
    private String middlename;
    private Date birthday;
    private Integer passportseries;
    private Integer passportnumber;

    public ClientsEntity(ClientDTO clientDTO){
        id = clientDTO.getId();
        surname = clientDTO.getSurname();
        firstname = clientDTO.getFirstname();
        middlename = clientDTO.getMiddlename();
        birthday = clientDTO.getBirthday();
        passportseries = clientDTO.getPassportseries();
        passportnumber = clientDTO.getPassportnumber();
    }

    public ClientsEntity() {
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
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 45)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "middlename", nullable = true, length = 45)
    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "passportseries", nullable = true)
    public Integer getPassportseries() {
        return passportseries;
    }

    public void setPassportseries(Integer passportseries) {
        this.passportseries = passportseries;
    }

    @Basic
    @Column(name = "passportnumber", nullable = true)
    public Integer getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(Integer passportnumber) {
        this.passportnumber = passportnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (id != that.id) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (passportseries != null ? !passportseries.equals(that.passportseries) : that.passportseries != null)
            return false;
        if (passportnumber != null ? !passportnumber.equals(that.passportnumber) : that.passportnumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (passportseries != null ? passportseries.hashCode() : 0);
        result = 31 * result + (passportnumber != null ? passportnumber.hashCode() : 0);
        return result;
    }
}
