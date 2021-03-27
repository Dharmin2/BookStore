/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author navni
 */
public class User extends Person implements Gift {

    private Date dateOfBirth;
    private String id;
    private Address address;
    private int point;

    public User() {
        this.dateOfBirth = new Date();
        this.id = "";
        this.address = new Address();
        this.point = 0;
    }
    
    /**
     * User Constructor
     * @param dateOfBirth Date dateOfBirth
     * @param id String id
     * @param address Uses Address class for address
     * @param point int point used to by gifts
     */
    public User(Date dateOfBirth, String id, Address address, int point) {
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.address = address;
        this.point = point;
    }
    
    /**
     * Copy Constructor
     * @param c copy Constructor for User
     */
    public User(User c) {
        this.dateOfBirth = c.dateOfBirth;
        this.id = c.id;
        this.address = c.address;
        this.point = c.point;
    }

    @Override
    public Item randomGift(ArrayList<Item> gifts) {
        Random rand = new Random();
        int idx = rand.nextInt(gifts.size());
        gifts.get(idx).setAmount(gifts.get(idx).getAmount()-1);
        this.point -= 200;
        if (dateOfBirth.equals(new Date())) {
            idx = rand.nextInt(gifts.size());
            gifts.get(idx).setAmount(gifts.get(idx).getAmount()-1);
        }
        return gifts.get(idx);
    }

    @Override
    public Item randomGift(ArrayList<Item> gifts, String type) {
        if (type.equalsIgnoreCase("Stationary") || type.equalsIgnoreCase("CD")
                || type.equalsIgnoreCase("Book")) {
            do {
                Item gift = randomGift(gifts);
                if (gift.getClass().getName().equalsIgnoreCase(type)) {
                    return gift;
                }
            } while (!(randomGift(gifts).getClass().getName().equalsIgnoreCase(type)));

        }
        return null;
    
    }

    @Override
    public Item pointToGift(ArrayList<Item> gifts, String itemNo) {
        for (int i = 0; i < gifts.size(); i++) {
            if (gifts.get(i).getItemNo().equals(itemNo)) {
                this.point -= 200;
                gifts.get(i).setAmount(gifts.get(i).getAmount()-1);
                Item gift = gifts.get(i);
                return gift;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.address);
        hash = 79 * hash + this.point;
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
        final User other = (User) obj;
        if (this.point != other.point) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "dateOfBirth=" + dateOfBirth + ", id=" + id
                + ", address=" + address + ", point=" + point + '}' + super.toString();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
