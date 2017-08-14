package gwtTest.client.dto;

import java.io.Serializable;
import java.sql.Date;

public class ClientDTO implements Serializable {

    private int id;
    private String surname;
    private String firstname;
    private String middlename;
    private Date birthday;
    private Integer passportseries;
    private Integer passportnumber;

    public ClientDTO(int id, String surname, String firstname, String middlename, Date birthday,
                Integer passportseries, Integer passportnumber){
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.passportseries = passportseries;
        this.passportnumber = passportnumber;
    }

    public ClientDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getPassportseries() {
        return passportseries;
    }

    public void setPassportseries(Integer passportseries) {
        this.passportseries = passportseries;
    }

    public Integer getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(Integer passportnumber) {
        this.passportnumber = passportnumber;
    }
}
