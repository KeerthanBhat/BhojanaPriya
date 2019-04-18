package com.example.bhojanapriya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class customerPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
    }

    public void viewFoodPage(View view)
    {
        Intent i1 = new Intent(this, viewFoodPage.class);
        startActivity(i1);
    }

    public void addOrdersPage(View view)
    {
        Intent i1 = new Intent(this, addOrdersPage.class);
        startActivity(i1);
    }
}