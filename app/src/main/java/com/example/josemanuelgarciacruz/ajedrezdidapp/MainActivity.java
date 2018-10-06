package com.example.josemanuelgarciacruz.ajedrezdidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

// Segunda Version

public class MainActivity extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextClave;
    CheckBox checkBoxLogin;

    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextClave = (EditText) findViewById(R.id.editTextClave);

        checkBoxLogin = (CheckBox) findViewById(R.id.checkBoxCrear);

        contexto = this;

        /*  Deshabilito el teclado del emulador
        editTextNombre.setInputType(InputType.TYPE_NULL);
        editTextClave.setInputType(InputType.TYPE_NULL);
        */

        Button buttonValidar = (Button) findViewById(R.id.buttonSiguiente);
        buttonValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validar();
            }
        });
    }

    private void validar(){
        editTextNombre.setError(null);
        editTextClave.setError(null);

        String nombre = editTextNombre.getText().toString();
        String claveString = editTextClave.getText().toString();

        if (checkBoxLogin.isChecked()){
            Intent intentLogin = new Intent(contexto, LoginActivity.class);
            startActivity(intentLogin);
            return;
        }

        if (TextUtils.isEmpty(nombre)){
            editTextNombre.setError(getString(R.string.error_campo_obligatorio));
            editTextNombre.requestFocus();
            return;
        }

        if(!nombre.equals("Manuel")){
            editTextNombre.setError(getString(R.string.error_datos_erroneos));
            editTextNombre.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(claveString)){
            editTextClave.setError(getString(R.string.error_campo_obligatorio));
            editTextClave.requestFocus();
            return;
        }

        if(!claveString.equals("1234")){
            editTextClave.setError(getString(R.string.error_datos_erroneos));
            editTextClave.requestFocus();
            return;
        }

        int clave = Integer.parseInt(claveString);
        if(clave != 1234){
            editTextClave.setError(getString(R.string.error_datos_erroneos));
            editTextClave.requestFocus();
            return;
        }



        Intent intent = new Intent(contexto, IndiceActivity.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Se ha validado correctamente", Toast.LENGTH_SHORT).show();


    }
}
