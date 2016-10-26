package ar.edu.utn.d2s.model.addres;

import org.uqbar.geodds.Point;

public class Address {

    private String mainStreet;
    private String street1;
    private String street2;
    private int streetNumber;
    private byte floor;
    private byte apartment;
    private byte unit;
    private int postalCode;
    private String city;
    private String district;
    private String state;
    private String country;
    private Point point;

    public Address(String mainStreet, String street1, String street2, int streetNumber, byte floor, byte apartment,
                   byte unit, int postalCode, String city, String district, String state, String country,
                   Point point) {
        this.mainStreet = mainStreet;
        this.street1 = street1;
        this.street2 = street2;
        this.streetNumber = streetNumber;
        this.floor = floor;
        this.apartment = apartment;
        this.unit = unit;
        this.postalCode = postalCode;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country = country;
        this.point = point;
    }

    public String getMainStreet() {
        if (mainStreet == null) {
            mainStreet = "";
        }
        return mainStreet;
    }

    public void setMainStreet(String mainStreet) {
        this.mainStreet = mainStreet;
    }

    public String getStreet1() {
        if (street1 == null) {
            street1 = "";
        }
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        if (street2 == null) {
            street2 = "";
        }
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public byte getFloor() {
        return floor;
    }

    public void setFloor(byte floor) {
        this.floor = floor;
    }

    public byte getApartment() {
        return apartment;
    }

    public void setApartment(byte apartment) {
        this.apartment = apartment;
    }

    public byte getUnit() {
        return unit;
    }

    public void setUnit(byte unit) {
        this.unit = unit;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        if (city == null) {
            city = "";
        }
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        if (district == null) {
            district = "";
        }
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        if (state == null) {
            state = "";
        }
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        if (country == null) {
            country = "";
        }
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}