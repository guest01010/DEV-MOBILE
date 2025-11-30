package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class cercle extends AppCompatActivity {

    private double calcp(double radius) {
        return 2 * Math.PI * radius;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cercle);

        EditText et = findViewById(R.id.et);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            String text = et.getText().toString().trim();
            if (text.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Veuillez entrer un rayon", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                double radius = Double.parseDouble(text);
                double result = calcp(radius);
                Toast.makeText(getApplicationContext(), "Le périmètre de votre cercle est : " + result, Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException ex) {
                Toast.makeText(getApplicationContext(), "Entrée invalide", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
