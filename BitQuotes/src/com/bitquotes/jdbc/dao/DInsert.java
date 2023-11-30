/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

import com.bitquotes.jdbc.JConnectionFactory;
import com.bitquotes.model.MBookName;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Bruno
 */
public class DInsert {
    
    public static boolean insertBook(MBookName objBookName) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "INSERT INTO book (book.bo_name, book.bo_author) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, objBookName.getBookName());
            stmt.setString(2, objBookName.getAuthor());
            stmt.executeUpdate();
            con.close();
            stmt.close();
            return true;
        }catch (SQLException ex) {
            return false;
        }
    }
    
}
