package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service;

import es.udc.javier.parisr.trabajo_tutelado_psi.data.route.RouteDataSourceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource.RouteDataSource;
import es.udc.javier.parisr.trabajo_tutelado_psi.module.ui.list.RouteAdapter;

public class RouteServiceImp implements RouteService {


    private RouteDataSource mDatasource = new RouteDataSourceImp();

    @Override
    public RouteAdapter searchRoutes() {
        return mDatasource.searchRoutes();
    }
    @Override
    public RouteAdapter addRoute(Route route){
        return mDatasource.addRoute(route);
    }

<<<<<<< HEAD
    public void evaluateRoute(Route route, float puntuacion){
        mDatasource.evaluateRoute(route,puntuacion);
    }
=======
    @Override
    public RouteAdapter searchRoutes(String s) {
        return mDatasource.searchRoutes(s);
    }


>>>>>>> 2ff36f40597bad88efaab139d5f0e05985bb21c2
}
