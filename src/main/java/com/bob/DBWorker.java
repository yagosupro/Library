package com.bob;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by bob on 24.01.2017.
 */
public class DBWorker {
    private final String USERNAME="root";
    private final String PASSWORD="1234";
    private final String URL="jdbc:mysql://localhost:3306/library";

    public Connection getConnection() {
        return connection;
    }

    private Connection connection = null;
    private static DBWorker instance;

    private DBWorker(){

        try {
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



//    public  void WriteDB(String nameAutor,String nameBook,String quantityBook) throws SQLException {
//
//        String autor=nameAutor;
//        String book=nameBook;
//        String quantity=quantityBook;
//        String pusto=null;
//        String INSERT ="insert into library (nameAutor,nameBook,whoHas,quanityBook) VALUES (?,?,?,?)";
//        PreparedStatement prepInsert = connection.prepareStatement(INSERT);
//        prepInsert.setString(1,autor);
//        prepInsert.setString(2,book);
//        prepInsert.setString(3,"Библиотека");
//        prepInsert.setInt(4, Integer.parseInt(quantity));
//        prepInsert.execute();
//
//    }
//
//    public  void WriteUsers(String nameUsers) throws SQLException {
//        String INSERT ="insert into users (nameUsers) VALUES (?)";
//        PreparedStatement prepInsert = connection.prepareStatement(INSERT);
//
//        prepInsert.setString(1, nameUsers);
//
//        prepInsert.execute();
//    }

    public static DBWorker getInstance(){
        if(instance==null){
            instance = new DBWorker();
        }
        return instance;
    }


}
