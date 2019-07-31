package com.example.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lostandfound.model.CardData;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CardData> list;
    FloatingActionButton floatingActionButton;
    CardAdapter cardAdapter;

    String district = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FirebaseApp.initializeApp(this);

        district = getIntent().getExtras().getString("district");

        recyclerView = findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, UploadActivity.class);
                intent.putExtra("district", district);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        recyclerView.setAdapter(null);
        cardAdapter = null;

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("lost")
                .whereEqualTo("district", district)
//                .orderBy("timestamp")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                    CardData cardData = new CardData();
                    cardData.setImage(queryDocumentSnapshots.getDocuments().get(i).getString("image"));
                    cardData.setTitle(queryDocumentSnapshots.getDocuments().get(i).getString("title"));
                    cardData.setDescription(queryDocumentSnapshots.getDocuments().get(i).getString("description"));

                    list.add(cardData);
                }

                cardAdapter = new CardAdapter(Main2Activity.this, list);
                recyclerView.setAdapter(cardAdapter);
            }
        });
    }
}
