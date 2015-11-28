package ua.angelin.lawyer.DBLayer.pojo;

/**
 * Created by Ангелин on 28.11.2015.
 */
public class Opponent extends Client {
    // Никакого своего функционала пока не имеет!))

    public Opponent(){
        setIsLawyer(false);
    }

    @Override
    public String toString() {
        return "Opponent{" +
                " id=" + getId() + '\'' +
                ", clientID='"+getUserID() + '\'' +
                ", name='"+getName() + '\'' +
                ", surname='"+getSurname() + '\'' +
                ", inn='" + getInn() + '\'' +
                ", passport='" + getPassport() + '\'' +
                ", telephone='"+getTelephoneNumber() + '\'' +
                ", e-mail='"+getEmail() + '\'' +
                '}';
    }
}
