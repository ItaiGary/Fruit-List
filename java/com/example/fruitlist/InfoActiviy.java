package com.example.fruitlist;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class InfoActiviy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_activiy);

        Intent intent = getIntent();

        String nameSum = intent.getStringExtra("name");
        String caloriesSum = intent.getStringExtra("calories");
        int imageSum =  Integer.parseInt(Objects.requireNonNull(intent.getStringExtra("image")));

        ImageView image = findViewById(R.id.imageView_i);
        image.setImageResource(imageSum);

        TextView name = findViewById(R.id.name_i);
        name.setText(nameSum);

        TextView calories = findViewById(R.id.calories_i);
        calories.setText(caloriesSum + "calories");



    }
}
