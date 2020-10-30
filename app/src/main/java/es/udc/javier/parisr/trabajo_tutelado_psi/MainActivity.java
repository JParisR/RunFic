package es.udc.javier.parisr.trabajo_tutelado_psi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.ItemClickListener {

    Bundle bundle = new Bundle();
    private MyAdapter adapter;
    Route item = new Route("Ruta 1","Ruta 'A Coruña'","Esta ruta discurre por..");
    Route item2 = new Route("Ruta 2","Ruta 'O Burgo'","Descripción ruta 2");
    Route item3 = new Route("Ruta 3","Ruta 'Cambre'","Descripción ruta 3...");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Datos para el recycler view
        ArrayList<Route> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item2);
        itemList.add(item3);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_main);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        //Divider para el recycler view
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //Use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Creo el adapter de items y se paso al recyclerView
        adapter = new MyAdapter(itemList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

        //Guardo en bundle el item pulsado
        bundle.putSerializable("item",adapter.getItem(position));

        //Creo un intent y le añado el bundle
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("bundle",bundle);
        startActivity(intent);
    }
}