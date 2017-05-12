
package com.example.arjun_mu.zomatoapi.GeoApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Popularity {

    @SerializedName("popularity")
    @Expose
    private String popularity;
    @SerializedName("nightlife_index")
    @Expose
    private String nightlifeIndex;
    @SerializedName("nearby_res")
    @Expose
    private List<String> nearbyRes = null;
    @SerializedName("top_cuisines")
    @Expose
    private List<String> topCuisines = null;
    @SerializedName("popularity_res")
    @Expose
    private String popularityRes;
    @SerializedName("nightlife_res")
    @Expose
    private String nightlifeRes;
    @SerializedName("subzone")
    @Expose
    private String subzone;
    @SerializedName("subzone_id")
    @Expose
    private Integer subzoneId;
    @SerializedName("city")
    @Expose
    private String city;

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getNightlifeIndex() {
        return nightlifeIndex;
    }

    public void setNightlifeIndex(String nightlifeIndex) {
        this.nightlifeIndex = nightlifeIndex;
    }

    public List<String> getNearbyRes() {
        return nearbyRes;
    }

    public void setNearbyRes(List<String> nearbyRes) {
        this.nearbyRes = nearbyRes;
    }

    public List<String> getTopCuisines() {
        return topCuisines;
    }

    public void setTopCuisines(List<String> topCuisines) {
        this.topCuisines = topCuisines;
    }

    public String getPopularityRes() {
        return popularityRes;
    }

    public void setPopularityRes(String popularityRes) {
        this.popularityRes = popularityRes;
    }

    public String getNightlifeRes() {
        return nightlifeRes;
    }

    public void setNightlifeRes(String nightlifeRes) {
        this.nightlifeRes = nightlifeRes;
    }

    public String getSubzone() {
        return subzone;
    }

    public void setSubzone(String subzone) {
        this.subzone = subzone;
    }

    public Integer getSubzoneId() {
        return subzoneId;
    }

    public void setSubzoneId(Integer subzoneId) {
        this.subzoneId = subzoneId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
