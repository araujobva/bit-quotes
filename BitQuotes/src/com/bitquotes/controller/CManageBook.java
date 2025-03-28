/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.sqlite.SInsert;
import com.bitquotes.jdbc.dao.sqlite.SSelect;
import com.bitquotes.jdbc.dao.sqlite.SDelete;
import com.bitquotes.jdbc.dao.sqlite.SUpdate;
import com.bitquotes.model.MBook;

/**
 *
 * @author bruno
 */
public class CManageBook {
    
    public static boolean addBook(MBook objBookName) {
        boolean verification = SInsert.insertBook(objBookName);
        return verification;
    }
    
    public static boolean removeBook(String bookName, String user) {
        int idBook = SSelect.searchIdBook(bookName, user);
        boolean verification = SDelete.deleteQuoteAndBook(idBook, bookName);
        return verification;
    }
    
    public static boolean updateBook(MBook bookNew, MBook bookOld) {
        int bookId = SSelect.searchIdBook(bookOld);
        boolean verification = SUpdate.bookUpdate(bookNew, bookId);
        return verification;
    }
    
}
