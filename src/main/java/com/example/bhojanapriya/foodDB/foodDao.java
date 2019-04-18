package com.example.bhojanapriya.foodDB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;

import com.example.bhojanapriya.foodDB.food;
import java.util.List;

@Dao
public interface foodDao
{
    @Query("SELECT * FROM food where name = :name")
    food fetchFoodByName(String name);

    @Insert
    void insertFood(food food);

    @Update
    void updateFood(food food);

    @Delete
    void delete(food food);
}