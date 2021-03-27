/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author navni
 */
public class Item {

    private String itemNo;
    protected double price;
    protected int amount;
    protected String category;
    private Date firstCreatedDate;

    public Item() {
        this.itemNo = "";
        this.price = 0;
        this.amount = 0;
        this.category = "";
        this.firstCreatedDate = new Date();
    }
    
    /**
     * Item Constructor
     * @param itemNo String itemNo used to find item
     * @param price price of item
     * @param amount amount of item in BookStore
     * @param category type Of item
     */
    public Item(String itemNo, double price, int amount, String category) {
        this.itemNo = "";
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.firstCreatedDate = new Date();
    }
    
    /**
     * Copy Constructor
     * @param c copy Constructor of Item 
     */
    public Item(Item c) {
        this.itemNo = c.itemNo;
        this.price = c.price;
        this.amount = c.amount;
        this.category = c.category;
        this.firstCreatedDate = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.itemNo);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 31 * hash + this.amount;
        hash = 31 * hash + Objects.hashCode(this.category);
        hash = 31 * hash + Objects.hashCode(this.firstCreatedDate);
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
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.itemNo, other.itemNo)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.firstCreatedDate, other.firstCreatedDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "itemNo=" + itemNo + ", price=" + price
                + ", amount=" + amount + ", category=" + category
                + ", firstCreatedDate=" + firstCreatedDate + '}';
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getFirstCreatedDate() {
        return firstCreatedDate;
    }

    public void setFirstCreatedDate(Date firstCreatedDate) {
        this.firstCreatedDate = firstCreatedDate;
    }

}
