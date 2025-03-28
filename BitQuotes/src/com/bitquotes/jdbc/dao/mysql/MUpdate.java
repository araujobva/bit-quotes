/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bitquotes.jdbc.JConnectionFactoryMySQL;
import com.bitquotes.model.MBook;
import com.bitquotes.model.MQuote;
import com.bitquotes.model.MUser;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class MUpdate {

    public static boolean bookUpdate(MBook objBook, int idBook) {
        try {
            Connection con = JConnectionFactoryMySQL.getConnection();
            String query = "UPDATE book SET bo_name = ?, bo_author = ? WHERE bo_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, objBook.getName());
            stmt.setString(2, objBook.getAuthor());
            stmt.setInt(3, idBook);
            stmt.executeUpdate();
            stmt.close(); // Fechando o PrepareStatement
            con.close(); // Fechando a conexão          
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível modificar!\n" + ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean quoteUpdate(MQuote quote) {
        try {
            Connection con = JConnectionFactoryMySQL.getConnection();
            String query = "UPDATE quote SET qu_quote = ?, qu_book_page = ?, bo_id = ?, us_name = ? WHERE qu_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, quote.getQuote());
            stmt.setString(2, quote.getBookPage());
            stmt.setInt(3, quote.getBookId());
            stmt.setString(4, quote.getUserOwner());
            stmt.setInt(5, quote.getId());
            stmt.executeUpdate();
            String query2 = "UPDATE book SET bo_author = ? WHERE book.bo_id = ?";
            PreparedStatement stmt2 = con.prepareStatement(query2);
            stmt2.setString(1, quote.getAuthor());
            stmt2.setInt(2, quote.getBookId());
            stmt2.executeUpdate();
            stmt.close(); // Fechando o PrepareStatement
            stmt2.close();
            con.close(); // Fechando a conexão          
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a citação!\n" + ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean userUpdate(MUser user, String oldUser) {
        try {
            Connection con = JConnectionFactoryMySQL.getConnection();
            String query = "UPDATE user SET us_name = ?, us_password = ?, us_administrator = ? WHERE us_name = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setBoolean(3, user.getAdministrator());
            stmt.setString(4, oldUser);
            stmt.executeUpdate();
            stmt.close(); // Fechando o PrepareStatement
            con.close(); // Fechando a conexão          
            return true;  
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o usuário!\n" +ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}

