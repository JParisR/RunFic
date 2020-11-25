package es.udc.javier.parisr.trabajo_tutelado_psi.module.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import es.udc.javier.parisr.trabajo_tutelado_psi.module.main.MainActivity;
import es.udc.javier.parisr.trabajo_tutelado_psi.databinding.ActivityAuthBinding;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.service.AuthService;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.service.AuthServiceImp;

public class AuthActivity extends AppCompatActivity {

    private static final short MIN_LENGTH = 6;
    private static final String TAG = "tag";
    private ActivityAuthBinding binding;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    AuthService authService = new AuthServiceImp();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();
    }

    public void signIn(final View view){
        String email = binding.etAuthEmail.getText().toString().trim();
        String password = binding.etAuthPassword.getText().toString().trim();

        switch (authService.signIn(email,password))
        {
            case 1:
                Toast.makeText(AuthActivity.this,"Invalid email", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(AuthActivity.this,"Password must have at least 6 characters", Toast.LENGTH_SHORT).show();
                break;

            case 0:
                goToMainActivity();
                break;

            case 3:
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
            case 1:
                Toast.makeText(AuthActivity.this,"Invalid email", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(AuthActivity.this,"Password must have at least 6 characters", Toast.LENGTH_SHORT).show();
                break;

            case 0:
                goToMainActivity();
                break;

            case 3:
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
