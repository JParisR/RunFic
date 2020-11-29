package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service;

import java.util.List;

import es.udc.javier.parisr.trabajo_tutelado_psi.data.route.RouteDataSourceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource.RouteDataSource;

public class RouteServiceImp implements RouteService {

    private RouteDataSource mDatasource = new RouteDataSourceImp();

    @Override
    public List<Route> searchRoutes() {

        return mDatasource.searchRoutes();
    }
}
