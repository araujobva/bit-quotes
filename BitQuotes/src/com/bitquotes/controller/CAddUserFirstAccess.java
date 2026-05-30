/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.model.MUser;
import com.bitquotes.jdbc.dao.sqlite.SInsert;

/**
 *
 * @author wolf
 */
public class CAddUserFirstAccess {
    
    public static boolean cAddUserFirstAccess(MUser user) {
        boolean verification = SInsert.addUserFirstAccess(user);
        return verification;
    }
    
}
