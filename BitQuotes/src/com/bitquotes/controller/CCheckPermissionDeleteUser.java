/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.sqlite.SSelect;

/**
 *
 * @author wolf
 */
public class CCheckPermissionDeleteUser {
    
    public static boolean checkPermissionDeleteUser(String user) {
        boolean verification = SSelect.checkPermissionDeleteUser(user);
        return verification;
    }
    
}
