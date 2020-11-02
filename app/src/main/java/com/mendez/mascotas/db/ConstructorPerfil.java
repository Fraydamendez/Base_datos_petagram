package com.mendez.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.mendez.mascotas.Pojo.Perfil;
import com.mendez.mascotas.R;

import java.util.ArrayList;

public class ConstructorPerfil {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorPerfil(Context context) {
        this.context=context;
    }

    public ArrayList<Perfil> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarMascotaPerfil(db);
       return db.obtenerTodosLasMascotasPerfil();
    }

    public void insertarMascotaPerfil(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN_PERFIL, R.drawable.pug3);
        db.insertarPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN_PERFIL, R.drawable.pug4);
        db.insertarPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN_PERFIL, R.drawable.pug5);
        db.insertarPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN_PERFIL, R.drawable.pug6);
        db.insertarPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN_PERFIL, R.drawable.pug7);
        db.insertarPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN_PERFIL, R.drawable.pug8);
        db.insertarPerfil(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN_PERFIL, R.drawable.pug9);
        db.insertarPerfil(contentValues);

    }
    public void darLikeContacto (Perfil perfil){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_PERFIL_ID_PERFIL, perfil.getId());
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_PERFIL_NUMERO_LIKES,LIKE);
        db.insertarLikePefil(contentValues);
    }

    public int obtenerLikesContactoPerf(Perfil perfil){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContactoPerf(perfil);

    }
}


