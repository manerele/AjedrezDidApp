package com.example.josemanuelgarciacruz.ajedrezdidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextClave;
    EditText editTextMail;
    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextClave = (EditText) findViewById(R.id.editTextClave);
        editTextMail = (EditText) findViewById(R.id.editTextMail);

        contexto = this;

        /*  Deshabilito el teclado del emulador
        editTextNombre.setInputType(InputType.TYPE_NULL);
        editTextClave.setInputType(InputType.TYPE_NULL);
        */

        Button buttonValidar = (Button) findViewById(R.id.buttonCrearUsuario);
        buttonValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validar();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void validar(){
        editTextNombre.setError(null);
        editTextClave.setError(null);

        String nombre = editTextNombre.getText().toString();
        String claveString = editTextClave.getText().toString();
        String mailString = editTextMail.getText().toString();

        if (TextUtils.isEmpty(nombre)){
            editTextNombre.setError(getString(R.string.error_campo_obligatorio));
            editTextNombre.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(claveString)){
            editTextClave.setError(getString(R.string.error_campo_obligatorio));
            editTextClave.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(mailString)){
            editTextMail.setError(getString(R.string.error_campo_obligatorio));
            editTextMail.requestFocus();
            return;
        }

        Intent intent = new Intent(contexto, MainActivity.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Nuevo usuario creado correctamente", Toast.LENGTH_SHORT).show();

    }
}
