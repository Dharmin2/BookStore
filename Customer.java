/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.util.Date;

/**
 *
 * @author navni
 */
public class Customer extends User {

    private int vipLevel;
    private static int nextCustomerId;
 
    public Customer() {
        super();
        this.vipLevel = 0;
    }
    
    /**
     * Customer constructor
     * @param vipLevel int vipLevel for points
     * @param dateOfBirth Date of Birth
     * @param id String id to find customer
     * @param address Uses Address Class for address
     * @param point int points used to buy gifts
     */
    public Customer(int vipLevel, Date dateOfBirth, String id, Address address,
            int point) {
        super(dateOfBirth, String.format("U%06d", nextCustomerId++), address, point);
        this.vipLevel = vipLevel;
    }
    
    /**
     * Copy constructor
     * @param c copy of Customer constructor
     */
    public Customer(Customer c) {
        super(c);
        this.vipLevel = c.vipLevel;
    }
    
    /**
     * Calculates the points of the user
     * @param amountSpent amount of money the customer spent
     * @return point for customer
     */
    public int calcPoint(double amountSpent) {
        double[] vipLevels = {1.0,1.05,1.1,1.15};
        double level = vipLevels[vipLevel];
        
        if (amountSpent > 200) {
            super.setPoint(super.getPoint() + 20);
        }
        super.setPoint((int) (amountSpent * level) + (super.getPoint()));
        return super.getPoint();
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 7;
        hash = 73 * hash + this.vipLevel;
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
        final Customer other = (Customer) obj;
        if (this.vipLevel != other.vipLevel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "vipLevel=" + vipLevel + '}' + super.toString();
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }
    
}
