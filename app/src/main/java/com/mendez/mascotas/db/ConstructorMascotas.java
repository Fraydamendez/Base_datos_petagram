package com.mendez.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.mendez.mascotas.Pojo.Mascota;
import com.mendez.mascotas.R;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascotas(Context context) {
        this.context=context;
    }


    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarMascota(db);
        return db.obtenerTodosLasMascotas();
    }

    public void insertarMascota(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Patas");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.pug);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Shein");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.shein);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Rayas");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.rayas);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Victor");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.victor);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE, "Coco");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.coco);
        db.insertarMascota(contentValues);



    }

    public void darLikeContacto (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES,LIKE);
        db.insertarLikeMascota(contentValues);
    }



      public int obtenerLikesContacto (Mascota mascota){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(mascota);

    }




}
