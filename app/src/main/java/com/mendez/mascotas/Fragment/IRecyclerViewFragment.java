package com.mendez.mascotas.Fragment;

import com.mendez.mascotas.Adaptador.Mascota_Adaptador;
import com.mendez.mascotas.Pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragment {
    public void generarLinearLayoutVertical();
    public Mascota_Adaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRv(Mascota_Adaptador adaptador);
}
