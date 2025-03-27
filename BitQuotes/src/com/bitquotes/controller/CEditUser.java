/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.mysql.MUpdate;
import com.bitquotes.model.MUser;

/**
 *
 * @author bruno
 */
public class CEditUser {
    
    public static boolean cEditUser(MUser user, String oldUser) {
        return MUpdate.userUpdate(user, oldUser);
    }
    
}
