/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.sqlite.SDelete;

/**
 *
 * @author bruno
 */
public class CRemoveUser {
    
    public static boolean cRemoveUser(String user) {
        return SDelete.deleteUser(user);
    }
    
}
