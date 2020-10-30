package es.udc.javier.parisr.trabajo_tutelado_psi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Route> mData;
    private ItemClickListener mClickListener;

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_title;
        TextView tv_subtitle;

        ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_subtitle = itemView.findViewById(R.id.tv_subtitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    //Constructor del adaptador
    public MyAdapter(List<Route> data) {
        this.mData = data;
    }

    //Infla el layout
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.route_list, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Route route = mData.get(position);
        holder.tv_title.setText(route.getRoute_name());
        holder.tv_subtitle.setText(route.getRoute_subname());
    }

    //Numero total de items
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //Obtener el item de la posicion
    Route getItem(int id) {
        return mData.get(id);
    }

    //Captura los clicks en los items
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // Interfaz para la MainActivity
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}