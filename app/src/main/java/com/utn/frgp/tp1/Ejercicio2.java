package com.utn.frgp.tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ejercicio2 extends AppCompatActivity {

    private TextView tv1;

    private double numero1 = 0;
    private double numero2 = 0;
    private String operador = "";
    private boolean nuevoNumero = true; // para resetear la pantalla al empezar un nuevo número

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv1 = (TextView) findViewById(R.id.tvResultado);
        tv1.setText("0");
    }

    public void escribir(View view) {
        Button btn = (Button) view;

        if (nuevoNumero) {
            tv1.setText(btn.getText());
            nuevoNumero = false;
        } else {
            if (!tv1.getText().toString().equals("0")) {
                tv1.setText(tv1.getText().toString() + btn.getText());
            } else {
                tv1.setText(btn.getText());
            }
        }
    }

    public void borrarTodo(View view) {
        tv1.setText("0");
        numero1 = 0;
        numero2 = 0;
        operador = "";
        nuevoNumero = true;
    }

    public void operar(View view) {
        Button btn = (Button) view;
        operador = btn.getText().toString(); // guarda +, -, x, ÷
        numero1 = Double.parseDouble(tv1.getText().toString());
        nuevoNumero = true;
    }

    public void calcularResultado(View view) {
        numero2 = Double.parseDouble(tv1.getText().toString());
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "×":
            case "*":
                resultado = numero1 * numero2;
                break;
            case "÷":
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    tv1.setText("Error");
                    return;
                }
                break;
        }

        tv1.setText(String.valueOf(resultado));
        // preparar para nueva operación
        numero1 = resultado;
        nuevoNumero = true;
    }
}
