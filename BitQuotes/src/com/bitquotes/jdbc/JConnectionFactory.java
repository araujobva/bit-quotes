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
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Definindo o driver do meu projeto. (NOTA: Para funcionar, importe o driver de conexão para o projeto.)
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bit_quotes","root",""); //Retornando uma conexão para o método que chamar este método.          
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Driver MySQL não encontrado.\n"+ex,"Erro de Driver",JOptionPane.ERROR_MESSAGE);
            System.out.println("Driver MySQL não encontrado."+ex);
            return null;
        } 
    }
}
