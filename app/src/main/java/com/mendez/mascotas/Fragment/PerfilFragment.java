package com.mendez.mascotas.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mendez.mascotas.Adaptador.Adaptador_Perfil;
import com.mendez.mascotas.MainActivity;
import com.mendez.mascotas.Pojo.Perfil;
import com.mendez.mascotas.R;
import com.mendez.mascotas.presentador.IPerfilFragmentPresent;
import com.mendez.mascotas.presentador.PerfilFragmentPresenter;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements IPerfilFragment {
    private IPerfilFragmentPresent presenter;
    private RecyclerView listaMascotas;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        //super.onCreate(savedInstanceState);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotaPerfil);
        presenter = new PerfilFragmentPresenter(this, getContext());
        presenter.mostarMascotasRV();
        return v;
    }


    @Override
    public void generarGridLayout() {

        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        listaMascotas.setLayoutManager(glm);


    }

    @Override
    public Adaptador_Perfil crearAdaptador (ArrayList<Perfil> perfil) {
        Adaptador_Perfil adaptador = new Adaptador_Perfil (perfil, (MainActivity) getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRv(Adaptador_Perfil adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}


