/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class JConnectionFactory {
    
    private static String driverJDBC = "com.mysql.jdbc.Driver";
    //private static String connectionPath = "jdbc:mysql://127.0.0.1/bit_quote_test";
    private static String connectionPath = "jdbc:mysql://127.0.0.1/bit_quote?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "8528";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(driverJDBC); //Definindo o driver do meu projeto. (NOTA: Para funcionar, importe o driver de conexão para o projeto)
            return DriverManager.getConnection(connectionPath, user, password); //Retornando uma conexão para o método que chamar este método.          
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Driver MySQL não encontrado!\n"+ex,"Erro de Driver!",JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
}
