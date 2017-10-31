package com.bob.entity;

/**
 * Created by bob on 25.01.2017.
 */
public class Client {
    private int id_client;
    private String name_clietn;
    private String address;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getName_clietn() {
        return name_clietn;
    }

    public void setName_clietn(String name_clietn) {
        this.name_clietn = name_clietn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
