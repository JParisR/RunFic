package es.udc.javier.parisr.trabajo_tutelado_psi.module.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.udc.javier.parisr.trabajo_tutelado_psi.module.main.MainActivity;
import es.udc.javier.parisr.trabajo_tutelado_psi.databinding.ActivityAuthBinding;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.service.AuthService;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.service.AuthServiceImp;

public class AuthActivity extends AppCompatActivity {

    private ActivityAuthBinding binding;
    AuthService authService = new AuthServiceImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void signIn(final View view){

        String email = binding.etAuthEmail.getText().toString().trim();
        String password = binding.etAuthPassword.getText().toString().trim();

        switch (authService.signIn(email,password))
        {
            case EMAIL_ERROR:
                Toast.makeText(AuthActivity.this,"Invalid email", Toast.LENGTH_SHORT).show();
                break;

            case PWD_ERROR:
                Toast.makeText(AuthActivity.this,"Password must have at least 6 characters",
                        Toast.LENGTH_SHORT).show();
                break;

            case SUCCESS:
                goToMainActivity();
                break;

            case FAILURE:
                Toast.makeText(AuthActivity.this, "Sign in failed, please, try again.",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void logIn(View view){

        String email = binding.etAuthEmail.getText().toString().trim();
        String password = binding.etAuthPassword.getText().toString().trim();

        switch (authService.logIn(email,password))
        {
            case EMAIL_ERROR:
                Toast.makeText(AuthActivity.this,"Invalid email", Toast.LENGTH_SHORT).show();
                break;

            case PWD_ERROR:
                Toast.makeText(AuthActivity.this,"Password must have at least 6 characters",
                        Toast.LENGTH_SHORT).show();
                break;

            case SUCCESS:
                goToMainActivity();
                break;

            case FAILURE:
                Toast.makeText(AuthActivity.this, "Log in failed, please, try again.",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void goToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
