package com.bob.service;

import com.bob.entity.Book;
import com.bob.entity.Client;
import com.bob.entity.Journal;
import com.bob.repository.JournalDAO;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by bob on 25.01.2017.
 */
//// TODO: 25.01.2017 Принимаю клиента, книгу и формирую запись в журнал.
    //перед этим проверяю наличие свободной книги, если книг нету, то выдаю исключение что свободн книг нет
    //дату выдачи проставляю сейчас
    //
public class JournalService {
    private JournalDAO journalDAO =new JournalDAO();
    public void issueBook(Book book,Client client) throws SQLException {
        //срастить данные
        if(book.getQuantity_book()>0) {

            Journal journal = new Journal();
            journal.setId_book(book.getId_book());
            journal.setId_client(client.getId_client());
            // TODO: 25.01.2017 почему то ругаеться на дату 
            journal.setIssue_time(new Date());
            journalDAO.insert(journal);
        }
        //// TODO: 25.01.2017 создать ексепшен свободных книг
        else System.out.println("Нет свободных книг");
    }
    //
    public void returnBook(Book book,Client client) throws SQLException {
    Journal journal=new Journal();
        journalDAO.return(journal,book,client);





    }

}
