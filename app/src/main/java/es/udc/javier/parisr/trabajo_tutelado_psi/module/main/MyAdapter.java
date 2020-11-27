package es.udc.javier.parisr.trabajo_tutelado_psi.module.main;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URI;
import java.util.List;

import es.udc.javier.parisr.trabajo_tutelado_psi.R;
import es.udc.javier.parisr.trabajo_tutelado_psi.domain.route.Route;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Route> mData;
    private ItemClickListener mClickListener;

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView tv_image;
        TextView tv_title;
        TextView tv_subtitle;
        TextView tv_description;

        ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_subtitle = itemView.findViewById(R.id.tv_subtitle);
            tv_image = (ImageView) itemView.findViewById(R.id.tv_image);
            tv_description = itemView.findViewById(R.id.tv_description);
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
        holder.tv_description.setText(route.getRoute_description());
        Picasso.with(holder.tv_image.getContext())
                .load(route.getImageURI())
                .into(holder.tv_image);
        viewConfigurations(holder);

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

    public void viewConfigurations(ViewHolder viewHolder){
        String prefer = "preferences";
        Context context = viewHolder.tv_description.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(prefer,context.MODE_PRIVATE);
        Boolean viewdesc= sharedPreferences.getBoolean("viewdesc",true);
        Boolean viewsub= sharedPreferences.getBoolean("viewsubtitle",false);

        if(viewdesc) viewHolder.tv_description.setVisibility(View.VISIBLE);
        else viewHolder.tv_description.setVisibility(View.INVISIBLE);

        if(viewsub) viewHolder.tv_subtitle.setVisibility(View.VISIBLE);
        else viewHolder.tv_subtitle.setVisibility(View.INVISIBLE);
    }
}