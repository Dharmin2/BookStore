/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject7;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author navni
 */
public class Book extends Item {

    protected String title;
    protected ArrayList<Person> authors;
    protected String isbn;
    protected Publisher publisher;
    protected static int nextBookNo = 0;

    public Book() {
        super();
        this.title = "";
        this.authors = new ArrayList<Person>();
        this.isbn = "";
        this.publisher = new Publisher();
    }
    
    /**
     * Book Constructor
     * @param title String name of book
     * @param authors an array of Person all authors of the book
     * @param isbn String isbn of Book
     * @param publisher Uses Publisher class, publisher of book
     * @param itemNo The String pattern of itemNo
     * @param price double the price of the book
     * @param amount int amount of that book
     * @param category String type of book only accepts certain parameters
     */
    public Book(String title, ArrayList<Person> authors, String isbn,
            Publisher publisher, String itemNo, double price, int amount,
            String category) {
        super(String.format("B%06d", nextBookNo++), price, amount, category);
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
                if (!this.category.equals("history") || !this.category.equals("science")
                || !this.category.equals("cook") || !this.category.equals("art")
                || !this.category.equals("sports")
                || !this.category.equals("others")) {
            throw new InvalidParameterException("Invalid parameter only accepts"
                    + "history,science,cook,sports and others");
        }
        this.category = category;
    }
    
    /**
     * Copy Constructor
     * @param c Shallow copy of Book
     */
    public Book(Book c) {
        super(c);
        this.title = c.title;
        this.authors = c.authors;
        this.isbn = c.isbn;
        this.publisher = c.publisher;
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.authors);
        hash = 97 * hash + Objects.hashCode(this.isbn);
        hash = 97 * hash + Objects.hashCode(this.publisher);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.authors, other.authors)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", authors=" + authors +
                ", isbn=" + isbn + ", publisher=" + publisher + '}' + super.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Person> authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public static int getNextBookNo() {
        return nextBookNo;
    }

    public static void setNextBookNo(int nextBookNo) {
        Book.nextBookNo = nextBookNo;
    }
    
    
}
