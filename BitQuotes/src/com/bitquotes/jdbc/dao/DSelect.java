/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

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
            ArrayList arrayUser = new ArrayList();
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT us_nome, us_senha FROM usuario";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            ResultSet rs; //Declarando objeto para pegar o resultado da consulta
            rs = stmt.executeQuery(); //Executando a consulta e pegando todo o resultado da consluta na variável rs
            rs.first(); //Iniciando o ResultSet "rs"
            do {
                arrayUser[i] = rs.getString("us_user");
                i++;
            } while (rs.next());
            stmt.close(); //Fechando o PrepareStatement
            rs.close(); //Fechando o ResultSet
            con.close(); //Fechando a conexão
            return arrayUser;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro de banco de dados!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
