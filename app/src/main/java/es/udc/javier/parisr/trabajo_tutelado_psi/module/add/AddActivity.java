package es.udc.javier.parisr.trabajo_tutelado_psi.module.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.udc.javier.parisr.trabajo_tutelado_psi.R;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service.RouteService;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service.RouteServiceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.util.PropertyValidator;
import es.udc.javier.parisr.trabajo_tutelado_psi.util.exceptions.InputValidationException;

public class AddActivity extends AppCompatActivity {

    Button bt_create;
    EditText text_name,text_sub,text_image,text_desc;
    RouteService routeService = new RouteServiceImp();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        bt_create= findViewById(R.id.add_button);
        text_name = findViewById(R.id.et_name);
        text_sub = findViewById(R.id.et_subtitle);
        text_image = findViewById(R.id.et_image);
        text_desc = findViewById(R.id.et_description);
        bt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = text_name.getEditableText().toString();
                String desc = text_desc.getEditableText().toString();
                String sub = text_sub.getEditableText().toString();
                String image = text_image.getEditableText().toString();

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


                routeService.addRoute(route);

                finish();
            }
        });
    }


}