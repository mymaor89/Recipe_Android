package com.example.user.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("EXTRA_MESSAGE");
        Resources res = getResources();
        String[] ingredients;
        if (message.equals("cookie"))
            ingredients = res.getStringArray(R.array.ingerdients_Chocolate_Chip_Cookies_array);
        else
            ingredients = res.getStringArray(R.array.ingerdients_Creme_Brulee);
        final ListView listView = (ListView) findViewById(R.id.list);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, ingredients);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        final TextView tv = (TextView) findViewById(R.id.counter);
        tv.setText(listView.getCheckedItemCount()+
                "/"+listView.getCount());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(listView.getCheckedItemCount()+
                        "/"+listView.getCount());
                if(listView.getCount() == listView.getCheckedItemCount()){
                    for(int i=0; i<listView.getCount(); i++) {
                        listView.getChildAt(i).setBackgroundColor(Color.argb(125,56, 166, 101));
                    }
                } else{
                    for(int i=0; i<listView.getCount(); i++) {
                        listView.getChildAt(i).setBackgroundColor(Color.WHITE);
                    }
                }
            }
        });
    }
}
