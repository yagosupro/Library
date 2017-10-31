package com.bob.repository;

import com.bob.DBWorker;
import com.bob.entity.Book;
import com.bob.entity.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by bob on 25.01.2017.
 */

public class BookDAO {
   public void insert(Book book) throws SQLException {
       String INSERT ="insert into books (name_autor,name_book,quantity_book) VALUES (?,?,?)";
       PreparedStatement prepInsert = DBWorker.getInstance().getConnection().prepareStatement(INSERT);
       prepInsert.setString(1,book.getName_autor());
       prepInsert.setString(2,book.getName_book());
       prepInsert.setInt(3, book.getQuantity_book());

       prepInsert.execute();
   }

    public void read(Book book) throws SQLException {
        Statement statmt = DBWorker.getInstance().getConnection().createStatement();
        ResultSet resSet;
        resSet = statmt.executeQuery("SELECT * FROM books");
        while (resSet.next()){
            book.setId_book(resSet.getInt("id_book"));
            book.setName_autor(resSet.getString("name_autor"));
            book.setName_book(resSet.getString("name_book"));
            book.setQuantity_book(resSet.getInt("quantity_book"));
            }
        statmt.close();
    }
    public void find(Book book) throws SQLException {
        String SELECT ="SELECT * FROM books WHERE name_autor=? and name_book=?";
        PreparedStatement prepSelect = DBWorker.getInstance().getConnection().prepareStatement(SELECT);
        prepSelect.setString(1,book.getName_autor());
        prepSelect.setString(2,book.getName_book());
        ResultSet resSet=prepSelect.executeQuery();
        while (resSet.next()){
            book.setId_book(resSet.getInt("id_book"));
            book.setQuantity_book(resSet.getInt("quantity_book"));
        }
        prepSelect.close();
    }
}
