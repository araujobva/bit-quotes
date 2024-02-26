/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.model;

/**
 *
 * @author bruno
 */
public class MUser {
    
    private String name;
    private String password;
    private boolean administrator;
      
    public String getName() {
        return this.name;
    }
    
    public void setName(String user) {
        this.name = user;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean getAdministrator() {
	    return this.administrator;
    }
    
    public void setAdministrator(boolean administrator) {
	    this.administrator = administrator;
    }
    
}
