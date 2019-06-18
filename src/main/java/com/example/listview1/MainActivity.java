package com.example.listview1;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Activity activity = this;
    EditText et_product;
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products = new ArrayList<String>();
        et_product = findViewById(R.id.et_product);
        listView = findViewById(R.id.lv_shopping);
        adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, android.R.id.text1, products);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                openDialog(position);

                return true;
            }
        });
    }


    public void openDialog(final int position) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle(getString(R.string.app_name)); //modificar el titol
        alertDialogBuilder.setMessage("¿Seguro que quieres borrar el elemento?")
                .setCancelable(false)
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Que volem fer si clica que si-> Esborrar del llistat
                        products.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel(); // No fem res, tanquem el Alert.
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create(); //crear el alert dialog
        alertDialog.show(); //mostrar per pantalla
    }

    public void buttonClicked(View view) {

        String text = et_product.getText().toString();
        if (!"".equals(text))
        {
            products.add(text);
            adapter.notifyDataSetChanged();
            et_product.setText("");
        }
    }
}
