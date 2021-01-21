package es.udc.javier.parisr.trabajo_tutelado_psi.module.detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CustomCap;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

import es.udc.javier.parisr.trabajo_tutelado_psi.R;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    DetailActivityFragment detailFragment;
    ArrayList< String[]> latLongString = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        try{

            Route route = (Route) bundle.getSerializable("item");
            route.getCoordenadas();
            String coordenadas = route.getCoordenadas();
            String [] array = coordenadas.split(";");
            for(int i = 0 ; i < array.length; i++){
                latLongString.add(array[i].split(","));
            }
            coordenadas.length();
            // "[lat/lng: (15.873785412226027,-14.067908339202404), lat/lng: (-13.655144559111513,24.101245589554306), lat/lng: (28.138426661939143,42.984977066516876), lat/lng: (-15.85568157299516,24.772195480763912), lat/lng: (-12.608182672633834,-52.90360026061534)]"
        }catch (NullPointerException e){
            Toast.makeText(this,"Error obteniendo la ruta",Toast.LENGTH_LONG).show();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        detailFragment = new DetailActivityFragment();
        detailFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.Fragment1, detailFragment);
        fragmentTransaction.commit();


        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        PolylineOptions poli = new PolylineOptions().clickable(true);

        for(int i = 0; i < latLongString.size(); i++){
            String lat = latLongString.get(i)[0];
            String lon = latLongString.get(i)[1];
            poli.add(new LatLng(Double.parseDouble(lat), Double.parseDouble(lon) ));
        }
        Polyline polyline1 = googleMap.addPolyline(poli);
        // [END maps_poly_activity_add_polyline]
        // [START_EXCLUDE silent]
        // Store a data object with the polyline, used here to indicate an arbitrary type.
        polyline1.setTag("B");
        // [END maps_poly_activity_add_polyline_set_tag]
        // Style the polyline.
        stylePolyline(polyline1);

    }

    // [START maps_poly_activity_style_polyline]
    private static final int COLOR_BLACK_ARGB = 0xff000000;
    private static final int POLYLINE_STROKE_WIDTH_PX = 12;

    /**
     * Styles the polyline, based on type.
     * @param polyline The polyline object that needs styling.
     */
    private void stylePolyline(Polyline polyline) {
        String type = "";
        // Get the data object stored with the polyline.
        if (polyline.getTag() != null) {
            type = polyline.getTag().toString();
        }

        switch (type) {
            // If no type is given, allow the API to use the default.
            case "A":

                break;
            case "B":
                // Use a round cap at the start of the line.
                polyline.setStartCap(new RoundCap());
                break;
        }

        polyline.setEndCap(new RoundCap());
        polyline.setWidth(POLYLINE_STROKE_WIDTH_PX);
        polyline.setColor(COLOR_BLACK_ARGB);
        polyline.setJointType(JointType.ROUND);
    }



}
