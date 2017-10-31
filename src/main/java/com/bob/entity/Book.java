package com.bob.entity;

/**
 * Created by bob on 25.01.2017.
 */
public class Book {
    private int id_book;
    private String name_autor;
    private String name_book;
    private int quantity_book;

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getName_autor() {
        return name_autor;
    }

    public void setName_autor(String name_autor) {
        this.name_autor = name_autor;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public int getQuantity_book() {
        return quantity_book;
    }

    public void setQuantity_book(int quantity_book) {
        this.quantity_book = quantity_book;
    }




}
