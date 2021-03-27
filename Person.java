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
public class Person {

    private String name;
    private String gender;
    private String phoneNo;
    private String email;

    public Person() {
        this.name = "";
        this.gender = "";
        this.phoneNo = "";
        this.email = "";
    }
    
    /**
     * Person Constructor
     * @param name String name 
     * @param gender String gender 
     * @param phoneNo String phoneNo 
     * @param email String email 
     */
    public Person(String name, String gender, String phoneNo, String email) {
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    
    /**
     * Copy constructor
     * @param c copy Constructor of Person
     */
    public Person(Person c) {
        this.name = c.name;
        this.gender = c.gender;
        this.phoneNo = c.phoneNo;
        this.email = c.email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.gender);
        hash = 53 * hash + Objects.hashCode(this.phoneNo);
        hash = 53 * hash + Objects.hashCode(this.email);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.phoneNo, other.phoneNo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", gender=" + gender
                + ", phoneNo=" + phoneNo + ", email=" + email + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
