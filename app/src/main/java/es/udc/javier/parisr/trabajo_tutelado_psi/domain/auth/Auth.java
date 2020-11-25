package es.udc.javier.parisr.trabajo_tutelado_psi.domain.auth;

public class Auth {

    private String email;
    private String password;

    public Auth(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
