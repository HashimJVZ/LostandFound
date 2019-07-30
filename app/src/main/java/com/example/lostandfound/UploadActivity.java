package com.example.lostandfound;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lostandfound.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UploadActivity extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    EditText editText_image, editText_title, editText_description;
    Button button;
    String district="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        district = getIntent().getExtras().getString("district");

        editText_image = findViewById(R.id.newimage);
        editText_title = findViewById(R.id.newtitle);
        editText_description = findViewById(R.id.newdescription);
        button = findViewById(R.id.donebtn);

        firebaseFirestore = FirebaseFirestore.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map map = new HashMap();

                map.put("image", editText_image.getText().toString());
                map.put("title", editText_title.getText().toString());
                map.put("description", editText_description.getText().toString());
                map.put("district", district);
                map.put("timestamp", System.currentTimeMillis());

                firebaseFirestore.collection("lost").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        finish();
                    }
                });
            }
        });
    }
}
