/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.bitquotes.jdbc.JConnectionFactorySQLite;

/**
 *
 * @author bruno
 */
public class SDelete {

    public static boolean deleteQuoteAndBook(int idBook, String bookName) {
        try {
            Connection con = JConnectionFactorySQLite.getConnection();
            String query0 = "DELETE FROM quote WHERE bo_id = ?"; 
            String query1 = "DELETE FROM book WHERE bo_name = ?"; 
            PreparedStatement stmt0 = con.prepareStatement(query0);
            PreparedStatement stmt1 = con.prepareStatement(query1);
            stmt0.setInt(1, idBook);
            stmt1.setString(1, bookName);
            stmt0.executeUpdate();
            stmt1.executeUpdate();
            stmt0.close();
            stmt1.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir o livro!\n"+ex,"ERRO!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean deleteQuote(int idQuote) {
        try {
            Connection con = JConnectionFactorySQLite.getConnection();
            String query = "DELETE FROM quote WHERE qu_id = ?"; 
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idQuote);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir o citação!\n"+ex,"ERRO!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean deleteUser(String user) {
        try {
            Connection con = JConnectionFactorySQLite.getConnection();
            String query = "DELETE FROM user WHERE us_name = ?"; 
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir o usuário!\n"+ex,"ERRO!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
