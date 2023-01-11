/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.DSelect;
import com.bitquotes.model.MUser;

/**
 *
 * @author bruno
 */
public class CAuthentication {

    public static boolean authentication(MUser user) {
        DSelect.authentication();
        return true;
    }
}
