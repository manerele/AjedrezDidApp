package com.example.josemanuelgarciacruz.ajedrezdidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button buttonVersion1 = (Button) findViewById(R.id.button_version_tarea_1);
        buttonVersion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), IndiceActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_introduccion) {
            Intent intent = new Intent(getApplicationContext(), IntroduccionActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_obj_gen) {
            Intent intent = new Intent(getApplicationContext(), ObjetivosGeneralesActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_obj_esp) {
            Intent intent = new Intent(getApplicationContext(), ObjetivosEspecificosActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_temporalizacion) {
            Intent intent = new Intent(getApplicationContext(), TemporalizacionActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_actuacion) {
            Intent intent = new Intent(getApplicationContext(), ActuacionActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_cont_ini) {
            Intent intent = new Intent(getApplicationContext(), ContenidosActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_cont_grad_med) {
            Intent intent = new Intent(getApplicationContext(), ContenidosMedioActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_Metodologia) {
            Intent intent = new Intent(getApplicationContext(), MetodologiaActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_otras_act) {
            Intent intent = new Intent(getApplicationContext(), OtrasActividadesActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /* Version anterior
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
        Fin version anterior */

        if (id == R.id.nav_fragmentos) {
            Intent intent = new Intent(getApplicationContext(), SeccionesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_introduccion) {
            Intent intent = new Intent(getApplicationContext(), IntroduccionActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_objetivos_generales) {
            Intent intent = new Intent(getApplicationContext(), ObjetivosGeneralesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_objetivos_esprvificos) {
            Intent intent = new Intent(getApplicationContext(), ObjetivosEspecificosActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_temporalizacion) {
            Intent intent = new Intent(getApplicationContext(), TemporalizacionActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_actuacion) {
            Intent intent = new Intent(getApplicationContext(), ActuacionActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contenidos_iniciacion) {
            Intent intent = new Intent(getApplicationContext(), ContenidosActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contenidos_nivel_mediio) {
            Intent intent = new Intent(getApplicationContext(), ContenidosMedioActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_metodologia) {
            Intent intent = new Intent(getApplicationContext(), MetodologiaActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_otras_actividades) {
            Intent intent = new Intent(getApplicationContext(), OtrasActividadesActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
