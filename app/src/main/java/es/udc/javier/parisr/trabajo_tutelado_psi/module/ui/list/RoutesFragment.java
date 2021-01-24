package es.udc.javier.parisr.trabajo_tutelado_psi.module.ui.list;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import es.udc.javier.parisr.trabajo_tutelado_psi.R;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service.RouteService;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service.RouteServiceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.module.detail.DetailActivity;

public class RoutesFragment extends Fragment implements RouteAdapter.ItemClickListener {

    Bundle bundle = new Bundle();
    private RouteAdapter adapter;
    private RouteService routeService = new RouteServiceImp();
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_routes, container, false);
        recyclerView = view.findViewById(R.id.rv_routes);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        //Divider para el recycler view
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        //Use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        //Creo el adapter de items y se paso al recyclerView
        adapter = routeService.searchRoutes();
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {

        //Guardo en bundle el item pulsado
        bundle.putSerializable("item",adapter.getItem(position));

        //Creo un intent y le añado el bundle
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("bundle",bundle);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        RouteAdapter adapter;
        adapter = routeService.searchRoutes();
        recyclerView.setAdapter(routeService.searchRoutes());
        adapter.setClickListener(this);
    }
}