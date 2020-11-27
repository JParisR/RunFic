package es.udc.javier.parisr.trabajo_tutelado_psi.module.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import es.udc.javier.parisr.trabajo_tutelado_psi.R;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title = findViewById(R.id.tv_title_detail);
        TextView subtitle = findViewById(R.id.tv_subtitle_detail);
        TextView description = findViewById(R.id.tv_description_detail);
        ImageView imageView = findViewById(R.id.tv_image);
        //Recupero el intent y el bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");

        //Obtengo el item y lo envio a la vista.
        try{
            Route route = (Route) bundle.getSerializable("item");
            title.setText(route.getRoute_name());
            subtitle.setText(route.getRoute_subname());
            description.setText(route.getRoute_description());
            Picasso.with(imageView.getContext())
                    .load(route.getImageURI())
                    .into(imageView);
        }catch (NullPointerException e){
            Toast.makeText(this, "No existen items", Toast.LENGTH_LONG).show();
        }
    }
}