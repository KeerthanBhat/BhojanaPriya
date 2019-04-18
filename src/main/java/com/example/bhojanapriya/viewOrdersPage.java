package com.example.bhojanapriya;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class viewOrdersPage extends AppCompatActivity {

    TextView tv;
    public SQLiteDatabase getDBOrderConnection()
    {
        SQLiteDatabase myDB = openOrCreateDatabase("orderDB", MODE_PRIVATE, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS food(tableno NUMBER, name VARCHAR, quantity VARCHAR, bill NUMBER)");

        return myDB;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders_page);

        SQLiteDatabase myDB = (SQLiteDatabase) getDBOrderConnection();
        Cursor cursor = myDB.rawQuery("SELECT * FROM food", null);

        tv = (TextView) findViewById(R.id.textView);
        tv.setText(getString(R.string.tab) + getString(R.string.tab)+ getString(R.string.tab)+ "TABLE NUMBER" +
                getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab)+ "FOOD" +
                getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab) + "QUANTITY" +
                getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab) + "BILL");
        int i = 1;
        while (cursor.moveToNext()) {
            int index;

            index = cursor.getColumnIndexOrThrow("tableno");
            int tabno = Integer.parseInt(cursor.getString(index));

            index = cursor.getColumnIndexOrThrow("name");
            String foodname = cursor.getString(index);

            index = cursor.getColumnIndexOrThrow("quantity");
            double foodqty = cursor.getLong(index);

            index = cursor.getColumnIndexOrThrow("bill");
            double bill = cursor.getLong(index);

            tv.append("\n\n" + Integer.toString(i) + '.' + getString(R.string.tab) + getString(R.string.tab) +
                            getString(R.string.tab) + tabno + getString(R.string.tab) + getString(R.string.tab)
                    + getString(R.string.tab) + getString(R.string.tab) + foodname + getString(R.string.tab)
                    + getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab) + foodqty +
                    getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab) + getString(R.string.tab)
                    + "Rs." + bill);
            i++;
        }
    }
}