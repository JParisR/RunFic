package es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth.service;

import es.udc.javier.parisr.trabajo_tutelado_psi.util.Result;

public interface AuthService {

    Result signIn(String email, String password);
    Result logIn(String email, String password);

}
