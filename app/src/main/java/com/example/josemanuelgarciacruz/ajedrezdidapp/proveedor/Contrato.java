package com.example.josemanuelgarciacruz.ajedrezdidapp.proveedor;

import android.net.Uri;
import android.provider.BaseColumns;

public class Contrato {

    public static final String AUTHORITY = "com.example.josemanuelgarciacruz.ajedrezdidapp.proveedor.ProveedorDeContenido";

    public static final class Player implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .parse("content://"+AUTHORITY+"/Player");

        // Table column
        public static final String NOMBRE = "Nombre";
        public static final String NACIONALIDAD = "Abreviatura";
        public static final String YEAR_NAC = "YearNacimiento";
        public static final String YEAR_DEF = "YearDefuncion";
        public static final String ELO = "Elo";
    }
}
