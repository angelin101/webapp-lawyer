package ua.angelin.lawyer.ServiceLayer.client;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ангелин on 28.10.2015.
 *
 * Класс заглушка для тестирования авторизации, до реализации Уровня Бизнес логики!!!
 */
public class Client {
    private int ID;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String passport;
    private long INNumber;
    private String address;
    private String telephone;
    private String email;
    private List<Affairs> affairsList;

    public Client() {

    }

    public List<Affairs> getAffairsList() {
        return affairsList;
    }

    public void setAffairsList(List<Affairs> affairsList) {
        this.affairsList = affairsList;
    }

    public Client(int ID, String name, String surname, String login, String password, String passport, long INNumber, String address, String telephone, String email) {

        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.passport = passport;
        this.INNumber = INNumber;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public long getINNumber() {
        return INNumber;
    }

    public void setINNumber(long INNumber) {
        this.INNumber = INNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
