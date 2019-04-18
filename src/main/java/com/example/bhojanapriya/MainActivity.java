package com.example.bhojanapriya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchAdminPage(View view)
    {
        Toast.makeText(this,"Good day, Admin!", Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent(this, adminPage.class);
        startActivity(i1);
    }

    public void launchCustomerPage(View view)
    {
        Toast.makeText(this,"Hope you find some delicious food, Customer!", Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent(this, customerPage.class);
        startActivity(i1);
    }
}