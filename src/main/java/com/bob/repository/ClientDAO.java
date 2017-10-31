package com.bob.repository;

import com.bob.DBWorker;
import com.bob.entity.Book;
import com.bob.entity.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by bob on 26.01.2017.
 */
public class ClientDAO {
    public void insert(Client client) throws SQLException {
        String INSERT ="insert into clients (name_client,client_adress) VALUES (?,?)";
        PreparedStatement prepInsert = DBWorker.getInstance().getConnection().prepareStatement(INSERT);
        prepInsert.setString(1,client.getName_clietn());
        prepInsert.setString(2,client.getAddress());
        prepInsert.execute();
    }

    public void read(Client client) throws SQLException {
        Statement statmt = DBWorker.getInstance().getConnection().createStatement();
        ResultSet resSet;
        resSet = statmt.executeQuery("SELECT * FROM clients");
        while (resSet.next()){
            client.setId_client(resSet.getInt("id_client"));
            client.setName_clietn(resSet.getString("name_client"));
            client.setAddress(resSet.getString("client_address"));

        }
        statmt.close();
        }

    public void find(Client client) throws SQLException {
        String SELECT ="SELECT * FROM books WHERE name_client=?";
        PreparedStatement prepSelect = DBWorker.getInstance().getConnection().prepareStatement(SELECT);
        prepSelect.setString(1,client.getName_clietn());
        ResultSet resSet=prepSelect.executeQuery();
        while (resSet.next()){
            client.setId_client(resSet.getInt("id_client"));
            client.setAddress(resSet.getString("client_address"));

        }
        prepSelect.close();
    }
}
