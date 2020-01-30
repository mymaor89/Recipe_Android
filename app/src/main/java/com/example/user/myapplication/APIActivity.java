package com.example.user.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APIActivity extends AppCompatActivity {
    private static final String YOUR_APP_ID ="bc5b863d" ;
    private static final String YOUR_APP_KEY = "e655dc3eb75debe4b41ea210450085da";
    TextView textView;
    Button btn;
    EditText edt;
    String query;
    String url;
    ImageView imageView;
    //DOCS : https://developer.edamam.com/edamam-docs-recipe-api

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        textView = (TextView) findViewById(R.id.tv_result);
        btn = (Button) findViewById(R.id.btn_request);
        edt = (EditText) findViewById(R.id.et_params);
        imageView = (ImageView) findViewById(R.id.imageView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }
    private void sendRequest(){
        RequestQueue queue = Volley.newRequestQueue(this);
        query = edt.getText().toString();
        url= "https://api.edamam.com/search?q="+query+"&app_id="+YOUR_APP_ID+"&app_key="+YOUR_APP_KEY+"&from=0&to=3&calories=591-722&health=alcohol-free";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        
                        try {
                            JSONObject jObject = new JSONObject(response);
                            JSONArray  jsonArray  = jObject.getJSONArray("hits");
                            jObject = jsonArray.getJSONObject(0);
                            jObject = jObject.getJSONObject("recipe");
                            String title = jObject.getString("label");
                            textView.setText(title);
                            String image_URL = jObject.getString("image");
                            Picasso.with(getApplicationContext()).load(image_URL).into(imageView);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
