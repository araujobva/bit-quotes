/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.DSelect;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class CRecoverUser {
    
    public static ArrayList cRecoverUser() {
        ArrayList<String> userList = new ArrayList<String>();
        userList = DSelect.recoverUser();
        return userList;
    }
    
}
