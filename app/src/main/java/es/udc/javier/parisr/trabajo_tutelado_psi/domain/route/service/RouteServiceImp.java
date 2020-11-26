package es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.service;

import es.udc.javier.parisr.trabajo_tutelado_psi.data.route.RouteDataSourceImp;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource.RouteDataSource;
import es.udc.javier.parisr.trabajo_tutelado_psi.module.main.MyAdapter;

public class RouteServiceImp implements RouteService {

    private RouteDataSource mDatasource = new RouteDataSourceImp();

    @Override
    public MyAdapter searchRoutes() {

        return mDatasource.searchRoutes();
    }
}
