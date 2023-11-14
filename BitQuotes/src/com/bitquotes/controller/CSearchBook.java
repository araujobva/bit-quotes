/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import java.util.ArrayList;
import com.bitquotes.model.MBookName;
import com.bitquotes.jdbc.dao.DSelect;

/**
 *
 * @author Bruno
 */
public class CSearchBook {
    
    public static ArrayList cSearchBook(String user) {
        ArrayList<MBookName> bookList = new ArrayList<MBookName>();
        bookList = DSelect.searchBook(user);
        return bookList;
    }
    
}
