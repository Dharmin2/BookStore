/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author navni
 */
public class BookStore {

    private ArrayList<Item> items;
    private ArrayList<Employee> employees;
    private ArrayList<Customer> customers;
    private ArrayList<Item> gifts;

    public BookStore() {
        this.items = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.gifts = new ArrayList<>();
    }
    
    /**
     * BookStore Constructor
     * @param items ArrayList of Item 
     * @param employees ArrayList of Employee
     * @param customers ArrayList of Customer
     * @param gifts ArrayList of Item
     */
    public BookStore(ArrayList<Item> items, ArrayList<Employee> employees,
            ArrayList<Customer> customers, ArrayList<Item> gifts) {
        this.items = items;
        this.employees = employees;
        this.customers = customers;
        this.gifts = gifts;
    }
    
    /**
     * Deep Copy Constructor
     * @param c Shallow Copy of BookStore
     */
    public BookStore(BookStore c) {
        this.items = new ArrayList<>(items);
        this.employees = new ArrayList<>(employees);
        this.customers = new ArrayList<>(customers);
        this.gifts = new ArrayList<>(gifts);
    }
    
    /**
     * adds product to ArrayList items
     * @param item Object of Item Class
     * @return true if item doesn't exist or updateResponce equals "y" or "yes"
     * false if updateResponce isn't "y" or "yes"
     */
    public boolean addProduct(Item item) {
        for (Item additem : items) {
            if (additem.equals(item)) {
                System.out.println("This item already exists update amount?");
                Scanner updateAmount = new Scanner(System.in);
                String updateResponce = updateAmount.nextLine();
                if (updateResponce.equals("y") || updateResponce.equals("yes")) {
                    item.setAmount(item.getAmount() + 1);
                    return true;
                } else {
                    return false;
                }
            }
        }
        items.add(item);
        return true;
    }
    
    /**
     * adds employee to ArrayList employees
     * @param employee Object of Employee class
     * @return false if employee exists else true
     */
    public boolean addEmployee(Employee employee) {
        for (Employee addemployee : employees) {
            if (addemployee.equals(employee)) {
                System.out.println("The employee is already in the list");
                return false;
            }
        }
        return true;
    }
    
    /**
     * adds customer to ArrayList customers
     * @param customer Object of Customer class
     * @return false if customer exists else true
     */
    public boolean addCustomer(Customer customer) {
        for (Customer addcustomer : customers) {
            if (addcustomer.equals(customer)) {
                System.out.println("The customer is already in the list");
                return false;
            }
        }
        return true;
    }
    
    /**
     * updates vipLevel to another int
     * @param id String to be compared with id
     * @param vipLevel int to change vipLevel to
     * @return true if id exists and response is yes else false
     */
    public boolean updateVip(String id, int vipLevel) {
        for (Customer customer : customers) {
            if (id.equals(customer.getId())) {
                Scanner updateVipLevel = new Scanner(System.in);
                vipLevel = updateVipLevel.nextInt();
                String confirm = updateVipLevel.nextLine();
                if (confirm.equals("y") || (confirm.equals("yes"))) {
                    customer.setVipLevel(vipLevel);
                    return true;
                } else {
                    return false;
                }
            }
        }
        System.out.println("ID" + id + "does not exist");
        return false;
    }
    
    /**
     * Adds Item to ArrayList if keyword equals Title or Name
     *
     * @param keyword String that is compared to class object
     * @return ArrayList searchResult
     */
    public ArrayList<Item> searchItem(String keyword) {
        ArrayList<Item> searchResult = new ArrayList<>();

        for (Item item : items) {
            if (item instanceof Book) {
                if (((Book) item).getTitle().contains(keyword)) {
                    searchResult.add(item);
                }
            } else if (item instanceof CD) {
                if (((CD) item).getName().contains(keyword)) {
                    searchResult.add(item);
                }
            } else if (item instanceof Stationary) {
                if (((Stationary) item).getName().contains(keyword)) {
                    searchResult.add(item);
                }
            }
        }
        return searchResult;
    }
    
    /**
     * Adds Item to ArrayList if Id,email,Name or PhoneNo contains keyword
     * @param keyword String that is compared to class object
     * @return ArrayList searchResult
     */
    public ArrayList<Customer> searchCustomer(String keyword) {
        ArrayList<Customer> searchResult = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getId().contains(keyword)
                    || customer.getEmail().contains(keyword)
                    || customer.getName().contains(keyword)
                    || customer.getPhoneNo().contains(keyword)) {
                searchResult.add(customer);
            }
        }
        return searchResult;
    }
    
    /**
     * checkout method determines cost of product and reduces the amount from items
     * @param id String id to find customer
     * @param items ArrayList 
     * @return cost
     */
    public double checkout(String id, ArrayList<Item> items) {
        double cost = 0;
        for (Item item : items) {
            cost += item.price;
            item.amount--;
        }

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setPoint((int) (customer.getPoint() + customer.calcPoint(cost)));
            }
        }
        return cost;
    }
    
    /**
     * Gives a list of all Users with birthday today
     * @return birthDaysToday an ArrayList of Users that have their birthday today
     */
    public ArrayList<User> firstBirthdayUser() {
        ArrayList<User> birthDaysToday = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getDateOfBirth().equals(new Date())) {
                birthDaysToday.add(customer);
            }
        }
        for (Employee employee : employees) {
            if (employee.getDateOfBirth().equals(new Date())) {
                birthDaysToday.add(employee);
            }
        }
        return birthDaysToday;
    }
}
