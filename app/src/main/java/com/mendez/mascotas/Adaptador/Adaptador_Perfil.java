package com.mendez.mascotas.Adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mendez.mascotas.MainActivity;
import com.mendez.mascotas.Pojo.Perfil;
import com.mendez.mascotas.R;
import com.mendez.mascotas.db.ConstructorPerfil;

import java.util.ArrayList;

public class Adaptador_Perfil extends RecyclerView.Adapter<Adaptador_Perfil.PerfilViewHolde> {

    ArrayList<Perfil> perfil;
    Activity activityd;

    public Adaptador_Perfil(ArrayList<Perfil> perfil, MainActivity mainActivity) {
        this.activityd = activityd;
        this.perfil =perfil;


    }


    @NonNull
    @Override
    public PerfilViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false);
        return new PerfilViewHolde(v);


    }

    public void onBindViewHolder(@NonNull final PerfilViewHolde perfilViewHolde, int position) {
        final Perfil perfils = perfil.get(position);
        perfilViewHolde.imgFotoPerfil.setImageResource(perfils.getImagenperf());
        perfilViewHolde.tvPuntuacionCVPerfil.setText(String.valueOf(perfils.getPuntuacionperf())+ "likes");

        perfilViewHolde.btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Te gustó esta foto de Patas " , Toast.LENGTH_SHORT).show();

                ConstructorPerfil constructorPerfil = new ConstructorPerfil(v.getContext());
                constructorPerfil.darLikeContacto(perfils);

                perfilViewHolde.tvPuntuacionCVPerfil.setText(String.valueOf(constructorPerfil.obtenerLikesContactoPerf(perfils)));

            }
        });

    }

    @Override
    public int getItemCount() {
        return perfil.size();
    }



    public static class PerfilViewHolde extends RecyclerView.ViewHolder {
        private ImageView imgFotoPerfil;
        private TextView tvPuntuacionCVPerfil;
        private ImageView btnFav;






        public PerfilViewHolde(View itemView) {
            super(itemView);
            imgFotoPerfil         = (ImageView) itemView.findViewById(R.id.imgFotoPerfilGaleria);
            tvPuntuacionCVPerfil  = (TextView) itemView.findViewById(R.id.tvpuntuacionPerfil);
            btnFav          = (ImageView) itemView.findViewById(R.id.ImgHuesoAmarilloPerfil);


        }
    }
}

