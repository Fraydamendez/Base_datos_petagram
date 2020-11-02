package com.mendez.mascotas.db;

public class ConstanteBaseDatos {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_MASCOTAS = "mascotas";
    public static final String TABLE_MASCOTAS_ID = "id";
    public static final String TABLE_MASCOTAS_NOMBRE = "nombre" ;
    public static final String TABLE_MASCOTAS_PUNTUACION = "puntuacion";
    public static final String TABLE_MASCOTAS_IMAGEN = "imagen" ;

    public static final String TABLE_LIKES_MASCOTA = "mascotas_like" ;
    public static final String TABLE_LIKES_MASCOTA_ID = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA = "id_mascota" ;
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES ="numero_likes" ;

    public static final String TABLE_MASCOTAS_PERFIL = "mascotas_perfil" ;
    public static final String TABLE_MASCOTAS_ID_PERFIL = "id_perfil";
    public static final String TABLE_MASCOTAS_PUNTUACION_PERFIL = "puntuacion_perfil" ;
    public static final String TABLE_MASCOTAS_IMAGEN_PERFIL = "imagen_perfil";


    public static final String TABLE_LIKES_PERFIL = "perfil_like";
    public static final String TABLE_LIKES_PERFIL_ID = "id" ;
    public static final String TABLE_LIKES_PERFIL_ID_PERFIL = "id_perfil";
    public static final String TABLE_LIKES_PERFIL_NUMERO_LIKES = "numero_likes" ;
}
