/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.sqlite.SSelect;

/**
 *
 * @author bruno
 */
public class CCheckADM {
    
    public static boolean cCheckADM(String user) {
        boolean adm = SSelect.checkADM(user);
        return adm;
    }
    
}
