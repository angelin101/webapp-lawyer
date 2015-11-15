package ua.angelin.lawyer.DBLayer.pojo;

/**
 * Created by Ангелин on 02.11.2015.
 *
 * Для этого класса реализовать equals и hashCode!!!!!!!!!!!!!!!!!!!
 */
public class Affair {
    private int affairID;
    private String subjectOfDispute;
    private String otherSide; // Сделать обьектом как и Клиент
    // Реализовать все переменные после чего реализовать методы equals() и hashCode()!!!

    public Affair() {
    }
    // Временный конструктор!!!! Пока класс не будет реализован полностью!!!!
    public Affair(int affairID, String subjectOfDispute){
        this.affairID = affairID;
        this.subjectOfDispute = subjectOfDispute;
    }

    public Affair(int affairID, String subjectOfDispute, String otherSide) {
        this.affairID = affairID;
        this.subjectOfDispute = subjectOfDispute;
        this.otherSide = otherSide;
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

    public String getOtherSide() {
        return otherSide;
    }

    public void setOtherSide(String otherSide) {
        this.otherSide = otherSide;
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
