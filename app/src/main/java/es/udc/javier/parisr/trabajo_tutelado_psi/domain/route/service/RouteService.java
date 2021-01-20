package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.module.ui.list.RouteAdapter;

public interface RouteService {

    RouteAdapter searchRoutes();
    RouteAdapter addRoute(Route route);
}
