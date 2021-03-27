/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.util.Date;
import java.security.InvalidParameterException;
import java.util.Objects;

/**
 *
 * @author navni
 */
public class Stationary extends Item {

    protected String name;
    protected static int nextStationaryNo = 0;

    public Stationary() {
        this.name = "";
    }
    
    /**
     * Stationary Constructor
     * @param name String name
     * @param itemNo String itemNo
     * @param price double price
     * @param amount int amount
     * @param category String category only accepts certain Parameters
     */
    public Stationary(String name, String itemNo, double price, int amount
            , String category) {
        super(String.format("S%06d", nextStationaryNo++), price, amount, category);
        this.name = name;
        if (!this.category.equals("pen") || (!this.category.equals("notebook"))
                || (!this.category.equals("card"))
                || (!this.category.equals("others"))) {
            throw new InvalidParameterException("Only accepts pen,notebook,card"
                    + " and others for category");
        }
    }
    
    /**
     * Copy Constructor
     * @param c copy Constructor of Stationary
     */
    public Stationary(Stationary c) {
        super(c);
        this.name = c.name;
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
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
        final Stationary other = (Stationary) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stationary{" + "name=" + name + '}' + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNextStationaryNo() {
        return nextStationaryNo;
    }

    public static void setNextStationaryNo(int nextStationaryNo) {
        Stationary.nextStationaryNo = nextStationaryNo;
    }
    
}
