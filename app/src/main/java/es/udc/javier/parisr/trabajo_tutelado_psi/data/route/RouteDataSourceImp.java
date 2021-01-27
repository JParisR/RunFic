package es.udc.javier.parisr.trabajo_tutelado_psi.data.route;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource.RouteDataSource;
import es.udc.javier.parisr.trabajo_tutelado_psi.module.ui.list.RouteAdapter;

public class RouteDataSourceImp implements RouteDataSource {

    String login;
    String TAG = "RouteDataSource";
    List<Route> itemList = new ArrayList<>();
    RouteAdapter adapter = new RouteAdapter(itemList);
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    @Override
    public RouteAdapter searchRoutes() {

        mDatabase.child("routes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                itemList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Route item=RouteParser.toRoute(ds);
                    itemList.add(item);
                    adapter.notifyDataSetChanged();
                    Log.d(TAG, "Value is: " + item.getRoute_name());
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        return  adapter;
    }

    @Override
    public RouteAdapter addRoute(Route route) {
        Map<String,Object> routeadd= new HashMap<>();
        routeadd.put("name",route.getRoute_name());
        routeadd.put("description",route.getRoute_description());
        routeadd.put("subname",route.getRoute_subname());
        routeadd.put("imageURI",route.getImageURI());

        route.setID(mDatabase.child("routes").push().getKey().toString());
        mDatabase.child("routes").push().setValue(routeadd);

        return adapter;
    }

    @Override
    public void evaluateRoute(Route route,float puntuacion){
        String login = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        route.getCalifications().put(login,puntuacion);
        route.setCalifications(route.getCalifications());
        if (route.canScore(route,login)) {
            mDatabase.child("routes").child(route.getID()).child("califications").push().setValue(route.getCalifications());
        }
    }
}
