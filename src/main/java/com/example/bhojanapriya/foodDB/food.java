package com.example.bhojanapriya.foodDB;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class food {
    @PrimaryKey(autoGenerate = true)
    private int food_id;

    private String name;
    private String category;
    private double price;

    /*
    public food(int food_id, String name, String category, double price) {
        this.food_id = food_id;
        this.name = name;
        this.category = category;
        this.price = price;
    }*/

    public food(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}