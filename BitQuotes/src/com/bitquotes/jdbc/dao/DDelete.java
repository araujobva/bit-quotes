/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.bitquotes.jdbc.JConnectionFactory;

/**
 *
 * @author Bruno
 */
public class DDelete {

    public static boolean deleteQuoteAndBook(int idBook, String bookName) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query0 = "DELETE FROM quote WHERE quote.bo_id = ?"; 
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
            JOptionPane.showMessageDialog(null,"Erro ao excluir o livro!\n"+ex,"Erro de exclusão!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean deleteQuote(int idQuote) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "DELETE FROM quote WHERE quote.qu_id = ?"; 
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idQuote);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir o citação!\n"+ex,"Erro de exclusão!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
