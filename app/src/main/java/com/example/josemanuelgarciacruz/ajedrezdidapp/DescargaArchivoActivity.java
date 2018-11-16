package com.example.josemanuelgarciacruz.ajedrezdidapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DescargaArchivoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descarga_archivo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Permite volver a la actividad padre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ImageView imageViewEscarga = (ImageView) findViewById(R.id.image_view_descarga_archivo);
        imageViewEscarga.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_view_descarga_archivo:
                // Aqui comenzamos con la descaga
                descargarPdf();
                break;
        }
    }

    void descargarPdf(){
        String urlADescargar = "https://www3.gobiernodecanarias.org/medusa/edublog/ieselrincon/wp-content/uploads/sites/137/2015/11/tablaDeConvalidaciones-20151019-2124.pdf";
        new DescargarPdfAsyncTask().execute(urlADescargar);

    }

    /*
        Esta clase posibilita que el usuario no se quede esperando a que
        la descarga termine.
        Los tres Void son los parámetros que se pasan a los métodos.
        - El primero se lo pasamos a doInBckground
        - El segundo se lo pasamos al onProgressUpdate
        - El tercero se lo pasamos al onPostExecute
     */
    class DescargarPdfAsyncTask extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... urlPdf) {

            String urlADescargar = urlPdf[0];
            HttpURLConnection conexion = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK){
                    return "Conexión no realizada correctamente";
                }

                inputStream = conexion.getInputStream();
                String rutaFicheroGuardado = getFilesDir() + "/files" + "TabladeDeConvalidaciones.pdf";
                outputStream = new FileOutputStream(rutaFicheroGuardado);

                byte [] data = new byte[1024];
                int count = 0;

                while ((count = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, count);

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            } finally {
                try {
                    if(inputStream != null) inputStream.close();
                    if(outputStream != null) outputStream.close();
                    if(conexion != null) conexion.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "Se realizó la descarga correctamente";
        }

        @Override
        protected void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);

            Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
        }
    }
}
