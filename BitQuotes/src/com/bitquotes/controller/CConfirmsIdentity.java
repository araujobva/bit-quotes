/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

/**
 *
 * @author bruno
 */
import com.bitquotes.jdbc.dao.sqlite.SSelect;

public class CConfirmsIdentity {
    
    public static boolean confirmsIdentity(String user, String password) {
        boolean verification = SSelect.confirmsIdentity(user, password);
        return verification;
    }
    
}
