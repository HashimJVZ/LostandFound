package com.example.lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      Button lostbtn, foundbtn;

      lostbtn = findViewById(R.id.lostbtn);
      lostbtn.setOnClickListener(new Button.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, LostActivity.class);
              startActivity(intent);
          }
      });

      foundbtn = findViewById(R.id.foundbtn);
      foundbtn.setOnClickListener(new Button.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, FoundActivity.class);
              startActivity(intent);
          }
      });
    }
}
