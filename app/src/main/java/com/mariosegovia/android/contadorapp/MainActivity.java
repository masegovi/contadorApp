package com.mariosegovia.android.contadorapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String KEY_CONTADOR = "contador";
    private EditText mCampoContador;
    private Button mBotonContar;
    private Button mBotonReiniciar;
    int contador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCampoContador = findViewById(R.id.campo_contador);
        mBotonContar = findViewById(R.id.boton_contar);
        mBotonReiniciar = findViewById(R.id.boton_reiniciar);
        mBotonContar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador = contador + 1;
                String contadorValue = String.valueOf(contador);

                mCampoContador.setText(contadorValue);
            }
        });

        mBotonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador = 0;
                String contadorValue = String.valueOf(contador);
                mCampoContador.setText(contadorValue);
            }
        });

        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt(KEY_CONTADOR);
            String contadorValue = String.valueOf(contador);
            mCampoContador.setText(contadorValue);
        } else {
            String contadorValue = String.valueOf(contador);
            mCampoContador.setText(contadorValue);
        }

    }

    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_CONTADOR, contador);
    }
}
