/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.jdbc.dao;

import com.bitquotes.model.MUser;
import com.bitquotes.model.MQuote;
import com.bitquotes.jdbc.JConnectionFactory;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.bitquotes.model.MBook;

/**
 *
 * @author bruno
 */
public class DSelect {

    //Método para autenticar usuário.
    public static ArrayList authentication() {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT user.us_name, user.us_password, user.us_administrator "
                    + "FROM user";
            ResultSet rs = con.createStatement().executeQuery(query);
            ArrayList<MUser> userList = new ArrayList<MUser>();
            MUser objUser = new MUser();
            while (rs.next()) { //Enquanto tiver dados no ResultSet "rs" o while faz.
                objUser.setName(rs.getString("us_name"));
                objUser.setPassword(rs.getString("us_password"));
                objUser.setAdministrator(rs.getBoolean("us_administrator"));
                userList.add(objUser);
                objUser = new MUser(); //Para não duplicar os valors no ArrayList.
            }
            con.close(); //Fechando a conexão.
            rs.close(); //Fechando o ResultSet.
            return userList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na autenticação!\n" + ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    //Método para procurar citações pelo nome do livro.
    public static ArrayList searchBookName(String user, String bookName) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT quote.qu_id, quote.qu_quote, quote.qu_book_page, quote.bo_id, quote.us_name, book.bo_name, book.bo_author FROM quote INNER JOIN book ON book.bo_id = quote.bo_id WHERE quote.us_name = ? AND book.bo_name LIKE ?";
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
                objQuote.setBookPage(rs.getString("quote.qu_book_page"));
                objQuote.setBookId(rs.getInt("quote.bo_id"));
                objQuote.setUserOwner(rs.getString("quote.us_name"));
                objQuote.setName(rs.getString("book.bo_name"));
                objQuote.setAuthor(rs.getString("book.bo_author"));
                quoteList.add(objQuote);
                objQuote = new MQuote(); //Para não duplicar os valors no ArrayList.
            }
            con.close();
            stmt.close();
            rs.close();
            return quoteList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fazer a pesquisa pelo nome do livro!\n" + ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    //Método para procurar citações por uma citação.
    public static ArrayList searchQuote(String user, String quotePiece) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT quote.qu_id, quote.qu_quote, quote.qu_book_page, quote.bo_id, quote.us_name, book.bo_name FROM quote INNER JOIN book ON book.bo_id = quote.bo_id WHERE quote.us_name = ? AND quote.qu_quote LIKE ?";
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
                objQuote.setBookPage(rs.getString("quote.qu_book_page"));
                objQuote.setBookId(rs.getInt("quote.bo_id"));
                objQuote.setUserOwner(rs.getString("quote.us_name"));
                objQuote.setName(rs.getString("book.bo_name"));
                quoteList.add(objQuote);
                objQuote = new MQuote(); //Para não duplicar os valors no ArrayList.
            }
            con.close();
            stmt.close();
            rs.close();
            return quoteList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fazer a pesquisa pela citação do livro!\n" + ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static ArrayList searchBook(String user) {
        try {
            Connection con = JConnectionFactory.getConnection();
            //String query = "SELECT book.bo_name FROM book INNER JOIN user WHERE user.us_name = ? ORDER BY book.bo_name ASC";
            String query = "SELECT book.bo_name FROM book WHERE book.us_us_name = ? ORDER BY book.bo_name ASC";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            MBook objNameBook = new MBook();
            ArrayList<MBook> bookList = new ArrayList<MBook>();
            while(rs.next()) {
                objNameBook.setName(rs.getString("book.bo_name"));
                bookList.add(objNameBook);
                objNameBook = new MBook();
            }
            con.close();
            stmt.close();
            rs.close();
            return bookList;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível trazer as informações do livro!\n" +ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        return null;    
    }
    
    public static int searchIdBook(String bookName, String user) {
        try {
            int id;
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT book.bo_id FROM book WHERE bo_name = ? AND us_us_name = ?";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            stmt.setString(1, bookName);
            stmt.setString(2, user);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("book.bo_id");
            con.close();
            stmt.close();
            rs.close();
            return id;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Não foi possível recuperar as informações do ID do Livro!\n"+ex, "ERRO!",JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }
    
    public static int searchIdBook(MBook book) {
        try {
            int id;
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT book.bo_id FROM book WHERE book.bo_name = ? AND book.bo_author = ? AND us_us_name = ?";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getUserName());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("book.bo_id");
            con.close();
            stmt.close();
            rs.close();
            return id;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Não foi possível recuperar as informações do ID do Livro!\n"+ex, "ERRO!",JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }
    
        public static String authorName(String bookName) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT book.bo_author FROM book WHERE book.bo_name = ?";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            stmt.setString(1, bookName);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String name = rs.getString("bo_author");
            con.close();
            stmt.close();
            rs.close();
            return name;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível trazer as informações do autor!\n" +ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        return null;    
    }
        
        public static boolean checkADM(String user) {
            try{
                Connection con = JConnectionFactory.getConnection();
                String query = "SELECT us_administrator FROM user WHERE us_name = ?";
                PreparedStatement stmt;
                stmt = con.prepareStatement(query);
                stmt.setString(1, user);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                boolean adm = rs.getBoolean("us_administrator");
                con.close();
                stmt.close();
                rs.close();
                return adm;
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível verificar se o usuário é um administrador!\n"+ex, "ERRO!",JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        
        public static ArrayList recoverUser() {
            try{
                Connection con = JConnectionFactory.getConnection();
                String query = "SELECT us_name FROM user";
                PreparedStatement stmt;
                stmt = con.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                ArrayList<String> userList = new ArrayList<String>();
                while(rs.next()) {
                    userList.add(rs.getString("us_name"));
                }
                con.close();
                stmt.close();
                rs.close();
                return userList;
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível buscar os usuário os usuários!\n"+ex, "ERRO!",JOptionPane.ERROR_MESSAGE);
            }
            return null;
        }
        
        //Verifica se o usuário relacionado a senha existe.
        public static boolean confirmsIdentity(String user, String password) {
        try {
            Connection con = JConnectionFactory.getConnection();
            String query = "SELECT COUNT(*) as user_count FROM user WHERE BINARY us_name = ? AND BINARY us_password = ?";
            //Se o retorno no campo user_count for maior que 1, é porque o usuário existe.
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            byte count = rs.getByte("user_count");
            con.close();
            stmt.close();
            rs.close();
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível verificar se o usuário é existe!\n" + ex, "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
