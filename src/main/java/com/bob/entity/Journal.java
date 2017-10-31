package com.bob.entity;

import java.util.Date;

/**
 * Created by bob on 25.01.2017.
 */
public class Journal {
    private int id_journal;
    private int id_book;
    private int id_client;

    private Date issue_time;
    private Date return_time;

    public int getId_journal() {
        return id_journal;
    }

    public void setId_journal(int id_journal) {
        this.id_journal = id_journal;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getIssue_time() {
        return issue_time;
    }

    public void setIssue_time(Date issue_time) {
        this.issue_time = issue_time;
    }

    public Date getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Date return_time) {
        this.return_time = return_time;
    }
}
