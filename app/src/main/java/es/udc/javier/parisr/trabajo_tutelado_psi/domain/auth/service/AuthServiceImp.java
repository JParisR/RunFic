package es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.service;

import es.udc.javier.parisr.trabajo_tutelado_psi.data.auth.AuthDataSourceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.datasource.AuthDataSource;
import es.udc.javier.parisr.trabajo_tutelado_psi.util.Result;

public class AuthServiceImp implements AuthService {

    AuthDataSource authDataSource = new AuthDataSourceImp();
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    final short MIN_LENGTH = 6;

    @Override
    public Result signIn(String email, String password) {

        if (!email.matches(emailPattern)) {
            return Result.EMAIL_ERROR;
        }
        else if (password.length() < MIN_LENGTH) {
            return Result.PWD_ERROR;
        }
        else {
            if (authDataSource.signInFirebase(email, password)) {
                return Result.SUCCESS;
            }
            else {
                return Result.FAILURE;
            }
        }
    }

    @Override
    public Result logIn(String email, String password) {

        if (!email.matches(emailPattern)) {
            return Result.EMAIL_ERROR;
        }
        else if (password.length() < MIN_LENGTH) {
            return Result.PWD_ERROR;
        }
        else {
            if (authDataSource.logInFirebase(email, password)) {
                return Result.SUCCESS;
            }
            else {
                return Result.FAILURE;
            }
        }
    }

}
