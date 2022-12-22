package com.example.sprint3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    private TextView textNombreInfo,textDescripcionInfo, textPrecioInfo;
    private ImageView imgInfo;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textNombreInfo = (TextView) findViewById(R.id.textNombreInfo);
        textDescripcionInfo = (TextView) findViewById(R.id.textDescripcionInfo);
        textPrecioInfo = (TextView) findViewById(R.id.textPrecioInfo);
        imgInfo = (ImageView) findViewById(R.id.imgInfo);
        btnInfo = (Button) findViewById(R.id.btnInfo);

        Intent intentInf = getIntent();
        textNombreInfo.setText(intentInf.getStringExtra("nombre"));
        textDescripcionInfo.setText(intentInf.getStringExtra("descripcion"));
        textPrecioInfo.setText(String.valueOf(intentInf.getIntExtra("precio",0)));
        imgInfo.setImageResource(intentInf.getIntExtra("imagen",0));

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Listado.class);
                startActivity(intent);
            }
        });
    }
}