package com.nahuel.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.fotoMascota.setImageResource(mascota.getFoto());
        holder.nombreMascota.setText(mascota.getNombre());
        Integer rating = mascota.getRaiting();
        holder.cantLikes.setText(rating.toString());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoMascota;
        private TextView nombreMascota;
        private TextView cantLikes;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoMascota = (ImageView) itemView.findViewById(R.id.fotoMascota);
            nombreMascota = (TextView) itemView.findViewById(R.id.nombreMascota);
            cantLikes = (TextView) itemView.findViewById(R.id.cantLikes);
        }
    }
}
