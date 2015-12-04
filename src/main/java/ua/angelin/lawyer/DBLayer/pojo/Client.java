package ua.angelin.lawyer.DBLayer.pojo;


/**
 * Created by Ангелин on 28.10.2015.
 */
public class Client extends User {
    private int id;
    private String inn; // Идентефикационный номер налогоплательщика
    private String passport;
    private String status;

    public Client() {
        setIsLawyer(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id + '\'' +
                ", userID='"+getUserID() + '\'' +
                ", name='"+getName() + '\'' +
                ", surname='"+getSurname() + '\'' +
                ", status='" + status + '\'' +
                ", inn='" + inn + '\'' +
                ", passport='" + passport + '\'' +
                ", telephone='"+getTelephoneNumber() + '\'' +
                ", e-mail='"+getEmail() + '\'' +
                '}';
    }
}
