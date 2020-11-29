package es.udc.javier.parisr.trabajo_tutelado_psi.module.conf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import es.udc.javier.parisr.trabajo_tutelado_psi.R;

public class ConfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf);

        final CheckBox view_subtitle = findViewById(R.id.cb_subt);
        final CheckBox view_descr = findViewById(R.id.cb_desc);
        String prefer="preferences";
        SharedPreferences sharedPreferences = getSharedPreferences(prefer,Context.MODE_PRIVATE);
        Boolean viewsubtitle= sharedPreferences.getBoolean("viewsubtitle",false);
        Boolean viewdescription= sharedPreferences.getBoolean("viewdesc",true);
        view_descr.setChecked(viewdescription);
        view_subtitle.setChecked(viewsubtitle);

        view_descr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean verdesc = view_descr.isChecked();
                Context context = getApplicationContext();
                String prefer="preferences";
                SharedPreferences sharedPreferences = getSharedPreferences(prefer,context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putBoolean("viewdesc",verdesc);
                editor.apply();
            }
        });

        view_subtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean verdesc = view_subtitle.isChecked();
                Context context = getApplicationContext();
                String prefer="preferences";
                SharedPreferences sharedPreferences = getSharedPreferences(prefer,context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putBoolean("viewsubtitle",verdesc);
                editor.apply();
            }
        });
    }
}