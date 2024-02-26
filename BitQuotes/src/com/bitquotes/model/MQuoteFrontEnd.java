/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.model;

/**
 *
 * @author bruno
 */
public class MQuoteFrontEnd {
    
    private int id;
    private String quote;
    private String bookName;
    private short pageBook;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getQuote() {
        return this.quote;
    }
    
    public void setQuote(String quote) {
        this.quote = quote;
    }
    
    public String getBookName() {
        return this.bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public short getPageBook() {
        return this.pageBook;
    }
    
    public void setPageBook(short pageBook) {
        this.pageBook = pageBook;
    }
         
}
