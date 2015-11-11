package ua.angelin.lawyer.DBLayer.pojo;

import ua.angelin.lawyer.DBLayer.pojo.Address;
import ua.angelin.lawyer.DBLayer.pojo.Affair;

import java.util.Set;

/**
 * Created by Ангелин on 04.11.2015.
 */
public abstract class User {
    private int userID;
    private String login;
    private String password;
    private boolean isLawyer;
    private String name;
    private String surname;
    private Address address;
    private String telephoneNumber; // В дальнейшем можно сделать Set
    private String email; // В дальнейшем можно сделать Set
    private Set<Affair> affairs;

    public User() {
    }

    public User(int userID, String login, String password, boolean isLawyer, String name, String surname, Address address, String telephoneNumber, String email, Set<Affair> affairs) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.isLawyer = isLawyer;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.affairs = affairs;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLawyer() {
        return isLawyer;
    }

    public void setIsLawyer(boolean isLawyer) {
        this.isLawyer = isLawyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Affair> getAffairs() {
        return affairs;
    }

    public void setAffairs(Set<Affair> affairs) {
        this.affairs = affairs;
    }
}