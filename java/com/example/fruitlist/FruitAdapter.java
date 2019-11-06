package com.example.fruitlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FruitAdapter extends ArrayAdapter {

    Context _context;
    int _layout;
    List<Fruit> _fruitList;


    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        _context = context;
        _layout = resource;
        _fruitList = objects;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View result = convertView;

        if (result == null) {
            result = LayoutInflater.from(_context).inflate(
                    R.layout.main_one_fruit_layout, parent, false
            );

            TextView tvName = result.findViewById(R.id.fruit);
            TextView tvCaloris = result.findViewById(R.id.caloris);
            ImageView tvPic = result.findViewById(R.id.fruit_imageView);

            tvName.setText(_fruitList.get(position).getName());
            tvCaloris.setText(_fruitList.get(position).getCaloris() + " Calories");
            tvPic.setImageResource(_fruitList.get(position).getImage());


           // result.setOnLongClickListener(new DeleteOnClickListener(this, position));
            /*Picasso.get().load(_fruitList.get(position).getImage()
            ).into(tvPic);
*/
        }
        return result;
    }
}

