package main.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class Prefs {
    public static final String  PREF_ACCESS_TOKEN = "PREF_ACCESS_TOKEN";
    private static SharedPreferences sharedPreferences;
    private static Prefs prefs;


    public static Prefs loadPrefs(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        }
        if (prefs == null)
            prefs = new Prefs();
        return prefs;
    }
    public void saveString(String key,String value){
        sharedPreferences.edit().putString(key, value).apply();
    }
    public String getString(String key,String defaultValue){
        return sharedPreferences.getString(key, defaultValue);
    }
}