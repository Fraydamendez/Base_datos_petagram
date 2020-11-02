package com.mendez.mascotas.Pojo;

public class Perfil {

    public Perfil(int imagenperf, String puntuacionperf) {
        this.puntuacionperf = puntuacionperf;
        this.imagenperf = imagenperf;
    }

    public int getLikesper() {
        return likesper;
    }

    public void setLikesper(int likesper) {
        this.likesper = likesper;
    }

    private int imagenperf;
    private String puntuacionperf;
    private int likesper;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Perfil() {

    }

    public int getImagenperf() {
        return imagenperf;
    }

    public void setImagenperf(int imagenperf) {
        this.imagenperf = imagenperf;
    }

    public String getPuntuacionperf() {
        return puntuacionperf;
    }

    public void setPuntuacionperf(String puntuacionperf) {
        this.puntuacionperf = puntuacionperf;
    }
}
