package com.example.josemanuelgarciacruz.ajedrezdidapp.proveedor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.josemanuelgarciacruz.ajedrezdidapp.pojos.Player;

public class PlayerProveedor {
    public static void insertRecord(ContentResolver resolver, Player player){

        Uri uri = Contrato.Player.CONTENT_URI;
        ContentValues values = new ContentValues();
        values.put(Contrato.Player.NOMBRE, player.getNombre());
        values.put(Contrato.Player.NACIONALIDAD, player.getNacionalidad());
        values.put(Contrato.Player.YEAR_NAC, player.getYearNacimiento());
        values.put(Contrato.Player.YEAR_DEF, player.getYearDefuncion());
        values.put(Contrato.Player.ELO, player.getElo());


        resolver.insert(uri, values);
    }

    static public void deleteRecord(ContentResolver resolver, int playerId){
        Uri uri = Uri.parse(Contrato.Player.CONTENT_URI + "/" + playerId);
        resolver.delete(uri, null, null);
    }

    public static void updateRecord(ContentResolver resolver, Player player){
        Uri uri = Uri.parse(Contrato.Player.CONTENT_URI + "/" + player.getID());

        ContentValues values = new ContentValues();

        values.put(Contrato.Player.NOMBRE, player.getNombre());
        values.put(Contrato.Player.NACIONALIDAD, player.getNacionalidad());
        values.put(Contrato.Player.YEAR_NAC, player.getYearNacimiento());
        values.put(Contrato.Player.YEAR_DEF, player.getYearDefuncion());
        values.put(Contrato.Player.ELO, player.getElo());

        resolver.update(uri, values, null, null);
    }

    static public Player readRecord(ContentResolver resolver, int playerId){

        Uri uri = Uri.parse(Contrato.Player.CONTENT_URI + "/" + playerId);
        String[] projection = {
                Contrato.Player.NOMBRE,
                Contrato.Player.NACIONALIDAD,
                Contrato.Player.YEAR_NAC,
                Contrato.Player.YEAR_DEF,
                Contrato.Player.ELO
        };

        Cursor cursor = resolver.query(uri, projection, null, null, null);
        if (((Cursor) cursor).moveToFirst()){

            Player player = new Player();
            player.setID(playerId);

            player.setNombre(cursor.getString(cursor.getColumnIndex(Contrato.Player.NOMBRE)));
            player.setNacionalidad(cursor.getString(cursor.getColumnIndex(Contrato.Player.NACIONALIDAD)));
            player.setYearNacimiento(cursor.getInt(cursor.getColumnIndex(Contrato.Player.YEAR_NAC)));
            player.setYearDefuncion(cursor.getInt(cursor.getColumnIndex(Contrato.Player.YEAR_DEF)));
            player.setElo(cursor.getInt(cursor.getColumnIndex(Contrato.Player.ELO)));

            return player;
        }

        return null;
    }
}
