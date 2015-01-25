package com.example.aitor.reproductorvideo;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

/**
 * Created by aitor on 19/01/2015.
 */
public class Adaptador extends CursorAdapter {
    private TextView tvnombre,tvfecha,tvtamano;
    private ImageView img;

    public Adaptador(Context context, Cursor c) {
        super(context, c, true);
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater i = LayoutInflater.from(parent.getContext());
        View v = i.inflate(R.layout.detalle, parent, false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
            img=(ImageView)view.findViewById(R.id.Image);
            tvnombre=(TextView) view.findViewById(R.id.tvnombre);
            tvfecha=(TextView) view.findViewById(R.id.tvfecha);
            tvtamano=(TextView)view.findViewById(R.id.tvtamano);
        Picasso.with(context).load(R.drawable.posibleicono).fit().into(img);
        tvnombre.setText(cursor.getString(cursor.getColumnIndex("_Display_name")));
        tvfecha.setText(Transformaciones.pasarAKB(cursor.getString(cursor.getColumnIndex("_Size"))));
        tvtamano.setText(Transformaciones.daTiempo(cursor.getString(cursor.getColumnIndex("duration"))));
    }



}
