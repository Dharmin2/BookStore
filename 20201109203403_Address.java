/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.util.Objects;

/**
 *
 * @author navni
 */
public class Address {

    private int streetNo;
    private String street;
    private String city;
    private String zipCode;
    
    public Address() {
        this.streetNo = 0;
        this.street = "";
        this.city = "";
        this.zipCode = "";
    }
    
    /**
     * Address Constructor
     * @param streetNo integer of streetNo
     * @param street name of street
     * @param city name of city
     * @param zipCode zipCode of location
     */
    public Address(int streetNo, String street, String city, String zipCode) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    /**
     * Copy Constructor
     * @param c shallow copy of Address constructor
     */
    public Address(Address c) {
        this.streetNo = c.streetNo;
        this.street = c.street;
        this.city = c.city;
        this.zipCode = c.zipCode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.streetNo;
        hash = 59 * hash + Objects.hashCode(this.street);
        hash = 59 * hash + Objects.hashCode(this.city);
        hash = 59 * hash + Objects.hashCode(this.zipCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.streetNo != other.streetNo) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "streetNo=" + streetNo + ", street=" + street +
                ", city=" + city + ", zipCode=" + zipCode + '}';
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
}
