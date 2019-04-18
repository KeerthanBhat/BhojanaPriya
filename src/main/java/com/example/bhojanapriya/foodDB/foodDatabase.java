package com.example.bhojanapriya.foodDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.bhojanapriya.foodDB.foodDao;

@Database(entities = { food.class }, version = 1, exportSchema = false)
public abstract class foodDatabase extends RoomDatabase {

    public abstract foodDao getFoodDao();

    private static foodDatabase foodDB;

    public static foodDatabase getInstance(Context context) {
        if (null == foodDB) {
            foodDB = buildDatabaseInstance(context);
        }
        return foodDB;
    }

    private static foodDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                foodDatabase.class,
                "foodDB.db")
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        foodDB = null;
    }
}