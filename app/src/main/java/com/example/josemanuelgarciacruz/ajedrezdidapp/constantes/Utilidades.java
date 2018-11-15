package com.example.josemanuelgarciacruz.ajedrezdidapp.constantes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utilidades {

    static public void loadImageFromStorage(Context contexto, String imagenFichero, ImageView img) throws FileNotFoundException {
        File f = contexto.getFileStreamPath(imagenFichero);
        Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
        img.setImageBitmap(b);
    }

    public static void storeImage(Bitmap imagen, Context contexto, String fileName) throws IOException {
        FileOutputStream fos = contexto.openFileOutput(fileName, Context.MODE_PRIVATE);
        imagen.compress(Bitmap.CompressFormat.PNG, 100, fos);
        fos.close();
    }
}
