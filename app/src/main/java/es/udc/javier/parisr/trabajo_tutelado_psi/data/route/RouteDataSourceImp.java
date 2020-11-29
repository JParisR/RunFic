package es.udc.javier.parisr.trabajo_tutelado_psi.data.route;

import java.util.ArrayList;
import java.util.List;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource.RouteDataSource;

public class RouteDataSourceImp implements RouteDataSource {

    @Override
    public List<Route> searchRoutes() {
        Route item = new Route("Ruta 1","Ruta 'A Coruña'","Esta ruta discurre por..");
        Route item2 = new Route("Ruta 2","Ruta 'O Burgo'","Descripción ruta 2");
        Route item3 = new Route("Ruta 3","Ruta 'Cambre'","Descripción ruta 3...");
        List<Route> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item2);
        itemList.add(item3);
        return itemList;
    }
}
