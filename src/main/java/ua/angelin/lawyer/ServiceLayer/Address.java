package ua.angelin.lawyer.ServiceLayer;

/**
 * Created by Ангелин on 04.11.2015.
 */
public class Address {
    private String country;
    private String city;
    private String street;
    private String apartments;

    public Address() {
    }

    public Address(String country, String city, String street, String apartments) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.apartments = apartments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
