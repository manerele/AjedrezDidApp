package com.example.josemanuelgarciacruz.ajedrezdidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class IndiceActivity extends AppCompatActivity {

    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indice);

        contexto = this;

        Button buttonSiguiente = (Button) findViewById(R.id.buttonElegir);
        final RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        final RadioButton radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        final RadioButton radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
        final RadioButton radioButton7 = (RadioButton) findViewById(R.id.radioButton7);
        final RadioButton radioButton8 = (RadioButton) findViewById(R.id.radioButton8);
        final RadioButton radioButton9 = (RadioButton) findViewById(R.id.radioButton9);

        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIntroduccion = new Intent(contexto, IntroduccionActivity.class);
                Intent intentObjGen = new Intent(contexto, ObjetivosGeneralesActivity.class);
                Intent intentObjEsp = new Intent(contexto, ObjetivosEspecificosActivity.class);
                Intent intentTemporalizacion = new Intent(contexto, TemporalizacionActivity.class);
                Intent intentActuacion = new Intent(contexto, ActuacionActivity.class);
                Intent intentContenidos = new Intent(contexto, ContenidosActivity.class);
                Intent intentContMedio = new Intent(contexto, ContenidosMedioActivity.class);
                Intent intentMetodologia = new Intent(contexto, MetodologiaActivity.class);
                Intent intentOtrasActividades = new Intent(contexto, OtrasActividadesActivity.class);

                if (radioButton1.isChecked()){
                    startActivity(intentIntroduccion);
                }
                if (radioButton2.isChecked()){
                    startActivity(intentObjGen);
                }
                if (radioButton3.isChecked()){
                    startActivity(intentObjEsp);
                }
                if (radioButton4.isChecked()){
                    startActivity(intentTemporalizacion);
                }
                if (radioButton5.isChecked()){
                    startActivity(intentActuacion);
                }
                if (radioButton6.isChecked()){
                    startActivity(intentContenidos);
                }
                if (radioButton7.isChecked()){
                    startActivity(intentContMedio);
                }
                if (radioButton8.isChecked()){
                    startActivity(intentMetodologia);
                }
                if (radioButton9.isChecked()){
                    startActivity(intentOtrasActividades);
                }

            }
        });
    }
}
