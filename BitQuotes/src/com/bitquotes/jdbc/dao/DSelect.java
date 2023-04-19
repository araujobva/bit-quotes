/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

import com.bitquotes.model.MUser;
import com.bitquotes.jdbc.JConnectionFactory;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.bitquotes.model.MQuote;

/**
 *
 * @author bruno
 */
public class DSelect {

    //Método para autenticar usuário.
    public static ArrayList authentication() {
        try {
            Connection con = JConnectionFactory.getConnection();
            //SELECT user.us_name, user.us_password, user.us_administrator FROM user
            String query = "SELECT user.us_name, user.us_password, user.us_administrator "
                    + "FROM user";
            ResultSet rs = con.createStatement().executeQuery(query);
            ArrayList<MUser> userList = new ArrayList<MUser>();
            MUser objUser = new MUser();
            while (rs.next()) { //Enquanto tiver dados no ResultSet "rs" o while faz.
                objUser.setUser(rs.getString("us_name"));
                objUser.setPassword(rs.getString("us_password"));
                objUser.setAdministrator(rs.getBoolean("us_administrator"));
                userList.add(objUser);
                objUser = new MUser(); //Para não duplicar os valors no ArrayList.
            }
            con.close(); //Fechando a conexão.
            rs.close(); //Fechando o ResultSet.
            return userList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na autenticação! " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    //Método para procurar citações pelo nome do livro.
    public static ArrayList searchBookName(String user, String bookName) {
        try {
            Connection con = JConnectionFactory.getConnection();
            //SELECT quote.qu_id, quote.qu_quote, book.bo_name, quote.qu_book_page FROM quote INNER JOIN book ON book.bo_id = quote.bo_id WHERE quote.us_name = "User" AND book.bo_name LIKE "%BookName%";
            String query = "SELECT quote.qu_id, quote.qu_quote, book.bo_name, quote.qu_book_page "
                    + "FROM quote "
                    + "INNER JOIN book "
                    + "ON book.bo_id = quote.bo_id "
                    + "WHERE quote.us_name = ? AND book.bo_name LIKE ?";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, "%" + bookName + "%");
            //ResultSet rs = con.createStatement().executeQuery(query);
            ResultSet rs = stmt.executeQuery();
            ArrayList<MQuote> quoteList = new ArrayList<MQuote>();
            MQuote objQuote = new MQuote();
            while (rs.next()) {
                objQuote.setId(rs.getInt("quote.qu_id"));
                objQuote.setQuote(rs.getString("quote.qu_quote"));
                objQuote.setBookName(rs.getString("book.bo_name"));
                objQuote.setPageBook(rs.getShort("quote.qu_book_page"));
                quoteList.add(objQuote);
                objQuote = new MQuote();
            }
            con.close();
            stmt.close();
            rs.close();
            return quoteList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fazer a pesquisa pelo nome do livro!\n" + ex, "Erro de pesquisa!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    //Método para procurar citações por uma citação.
    public static ArrayList searchQuote(String user, String quotePiece) {
                try {
            Connection con = JConnectionFactory.getConnection();
            //SELECT quote.qu_id, quote.qu_quote, book.bo_name, quote.qu_book_page FROM quote INNER JOIN book ON book.bo_id = quote.bo_id WHERE quote.us_name = "user" AND quote.qu_quote LIKE "%Quote Piece%";
            String query = "SELECT quote.qu_id, quote.qu_quote, book.bo_name, quote.qu_book_page "
                    + "FROM quote "
                    + "INNER JOIN book "
                    + "ON book.bo_id = quote.bo_id "
                    + "WHERE quote.us_name = ? AND quote.qu_quote LIKE ?";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, "%" + quotePiece + "%");
            //ResultSet rs = con.createStatement().executeQuery(query);
            ResultSet rs = stmt.executeQuery();
            ArrayList<MQuote> quoteList = new ArrayList<MQuote>();
            MQuote objQuote = new MQuote();
            while (rs.next()) {
                objQuote.setId(rs.getInt("quote.qu_id"));
                objQuote.setQuote(rs.getString("quote.qu_quote"));
                objQuote.setBookName(rs.getString("book.bo_name"));
                objQuote.setPageBook(rs.getShort("quote.qu_book_page"));
                quoteList.add(objQuote);
                objQuote = new MQuote();
            }
            con.close();
            stmt.close();
            rs.close();
            return quoteList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fazer a pesquisa pela citação do livro!\n" + ex, "Erro de pesquisa!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}
