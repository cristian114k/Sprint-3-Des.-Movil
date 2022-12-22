package com.example.sprint3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.sprint3.Adaptadores.ProductAdapter;
import com.example.sprint3.BD.DBFirebase;
import com.example.sprint3.BD.DBHelper;
import com.example.sprint3.Entidades.Product;
import com.example.sprint3.Servicios.ProductService;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {

    private DBHelper dbHelper;
    private DBFirebase dbFirebase;

    private ListView listViewP;
    private ProductAdapter productoAdaptador;
    private ArrayList<Product> arrayP;
    private ProductService productService;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        try {
            dbHelper = new DBHelper(this);
            dbFirebase = new DBFirebase();
        }catch (Exception e){
            Log.e("Error DB", e.toString());
        }

        arrayP = new ArrayList<>();
        productService = new ProductService();

        Product product1 = new Product("iPhone 11", "128 GB Negro ", 100,"");
        Product product2 = new Product("SAMSUNG S20 FE", "128 GB 5G Azul", 2000, "");

        //arrayP = productService.cursorToArrayList(dbHelper.getData());





        //dbHelper.insertData(product1);
        //dbHelper.insertData(product2);

        //arrayP.add(product1);
        //arrayP.add(product2);


        productoAdaptador = new ProductAdapter(this,arrayP);
        listViewP = (ListView) findViewById(R.id.listViewListado);

        listViewP.setAdapter(productoAdaptador);

        btnAgregar = (Button) findViewById(R.id.Agregar);

        dbFirebase.getData(productoAdaptador,arrayP);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductForm.class);
                startActivity(intent);
            }
        });


    }
}