package ua.angelin.lawyer.DBLayer.pojo;

/**
 * Created by Ангелин on 02.11.2015.
 *
 * Для этого класса реализовать equals и hashCode!!!!!!!!!!!!!!!!!!!
 */
public class Affair {
    private int affairID;

    private String affairNumber;
    private String status;
    private Opponent opponent;
    // Класс Affair не будет содержать обьекты Client и Lawyer!
    // Реализовать все переменные после чего реализовать методы equals() и hashCode()!!!

    private String subjectOfDispute;

    public Affair() {
    }

    public int getAffairID() {
        return affairID;
    }

    public void setAffairID(int affairID) {
        this.affairID = affairID;
    }
    public String getSubjectOfDispute() {
        return subjectOfDispute;
    }

    public void setSubjectOfDispute(String subjectOfDispute) {
        this.subjectOfDispute = subjectOfDispute;
    }

    public Opponent getOpponent() {
        return opponent;
    }

    public void setOpponent(Opponent opponent) {
        this.opponent = opponent;
    }

    public String getAffairNumber() {
        return affairNumber;
    }

    public void setAffairNumber(String affairNumber) {
        this.affairNumber = affairNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Временная реализация!!!!!!!
    @Override
    public String toString() {
        return "Affair{" +
                "affairID=" + affairID +
                ", subjectOfDispute='" + subjectOfDispute + '\'' +
                '}';
    }
}
