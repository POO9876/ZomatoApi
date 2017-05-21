package com.example.arjun_mu.zomatoapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
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
    public void onBindViewHolder(final RestaurantAdapter.Myholder holder, int position) {

        NearbyRestaurant nearbyRestaurant = moviesList.get(position);
        final Restaurant restaurant = nearbyRestaurant.getRestaurant();

        holder.name.setText(restaurant.getName());
        final ImageLoader imageLoader = VolleySingleton.getInstance(context).getImageLoader();

//        imageLoader.get(restaurant.getFeaturedImage(), ImageLoader.getImageListener( holder.networkImageView,
//                R.mipmap.ic_launcher, android.R.drawable
//                        .ic_dialog_alert));

        imageLoader.get(restaurant.getFeaturedImage(), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                if (response != null) {
                    Bitmap bitmap = response.getBitmap();
                    if (bitmap != null) {
                        holder.progressBar.setVisibility(View.GONE);

                        holder.networkImageView.setImageUrl(restaurant.getFeaturedImage(), imageLoader);
                    }

                }
                else {
                    holder.progressBar.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        public TextView name, lat, lon;
        public NetworkImageView networkImageView;
        public ProgressBar progressBar;


        public Myholder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.resname);
            networkImageView = (NetworkImageView) itemView.findViewById(R.id.imageView);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progressBar);

        }
    }
}
