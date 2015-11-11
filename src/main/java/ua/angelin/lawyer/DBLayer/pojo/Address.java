package ua.angelin.lawyer.DBLayer.pojo;

/**
 * Created by Ангелин on 04.11.2015.
 */
public class Address {
    private String city;
    private String street;
    private String apartments;

    public Address() {
    }

    public Address(String city, String street, String apartments) {
        this.city = city;
        this.street = street;
        this.apartments = apartments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartments() {
        return apartments;
    }

    public void setApartments(String apartments) {
        this.apartments = apartments;
    }
}
