package com.example.bhojanapriya;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addFoodPage extends AppCompatActivity {

    private EditText foodName;
    private Spinner foodCategory;
    private EditText foodPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_page);

        Spinner dropdown = findViewById(R.id.foodCategory);
        String[] items = new String[]{"Sweets", "Starters", "Main Course", "Desserts"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        foodName = (EditText) findViewById(R.id.foodName);
        foodCategory = (Spinner) findViewById(R.id.foodCategory);
        foodPrice = (EditText) findViewById(R.id.foodPrice);
    }

    public SQLiteDatabase getDBConnection()
    {
        SQLiteDatabase myDB = openOrCreateDatabase("foodDB", MODE_PRIVATE, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS food(name VARCHAR, category VARCHAR, price NUMBER)");

        return myDB;
    }

    public void addFood(View view) {
        String name = foodName.getText().toString();
        String category = foodCategory.getSelectedItem().toString();
        double price = Double.parseDouble(foodPrice.getText().toString());

        SQLiteDatabase myDB = (SQLiteDatabase)getDBConnection();
        myDB.execSQL("INSERT INTO food VALUES(?,?,?)",new Object[]{name,category,price});

        Toast.makeText(this,name + " added successfully.", Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent(this, addFoodPage.class);
        startActivity(i1);
    }
}