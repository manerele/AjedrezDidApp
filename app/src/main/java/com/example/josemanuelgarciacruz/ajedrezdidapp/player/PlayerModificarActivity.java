package com.example.josemanuelgarciacruz.ajedrezdidapp.player;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.josemanuelgarciacruz.ajedrezdidapp.R;
import com.example.josemanuelgarciacruz.ajedrezdidapp.constantes.G;
import com.example.josemanuelgarciacruz.ajedrezdidapp.pojos.Player;
import com.example.josemanuelgarciacruz.ajedrezdidapp.proveedor.Contrato;
import com.example.josemanuelgarciacruz.ajedrezdidapp.proveedor.PlayerProveedor;

public class PlayerModificarActivity extends AppCompatActivity {

    EditText editTextPlayerNombre;
    EditText editTextPlayerNacionalidad;
    EditText editTextPlayerYearNac;
    EditText editTextPlayerYearDef;
    EditText editTextPlayerElo;

    private int intYearNac;
    private int intYearDef;
    private int intElo;
    int playerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detalle);



        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Player_detalle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        */

        editTextPlayerNombre = (EditText) findViewById(R.id.editTextPlayerNombre);
        editTextPlayerNacionalidad = (EditText) findViewById(R.id.editTextPlayerNacionalidad);
        editTextPlayerYearNac = (EditText) findViewById(R.id.editTextPlayerYearNac);
        editTextPlayerYearDef = (EditText) findViewById(R.id.editTextPlayerYearDef);
        editTextPlayerElo = (EditText) findViewById(R.id.editTextPlayerElo);

        playerId = this.getIntent().getExtras().getInt(Contrato.Player._ID);
        Player player = PlayerProveedor.readRecord(getContentResolver(), playerId);


        Log.i("manolo", "Player player");

        editTextPlayerNombre.setText(player.getNombre());
        Log.i("manolo", "editTextPlayerNombre");
        editTextPlayerNacionalidad.setText(player.getNacionalidad());;
        Log.i("manolo", "editTextPlayerNacionalida");
        editTextPlayerYearNac.setText(String.valueOf(player.getYearNacimiento()));;
        Log.i("manolo", "editTextPlayerYearNac");
        editTextPlayerYearDef.setText(String.valueOf(player.getYearDefuncion()));;
        Log.i("manolo", "editTextPlayerYearDef");
        editTextPlayerElo.setText(String.valueOf(player.getElo()));;
        Log.i("manolo", "editTextPlayerElo");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem menuItem = menu.add(Menu.NONE, G.GUARDAR, Menu.NONE, "Guardar");
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuItem.setIcon(R.drawable.ic_action_guardar);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case G.GUARDAR:
                attemptGuardar();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    void attemptGuardar(){


        EditText editTextPlayerNombre = (EditText) findViewById(R.id.editTextPlayerNombre);
        EditText editTextPlayerNacionalidad = (EditText) findViewById(R.id.editTextPlayerNacionalidad);
        EditText editTextPlayerYearNac = (EditText) findViewById(R.id.editTextPlayerYearNac);
        EditText editTextPlayerYearDef = (EditText) findViewById(R.id.editTextPlayerYearDef);
        EditText editTextPlayerElo = (EditText) findViewById(R.id.editTextPlayerElo);


        editTextPlayerNombre.setError(null);
        editTextPlayerNacionalidad.setError(null);
        editTextPlayerYearNac.setError(null);
        editTextPlayerYearDef.setError(null);
        editTextPlayerElo.setError(null);



        String nombre = String.valueOf(editTextPlayerNombre.getText());
        String nacionalidad = String.valueOf(editTextPlayerNacionalidad.getText());


        String yearNac = String.valueOf(editTextPlayerYearNac.getText());
        if (!TextUtils.isEmpty(yearNac)) {
            intYearNac = Integer.parseInt(yearNac);
        }

        String yearDef = String.valueOf(editTextPlayerYearDef.getText());
        if (!TextUtils.isEmpty(yearDef)) {
            intYearDef = Integer.parseInt(yearDef);
        }

        String elo = String.valueOf(editTextPlayerElo.getText());
        if (!TextUtils.isEmpty(elo)) {
            intElo = Integer.parseInt(elo);
        }

        if (TextUtils.isEmpty(nombre)){
            editTextPlayerNombre.setError(getString(R.string.campo_requerido));
            editTextPlayerNombre.requestFocus();

            return;
        }

        if (TextUtils.isEmpty(nacionalidad)){
            editTextPlayerNacionalidad.setError(getString(R.string.campo_requerido));
            editTextPlayerNacionalidad.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(yearNac)){
            editTextPlayerYearNac.setError(getString(R.string.campo_requerido));
            editTextPlayerYearNac.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(yearDef)){
            editTextPlayerYearDef.setError(getString(R.string.campo_requerido));
            editTextPlayerYearDef.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(elo)){
            editTextPlayerElo.setError(getString(R.string.campo_requerido));
            editTextPlayerElo.requestFocus();
            return;
        }

        Player player = new Player(playerId, nombre, nacionalidad, intYearNac, intYearDef, intElo);
        PlayerProveedor.updateRecord(getContentResolver(), player);
        finish();


    }
}
