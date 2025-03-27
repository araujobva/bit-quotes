/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao.mysql;

import com.bitquotes.jdbc.JConnectionFactoryMySQL;
import com.bitquotes.model.MBook;
import com.bitquotes.model.MQuote;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import com.bitquotes.model.MUser;

/**
 *
 * @author bruno
 */
public class MInsert {

    public static boolean insertBook(MBook objBookName) {
        try {
            Connection con = JConnectionFactoryMySQL.getConnection();
            String query = "INSERT INTO book (book.bo_name, book.bo_author, book.us_us_name) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, objBookName.getName());
            stmt.setString(2, objBookName.getAuthor());
            stmt.setString(3, objBookName.getUserName());
            stmt.executeUpdate();
            con.close();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Esse livro já existe!\n" + ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean insertQuote(MQuote objQuote) {
        try {
            Connection con = JConnectionFactoryMySQL.getConnection();
            String query = "INSERT INTO quote (qu_quote, qu_book_page, bo_id, us_name) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, objQuote.getQuote());
            stmt.setString(2, objQuote.getBookPage());
            stmt.setInt(3, objQuote.getId());
            stmt.setString(4, objQuote.getUserOwner());
            stmt.executeUpdate();
            con.close();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir citação!\n" + ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean addUser(MUser user) {
        try {
            Connection con = JConnectionFactoryMySQL.getConnection();
            String query = "INSERT INTO user (us_name, us_password, us_administrator) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setBoolean(3, user.getAdministrator());
            stmt.executeUpdate();
            con.close();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar um novo usuário!\nESSE USUÁRIO JÁ EXISTE!","ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}


