package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route;

import java.io.Serializable;

public class Route implements Serializable {

    private String route_name;
    private String route_subname;
    private String route_description;
    private String imageURI;

    public Route(String route_name, String route_subname, String route_description, String imageURI) {
        this.route_name = route_name;
        this.route_subname = route_subname;
        this.route_description = route_description;
        this.imageURI=imageURI;

    }



    public Route(String route_name, String route_subname, String route_description) {
        this.route_name = route_name;
        this.route_subname = route_subname;
        this.route_description = route_description;
        this.imageURI="https://media.quincemil.com/imagenes/2019/09/19181814/Torre-de-Hercules-aerea-640x360.jpg";
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
}