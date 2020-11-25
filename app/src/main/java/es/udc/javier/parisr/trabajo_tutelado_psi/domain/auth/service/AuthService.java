package es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.service;

public interface AuthService {

    int signIn(String email, String password);
    int logIn(String email, String password);
}
