package es.udc.javier.parisr.trabajo_tutelado_psi.data.route;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.datasource.RouteDataSource;
import es.udc.javier.parisr.trabajo_tutelado_psi.module.main.MyAdapter;

public class RouteDataSourceImp implements RouteDataSource {

    String TAG = "RouteDataSource";
    List<Route> itemList = new ArrayList<>();
    MyAdapter adapter = new MyAdapter(itemList);

    @Override
    public MyAdapter searchRoutes() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("route").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                itemList.clear();
                String name = dataSnapshot.child("name").getValue().toString();
                String subname = dataSnapshot.child("subname").getValue().toString();
                String description = dataSnapshot.child("description").getValue().toString();
                Route item = new Route(name,subname,description);
                itemList.add(item);
                adapter.notifyDataSetChanged();
                Log.d(TAG, "Value is: " + name);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        return  adapter;
    }
}
