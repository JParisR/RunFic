package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route;

import java.util.List;

public class Routes {
   // @SerializedName("count")
    private int count;

    //@SerializedName("routes")
    private List<Route> routes;

    public Routes(int count,
                   List<Route> routes) {

        this.count = count;
        this.routes = routes;
    }

    public int getCount() {

        return count;
    }

    public List<Route> getRoutes() {

        return routes;
    }
}
