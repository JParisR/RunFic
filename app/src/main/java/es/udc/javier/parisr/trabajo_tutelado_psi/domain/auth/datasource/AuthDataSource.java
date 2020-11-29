package es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.datasource;

public interface AuthDataSource {

    boolean signInFirebase(String email, String password);
    boolean logInFirebase(String email, String password);
}
