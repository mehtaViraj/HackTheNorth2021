package com.company.stockclock;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beust.klaxon.Klaxon;

import java.io.StringReader;
import java.util.ArrayList;

import static com.beust.klaxon.Klaxon.*;

public class httpRequests {

    public void requests(Context context,String path, ArrayList<String> keys, ArrayList<String> values)
    {
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        String url = "https://canvas-antler-326322.uc.r.appspot.com/"+path;

        String final_path = "=?";

        for (int i = 0; i<keys.size(); i++)
        {
            final_path = final_path+keys.get(i)+"="+values.get(i)+"&";
        }

        url = url+final_path;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        reJson = Klaxon.parse(new StringReader(response));

                    }
                })
    }

}
