/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

import com.bitquotes.model.MUser;
import com.bitquotes.jdbc.JConnectionFactory;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class DSelect {
    
    public static ArrayList authentication() {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT us_name, us_password, us_administrator FROM user";
            ResultSet rs = con.createStatement().executeQuery(query);
            ArrayList<MUser> userList = new ArrayList<MUser>();
            MUser objUser = new MUser();
            while (rs.next()) { //Enquanto tiver dados no ResultSet "rs" o while faz
                objUser.setUser(rs.getString("us_name"));
                objUser.setPassword(rs.getString("us_password"));
                objUser.setAdministrator(rs.getBoolean("us_administrator"));
                userList.add(objUser);
                objUser = new MUser(); //Para não duplicar os valors no ArrayList
            }
            con.close(); //Fechando a conexão
            rs.close(); //Fechando o ResultSet
            return userList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na autenticação!"+ex,"Erro!",JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }
}

