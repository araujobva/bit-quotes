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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class DSelect {
    
    public static ArrayList authentication() {
        try {
            ArrayList<MUser> arrayUser = new ArrayList<MUser>();
            MUser objUser = new MUser();
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT us_name, us_password, us_administrator FROM user";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            ResultSet rs; //Declarando objeto do tipo ResultSet para pegar o resultado da consulta no banco de dados
            rs = stmt.executeQuery(); //Executando a consulta e pegando todo o resultado da consluta na variável rs
            rs.first(); //Iniciando o ResultSet "rs" na primeira posição 
            do {
               // arrayUser[i] = rs.getString("us_user");
	       objUser.setUser(rs.getString("us_name")); 
	       objUser.setPassword(rs.getString("us_password"));
	       objUser.setAdministrator(rs.getBoolean("us_administrator"));
	       arrayUser.add(objUser);
            } while (rs.next()); //Faça enquanto tiver dados no rs
            stmt.close(); //Fechando o PrepareStatement
            rs.close(); //Fechando o ResultSet
            con.close(); //Fechando a conexão
            return arrayUser;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            //ex.printStackTrace();
            return null;
        }
    }
}
