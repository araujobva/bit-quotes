/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import java.util.ArrayList;
import com.bitquotes.jdbc.dao.sqlite.SSelect;
import com.bitquotes.model.MQuote;

/**
 *
 * @author bruno
 */
public class CSearchQuote {
    
    public static ArrayList searchQuoteBookName(String user, String bookName) {
        ArrayList<MQuote> quoteList = new ArrayList<MQuote>();
        quoteList = SSelect.searchBookName(user, bookName);
        return quoteList;
    }
    
    public static ArrayList searchQuote(String user, String quotePiece) {
        ArrayList<MQuote> quoteList = new ArrayList<MQuote>();
        quoteList = SSelect.searchQuote(user, quotePiece);
        return quoteList;
    }
    
}
