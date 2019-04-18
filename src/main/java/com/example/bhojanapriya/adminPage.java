package com.example.bhojanapriya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class adminPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
    }

    public void addFoodPage(View view)
    {
        Intent i1 = new Intent(this, addFoodPage.class);
        startActivity(i1);
    }

    public void viewOrdersPage(View view)
    {
        Intent i1 = new Intent(this, viewOrdersPage.class);
        startActivity(i1);
    }
}