/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.DDelete;

/**
 *
 * @author Wolf
 */
public class CDeleteQuote {
    
    public static boolean deleteQuote(int idQuote) {
        DDelete.deleteQuote(idQuote);
        return true;
    }
    
}
