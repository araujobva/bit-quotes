/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import java.util.ArrayList;
import com.bitquotes.jdbc.dao.DSelect;
import com.bitquotes.model.MQuoteFrontEnd;

/**
 *
 * @author bruno
 */
public class CSearchQuote {
    
    public static ArrayList searchQuoteBookName(String user, String bookName) {
        ArrayList<MQuoteFrontEnd> quoteList = new ArrayList<MQuoteFrontEnd>();
        quoteList = DSelect.searchBookName(user, bookName);
        return quoteList;
    }
    
    public static ArrayList searchQuote(String user, String quotePiece) {
        ArrayList<MQuoteFrontEnd> quoteList = new ArrayList<MQuoteFrontEnd>();
        quoteList = DSelect.searchQuote(user, quotePiece);
        return quoteList;
    }
    
}
