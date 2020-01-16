package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {
    ImageButton btn_creme,btn_cookie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_creme = (ImageButton) findViewById(R.id.creme);
        btn_cookie = (ImageButton) findViewById(R.id.cookie);
        btn_creme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                String message = "creme";
                intent.putExtra("EXTRA_MESSAGE", message);
                startActivity(intent);
            }
    });
        btn_cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                String message = "cookie";
                intent.putExtra("EXTRA_MESSAGE", message);
                startActivity(intent);
            }
        });
    }
}
