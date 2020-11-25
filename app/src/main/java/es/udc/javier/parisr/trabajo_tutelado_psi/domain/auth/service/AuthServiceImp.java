package es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.service;

import es.udc.javier.parisr.trabajo_tutelado_psi.data.auth.AuthDataSourceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.datasource.AuthDataSource;

public class AuthServiceImp implements AuthService{
    AuthDataSource authDataSource = new AuthDataSourceImp();
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    public int signIn(String email, String password) {

        final short MIN_LENGTH = 6;

        if (!email.matches(emailPattern)){
            return 1;
        }
        else if(password.length() < MIN_LENGTH){
            return 2;
        }else {
            if(authDataSource.signInFirebase(email, password)) {
                return 0;
            }else{
                return 3;
            }
        }
    }

    @Override
    public int logIn(String email, String password) {
        final short MIN_LENGTH = 6;

        if (!email.matches(emailPattern)){
            return 1;
        }
        else if(password.length() < MIN_LENGTH){
            return 2;
        }else {
            if(authDataSource.logInFirebase(email, password)) {
                return 0;
            }else{
                return 3;
            }
        }
    }
}
