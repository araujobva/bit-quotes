/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.model.MQuote;
import com.bitquotes.jdbc.dao.DUpdate;

/**
 *
 * @author wolf
 */
public class CQuoteUpdate {
    
    public static boolean quoteUpdate(MQuote objQuote) {
        boolean verification = DUpdate.quoteUpdate(objQuote);
        return verification;
    }
    
}
