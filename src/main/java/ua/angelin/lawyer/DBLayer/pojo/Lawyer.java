package ua.angelin.lawyer.DBLayer.pojo;

/**
 * Created by Ангелин on 28.11.2015.
 */
public class Lawyer extends User {
    private int lawyerID;
    private String lawyerLicense;

    public Lawyer(){
        setIsLawyer(true);
    }

    public int getLawyerID() {
        return lawyerID;
    }

    public void setLawyerID(int lawyerID) {
        this.lawyerID = lawyerID;
    }

    public String getLawyerLicense() {
        return lawyerLicense;
    }

    public void setLawyerLicense(String lawyerLicense) {
        this.lawyerLicense = lawyerLicense;
    }
}
