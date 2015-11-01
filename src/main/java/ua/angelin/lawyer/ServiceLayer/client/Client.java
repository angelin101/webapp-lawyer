package ua.angelin.lawyer.ServiceLayer.client;

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

    public Client(int ID, String name, String surname, String login, String password) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
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
