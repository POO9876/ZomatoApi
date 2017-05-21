package com.example.arjun_mu.zomatoapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.arjun_mu.zomatoapi.CustomVolley.GsonRequest;
import com.example.arjun_mu.zomatoapi.GeoApi.GeoCode;
import com.example.arjun_mu.zomatoapi.GeoApi.Location_;
import com.example.arjun_mu.zomatoapi.GeoApi.NearbyRestaurant;
import com.example.arjun_mu.zomatoapi.GeoApi.Restaurant;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // Button btnShowLocation;

    private static final String TAG = "MainActivity";
    // GPSTracker class
    GPSTracker gps;
    RecyclerView recyclerView;

    List<NearbyRestaurant> nearbyRest;
    private RestaurantAdapter mAdapter;
    List<NearbyRestaurant> nearbyRestaurants;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //     btnShowLocation= (Button) findViewById(R.id.mybutton);

//        btnShowLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                // create class object
//                gps = new GPSTracker(MainActivity.this);
//
//                // check if GPS enabled
//                if(gps.canGetLocation()){
//
//                    double latitude = gps.getLatitude();
//                    double longitude = gps.getLongitude();
//
//                    // \n is for new line
//                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
//                }else{
//                    // can't get location
//                    // GPS or Network is not enabled
//                    // Ask user to enable GPS/network in settings
//                    gps.showSettingsAlert();
//                }
//
//            }
//        });


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                NearbyRestaurant nearbyRestaurant = nearbyRestaurants.get(position);
                Restaurant restaurant = nearbyRestaurant.getRestaurant();
                Toast.makeText(getApplicationContext(), restaurant.getName() + "", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        VolleyLog.DEBUG = true;


        final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, ApiConstant.GeoCode, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        //  Log.d(TAG, "onResponse: "+response.toString());

                        Gson gson = new Gson();
                        GeoCode geocode = gson.fromJson(response.toString(), GeoCode.class);

                        nearbyRestaurants = geocode.getNearbyRestaurants();

                        mAdapter = new RestaurantAdapter(nearbyRestaurants, getApplicationContext());

                        recyclerView.setHasFixedSize(true);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(mAdapter);


                        for (NearbyRestaurant nearbyRestaurant : nearbyRestaurants) {
                            Restaurant restaurant = nearbyRestaurant.getRestaurant();

                            String resid = restaurant.getId();
                            Location_ location = restaurant.getLocation();
                            Log.d(TAG, "onResponse: " + restaurant.getName() + " lat:" + location.getLatitude() + " long :" + location.getLongitude());
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                }

                )

        {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("user-key", "c8e75be8258f06990d42e533b812e5a5");
                return headers;
            }
        };

        // Access the RequestQueue through your singleton class.
      //  VolleySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

        customResponseObject();
    }

        private void customResponseObject() {

        GsonRequest gsonRequest = new GsonRequest(ApiConstant.GeoCode, GeoCode.class, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                // Handle response


                GeoCode geocode= (GeoCode) response;
                nearbyRestaurants =  geocode.getNearbyRestaurants();


                mAdapter = new RestaurantAdapter(nearbyRestaurants, getApplicationContext());

                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);


                for (NearbyRestaurant nearbyRestaurant : nearbyRestaurants) {
                    Restaurant restaurant = nearbyRestaurant.getRestaurant();

                    String resid = restaurant.getId();
                    Location_ location = restaurant.getLocation();
                    Log.d(TAG, "onResponse: " + restaurant.getName() + " lat:" + location.getLatitude() + " long :" + location.getLongitude());
                }
                Log.d(TAG, "onResponse: from my custom"+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
            }
        });
        // Add gson request to volley request queue.
        VolleySingleton.getInstance(this).addToRequestQueue(gsonRequest);
    }


}



