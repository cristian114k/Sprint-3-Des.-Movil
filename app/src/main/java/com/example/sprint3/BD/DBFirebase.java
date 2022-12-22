package com.example.sprint3.BD;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.sprint3.Adaptadores.ProductAdapter;
import com.example.sprint3.Entidades.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebase {
    private FirebaseFirestore db;

    public DBFirebase(){
        this.db = FirebaseFirestore.getInstance();
    }

    public void insertData(Product product){
        // Create a new user with a first and last name
        Map<String, Object> p = new HashMap<>();
        p.put("id", product.getId());
        p.put("nombre", product.getNombre());
        p.put("descripcion", product.getDescripcion());
        p.put("imagen", product.getImagen());
        p.put("precio",product.getPrecio());

        // Add a new document with a generated ID
        db.collection("product").add(p);
    }

    public void getData(ProductAdapter adapter, ArrayList<Product> list){
        db.collection("product")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = new Product(
                                    document.getData().get("id").toString(),
                                    document.getData().get("nombre").toString(),
                                    document.getData().get("descripcion").toString(),
                                    document.getData().get("imagen").toString(),
                                    Integer.parseInt(document.getData().get("precio").toString())
                                );
                                list.add(product);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.e("Error Document","Error getting documents.", task.getException());
                        }
                    }
                });
    }
}

