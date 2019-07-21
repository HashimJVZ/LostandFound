package com.example.lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button lostbtn = findViewById(R.id.lostbtn);
        Button foundbtn = findViewById(R.id.foundbtn);

      lostbtn.setOnClickListener(new Button.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(LostActivity);
          }
      });

      foundbtn.setOnClickListener(new Button.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(FoundActivity);
          }
      });
    }
}
