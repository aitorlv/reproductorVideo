package com.example.aitor.reproductorvideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by aitor on 21/01/2015.
 */
public class Transformaciones {

    public static String daTiempo(String milisegundos){
        long milisegundo= Long.parseLong(milisegundos);

       return String.format("%d : %d",
                TimeUnit.MILLISECONDS.toMinutes(milisegundo),
                TimeUnit.MILLISECONDS.toSeconds(milisegundo) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milisegundo))
        );

    }

    public static String pasarAKB(String tamano){
        long size=Long.parseLong(tamano);
        long m = size/1024;

        return m+"KB";
    }
}
