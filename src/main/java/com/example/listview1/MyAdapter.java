package com.example.listview1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listview1.model.Product;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Product> {
    int layoutResourceId;
    Context context;
    ArrayList<Product> data;
    public MyAdapter(Context context, int layoutResourceId, ArrayList<Product> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        TextView tv_texto = (TextView) row.findViewById(R.id.texto);
        TextView tv_units = (TextView) row.findViewById(R.id.tv_units);


        Product p = data.get(position);

        tv_texto.setText(p.getName());
        tv_units.setText(String.valueOf(p.getUnits()));

        if (p.isIs_bought())
        {
            tv_texto.setTextColor(context.getResources().getColor(R.color.red));
        }

        return row;
    }


}

