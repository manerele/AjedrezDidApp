package com.example.josemanuelgarciacruz.ajedrezdidapp.player;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.josemanuelgarciacruz.ajedrezdidapp.R;
import com.example.josemanuelgarciacruz.ajedrezdidapp.constantes.G;
import com.example.josemanuelgarciacruz.ajedrezdidapp.constantes.Utilidades;
import com.example.josemanuelgarciacruz.ajedrezdidapp.pojos.Player;
import com.example.josemanuelgarciacruz.ajedrezdidapp.proveedor.PlayerProveedor;

import java.io.IOException;

public class PlayerInsertarActivity extends AppCompatActivity {

    final int PETICION_SACAR_FOTO = 1;
    final int PETICION_GALERIA = 2;
    ImageView imageViewPlayer;

    EditText editTextPlayerNombre;
    EditText editTextPlayerNacionalidad;
    EditText editTextPlayerYearNac;
    EditText editTextPlayerYearDef;
    EditText editTextPlayerElo;

    private int intYearNac;
    private int intYearDef;
    private int intElo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detalle);

        editTextPlayerNombre = (EditText) findViewById(R.id.editTextPlayerNombre);
        editTextPlayerNacionalidad = (EditText) findViewById(R.id.editTextPlayerNacionalidad);
        editTextPlayerYearNac = (EditText) findViewById(R.id.editTextPlayerYearNac);
        editTextPlayerYearDef = (EditText) findViewById(R.id.editTextPlayerYearDef);
        editTextPlayerElo = (EditText) findViewById(R.id.editTextPlayerElo);

        imageViewPlayer = (ImageView) findViewById(R.id.image_view_ciclo);

        ImageButton imageButtonCamara = (ImageButton) findViewById(R.id.imagen_button_camara);
        imageButtonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sacarFoto();
            }
        });

        ImageButton imageButtonGaleria = (ImageButton) findViewById(R.id.imagen_button_galeria);
        imageButtonGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elegirDeGaleria();
            }
        });

    }

    void elegirDeGaleria(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, PETICION_GALERIA);
    }

    void sacarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, PETICION_SACAR_FOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case PETICION_SACAR_FOTO:
                if (resultCode == RESULT_OK){
                    Bitmap foto = (Bitmap) data.getExtras().get("data");
                    imageViewPlayer.setImageBitmap(foto);
                    try {
                        Utilidades.storeImage(foto, this, "imagen.jpg");
                    } catch (IOException e){
                        Toast.makeText(getApplicationContext(), "Error: No se pudo guardar la imagen", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    // cancelacion
                }
                break;
            case PETICION_GALERIA:
                if (resultCode == RESULT_OK){
                    Uri uri = data.getData();
                    imageViewPlayer.setImageURI(uri);
                } else {
                    // Cancelacion
                }
                break;
        }

        //super.onActivityResult(requestCode, resultCode, data);
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

        Player player = new Player(G.SIN_VALOR_INT, nombre, nacionalidad, intYearNac, intYearDef, intElo, null);
        PlayerProveedor.insertRecord(getContentResolver(), player);
        finish();


    }
}
