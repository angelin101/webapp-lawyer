package ua.angelin.lawyer.DBLayer.pojo;


import java.util.Set;


/**
 * Created by Ангелин on 28.10.2015.
 *
 * Класс заглушка для тестирования авторизации, до реализации Уровня Бизнес логики!!!
 */
public class Client extends User {
    private String identNumber;
    private String passport;

    // При каждом создании обьекта выполняеться этот блок, определяя Клиента НЕ Юр.лицом
    {
        setIsLawyer(false);
    }

    public Client() {
    }

    public Client(String identNumber, String passport) {
        this.identNumber = identNumber;
        this.passport = passport;
    }

    public Client(int userID, String login, String password, boolean isLawyer, String name, String surname, Address address, String telephoneNumber, String email, Set<Affair> affairs, String identNumber, String passport) {
        super(userID, login, password, isLawyer, name, surname, address, telephoneNumber, email, affairs);
        this.identNumber = identNumber;
        this.passport = passport;
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
}
