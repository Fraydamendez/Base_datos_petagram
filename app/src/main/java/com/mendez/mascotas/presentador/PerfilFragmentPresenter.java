package com.mendez.mascotas.presentador;

import android.content.Context;

import com.mendez.mascotas.Fragment.IPerfilFragment;
import com.mendez.mascotas.Pojo.Perfil;
import com.mendez.mascotas.db.ConstructorPerfil;

import java.util.ArrayList;

public class PerfilFragmentPresenter implements IPerfilFragmentPresent {
    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ConstructorPerfil constructorPerfil;
    private ArrayList<Perfil> perfil;

    public PerfilFragmentPresenter(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        obtenerMascotasBaseDatos();

    }
    @Override
    public void obtenerMascotasBaseDatos () {
        constructorPerfil = new ConstructorPerfil(context);
        perfil = constructorPerfil.obtenerDatos();
        mostarMascotasRV();
    }

    @Override
    public void mostarMascotasRV() {

        iPerfilFragment.inicializarAdaptadorRv(iPerfilFragment.crearAdaptador(perfil));
        iPerfilFragment.generarGridLayout();

    }
}
