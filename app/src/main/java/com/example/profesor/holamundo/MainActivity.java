package com.example.profesor.holamundo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    static final String TAG = "test_actividad";


    int mContador;
    TextView mTvContador; // view que muestra el valor del contador



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Llamado onCreate(Bundle)");


        // Carga el layout con el interface de usuario
        setContentView(R.layout.main_layout);

        // Le asignamos acción al boton cuando este reciva un evento
        // de click

        // Referencia al textview donde mostrar el número contador
        mTvContador = findViewById(R.id.contador);

        // Referencia al botón a través de su identificador de recurso
        Button botonContador = findViewById(R.id.boton_cont);
        // Asignamo listener para el evento click
        botonContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContador.setText(String.valueOf(++mContador));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Llamado onStart()");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Llamado onPause()");



    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Llamado onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Llamado onDestroy()");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Llamado onRestart()");

    }

}
