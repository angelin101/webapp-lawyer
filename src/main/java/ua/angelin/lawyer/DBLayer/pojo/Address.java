package ua.angelin.lawyer.DBLayer.pojo;

/**
 * Created by Ангелин on 04.11.2015.
 */
public class Address {
    private int addressID;
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

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Address)) return false;
        Address address = (Address) obj;
        if (!city.equals(address.city)) return false;
        if (!street.equals(address.street)) return false;
        return apartments.equals(address.apartments);
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + apartments.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "г. " + city +
                ", ул. " + street +
                ", " + apartments;
    }
}

