
package com.example.arjun_mu.zomatoapi.GeoApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant {

    @SerializedName("R")
    @Expose
    private Restrant r;
    @SerializedName("apikey")
    @Expose
    private String apikey;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("location")
    @Expose
    private Location_ location;
    @SerializedName("switch_to_order_menu")
    @Expose
    private Integer switchToOrderMenu;
    @SerializedName("cuisines")
    @Expose
    private String cuisines;
    @SerializedName("average_cost_for_two")
    @Expose
    private Integer averageCostForTwo;
    @SerializedName("price_range")
    @Expose
    private Integer priceRange;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("offers")
    @Expose
    private List<Object> offers = null;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("user_rating")
    @Expose
    private UserRating userRating;
    @SerializedName("photos_url")
    @Expose
    private String photosUrl;
    @SerializedName("menu_url")
    @Expose
    private String menuUrl;
    @SerializedName("featured_image")
    @Expose
    private String featuredImage;
    @SerializedName("has_online_delivery")
    @Expose
    private Integer hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    @Expose
    private Integer isDeliveringNow;
    @SerializedName("deeplink")
    @Expose
    private String deeplink;
    @SerializedName("has_table_booking")
    @Expose
    private Integer hasTableBooking;
    @SerializedName("book_url")
    @Expose
    private String bookUrl;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @SerializedName("order_url")
    @Expose
    private String orderUrl;
    @SerializedName("order_deeplink")
    @Expose
    private String orderDeeplink;

    public Restrant getR() {
        return r;
    }

    public void setR(Restrant r) {
        this.r = r;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location_ getLocation() {
        return location;
    }

    public void setLocation(Location_ location) {
        this.location = location;
    }

    public Integer getSwitchToOrderMenu() {
        return switchToOrderMenu;
    }

    public void setSwitchToOrderMenu(Integer switchToOrderMenu) {
        this.switchToOrderMenu = switchToOrderMenu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public Integer getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public void setAverageCostForTwo(Integer averageCostForTwo) {
        this.averageCostForTwo = averageCostForTwo;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    public Integer getHasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    public void setHasOnlineDelivery(Integer hasOnlineDelivery) {
        this.hasOnlineDelivery = hasOnlineDelivery;
    }

    public Integer getIsDeliveringNow() {
        return isDeliveringNow;
    }

    public void setIsDeliveringNow(Integer isDeliveringNow) {
        this.isDeliveringNow = isDeliveringNow;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public Integer getHasTableBooking() {
        return hasTableBooking;
    }

    public void setHasTableBooking(Integer hasTableBooking) {
        this.hasTableBooking = hasTableBooking;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getOrderDeeplink() {
        return orderDeeplink;
    }

    public void setOrderDeeplink(String orderDeeplink) {
        this.orderDeeplink = orderDeeplink;
    }

}
