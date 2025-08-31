package com.utn.frgp.tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ejercicio1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void suma (View view){
        EditText num1 = findViewById(R.id.txtN01);
        EditText num2 = findViewById(R.id.txtN02);
        EditText txtresultado = findViewById(R.id.txtResultado);

        String valor1 = num1.getText().toString();
        String valor2 = num2.getText().toString();

        if (!valor1.isEmpty() && !valor2.isEmpty()) {
            int v_01 = Integer.parseInt(valor1);
            int v_02 = Integer.parseInt(valor2);
            int v_resultado = v_01 + v_02;
            txtresultado.setText("Resultado: " + v_resultado);
        } else {
             txtresultado.setText("Por favor ingrese ambos números");
        }
    }
}