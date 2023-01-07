package com.bean;

public class Item {
    private int id;
    private String book_name;
    private float price;
    public Item()
    {

    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
