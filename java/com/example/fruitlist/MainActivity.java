package com.example.fruitlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView lv;
    public FruitAdapter fruitadapter;
    public ArrayList<Fruit> fruits;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruits = new ArrayList<>();
        fruits.add(new Fruit("Guava", " 18", R.drawable.guyava));
        fruits.add(new Fruit("Mango", " 26", R.drawable.mango));
        fruits.add(new Fruit("Papaya", " 21", R.drawable.papaya));
        fruits.add(new Fruit("Toot", " 4", R.drawable.toot));
        fruits.add(new Fruit("Lemon", " 6", R.drawable.lemon));
        fruits.add(new Fruit("Passion", " 5", R.drawable.passionfruit));
        fruits.add(new Fruit("Cherry", " 1", R.drawable.cherrys));
        fruits.add(new Fruit("Blue Berry", " 2", R.drawable.blueberrey));


        fruitadapter = new FruitAdapter(this, R.layout.main_one_fruit_layout, fruits);
        lv = findViewById(R.id.main_fruit_list);
        lv.setAdapter(fruitadapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Fruit fruit = (Fruit) fruitadapter.getItem(position);
                Intent intent = new Intent(getBaseContext(), InfoActiviy.class);
                intent.putExtra("name", fruit.getName());
                intent.putExtra("calories", fruit.getCaloris());
                intent.putExtra("image", String.valueOf(fruit.image));
                startActivity(intent);
            }
        });


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder b = new AlertDialog.Builder(fruitadapter._context);
                b.setTitle("Delete '" + fruits.get(position).name + "'");
                b.setMessage("Are you sure you want to delete?");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        fruits.remove(position);
                        fruitadapter.notifyDataSetChanged();
                        Toast.makeText(fruitadapter._context, "Deleted", Toast.LENGTH_LONG).show();
                    }
                });
                b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(fruitadapter._context, "Sigh... All of our fruits are delicious, dont miss out!", Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alert = b.create();
                alert.show();



                return true;
            }
        });
    }
}


