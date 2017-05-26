package com.example.arjun_mu.zomatoapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.arjun_mu.zomatoapi.CustomVolley.GsonRequest;
import com.example.arjun_mu.zomatoapi.GeoClass.GeoCode;
import com.example.arjun_mu.zomatoapi.GeoClass.Location_;
import com.example.arjun_mu.zomatoapi.GeoClass.NearbyRestaurant;
import com.example.arjun_mu.zomatoapi.GeoClass.Restaurant;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // Button btnShowLocation;

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;

    List<NearbyRestaurant> nearbyRest;
    List<NearbyRestaurant> nearbyRestaurants;
    private RestaurantAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPref.init(getApplicationContext());
        // SharedPref.write(SharedPref.NAME, "XXXX");//save string in shared preference.
        // SharedPref.write(SharedPref.AGE, "25");//save int in shared preference.

        // String name = SharedPref.read(SharedPref.NAME, null);//read string in shared preference.
        // String age = SharedPref.read(SharedPref.AGE, "0");//read int in shared preference.
//        SharedPref.write(SharedPref.IS_SELECT, true);//save boolean in shared preference.
//        boolean isSelect = SharedPref.read(SharedPref.IS_SELECT, false);//read boolean in shared preference.


        SharedPreferences sharedPreferences = SharedPref.getmSharedPref();
        if (!sharedPreferences.contains(SharedPref.IS_SELECT)) {
            SharedPref.write(SharedPref.IS_SELECT, "first");
        } else {
            SharedPref.write(SharedPref.IS_SELECT, "second");

        }

        String name = SharedPref.read(SharedPref.IS_SELECT, null);
        Log.d(TAG, "onCreate: " + name);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                NearbyRestaurant nearbyRestaurant = nearbyRestaurants.get(position);
                Restaurant restaurant = nearbyRestaurant.getRestaurant();
                Location_ location = restaurant.getLocation();
                String lat = location.getLatitude();
                String log = location.getLongitude();

                Intent intent=new Intent(getApplicationContext(),MapActivity.class);
                intent.putExtra("lat",lat);
                intent.putExtra("log",log);
                startActivity(intent);

               // Toast.makeText(getApplicationContext(), restaurant.getName() + "", Toast.LENGTH_SHORT).show();

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


                GeoCode geocode = (GeoCode) response;
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
                Log.d(TAG, "onResponse: from my custom" + response);

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



