package ua.angelin.lawyer.ServiceLayer;

/**
 * Created by ������� on 02.11.2015.
 *
 * ��� ����� ������ ����������� equals � hashCode!!!!!!!!!!!!!!!!!!!
 */
public class Affair {
    private int affairID;
    private String subjectOfDispute;
    private String otherSide; // ������� �������� ��� � ������

    public Affair() {
    }

    public Affair(int affairID, String subjectOfDispute, String otherSide) {
        this.affairID = affairID;
        this.subjectOfDispute = subjectOfDispute;
        this.otherSide = otherSide;
    }

    public int getNum() {
        return affairID;
    }

    public void setNum(int num) {
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

    ;
}
