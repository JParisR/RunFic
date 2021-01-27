package es.udc.javier.parisr.trabajo_tutelado_psi.util;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.util.exceptions.InputValidationException;

public final class PropertyValidator {
    static int MAX_LENGTH_TITLE = 30;

    public static void validateTitle(String title) throws InputValidationException {
        if(title.length()==0) {throw new InputValidationException("title","title too short");}
        if(title.length()>MAX_LENGTH_TITLE) {throw new InputValidationException("title","title too long");}
    }

    public static void validateDescription(String title) throws InputValidationException {
        if(title.length()==0) {throw new InputValidationException("description","title too short");}
    }

    public static void validatesubTitle(String title) throws InputValidationException {
        if(title.length()==0) {throw new InputValidationException("subname","subtitle too short");}
        if(title.length()>MAX_LENGTH_TITLE) {throw new InputValidationException("subname","subtitle too long");}
    }

    public static boolean urlValidator(String url)
    {
        /*validación de url*/
        try {
            new URL(url).toURI();
            return true;
        }
        catch (URISyntaxException exception) {
            return false;
        }
        catch (MalformedURLException exception) {
            return false;
        }
    }

    public static void validateImage(String title) throws InputValidationException {
        if(title.length()==0) {throw new InputValidationException("imageURI","image too short");}
        if(!urlValidator(title)) {throw new InputValidationException("imageURI","image URL is incorrect");}
    }

    public static void validateRoute(Route route) throws InputValidationException {
        validateTitle(route.getRoute_name());
        validateDescription(route.getRoute_description());
        validateImage(route.getImageURI());
        validatesubTitle(route.getRoute_subname());
    }
}
