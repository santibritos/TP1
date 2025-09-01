package com.utn.frgp.tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio1 extends AppCompatActivity {

    private EditText num1, num2, numLn, txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        // Inicializamos todos los EditText una sola vez
        num1 = findViewById(R.id.txtN01);
        num2 = findViewById(R.id.txtN02);
        numLn = findViewById(R.id.txtN_Ln);
        txtResultado = findViewById(R.id.txtResultado);
    }

    // Método para sumar
    public void suma(View view) {
        String valor1 = num1.getText().toString();
        String valor2 = num2.getText().toString();

        if (!valor1.isEmpty() && !valor2.isEmpty()) {
            try {
                double v_01 = Double.parseDouble(valor1);
                double v_02 = Double.parseDouble(valor2);
                double v_resultado = v_01 + v_02;
                txtResultado.setText("Resultado: " + v_resultado);
            } catch (NumberFormatException e) {
                txtResultado.setText("Error: valores inválidos");
            }
        } else {
            txtResultado.setText("Por favor ingrese ambos números");
        }
    }

    // Método para calcular logaritmo natural
    public void logaritmoNatural(View view) {
        String valorLn = numLn.getText().toString();

        if (!valorLn.isEmpty()) {
            try {
                double v = Double.parseDouble(valorLn);
                if (v > 0) {
                    double resultado = Math.log(v);
                    txtResultado.setText("Resultado: " + resultado);
                } else {
                    txtResultado.setText("Error: ingrese un número positivo");
                }
            } catch (NumberFormatException e) {
                txtResultado.setText("Error: valor inválido");
            }
        } else {
            txtResultado.setText("Por favor ingrese un número");
        }
    }
}
