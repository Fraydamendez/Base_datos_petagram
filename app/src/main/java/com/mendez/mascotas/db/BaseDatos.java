package com.mendez.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mendez.mascotas.Pojo.Mascota;
import com.mendez.mascotas.Pojo.Perfil;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstanteBaseDatos.TABLE_MASCOTAS + " ("
                + ConstanteBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstanteBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT, "
                + ConstanteBaseDatos.TABLE_MASCOTAS_PUNTUACION + " TEXT, "
                + ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN     + " INTEGER"+
                ")";

        String queryCrearTablaPerfil = "CREATE TABLE " + ConstanteBaseDatos.TABLE_MASCOTAS_PERFIL + " ("
                + ConstanteBaseDatos.TABLE_MASCOTAS_ID_PERFIL       + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstanteBaseDatos.TABLE_MASCOTAS_PUNTUACION_PERFIL + " TEXT, "
                + ConstanteBaseDatos.TABLE_MASCOTAS_IMAGEN_PERFIL     + " INTEGER"+
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES_MASCOTA + "("
                + ConstanteBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstanteBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, "
                + ConstanteBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER,"
                + "FOREIGN KEY (" + ConstanteBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ")"
                + "REFERENCES " + ConstanteBaseDatos.TABLE_MASCOTAS + "("+ConstanteBaseDatos.TABLE_MASCOTAS_ID +")" +
                ")";

        String queryCrearTablaLikesPerfil = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES_PERFIL + "("
                + ConstanteBaseDatos.TABLE_LIKES_PERFIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstanteBaseDatos.TABLE_LIKES_PERFIL_ID_PERFIL + " INTEGER, "
                + ConstanteBaseDatos.TABLE_LIKES_PERFIL_NUMERO_LIKES + " INTEGER,"
                + "FOREIGN KEY (" + ConstanteBaseDatos.TABLE_LIKES_PERFIL_ID_PERFIL + ")"
                + "REFERENCES " + ConstanteBaseDatos.TABLE_MASCOTAS_PERFIL + "("+ConstanteBaseDatos.TABLE_MASCOTAS_ID +")" +
                ")";



        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaPerfil);
        db.execSQL(queryCrearTablaLikesMascota);
        db.execSQL(queryCrearTablaLikesPerfil);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstanteBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstanteBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setPuntuacion(registros.getString(2));
            mascotaActual.setImagen(registros.getInt(3));


            String queryLikes = "SELECT COUNT("+ConstanteBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes"
                    +" FROM " + ConstanteBaseDatos.TABLE_LIKES_MASCOTA
                    +" WHERE " + ConstanteBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registroslikes = db.rawQuery(queryLikes, null);
            if (registroslikes.moveToNext()){
                mascotaActual.setLikes(registroslikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }
            mascotas.add(mascotaActual);


        }
        db.close();

        return mascotas;
    }

    public ArrayList<Perfil> obtenerTodosLasMascotasPerfil(){
        ArrayList<Perfil> perfils = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_MASCOTAS_PERFIL;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Perfil perfilActual = new Perfil();
            perfilActual.setId(registros.getInt(0));
            perfilActual.setPuntuacionperf(registros.getString(1));
            perfilActual.setImagenperf(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstanteBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes"
                    +" FROM " + ConstanteBaseDatos.TABLE_LIKES_PERFIL
                    +" WHERE " + ConstanteBaseDatos.TABLE_LIKES_PERFIL_ID_PERFIL + "=" + perfilActual.getId();

            Cursor registroslikes = db.rawQuery(queryLikes, null);
            if (registroslikes.moveToNext()){
                perfilActual.setLikesper(registroslikes.getInt(0));
            }else {
                perfilActual.setLikesper(0);
            }
            perfils.add(perfilActual);


        }
        db.close();

        return perfils;
    }


    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();

    }

    public void insertarPerfil(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_MASCOTAS_PERFIL, null, contentValues);
        db.close();

    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikePefil(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKES_PERFIL, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto (Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstanteBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+")"
                + " FROM " + ConstanteBaseDatos.TABLE_LIKES_MASCOTA
                + " WHERE " + ConstanteBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "="+ mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

    public int obtenerLikesContactoPerf (Perfil perfil){
        int likes = 0;

        String query = "SELECT COUNT("+ConstanteBaseDatos.TABLE_LIKES_PERFIL_NUMERO_LIKES+")"
                + " FROM " + ConstanteBaseDatos.TABLE_LIKES_PERFIL
                + " WHERE " + ConstanteBaseDatos.TABLE_LIKES_PERFIL_ID_PERFIL + "="+ perfil.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

}
