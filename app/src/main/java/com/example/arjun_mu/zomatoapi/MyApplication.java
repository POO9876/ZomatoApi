package com.example.arjun_mu.zomatoapi;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by arjun27 on 5/20/2017.
 */
public class MyApplication extends Application {

    public static MyApplication singleton = null;
    private static final String TAG="MyApplication";

    @Override
    public void onCreate() {
        singleton=this;

        super.onCreate();
    }

    public static MyApplication getInstance(Context context) {
        return singleton;
    }


    public void store(Context context) {

        SharedPreferences.Editor editor = context.getSharedPreferences(getPackageName(), MODE_PRIVATE).edit();
        editor.putString("name", "Elena");
        editor.putInt("idName", 12);
        Log.d(TAG, "store() called");
        editor.commit();

    }


    public void read(Context context){
        SharedPreferences prefs = context.getSharedPreferences(getPackageName(), MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        if (restoredText != null) {
            String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
            int idName = prefs.getInt("idName", 0); //0 is the default value.
            Log.d(TAG, "read() called"+name);
        }
    }
}
