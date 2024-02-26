/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.DInsert;
import com.bitquotes.jdbc.dao.DSelect;
import com.bitquotes.jdbc.dao.DDelete;
import com.bitquotes.model.MBook;

/**
 *
 * @author Bruno
 */
public class CManageBook {
    
    public static boolean addBook(MBook objBookName) {
        boolean verification = DInsert.insertBook(objBookName);
        return verification;
    }
    
    public static boolean removeBook(String bookName) {
        int idBook = DSelect.searchIdBook(bookName);
        boolean verification = DDelete.deleteQuoteAndBook(idBook, bookName);
        return verification;
    }
    
}
