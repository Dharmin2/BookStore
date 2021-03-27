/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author navni
 */
public class CD extends Item {

    protected String name;
    protected Person artist;
    protected Publisher publisher;
    protected static int nextCdNo;

    public CD() {
        super.setItemNo(String.format("C%06d",nextCdNo++));
        this.name = "";
        this.artist = new Person();
        this.publisher = new Publisher();
    }
    
    /**
     * Constructor of CD
     * @param name String name of CD
     * @param price double price of CD
     * @param amount int amount of CD
     * @param category type of CD only accepts certain parameters
     */
    public CD(String name, double price, int amount, String category) {
        super(String.format("C%06d", nextCdNo++), price, amount, category);
        this.name = name;
        this.price =  price;
        this.amount = amount;
        if (!this.category.equals("pop") || !this.category.equals("classic")
                || !this.category.equals("jazz") || !this.category.equals("new age")
                || !this.category.equals("sound track")
                || !this.category.equals("others")) {
            throw new InvalidParameterException("Only accepts jazz,new age,"
                    + "sound track and others");
        }
        this.category = category;
    }
    
    /**
     * Copy Constructor
     * @param c copy of CD Constructor
     */
    public CD(CD c) {
        super(c);
        this.name = c.name;
        this.artist = c.artist;
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.artist);
        hash = 61 * hash + Objects.hashCode(this.publisher);
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
        final CD other = (CD) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CD{" + "name=" + name + ", artist=" + artist +
                ", publisher=" + publisher + '}' + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getArtist() {
        return artist;
    }

    public void setArtist(Person artist) {
        this.artist = artist;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public static int getNextCdNo() {
        return nextCdNo;
    }

    public static void setNextCdNo(int nextCdNo) {
        CD.nextCdNo = nextCdNo;
    }
    
}
