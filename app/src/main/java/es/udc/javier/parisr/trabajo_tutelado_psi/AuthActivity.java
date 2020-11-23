package es.udc.javier.parisr.trabajo_tutelado_psi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import es.udc.javier.parisr.trabajo_tutelado_psi.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {

    private static final String TAG = "tag";
    private FirebaseAuth mAuth;
    private ActivityAuthBinding binding;

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

        if (email.isEmpty() == false && password.isEmpty() == false){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "createUserWithEmail:success");
                                goToMainActivity();
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(AuthActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void logIn(View view){
        String email = binding.etAuthEmail.getText().toString().trim();
        String password = binding.etAuthPassword.getText().toString().trim();

        if (email.isEmpty() == false && password.isEmpty() == false){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "LogInUserWithEmail:success");
                                goToMainActivity();
                            } else {
                                Log.w(TAG, "LogInUserWithEmail:failure", task.getException());
                                Toast.makeText(AuthActivity.this, "Sign in failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void goToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}