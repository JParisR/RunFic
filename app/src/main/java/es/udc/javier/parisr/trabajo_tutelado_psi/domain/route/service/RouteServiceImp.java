package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service;

import es.udc.javier.parisr.trabajo_tutelado_psi.data.route.RouteDataSourceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource.RouteDataSource;
import es.udc.javier.parisr.trabajo_tutelado_psi.module.ui.list.RouteAdapter;

public class RouteServiceImp implements RouteService {

    private RouteDataSource mDatasource = new RouteDataSourceImp();

    @Override
    public RouteAdapter searchRoutes() {

        return mDatasource.searchRoutes();
    }
}
