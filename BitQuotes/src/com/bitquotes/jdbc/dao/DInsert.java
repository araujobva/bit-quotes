/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

import com.bitquotes.jdbc.JConnectionFactory;
import com.bitquotes.model.MBook;
import com.bitquotes.model.MQuote;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class DInsert {
    
    public static boolean insertBook(MBook objBookName) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "INSERT INTO book (book.bo_name, book.bo_author) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, objBookName.getName());
            stmt.setString(2, objBookName.getAuthor());
            stmt.executeUpdate();
            con.close();
            stmt.close();
            return true;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir livro!\n"+ex,"ERRO!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean insertQuote(MQuote objQuote) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "INSERT INTO quote (qu_quote, qu_book_page, bo_id, us_name) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, objQuote.getQuote());
            stmt.setShort(2, objQuote.getBookPage());
            stmt.setInt(3, objQuote.getId());
            stmt.setString(4, objQuote.getUserOwner());
            stmt.executeUpdate();
            con.close();
            stmt.close();
            return true;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir citação!\n"+ex,"ERRO!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
