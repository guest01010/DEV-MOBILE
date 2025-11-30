package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TempConverterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        EditText etC = findViewById(R.id.etCelsius);
        EditText etF = findViewById(R.id.etFahrenheit);
        Button btnToF = findViewById(R.id.btnToF);
        Button btnToC = findViewById(R.id.btnToC);

        btnToF.setOnClickListener(v -> {
            String s = etC.getText().toString().trim();
            if (s.isEmpty()) { etF.setText(""); return; }
            try {
                double c = Double.parseDouble(s);
                double f = c * 9 / 5 + 32;
                etF.setText(String.format("%.2f", f));
            } catch (NumberFormatException e) { etF.setText(""); }
        });

        btnToC.setOnClickListener(v -> {
            String s = etF.getText().toString().trim();
            if (s.isEmpty()) { etC.setText(""); return; }
            try {
                double f = Double.parseDouble(s);
                double c = (f - 32) * 5 / 9;
                etC.setText(String.format("%.2f", c));
            } catch (NumberFormatException e) { etC.setText(""); }
        });
    }
}
