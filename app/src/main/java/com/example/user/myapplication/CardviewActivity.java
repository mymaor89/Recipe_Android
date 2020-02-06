package com.example.user.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CardviewActivity extends BaseActivity {

    // Recycler View object
    RecyclerView recyclerView;

    // Array list for recycler view data source
    ArrayList<String> source;

    // Layout Manager
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    // adapter class object
    Adapter adapter;

    // Linear Layout Manager
    LinearLayoutManager verticalLayout;
    RelativeLayout rl;
    View ChildView;
    int RecyclerViewItemPosition;
    ImageView imgview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        imgview = (ImageView) findViewById(R.id.background_image);
        rl = (RelativeLayout) findViewById(R.id.relativelayout);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("EXTRA_MESSAGE");

        // initialisation with id's
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());

        // Set LayoutManager on Recycler View
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList(message);
        changeBackground(message);
        // calling constructor of adapter
        // with source list as a parameter
        adapter = new Adapter(source);

        // Set Horizontal Layout Manager
        // for Recycler view
        verticalLayout = new LinearLayoutManager(CardviewActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(verticalLayout);

        // Set adapter on recycler view
        recyclerView.setAdapter(adapter);


    }

    private void changeBackground(String message) {
        Resources res = getResources();
        if (message.equals("cookie")){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                imgview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cookie));

                }
                else{
                imgview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cookie) );
            }

        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                imgview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.creme));
            }else{
                imgview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.creme) );
            }
        }
    }

    // Function to add items in RecyclerView.
    public void AddItemsToRecyclerViewArrayList(String message) {
        // Adding items to ArrayList
        Resources res = getResources();
        String[] ingredients;
        if (message.equals("cookie"))
             ingredients = res.getStringArray(R.array.steps_Cookie);
        else
            ingredients = res.getStringArray(R.array.steps_Creme_Brulee_array);
        source = new ArrayList<String>(Arrays.asList(ingredients));

    }

}