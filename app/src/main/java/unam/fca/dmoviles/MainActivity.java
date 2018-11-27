package unam.fca.dmoviles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int IMAGE_WIDTH = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Actividad 8 Creacion de una calculadora de porcentajes
        //En esta actividad crearas una aplicacion que calcule la diferencia relativa en porcentaje entre dos numeros.


        // El archivo del layout de la actividad se encuentra en la carpeta
        // res/layout/activity_main.xml
        setContentView(R.layout.activity_main);

        //Se hace referencia al boton dentro del layout
        final Button btn = findViewById(R.id.button);

       //Se hace referencia al componente editText del layout
        final EditText et1 = (EditText)findViewById(R.id.editText);

        //Se hace referencia al componente editText1 del layout
        final EditText et2 = (EditText)findViewById(R.id.editText2);

        //Se hace referencia al componente textViewResult del layout
        final TextView tv = findViewById(R.id.textViewResult);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float v1 = Float.parseFloat(String.valueOf(et1.getText()));
                float v2 = Float.parseFloat(String.valueOf(et2.getText()));
                float difRelativa = (v2-v1) * 100 / Math.abs(v1);
                tv.setText(difRelativa+"");
            }
        });



        //Actividades
        //a) Ejecuta la aplicacion y familiarizate con el layout definido en R.layout.activity_main
        //b) Crea la logica para calcular la diferencia relativa en porcentaje entre dos numeros
        //c) La formula para calcular la diferencia relativa en porcentaje esta en: https://www.calculatorsoup.com/calculators/algebra/percent-change-calculator.php
        //d) La aplicacion debe calcular la diferencia relativa en porcentaje de los valores contenidos en "editText" y "editText2"
        //e) Al hacer click en el boton "button", la aplicacion debera calcular dicha diferencia y poner el resultado en el campo "textViewResult"
        //f) La aplicacion debera manejar adecuadamente el cambio de rotacion para el resultado y los campos de texto
        //e) Anota tus respuestas y las capturas de pantalla en un documento en Word
        //f) Sube tu codigo al repositorio.
        //g) Sube el documento Word a la plataforma Moodle. Incluye la liga a tu repositorio


    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        final TextView tv = findViewById(R.id.textViewResult);
        final EditText et1 = (EditText) findViewById(R.id.editText);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        tv.setText(savedInstanceState.getString("resultado"));
        et1.setText(savedInstanceState.getString("valor1"));
        et2.setText(savedInstanceState.getString("valor2"));
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        final TextView tv = findViewById(R.id.textViewResult);
        final EditText et1 = (EditText) findViewById(R.id.editText);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        outState.putString("resultado", tv.getText().toString());
        outState.putString("valor1",et1.getText().toString());
        outState.putString("valor2",et2.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
