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
public class Employee extends User{
    private static int nextEmployeeId;
    private double salary;
    private Date firstDayHired;

    public Employee() {
        super();
        this.nextEmployeeId = 0;
        this.salary = 0;
        this.firstDayHired = new Date();
    }
    
    /**
     * Employee Constructor
     * @param nextId int id of Employee
     * @param salary double salary of Employee
     * @param firstDayHired Date firstDayHired for calculating points
     * @param dateOfBirth Date DateOfBirth
     * @param id String id to find employee
     * @param address Uses Address Class for address
     * @param point points for employee used to buy gifts
     */
    public Employee(int nextId, double salary, Date firstDayHired,
            Date dateOfBirth, String id, Address address, int point) {
        super(dateOfBirth, String.format("E%06d", nextEmployeeId++), address, point);
        this.firstDayHired = firstDayHired;
        this.salary = salary;
    }
    
    /**
     * Copy Constructor
     * @param c Copy of Employee Constructor
     */
    public Employee(Employee c) {
        super(c);
        this.salary = c.salary;
    }
    
    /**
     * Calculates amount of points for employee
     * @return amount of points
     */
    public int calcPoint() {
        Date currentDate = new Date();
        long days = (currentDate.getTime() - firstDayHired.getTime()) / 86400000;
        long months = days / 30;
        long years = months / 12;
        
        for (int i = 0; i < years; i++) {
            super.setPoint(super.getPoint() + 365 + (12 * i));
        }
        months = (days - (years * 365)) / 30;
        super.setPoint((int) (super.getPoint() + (days - (years * 365)) + (months * years)));;
        return super.getPoint();
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 5;
        hash = 59 * hash + this.nextEmployeeId;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.firstDayHired);
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
        final Employee other = (Employee) obj;
        if (this.nextEmployeeId != other.nextEmployeeId) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary)) {
            return false;
        }
        if (!Objects.equals(this.firstDayHired, other.firstDayHired)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "nextId=" + nextEmployeeId + ", salary=" + salary +
                ", firstDayHired=" + firstDayHired + '}' + super.toString();
    }

    public int getNextId() {
        return nextEmployeeId;
    }

    public void setNextId(int nextId) {
        this.nextEmployeeId = nextId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getFirstDayHired() {
        return firstDayHired;
    }

    public void setFirstDayHired(Date firstDayHired) {
        this.firstDayHired = firstDayHired;
    }
    
}
