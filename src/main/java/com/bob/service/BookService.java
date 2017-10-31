package com.bob.service;

import com.bob.entity.Book;
import com.bob.repository.BookDAO;

import java.sql.SQLException;

/**
 * Created by bob on 25.01.2017.
 */

//// TODO: 25.01.2017 бизнес логику
public class BookService {
    private BookDAO bookDAO=new BookDAO();

    /**
     * метод добавляет книги в библиотеку
     * @param book добавляемая книга
     * @throws BookException
     */

    public void add(Book book) throws BookException {
        //// TODO: 25.01.2017 проверить наличие книги если есть, то сложить количество.
        // Если кол во отрицательное то выдать исключение

        try {
            bookDAO.insert(book);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BookException("Ошибка добавления книги", e);
        }

    }
}
