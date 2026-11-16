package com.maktabati.app;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;

public class Pending {
    private static final String PREF = "pending";
    private static final String KEY = "items";

    public static synchronized void add(Context c, String title, String text) {
        try {
            SharedPreferences sp = c.getSharedPreferences(PREF, Context.MODE_PRIVATE);
            JSONArray a = new JSONArray(sp.getString(KEY, "[]"));
            JSONObject o = new JSONObject();
            o.put("title", title == null ? "" : title);
            o.put("text", text);
            a.put(o);
            sp.edit().putString(KEY, a.toString()).apply();
        } catch (Exception e) { }
    }

    public static synchronized String take(Context c) {
        SharedPreferences sp = c.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        String s = sp.getString(KEY, "[]");
        sp.edit().putString(KEY, "[]").apply();
        return s;
    }
}
