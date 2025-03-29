/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import com.bitquotes.view.VJFrameAuthentication;
import com.bitquotes.view.VJFrameAddUserFirstAccess;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class CMain {
    
    public static void main(String[] args) {
        ArrayList<String> userList= new ArrayList<String>();
        userList = CRecoverUser.cRecoverUser();
        boolean verification = false;
        for (int i = 0; i < userList.size(); i++) {
           verification = true;
        }
        if (verification) {
            VJFrameAuthentication screen = new VJFrameAuthentication();
            screen.setVisible(true);
        } else if (!verification) {
            VJFrameAddUserFirstAccess screenAddUser = new VJFrameAddUserFirstAccess();
            screenAddUser.setVisible(true);
        }
    }
    
}
