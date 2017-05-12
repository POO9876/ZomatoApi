
package com.example.arjun_mu.zomatoapi.GeoApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeoCode {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("popularity")
    @Expose
    private Popularity popularity;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("nearby_restaurants")
    @Expose
    private List<NearbyRestaurant> nearbyRestaurants = null;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<NearbyRestaurant> getNearbyRestaurants() {
        return nearbyRestaurants;
    }

    public void setNearbyRestaurants(List<NearbyRestaurant> nearbyRestaurants) {
        this.nearbyRestaurants = nearbyRestaurants;
    }

}
