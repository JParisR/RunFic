package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Route implements Serializable {

    private String ID;
    private Map<String,Float> califications=new HashMap<>();
    private String route_name;
    private String route_subname;
    private String route_description;
    private String imageURI;
    private String coordenadas;

    public Route(String route_name, String route_subname, String route_description, String imageURI, String coordenadas) {
        this.route_name = route_name;
        this.route_subname = route_subname;
        this.route_description = route_description;
        this.imageURI=imageURI;
        this.coordenadas = coordenadas;

    }

    public Map<String,Float> getCalifications() {
        return califications;
    }

    public void addCalification(String login,Float calification){
        this.califications.put(login,calification);
    }
    public void setCalifications(Map<String,Float> califications) {
        this.califications = califications;
    }

    public Route(String route_name, String route_subname, String route_description,String coordenadas) {
        this.route_name = route_name;
        this.route_subname = route_subname;
        this.route_description = route_description;
        this.imageURI="https://media.quincemil.com/imagenes/2019/09/19181814/Torre-de-Hercules-aerea-640x360.jpg";
        this.coordenadas = coordenadas;
    }

    public Route(String ID, String route_name, String route_subname, String route_description, String imageURI) {
        this.ID=ID;
        this.route_name = route_name;
        this.route_subname = route_subname;
        this.route_description = route_description;
        this.imageURI = imageURI;
    }

    public boolean canScore(Route route, String login){
        return !(route.getCalifications().containsKey(login));
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public String getRoute_subname() {
        return route_subname;
    }

    public void setRoute_subname(String route_subname) {
        this.route_subname = route_subname;
    }

    public String getRoute_description() {
        return route_description;
    }

    public void setRoute_description(String route_description) {
        this.route_description = route_description;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setC(String coordenadas) {
        this.coordenadas = coordenadas;
    }
}
