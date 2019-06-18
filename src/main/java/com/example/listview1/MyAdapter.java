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

        String valor = data.get(position).getName();
        tv_texto.setText(valor);

        if (valor.toUpperCase().startsWith("P") || valor.toUpperCase().startsWith("C"))
        {
            tv_texto.setTextColor(context.getResources().getColor(R.color.red));
        }

        return row;
    }


}

