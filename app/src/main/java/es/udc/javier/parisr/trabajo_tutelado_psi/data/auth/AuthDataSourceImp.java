package es.udc.javier.parisr.trabajo_tutelado_psi.data.auth;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.datasource.AuthDataSource;

public class AuthDataSourceImp implements AuthDataSource {

    private FirebaseAuth mAuth;
    private static final String TAG = "AuthDataSource";

    @Override
    public boolean signInFirebase(String email, String password) {

        mAuth = FirebaseAuth.getInstance();

        Task task = mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "SignInUserWithEmail:success");
                        } else {
                            Log.w(TAG, "SignInUserWithEmail:failure", task.getException());
                        }
                    }
                });
        
        while(!task.isComplete()){
        }

        return task.isSuccessful();
    }

    @Override
    public boolean logInFirebase(String email, String password) {

        mAuth = FirebaseAuth.getInstance();

        Task task = mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "LogInUserWithEmail:success");
                        } else {
                            Log.w(TAG, "LogInUserWithEmail:failure", task.getException());
                        }
                    }
                });

        while(!task.isComplete()){
        }

        return task.isSuccessful();
    }

}
