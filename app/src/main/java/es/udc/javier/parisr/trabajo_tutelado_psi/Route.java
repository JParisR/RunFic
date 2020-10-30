package es.udc.javier.parisr.trabajo_tutelado_psi;

import java.io.Serializable;

public class Route implements Serializable {

    private String route_name;
    private String route_subname;
    private String route_description;

    public Route(String route_name, String route_subname, String route_description) {
        this.route_name = route_name;
        this.route_subname = route_subname;
        this.route_description = route_description;
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
