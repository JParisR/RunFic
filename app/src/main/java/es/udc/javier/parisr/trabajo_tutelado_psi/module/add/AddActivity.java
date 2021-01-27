package es.udc.javier.parisr.trabajo_tutelado_psi.module.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

import java.util.ArrayList;
import java.util.List;

import es.udc.javier.parisr.trabajo_tutelado_psi.R;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service.RouteService;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service.RouteServiceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.util.PropertyValidator;
import es.udc.javier.parisr.trabajo_tutelado_psi.util.exceptions.InputValidationException;

public class AddActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener{

    Button bt_create, bt_reinicio;
    EditText text_name,text_sub,text_image,text_desc;
    RouteService routeService = new RouteServiceImp();
    String ruta = "";
    ArrayList<MarkerOptions> markers = new ArrayList<>();
    GoogleMap map;
    int m = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        bt_create= findViewById(R.id.add_button);
        text_name = findViewById(R.id.et_name);
        text_sub = findViewById(R.id.et_subtitle);
        text_image = findViewById(R.id.et_image);
        text_desc = findViewById(R.id.et_description);
        bt_reinicio = findViewById(R.id.reinicio_button);
        bt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = text_name.getEditableText().toString();
                String desc = text_desc.getEditableText().toString();
                String sub = text_sub.getEditableText().toString();
                String image = text_image.getEditableText().toString();
                String coordenadas = ruta.toString();

                Route route = new Route(name,sub,desc,image);
                try {
                    PropertyValidator.validateRoute(route);
                }
                catch(InputValidationException ex){
                    Toast toast1 = Toast.makeText(v.getContext(),
                                    ex.getError(), Toast.LENGTH_LONG);
                    toast1.show();
                    return;
                }


                Route route1 = new Route(name,sub,desc,image,coordenadas);
                routeService.addRoute(route1);

                finish();
            }
        });

        bt_reinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruta="";
                map.clear();
            }
        });

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
        googleMap.setOnMapLongClickListener(this);


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
    @Override
    public void onMapLongClick(LatLng latLng) {
        map.addMarker( new MarkerOptions().draggable(true).position(latLng));
        ruta += latLng.latitude + "," + latLng.longitude + ";";

        Toast.makeText(this,"tapped, point=" + latLng,Toast.LENGTH_LONG).show();

    }

}