/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.model;

/**
 *
 * @author Bruno
 */
public class MBook {
    
    private int id;
    private String name;
    private String author;
    //private ??? photo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the bookName
     */
    public String getName() {
        return name;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setName(String bookName) {
        this.name = bookName;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
   
}
