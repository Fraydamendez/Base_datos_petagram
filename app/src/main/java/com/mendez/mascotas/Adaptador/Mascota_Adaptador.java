package com.mendez.mascotas.Adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mendez.mascotas.Pojo.Mascota;
import com.mendez.mascotas.R;
import com.mendez.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;



public class Mascota_Adaptador extends RecyclerView.Adapter<Mascota_Adaptador.MascotaViewHolde> {

    ArrayList<Mascota> mascota;
    Activity activity;

    public Mascota_Adaptador(ArrayList<Mascota> mascota, FragmentActivity mainActivity) {
        this.activity = activity;
        this.mascota=mascota;


    }

    @NonNull
    @Override
    public MascotaViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolde(v);


    }



    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolde mascotaViewHolde, int position) {
       final Mascota mascotas= mascota.get(position);
        mascotaViewHolde.imgFoto.setImageResource(mascotas.getImagen());
        mascotaViewHolde.tv_nombreCV.setText(mascotas.getNombre());
        mascotaViewHolde.tvPuntuacionCV.setText(String.valueOf(mascotas.getPuntuacion())+ "likes");

        mascotaViewHolde.btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Diste like a " + mascotas.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(v.getContext());
                constructorMascotas.darLikeContacto(mascotas);

                mascotaViewHolde.tvPuntuacionCV.setText(String.valueOf(constructorMascotas.obtenerLikesContacto(mascotas)));

            }
        });


    }


    @Override
    public int getItemCount() {
        return mascota.size();
    }



        public static class MascotaViewHolde extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tv_nombreCV;
        private TextView tvPuntuacionCV;
        private ImageView btnFav;




        public MascotaViewHolde(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tv_nombreCV     = (TextView) itemView.findViewById(R.id.tvnombre);
            tvPuntuacionCV  = (TextView) itemView.findViewById(R.id.tvpuntuacion);
            btnFav          = (ImageView) itemView.findViewById(R.id.imgHuesoBlanco);


        }
    }

}
