package com.example.profesor.holamundo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    static final String TAG = "test_actividad";
    static final String KEY_CONTADOR =  "com.example.profesor.holamundo" + "CONTADOR";


    int mContador; // Valor del contador
    TextView mTvContador; // view que muestra el valor del contador



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
            Log.d(TAG, "Llamado onCreate(Bundle)");
        else
            Log.d(TAG, "Llamado onCreate(null)");

        // Carga el layout con el interface de usuario
        setContentView(R.layout.main_layout);

        // Le asignamos acción al botón cuando este reciba un evento
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
        // Lugar más idoneo para restaurar datos persistentes
        /*//Ejemplo: Uso de objeto SahredPreferences
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        mContador = preferences.getInt(KEY_CONTADOR,0);
        mTvContador.setText(String.valueOf(mContador));*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Llamado onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Llamado onPause()");

        // Lugar más idóneo para guardar datos persistentes
       /* // Ejemplo: guarda contador usando Objeto SaharePreferences.

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_CONTADOR,mContador);
        editor.commit();*/

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // para evitar que el contador se ponga a cero cuando rotamos
        // el dispositivo vamos a guardar el valor dentro de este método
        // Este método se ejecuta siempre antes de que la actividad sea destruida
        // OJO: no se ejecuta si: a) salimos de la actividad con boton back
        //                        b) matamos la actividad con finish()

        Log.d(TAG, "Llamado onSaveInstanceState(Bundle)");


        // Mete valor del contador en el Bundle
        // Este valor luego, lo sacamos en el onRestoreInstanceState(Bundle)
        // y asignamos a mContador

        Log.d(TAG,"Guardando valor del contador...");
        outState.putInt(KEY_CONTADOR,mContador);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(TAG, "Llamado onRestoreInstanceState(Bundle)");


        // onRestoreInstanceState se invoca después de onStart(), cuando la activity
        // se reinicializa desde el Bundle con el estado guardado por porSaveInstanceState.
        // OJO:  NO se llama si la actividad no fue destruida
        // por el entorno de ejecución (como cuando el usuario presiona el
        // botón Atrás o la actividad se cierra programáticamente usando finish ()).

        // Recogemos valor del contador previamente guardo. Esto se puede hacer también
        // en onCreate(Bundle)

        Log.d(TAG,"Restaurando valor del contador...");
        mContador= savedInstanceState.getInt(KEY_CONTADOR);
        mTvContador.setText(String.valueOf(mContador));
    }


}
