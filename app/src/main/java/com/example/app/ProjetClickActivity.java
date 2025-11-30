package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProjetClickActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projet_click);

        EditText et = findViewById(R.id.et);
        Button btn = findViewById(R.id.btnClick);

        btn.setOnClickListener(v -> {

            btn.setText(et.getText().toString() );
        });
    }
}
