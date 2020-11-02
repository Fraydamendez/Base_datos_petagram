package com.mendez.mascotas.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mendez.mascotas.Adaptador.Mascota_Adaptador;
import com.mendez.mascotas.MainActivity;
import com.mendez.mascotas.Pojo.Mascota;
import com.mendez.mascotas.R;
import com.mendez.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.mendez.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {
    private IRecyclerViewFragmentPresenter presenter;
    private RecyclerView listaMascotas;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        //super.onCreate(savedInstanceState);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascota);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        presenter.obtenerMascotasBaseDatos();
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);


    }

    @Override
    public Mascota_Adaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        Mascota_Adaptador adaptador = new Mascota_Adaptador(mascotas, (MainActivity) getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRv(Mascota_Adaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
