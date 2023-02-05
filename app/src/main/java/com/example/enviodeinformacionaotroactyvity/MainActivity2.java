package com.example.enviodeinformacionaotroactyvity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    //variables
    TextView dinerito;
    TextView descripcion;

    private Button btnregre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //definicion de cada texview
               TextView nombrecito = findViewById(R.id.nombresito);
                descripcion = findViewById(R.id.explicadito);
                dinerito = findViewById(R.id.dinerito);

                //definicion de el boton para regresar a la activity principal
                btnregre = findViewById(R.id.BTNregreso);


                //cuadro que recibe los datos y los amnda a los textview
                Bundle extras = getIntent().getExtras();
                if (extras != null){

                    String Nombre = extras.getString("texto1");
                    int dineros = extras.getInt("texto3");
                    String descerp = extras.getString("texto2");

                     nombrecito.setText(Nombre);
                     dinerito.setText(String.valueOf(dineros));
                     descripcion.setText(descerp);
                }

                //el impuesto sobre la renta salvadoreno
                TextView liquido = findViewById(R.id.liquido);
                String sueldo =dinerito.getText().toString() ;

                double sueldo2 = Integer.parseInt(sueldo);
                double sueldo3 = 0;
                if (sueldo2 >= 2832 && sueldo2 <= 5371.44){
                     sueldo3 = sueldo2 * 0.1;
                } else if (sueldo2 >= 5371.44 && sueldo2 <= 12228.60) {
                     sueldo3 = sueldo2 * 0.2;
                }else if (sueldo2 >=12228.61){
                     sueldo3 = sueldo2 * 0.3;
                }
                 double resultado = sueldo2 - sueldo3;
                liquido.setText(String.valueOf(resultado));

                //lo que hace el boton para regresar
                btnregre.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

    }
}