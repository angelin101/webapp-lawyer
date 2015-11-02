package ua.angelin.lawyer.ServiceLayer.client;

/**
 * Created by Ангелин on 02.11.2015.
 */
public class Affairs {
    private int num;
    private String subjectOfDispute;

    public Affairs() {
    }

    public Affairs(int num, String subjectOfDispute, String otherSide) {
        this.num = num;
        this.subjectOfDispute = subjectOfDispute;
        this.otherSide = otherSide;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    private String otherSide;
}
