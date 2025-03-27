/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.mysql.MSelect;
import com.bitquotes.model.MUser;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class CAuthentication {

    public static boolean authentication(MUser user) {
        ArrayList<MUser> userList = new ArrayList<MUser>();
        userList = MSelect.authentication();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(user.getName()) && userList.get(i).getPassword().equals(user.getPassword())) {
                user.setAdministrator(userList.get(i).getAdministrator());
                return true;
            }
        }
        return false;
    }
    
}
