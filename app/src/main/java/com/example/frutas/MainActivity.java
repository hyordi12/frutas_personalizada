package com.example.frutas;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FrutasAdapter.OnTotalChangeListener {

    private RecyclerView recyclerViewFrutas;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTotal = findViewById(R.id.tvTotal);

        List<Fruta> frutas = Arrays.asList(
                new Fruta("Manzana", 10, "Una manzana roja dulce", false),
                new Fruta("Banana", 8, "Una banana amarilla jugosa", false),
                new Fruta("Cereza", 5, "Cerezas rojas tiernas", false),
                new Fruta("Fresa", 9, "Fresas rojas sabrosas", false),
                new Fruta("Uva", 15, "Uvas verdes jugosas", false)
        );

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
