/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

/**
 *
 * @author arauj
 */

import com.bitquotes.jdbc.dao.DSelect;

public class CConfirmsIdentity {
    
    public static boolean confirmsIdentity(String user, String password) {
        boolean verification = DSelect.confirmsIdentity(user, password);
        return verification;
    }
    
}
