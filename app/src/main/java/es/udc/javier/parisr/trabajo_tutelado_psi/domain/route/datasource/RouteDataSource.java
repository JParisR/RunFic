package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.module.ui.list.RouteAdapter;

public interface RouteDataSource {
    RouteAdapter searchRoutes();
    RouteAdapter addRoute(Route route);
    void evaluateRoute(Route route,float puntuacion);
    RouteAdapter searchRoutes(String s);
}
