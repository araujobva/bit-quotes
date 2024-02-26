/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.DInsert;
import com.bitquotes.model.MQuote;

/**
 *
 * @author bruno
 */
public class CAdd {
    
    public static boolean addQuote(MQuote objQuote) {
        boolean verification = DInsert.insertQuote(objQuote);
        return verification;
    } 
    
}
