package com.example.listview1;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Activity activity = this;
    EditText et_product, et_units;
    CheckBox checkBox;
    ListView listView;
    MyAdapter adapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products = new ArrayList<Product>();

        et_product = findViewById(R.id.et_product);
        et_units = findViewById(R.id.et_units);
        checkBox = findViewById(R.id.chk_bought);
        listView = findViewById(R.id.lv_shopping);

        adapter = new MyAdapter(activity, R.layout.row, products);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                openDialog(position);

                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               products.get(position).setIs_bought(true);
               adapter.notifyDataSetChanged();
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
        String units = et_units.getText().toString();
        if (!"".equals(text) && !"".equals(units) ) {
            products.add(new Product(text, Integer.parseInt(units), checkBox.isChecked()));
            adapter.notifyDataSetChanged();

            //Borrar edittext y checbox:
            et_product.setText("");
            et_units.setText("");
            checkBox.setChecked(false);
        }
    }
}
