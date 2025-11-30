package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3); // layout XML contenant les 3 boutons

        Button btnPage1 = findViewById(R.id.btnPage1);
        Button btnPage2 = findViewById(R.id.btnPage2);
        Button btnPage3 = findViewById(R.id.btnPage3);

        // Redirection vers MainActivity
        btnPage1.setOnClickListener(v ->
                startActivity(new Intent(MainActivity3.this, MainActivity.class))
        );

        // Redirection vers MainActivity1
        btnPage2.setOnClickListener(v ->
                startActivity(new Intent(MainActivity3.this, MainActivity1.class))
        );

        // Redirection vers MainActivity2
        btnPage3.setOnClickListener(v ->
                startActivity(new Intent(MainActivity3.this, MainActivity2.class))
        );
    }
}
