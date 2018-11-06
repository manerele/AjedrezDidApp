package com.example.josemanuelgarciacruz.ajedrezdidapp.proveedor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

import com.example.josemanuelgarciacruz.ajedrezdidapp.pojos.Player;

public class PlayerProveedor {
    public static void insert(ContentResolver resolver, Player player){

        Uri uri = Contrato.Player.CONTENT_URI;
        ContentValues values = new ContentValues();
        values.put(Contrato.Player.NOMBRE, player.getNombre());
        values.put(Contrato.Player.NACIONALIDAD, player.getNacionalidad());
        values.put(Contrato.Player.YEAR_NAC, player.getYearDefuncion());
        values.put(Contrato.Player.YEAR_DEF, player.getYearNacimiento());
        values.put(Contrato.Player.ELO, player.getElo());


        resolver.insert(uri, values);
    }

    static public void delete(ContentResolver resolver, int playerId){
        Uri uri = Uri.parse(Contrato.Player.CONTENT_URI + "/" + playerId);
        resolver.delete(uri, null, null);
    }
}
