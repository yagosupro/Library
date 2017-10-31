package com.bob.service;

/**
 * Created by bob on 25.01.2017.
 */
public class BookException extends Exception {
    public BookException(String message, Exception e) {
        super(message,e);
    }
}
