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

    private static final short MIN_LENGTH = 6;
    private static final String TAG = "tag";
    private FirebaseAuth mAuth;
    private ActivityAuthBinding binding;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

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

        if (!email.matches(emailPattern)){
            Toast.makeText(AuthActivity.this,"Invalid email", Toast.LENGTH_SHORT).show();
        }
        else if(password.length() < MIN_LENGTH){
            Toast.makeText(AuthActivity.this,"Password must have at least 6 characters", Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "createUserWithEmail:success");
                                goToMainActivity();
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(AuthActivity.this, "Sign in failed, please, try again.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void logIn(View view){
        String email = binding.etAuthEmail.getText().toString().trim();
        String password = binding.etAuthPassword.getText().toString().trim();

        if (!email.matches(emailPattern)){
            Toast.makeText(AuthActivity.this,"Invalid email", Toast.LENGTH_SHORT).show();
        }
        else if(password.length() < MIN_LENGTH){
            Toast.makeText(AuthActivity.this,"Password must have at least 6 characters", Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "LogInUserWithEmail:success");
                                goToMainActivity();
                            } else {
                                Log.w(TAG, "LogInUserWithEmail:failure", task.getException());
                                Toast.makeText(AuthActivity.this, "Log in failed, please, try again",
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
