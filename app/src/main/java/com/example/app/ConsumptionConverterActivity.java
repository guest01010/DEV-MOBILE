package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConsumptionConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumption);

        EditText et = findViewById(R.id.input);
        Button toL100 = findViewById(R.id.btnToL100);
        Button toMpg = findViewById(R.id.btnToMpg);
        TextView out = findViewById(R.id.output);

        toL100.setOnClickListener(v -> {
            String s = et.getText().toString().trim();
            if (s.isEmpty()) { out.setText("Entrée vide"); return; }
            try {
                double mpg = Double.parseDouble(s);
                double l100 = 235.214583 / mpg; // mpg(US) -> L/100km
                out.setText(String.format("%.2f L/100km", l100));
            } catch (NumberFormatException e) { out.setText("Entrée invalide"); }
        });

        toMpg.setOnClickListener(v -> {
            String s = et.getText().toString().trim();
            if (s.isEmpty()) { out.setText("Entrée vide"); return; }
            try {
                double l100 = Double.parseDouble(s);
                double mpg = 235.214583 / l100; // L/100km -> mpg(US)
                out.setText(String.format("%.2f mpg", mpg));
            } catch (NumberFormatException e) { out.setText("Entrée invalide"); }
        });
    }
}
