/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bitquotes.jdbc.JConnectionFactory;

/**
 *
 * @author Bruno
 */
public class DDelete {

    public static boolean deleteBook(String bookName) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query0 = "DELETE FROM "; 
            String query1 = "DELETE FROM book WHERE bo_name = ?"; //Excluindo livro
            PreparedStatement stmt = con.prepareStatement(query0);
            //stmt.setInt(1, query0);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
