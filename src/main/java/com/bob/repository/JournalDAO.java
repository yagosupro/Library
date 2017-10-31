package com.bob.repository;

import com.bob.DBWorker;

import com.bob.entity.Book;
import com.bob.entity.Client;
import com.bob.entity.Journal;

import java.sql.*;

/**
 * Created by bob on 25.01.2017.
 */
public class JournalDAO {
    public void insert(Journal journal) throws SQLException {
        String INSERT ="insert into journal (id_book,id_client,issue_time,return_time) VALUES (?,?,?,?)";
        PreparedStatement prepInsert = DBWorker.getInstance().getConnection().prepareStatement(INSERT);
        prepInsert.setInt(1,journal.getId_book());
        prepInsert.setInt(2, journal.getId_client());
        prepInsert.setDate(3, (Date) journal.getIssue_time());
        prepInsert.setDate(4, (Date) journal.getReturn_time());
        prepInsert.execute();
    }

    public void returnBook(Journal journal,Book book,Client client) throws SQLException {

        String SELECT ="SELECT * FROM journal WHERE id_client=? and id_book=? and return_time=0";
        PreparedStatement prepSelect = DBWorker.getInstance().getConnection().prepareStatement(SELECT);
        prepSelect.setInt(1,client.getId_client());
        prepSelect.setInt(2,book.getId_book());
        ResultSet resSet=prepSelect.executeQuery();
        while (resSet.next()){
            journal.setId_journal(resSet.getInt("id_journal"));
            }
        prepSelect.close();

        String UPDATE ="UPDATE journal SET return_time = ?  WHERE id_journal = ?";
        PreparedStatement prepUpdate = DBWorker.getInstance().getConnection().prepareStatement(UPDATE);
        prepUpdate.setDate(1,new Date());
        prepUpdate.setInt(2,journal.getId_journal());
        prepUpdate.executeUpdate();

        UPDATE="UPDATE book SET quantity_book = ?  WHERE id_book = ?";
        prepUpdate = DBWorker.getInstance().getConnection().prepareStatement(UPDATE);
        prepUpdate.setInt(1,book.getQuantity_book()-1);
        prepUpdate.setInt(2,book.getId_book());

    }
}
