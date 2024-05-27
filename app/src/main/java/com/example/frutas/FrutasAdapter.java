package com.example.frutas;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FrutasAdapter extends RecyclerView.Adapter<FrutasAdapter.FrutaViewHolder> {

    private Context context;
    private List<Fruta> frutas;
    private double total;
    private OnTotalChangeListener listener;

    public FrutasAdapter(Context context, List<Fruta> frutas, OnTotalChangeListener listener) {
        this.context = context;
        this.frutas = frutas;
        this.listener = listener;
        this.total = 0;
    }

    @NonNull
    @Override
    public FrutaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_frutas, parent, false);
        return new FrutaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrutaViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Fruta fruta = frutas.get(position);
        holder.tvPrecio.setText(String.valueOf(fruta.getPrecio()));
        holder.tvDescripcion.setText(fruta.getDescripcion());


        String imageName = getImagenName(fruta.getNombre());
        Drawable imageDrawable = context.getResources().getDrawable(context.getResources().getIdentifier(imageName, "drawable", context.getPackageName()));
        if (imageDrawable!= null) {
            holder.ivImagen.setImageDrawable(imageDrawable);
        } else {
            holder.ivImagen.setImageResource(R.drawable.default_image);
        }

        holder.itemView.setOnClickListener(v -> {
            if (!fruta.isSeleccionada()) {
                total += fruta.getPrecio();
                fruta.setSeleccionada(true);
            }
            notifyItemChanged(position);
            notifyTotalChanged();
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (fruta.isSeleccionada()) {
                total -= fruta.getPrecio();
                fruta.setSeleccionada(false);
            }
            notifyItemChanged(position);
            notifyTotalChanged();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return frutas.size();
    }

    private void notifyTotalChanged() {
        if (listener!= null) {
            listener.onTotalChange(total);
        }
    }

    private String getImagenName(String nombre) {
        String imageName = "";
        switch (nombre) {
            case "Manzana":
                imageName = "manzana";
                break;
            case "Banana":
                imageName = "banana";
                break;
            case "Cereza":
                imageName = "cereza";
                break;
            case "Fresa":
                imageName = "fresa";
                break;
            case "Uva":
                imageName = "uva";
                break;
            default:
                imageName = "default_image";
        }
        return imageName;
    }

    static class FrutaViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagen;
        TextView tvPrecio;
        TextView tvDescripcion;

        public FrutaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        }
    }

    public interface OnTotalChangeListener {
        void onTotalChange(double total);
    }
}
