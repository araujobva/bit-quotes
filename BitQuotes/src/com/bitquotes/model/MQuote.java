/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.model;

/**
 *
 * @author bruno
 */
public class MQuote {
    
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

//mysql> describe quote;
//+--------------+-------------+------+-----+---------+----------------+
//| Field        | Type        | Null | Key | Default | Extra          |
//+--------------+-------------+------+-----+---------+----------------+
//| qu_id        | int         | NO   | PRI | NULL    | auto_increment |
//| qu_quote     | longtext    | NO   |     | NULL    |                |
//| qu_book_page | smallint    | NO   |     | NULL    |                |
//| bo_id        | int         | NO   | MUL | NULL    |                |
//| us_name      | varchar(45) | NO   | MUL | NULL    |                |
//+--------------+-------------+------+-----+---------+----------------+

//mysql> describe book;
//+-----------+-------------+------+-----+---------+----------------+
//| Field     | Type        | Null | Key | Default | Extra          |
//+-----------+-------------+------+-----+---------+----------------+
//| bo_id     | int         | NO   | PRI | NULL    | auto_increment |
//| bo_name   | varchar(90) | NO   |     | NULL    |                |
//| bo_author | varchar(90) | NO   |     | NULL    |                |
//| bo_photo  | longblob    | YES  |     | NULL    |                |
//+-----------+-------------+------+-----+---------+----------------+
