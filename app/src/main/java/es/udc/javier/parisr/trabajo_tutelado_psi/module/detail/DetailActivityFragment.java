package es.udc.javier.parisr.trabajo_tutelado_psi.module.detail;


import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import es.udc.javier.parisr.trabajo_tutelado_psi.R;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service.RouteService;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service.RouteServiceImp;

public class DetailActivityFragment extends Fragment {

    TextView title ;
    TextView subtitle ;
    TextView description;
    ImageView imageView ;
    Route route;
    RouteService routeService = new RouteServiceImp();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView title = view.findViewById(R.id.tv_title_detail);
        TextView subtitle = view.findViewById(R.id.tv_subtitle_detail);
        TextView description = view.findViewById(R.id.tv_description_detail);
        ImageView imageView = view.findViewById(R.id.tv_image);
        Bundle args = getArguments();
        try{
            route = (Route) args.getSerializable("item");
            title.setText(route.getRoute_name());
            subtitle.setText(route.getRoute_subname());
            description.setText(route.getRoute_description());
            Picasso.with(imageView.getContext())
                    .load(route.getImageURI())
                    .into(imageView);

        }catch (NullPointerException e){

        }

        RatingBar calificacion = view.findViewById(R.id.calificacion);
        calificacion.setVisibility(View.INVISIBLE);
        calificacion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                routeService.evaluateRoute(route,rating);
            }
        });

        return view;
    }

}