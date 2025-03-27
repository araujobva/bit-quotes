/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import java.util.ArrayList;
import com.bitquotes.model.MBook;
import com.bitquotes.jdbc.dao.mysql.MSelect;
import com.bitquotes.jdbc.dao.mysql.MSelect;

/**
 *
 * @author bruno
 */
public class CSearchBook {
    
    public static ArrayList cSearchBook(String user) {
        ArrayList<MBook> bookList = new ArrayList<MBook>();
        bookList = MSelect.searchBook(user);
        return bookList;
    }
    
    public static int cSearchIdBook(String bookName, String user) {
        int idBook = MSelect.searchIdBook(bookName, user);
        return idBook;
    }
    
}
