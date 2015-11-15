package ua.angelin.lawyer.DBLayer.pojo;


import java.util.List;



/**
 * Created by Ангелин on 28.10.2015.
 *
 * Класс заглушка для тестирования авторизации, до реализации Уровня Бизнес логики!!!
 */
public class Client extends User {
    private int clientID;
    private String identNumber;
    private String passport;

    // При каждом создании обьекта выполняеться этот блок, определяя Клиента НЕ Юр.лицом
    {
        setIsLawyer(false);
    }

    public Client() {
    }

    public Client(int clientID, String identNumber, String passport) {
        this.clientID = clientID;
        this.identNumber = identNumber;
        this.passport = passport;
    }
    // Временный конструктор,для заглушки вместо БД. Вместо него потом сделать конструктор принимающий обьект User
    public Client(int userID, String login, String password, boolean isLawyer, String name, String surname, Address address, String telephoneNumber, String email, List<Affair> affairs, String identNumber, String passport) {
        super(userID, login, password, isLawyer, name, surname, address, telephoneNumber, email, affairs);
        this.identNumber = identNumber;
        this.passport = passport;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID + '\'' +
                ", userID='"+getUserID() + '\'' +
                ", name='"+getName() + '\'' +
                ", surname='"+getSurname() + '\'' +
                ", identNumber='" + identNumber + '\'' +
                ", passport='" + passport + '\'' +
                ", telephone='"+getTelephoneNumber() + '\'' +
                ", e-mail='"+getEmail() + '\'' +
                '}';
    }
}
