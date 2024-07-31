/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

/**
 *
 * @author bruno
 */

import com.bitquotes.model.MUser;
import com.bitquotes.jdbc.dao.DInsert;

public class CAddUser {
    
    public static boolean cAddUser(MUser user) {
        return DInsert.addUser(user);
    }
    
}
