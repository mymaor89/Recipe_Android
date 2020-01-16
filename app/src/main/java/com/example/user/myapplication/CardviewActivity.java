package com.example.user.myapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CardviewActivity extends AppCompatActivity {

    // Recycler View object
    RecyclerView recyclerView;

    // Array list for recycler view data source
    ArrayList<String> source;

    // Layout Manager
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    // adapter class object
    Adapter adapter;

    // Linear Layout Manager
    LinearLayoutManager HorizontalLayout;

    View ChildView;
    int RecyclerViewItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

        // initialisation with id's
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());

        // Set LayoutManager on Recycler View
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        // calling constructor of adapter
        // with source list as a parameter
        adapter = new Adapter(source);

        // Set Horizontal Layout Manager
        // for Recycler view
        HorizontalLayout = new LinearLayoutManager(CardviewActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(HorizontalLayout);

        // Set adapter on recycler view
        recyclerView.setAdapter(adapter);
    }

    // Function to add items in RecyclerView.
    public void AddItemsToRecyclerViewArrayList() {
        // Adding items to ArrayList
        Resources res = getResources();
        String[] ingredients;
        //if (message.equals("cookie"))
         ingredients = res.getStringArray(R.array.steps_Creme_Brulee_array);
       // else
       //     ingredients = res.getStringArray(R.array.ingerdients_Creme_Brulee);
        source = new ArrayList<String>(Arrays.asList(ingredients));

    }
}