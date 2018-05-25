package com.luindros.gsoncomplejo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Gson gson;

    private String JsonURL = "http://api.openweathermap.org/data/2.5/find?q=London,uk&appid=62c44155efb775337d698e0089a05319&units=metric";
    private RequestQueue requestQueue;
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        requestQueue = Volley.newRequestQueue(this);
        weather=new Weather();


        GsonBuilder builder=new GsonBuilder();
        builder.registerTypeAdapter(Weather.class, new Deserializer());
        gson=builder.create();

        requestWeather();
    }

    private void requestWeather() {

        JsonObjectRequest rq = new JsonObjectRequest(Request.Method.GET, JsonURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                weather=gson.fromJson(String.valueOf(response), Weather.class);
                Toast.makeText(MainActivity.this, "WeatherElements: "+weather.getCod()+
                        weather.getCountry()+weather.getDescription()+weather.getName(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(rq);
    }

}
