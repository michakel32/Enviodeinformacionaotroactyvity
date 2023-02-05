package com.example.enviodeinformacionaotroactyvity;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

//variables
    EditText nombre;
    EditText monto;
    EditText descripcion;
    Button enviar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//configuracion boton para enviar datos
        Button enviar = findViewById(R.id.BTNcalcular);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //definiendo cada lugar para almacenar os datos
                nombre = findViewById(R.id.TXTNombre);
                descripcion = findViewById(R.id.TXTdescrip);
                monto = findViewById(R.id.TXTmonto);

                //if para que rellenar los datos de forma correcta
                String mensajenombre = nombre.getText().toString();
                if (mensajenombre.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Complete todos lo campos porfavor", Toast.LENGTH_LONG).show();
                }
                    String mensadescripcion = descripcion.getText().toString();
                    if (mensadescripcion.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Complete todos lo campos porfavor", Toast.LENGTH_LONG).show();
                    }else {
                        int mensajemonto = Integer.parseInt(monto.getText().toString());

                        //intent de lo que va a enviar
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("texto1", mensajenombre);
                        intent.putExtra("texto2", mensadescripcion);
                        intent.putExtra("texto3", mensajemonto);

                        //lo que ejecuta el intent y cierra la activity
                        startActivity(intent);
                        finish();
                    }
            }
        });

    }

}