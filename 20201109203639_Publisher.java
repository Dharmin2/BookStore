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
class Publisher extends Address {
    private String name;
    private Person contact;
    private Address address;

    public Publisher() {
        this.name = "";
        this.contact = new Person();
        this.address = new Address();
    }

    /**
     * Publisher Constructor
     * @param name String Name 
     * @param contact Uses Person Class for contact
     * @param address Uses Address class for address
     * @param streetNo int streetNo
     * @param street String street
     * @param city String city
     * @param zipCode String zipCode
     */
    public Publisher(String name, Person contact, Address address, int streetNo,
            String street, String city, String zipCode) {
        super(streetNo, street, city, zipCode);
        this.name = name;
        this.contact = contact;
        this.address = address;
    }
    
    /**
     * Copy Constructor
     * @param c copy Constructor for Publisher
     */
    public Publisher(Publisher c) {
        super(c);
        this.name = c.name;
        this.contact = c.contact;
        this.address = c.address;
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.contact);
        hash = 97 * hash + Objects.hashCode(this.address);
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
        final Publisher other = (Publisher) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publisher{" + "name=" + name + ", contact=" + contact +
                ", address=" + address + '}' + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getContact() {
        return contact;
    }

    public void setContact(Person contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
