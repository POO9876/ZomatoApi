package com.example.arjun_mu.zomatoapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.arjun_mu.zomatoapi.GeoApi.NearbyRestaurant;
import com.example.arjun_mu.zomatoapi.GeoApi.Restaurant;

import java.util.List;

/**
 * Created by arjun_mu on 5/15/2017.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.Myholder> {


    Context context;
    private List<NearbyRestaurant> moviesList;

    public RestaurantAdapter(List<NearbyRestaurant> moviesList, Context c) {
        this.moviesList = moviesList;
        this.context = c;
    }

    @Override
    public RestaurantAdapter.Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_row, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.Myholder holder, int position) {

        NearbyRestaurant nearbyRestaurant = moviesList.get(position);
        Restaurant restaurant = nearbyRestaurant.getRestaurant();

        holder.name.setText(restaurant.getName());
        ImageLoader imageLoader = VolleySingleton.getInstance(context).getImageLoader();
        holder.networkImageView.setImageUrl(restaurant.getFeaturedImage(), imageLoader);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        public TextView name, lat, lon;
        public NetworkImageView networkImageView;


        public Myholder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.resname);
            networkImageView = (NetworkImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
