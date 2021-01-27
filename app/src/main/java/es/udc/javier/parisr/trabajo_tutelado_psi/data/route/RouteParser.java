package es.udc.javier.parisr.trabajo_tutelado_psi.data.route;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;

public class RouteParser {

    public static Route toRoute(DataSnapshot ds){
        String ID;String name="default",subname="default",description="default",imageURI="default";

        ID=ds.getKey().toString();
        if(ds.child("name").getValue()!=null)
            name = ds.child("name").getValue().toString();
        if(ds.child("subname").getValue()!=null)
            subname = ds.child("subname").getValue().toString();
        if(ds.child("description").getValue()!=null)
            description = ds.child("description").getValue().toString();
        if(ds.child("imageURI").getValue()!=null)
            imageURI = ds.child("imageURI").getValue().toString();
        if(ds.child("coordenadas").getValue()!=null)
            coordenadas = ds.child("coordenadas").getValue().toString();

        return new Route(ID,name, subname, description, imageURI);
    }

    public static List<Route> toListRoutes(DataSnapshot dataSnapshot){
        List <Route> itemList =new ArrayList<>();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Route route = toRoute(ds);
            itemList.add(route);
        }
        return itemList;
    }
}
