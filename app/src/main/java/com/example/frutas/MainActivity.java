package com.example.frutas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FrutasAdapter.OnTotalChangeListener {

    private RecyclerView recyclerViewFrutas;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTotal = findViewById(R.id.tvTotal);

        List<Fruta> frutas = new ArrayList<>();
        frutas.add(new Fruta(getString(R.string.manzana), 10, getString(R.string.descripcion_manzana), false));
        frutas.add(new Fruta(getString(R.string.banana), 8, getString(R.string.descripcion_banana), false));
        frutas.add(new Fruta(getString(R.string.cereza), 5, getString(R.string.descripcion_cereza), false));
        frutas.add(new Fruta(getString(R.string.fresa), 9, getString(R.string.descripcion_fresa), false));
        frutas.add(new Fruta(getString(R.string.uva), 15, getString(R.string.descripcion_uva), false));

        recyclerViewFrutas = findViewById(R.id.recyclerViewFrutas);
        recyclerViewFrutas.setLayoutManager(new LinearLayoutManager(this));
        FrutasAdapter adapter = new FrutasAdapter(this, frutas, this);
        recyclerViewFrutas.setAdapter(adapter);
    }

    @Override
    public void onTotalChange(double total) {
        tvTotal.setText("Total: " + total);
    }
}
