/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.mysql.MInsert;
import com.bitquotes.jdbc.dao.mysql.MSelect;
import com.bitquotes.jdbc.dao.mysql.MDelete;
import com.bitquotes.jdbc.dao.mysql.MUpdate;
import com.bitquotes.model.MBook;

/**
 *
 * @author bruno
 */
public class CManageBook {
    
    public static boolean addBook(MBook objBookName) {
        boolean verification = MInsert.insertBook(objBookName);
        return verification;
    }
    
    public static boolean removeBook(String bookName, String user) {
        int idBook = MSelect.searchIdBook(bookName, user);
        boolean verification = MDelete.deleteQuoteAndBook(idBook, bookName);
        return verification;
    }
    
    public static boolean updateBook(MBook bookNew, MBook bookOld) {
        int bookId = MSelect.searchIdBook(bookOld);
        boolean verification = MUpdate.bookUpdate(bookNew, bookId);
        return verification;
    }
    
}
