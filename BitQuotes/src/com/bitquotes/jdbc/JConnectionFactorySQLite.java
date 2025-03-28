/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class JConnectionFactorySQLite {

    public static Connection getConnection() {
        String url = "jdbc:sqlite:bitQuoteDatabase.db"; // Nome do arquivo do banco de dados para acesso

        // Conexão e execução de comandos SQL
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            return connection;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Driver SQLite não encontrado!\n"+ex,"Erro de Driver!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
//    public static void main(String[] args) {
//        getConnection();
//    }
    
}
