package com.mendez.mascotas.presentador;

import android.content.Context;

import com.mendez.mascotas.Fragment.IRecyclerViewFragment;
import com.mendez.mascotas.Pojo.Mascota;
import com.mendez.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascota;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();

    }
        @Override
        public void obtenerMascotasBaseDatos () {
            constructorMascotas = new ConstructorMascotas(context);
            mascota = constructorMascotas.obtenerDatos();
            mostarMascotasRV();
        }

        @Override
        public void mostarMascotasRV () {

            iRecyclerViewFragment.inicializarAdaptadorRv(iRecyclerViewFragment.crearAdaptador(mascota));
            iRecyclerViewFragment.generarLinearLayoutVertical();

        }
    }

