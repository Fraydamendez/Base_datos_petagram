package com.mendez.mascotas.Fragment;

import com.mendez.mascotas.Adaptador.Adaptador_Perfil;
import com.mendez.mascotas.Pojo.Perfil;

import java.util.ArrayList;

public interface IPerfilFragment {

    public void generarGridLayout();
    public Adaptador_Perfil crearAdaptador(ArrayList<Perfil> perfil);
    public void inicializarAdaptadorRv(Adaptador_Perfil adaptador);
}
