package com.example.josemanuelgarciacruz.ajedrezdidapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class SeccionesActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secciones);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secciones, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_secciones, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);


            /* Modifico el código que se genera por omisión con un swhich.

            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            */

            int numeroSeccion = getArguments().getInt(ARG_SECTION_NUMBER);

            switch (numeroSeccion) {
                case 1:{
                    textView.setText(getString(R.string.texto_primera_pestña));
                    return rootView;
                }
                case 2: {
                    textView.setText(getString(R.string.textView_introducion_apartado));
                    return rootView;
                }
                case 3: {
                    textView.setText(getString(R.string.textView_objetivos_generales));
                    return rootView;
                }
                case 4: {
                    textView.setText(getString(R.string.textView_objetivos_especificos));
                    return rootView;
                }
                case 5: {
                    textView.setText(getString(R.string.textView_temporalizacion));
                    return rootView;
                }
                case 6: {
                    textView.setText(getString(R.string.textView_actuacion));
                    return rootView;
                }
                case 7: {
                    textView.setText(getString(R.string.textView_contenidos));
                    return rootView;
                }
                case 8: {
                    textView.setText(getString(R.string.textView_contenidos_nivel_medio));
                    return rootView;
                }
                case 9: {
                    textView.setText(getString(R.string.textView_metodologia));
                    return rootView;
                }
                case 10: {
                    textView.setText(getString(R.string.textView_otras_actividades));
                    return rootView;
                }
            }
            return rootView;
        }

        /*
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_secciones, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
        */
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 10;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "INICIO";
                case 1:
                    return "Introduccion";
                case 2:
                    return "Objetivos Generales";
                case 3:
                    return "Objetivos Especificos";
                case 4:
                    return "Temporalizacion";
                case 5:
                    return "Actuacion";
                case 6:
                    return "Contenidos";
                case 7:
                    return "Contenidos Nivel Medio";
                case 8:
                    return "Metodologia";
                case 9:
                    return "Otras Actividades";

            }
            return super.getPageTitle(position);
        }
    }
}
