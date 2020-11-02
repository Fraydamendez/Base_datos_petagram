package com.mendez.mascotas;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mendez.mascotas.Adaptador.Mascota_Adaptador;
import com.mendez.mascotas.Pojo.Mascota;

import java.util.ArrayList;
public class mascota_favorita extends AppCompatActivity {

    ArrayList<Mascota> mascotasfav;
    private RecyclerView listaMascotasFav;
    private Toolbar ActionBarfav;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        androidx.appcompat.widget.Toolbar ActionBarfav = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(ActionBarfav);

         getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        listaMascotasFav = (RecyclerView) findViewById(R.id.rvFav);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(llm);
        inicializaListaMascotasFav();
        inicializarAdaptadorFav();

    }

    public Mascota_Adaptador adaptador;

    public void inicializarAdaptadorFav(){
        adaptador = new Mascota_Adaptador(mascotasfav, this);
        listaMascotasFav.setAdapter(adaptador);

    }

    public void inicializaListaMascotasFav(){

        mascotasfav = new ArrayList<Mascota>();


        mascotasfav.add(new Mascota(R.drawable.pug, "Patas", "2"));
        mascotasfav.add(new Mascota(R.drawable.rayas,"Rayas", "4"));
        mascotasfav.add(new Mascota(R.drawable.victor,"Victor", "3"));
        mascotasfav.add(new Mascota(R.drawable.shein,"Shein", "5"));
        mascotasfav.add(new Mascota(R.drawable.coco,"Coquito", "5"));
    }


}






