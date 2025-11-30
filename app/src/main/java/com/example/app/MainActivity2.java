package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText madInput, eurInput, usdInput;
    Button btnConvert, btnClear;

    final double EURO_TO_MAD = 10.69;
    final double USD_TO_MAD = 9.85;
    final double USD_TO_EUR = 0.92;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        madInput = findViewById(R.id.editMAD);
        eurInput = findViewById(R.id.editEUR);
        usdInput = findViewById(R.id.editUSD);
        btnConvert = findViewById(R.id.btnConvert);
        btnClear = findViewById(R.id.btnReset);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String madStr = madInput.getText().toString();
                String eurStr = eurInput.getText().toString();
                String usdStr = usdInput.getText().toString();

                if (!madStr.isEmpty()) {
                    double mad = Double.parseDouble(madStr);
                    eurInput.setText(String.valueOf(mad / EURO_TO_MAD));
                    usdInput.setText(String.valueOf(mad / USD_TO_MAD));
                } else if (!eurStr.isEmpty()) {
                    double eur = Double.parseDouble(eurStr);
                    madInput.setText(String.valueOf(eur * EURO_TO_MAD));
                    usdInput.setText(String.valueOf(eur / USD_TO_EUR));
                } else if (!usdStr.isEmpty()) {
                    double usd = Double.parseDouble(usdStr);
                    madInput.setText(String.valueOf(usd * USD_TO_MAD));
                    eurInput.setText(String.valueOf(usd * USD_TO_EUR));
                } else {
                    Toast.makeText(MainActivity2.this, "Entrez une valeur à convertir", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                madInput.setText("");
                eurInput.setText("");
                usdInput.setText("");
            }
        });
    }
}