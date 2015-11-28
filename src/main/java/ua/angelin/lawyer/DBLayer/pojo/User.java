package ua.angelin.lawyer.DBLayer.pojo;


import java.util.List;

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
    private List<Affair> affairs; // В дальнейшем, когда класс Affiar будет полностью реализован, можно сделать Set<Affair>
    //(предварительно определиться сo значимыми для метода equals() переменными!!!)

    public User() {
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

    public List<Affair> getAffairs() {
        return affairs;
    }

    public void setAffairs(List<Affair> affairs) {
        this.affairs = affairs;
    }

    public int getAddressID() {
        return address.getAddressID();
    }

    public void setAddressID(int addressID) {
        address = new Address();
        address.setAddressID(addressID);
    }
}