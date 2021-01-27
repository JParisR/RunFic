package es.udc.javier.parisr.trabajo_tutelado_psi.util.exceptions;

public class InputValidationException extends Exception {

    private String attribute;
    private String error;

    public InputValidationException(String attribute, String error) {
        this.attribute = attribute;
        this.error = error;
    }

    public InputValidationException(){
        this.error="error";
    }

    public String getAttribute() {
        return attribute;
    }

    public String getError() {
        return error;
    }
}
