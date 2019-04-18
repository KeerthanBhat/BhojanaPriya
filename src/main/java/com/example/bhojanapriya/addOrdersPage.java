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

public class addOrdersPage extends AppCompatActivity {

    private EditText tableNo;
    private Spinner foodName;
    private EditText foodQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_orders_page);

        Spinner dropdown = findViewById(R.id.foodName);
        String[] items = getFoodNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        tableNo = (EditText) findViewById(R.id.tableNo);
        foodName = (Spinner) findViewById(R.id.foodName);
        foodQty = (EditText) findViewById(R.id.foodQty);
    }

    public SQLiteDatabase getDBConnection()
    {
        SQLiteDatabase myDB = openOrCreateDatabase("foodDB", MODE_PRIVATE, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS food(name VARCHAR, category VARCHAR, price NUMBER)");

        return myDB;
    }

    public String[] getFoodNames()
    {
        SQLiteDatabase myDB = (SQLiteDatabase) getDBConnection();

        Cursor cursor = myDB.rawQuery("SELECT * FROM food", null);

        int len = cursor.getCount();
        String[] foodNames = new String[len];
        int i = 0;
        while (cursor.moveToNext()) {
            int index;

            index = cursor.getColumnIndexOrThrow("name");
            String foodname = cursor.getString(index);

            foodNames[i++] = foodname;
        }
        return foodNames;
    }

    public SQLiteDatabase getDBOrderConnection()
    {
        SQLiteDatabase myDB = openOrCreateDatabase("orderDB", MODE_PRIVATE, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS food(tableno NUMBER, name VARCHAR, quantity VARCHAR, bill NUMBER)");

        return myDB;
    }

    public void generateBill(View view) {
        int tabNo = Integer.parseInt(tableNo.getText().toString());
        String name = foodName.getSelectedItem().toString();
        int qty = Integer.parseInt(foodQty.getText().toString());

        double bill = getBill(name,qty);

        SQLiteDatabase myDB = (SQLiteDatabase)getDBOrderConnection();
        myDB.execSQL("INSERT INTO food VALUES(?,?,?,?)",new Object[]{tabNo,name,qty,bill});

        Toast.makeText(this,"Your bill is: Rs." + bill, Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent(this, addOrdersPage.class);
        startActivity(i1);
    }

    public double getBill(String name, int qty)
    {
        SQLiteDatabase myDB = (SQLiteDatabase) getDBConnection();

        Cursor cursor = myDB.rawQuery("SELECT * FROM food WHERE name=?", new String[]{name});

        double price = 0;
        while (cursor.moveToNext()) {
            int index;

            index = cursor.getColumnIndexOrThrow("price");
            price = Double.parseDouble(cursor.getString(index));
        }

        return price*qty;
    }
}
