/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.sqlite.SSelect;

/**
 *
 * @author bruno
 */
public class CSearchAuthorName {
    
    public static String cSearchAuthorName(String bookName) {
        String author = SSelect.authorName(bookName);
        if(author != null) {
            return author;
        }else {
            return null;
        }
    }
    
}
