package com.example.sprint3.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sprint3.Entidades.Product;
import com.example.sprint3.Info;
import com.example.sprint3.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private Context contexto;
    private ArrayList<Product> arrayProductos;

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.contexto = context;
        this.arrayProductos = arrayProducts;
    }

    @Override
    public int getCount() {
        return arrayProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.contexto);
        view = layoutInflater.inflate(R.layout.plantilla_visualizacion,null);

        ImageView imgP = (ImageView) view.findViewById(R.id.imgPlantilla);
        TextView textNombrePlantilla = (TextView) view.findViewById(R.id.textNombrePlantilla);
        TextView textDescripcionPlantilla = (TextView) view.findViewById(R.id.textDescripcionPlantilla);
        TextView textPrecioPlantilla = (TextView) view.findViewById(R.id.textPrecioPlantilla);

        Product producto = arrayProductos.get(i);

        imgP.setImageResource(R.drawable.img);
        textNombrePlantilla.setText(producto.getNombre());
        textDescripcionPlantilla.setText(producto.getDescripcion());
        textPrecioPlantilla.setText(String.valueOf(producto.getPrecio()));

        imgP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto.getApplicationContext(), Info.class);
                intent.putExtra("nombre",producto.getNombre());
                intent.putExtra("descripcion",producto.getDescripcion());
                intent.putExtra("precio",producto.getPrecio());
                intent.putExtra("imagen",producto.getImagen());
                contexto.startActivity(intent);
            }
        });

        return view;
    }
}
