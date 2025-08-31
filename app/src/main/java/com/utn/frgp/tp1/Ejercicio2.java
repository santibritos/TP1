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
    }

    public void escribir(View view)
    {
        Button btn = (Button) view;

        if(!tv1.getText().toString().equals("0"))
        {
            tv1.setText(tv1.getText().toString()+btn.getText());
        }else
        {
            tv1.setText(btn.getText());
        }

    }

    public void borrarTodo(View view)
    {
        tv1.setText("0");
    }

}