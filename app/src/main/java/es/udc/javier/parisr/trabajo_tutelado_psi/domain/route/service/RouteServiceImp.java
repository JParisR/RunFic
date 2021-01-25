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

    @Override
    public RouteAdapter searchRoutes(String s) {
        return mDatasource.searchRoutes(s);
    }


}
