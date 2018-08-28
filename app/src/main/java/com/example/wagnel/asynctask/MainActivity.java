package com.example.wagnel.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, new BlankFragment())
                .addToBackStack("Blue")
                .commit();
                */
    }
}
