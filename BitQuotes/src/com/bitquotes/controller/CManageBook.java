/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.DInsert;
import com.bitquotes.model.MBookName;

/**
 *
 * @author Bruno
 */
public class CManageBook {
    
    public static boolean addBook(MBookName objBookName) {
        boolean verification = DInsert.insertBook(objBookName);
        return verification;
    }
    
    public static boolean removeBook(String bookName) {
        boolean verification = true;
        return verification;
    }
    
}
