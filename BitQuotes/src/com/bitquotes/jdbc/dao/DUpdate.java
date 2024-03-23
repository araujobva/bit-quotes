/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bitquotes.jdbc.JConnectionFactory;
import com.bitquotes.model.MBook;
import com.bitquotes.model.MQuote;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class DUpdate {

    public static boolean bookUpdate(MBook objBook, int idBook) {  
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "UPDATE book SET bo_name = ?, bo_author = ? WHERE bo_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, objBook.getName());
            stmt.setString(2, objBook.getAuthor());
            stmt.setInt(3, idBook);
            stmt.executeUpdate();
            stmt.close(); //Fechando o PrepareStatement
            con.close(); //Fechando a conexão          
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! Não foi possível modificar!\n"+ex,"ERRO!",JOptionPane.ERROR_MESSAGE);
            return false;
        }        
    }  
    
    public static boolean quoteUpdate(MQuote quote) {
        try{         
            Connection con = JConnectionFactory.getConnection();
            String query = "UPDATE quote SET quote.qu_quote = ?, quote.qu_book_page = ?, quote.bo_id = ? WHERE quote.qu_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, quote.getQuote());
            stmt.setShort(2, quote.getBookPage());
            stmt.setInt(3, quote.getBookId());
            stmt.setInt(4, quote.getBookId());
            stmt.executeUpdate();
            stmt.close(); //Fechando o PrepareStatement
            con.close(); //Fechando a conexão          
            return true;          
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro! Não foi possível atualizar a citação\n"+ex,"ERRO!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
