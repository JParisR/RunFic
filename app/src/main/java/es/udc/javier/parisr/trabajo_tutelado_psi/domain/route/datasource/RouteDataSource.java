package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource;

import java.util.List;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;

public interface RouteDataSource {
    List<Route> searchRoutes();
}
