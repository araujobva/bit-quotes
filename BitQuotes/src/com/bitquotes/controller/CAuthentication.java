/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.jdbc.dao.DSelect;
import com.bitquotes.model.MUser;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class CAuthentication {

    public static boolean authentication(MUser user) {
        ArrayList<MUser> userList = new ArrayList<MUser>();
        userList = DSelect.authentication();
        for(int i = 0; i < userList.size(); i++) { 
            if(userList.get(i).getName().equals(user.getName()) && userList.get(i).getPassword().equals(user.getPassword()))
                return true;
        }
        return false;
    }
}
