package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView  tv_heading;
    ImageView imageView;
    Button btn_ingredients;
    Button btn_steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("EXTRA_MESSAGE");
        btn_ingredients = (Button) findViewById(R.id.btn_ingredients);
        btn_steps = (Button) findViewById(R.id.btn_steps);
        if (message.equals("cookie")){
            tv_heading = (TextView) findViewById(R.id.tv_Heading);
            tv_heading.setText(R.string.Heading_Chocolate_Chip_Cookies);
            imageView = (ImageView) findViewById(R.id.image_view);
            imageView.setImageResource(R.drawable.cookie);
        }
        btn_ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ListActivity.class);
                i.putExtra("EXTRA_MESSAGE", message);
                startActivity(i);
            }
        });
        btn_steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CardviewActivity.class);
                i.putExtra("EXTRA_MESSAGE", message);
                startActivity(i);
            }
        });
    }
}
