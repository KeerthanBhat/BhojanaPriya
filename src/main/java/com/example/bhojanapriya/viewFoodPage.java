package com.example.bhojanapriya;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class viewFoodPage extends AppCompatActivity {

    TextView tv;
    public SQLiteDatabase getDBConnection()
    {
        SQLiteDatabase myDB = openOrCreateDatabase("foodDB", MODE_PRIVATE, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS food(name VARCHAR, category VARCHAR, price NUMBER)");

        return myDB;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_page);

        SQLiteDatabase myDB = (SQLiteDatabase) getDBConnection();
        Cursor cursor = myDB.rawQuery("SELECT * FROM food", null);

        tv = (TextView) findViewById(R.id.textview);
        tv.setText(getString(R.string.tab) + getString(R.string.tab)+ getString(R.string.tab)+ "NAME" +
                getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab)+ "CATEGORY" +
                getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab) + "PRICE");
        int i = 1;
        while (cursor.moveToNext()) {
            int index;

            index = cursor.getColumnIndexOrThrow("name");
            String foodname = cursor.getString(index);

            index = cursor.getColumnIndexOrThrow("category");
            String foodcategory = cursor.getString(index);

            index = cursor.getColumnIndexOrThrow("price");
            double foodprice = cursor.getLong(index);

            tv.append("\n\n" + Integer.toString(i) + '.' + getString(R.string.tab)+ getString(R.string.tab) +
                    foodname + getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab) +
                    foodcategory + getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab) +
                    foodprice);
            i++;
        }
    }

    public void searchByCategory(View view)
    {
        Intent i = new Intent(this, searchCategory.class);
        startActivity(i);
    }
}