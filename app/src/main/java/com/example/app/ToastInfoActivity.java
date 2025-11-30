package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToastInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_info);
        EditText et = findViewById(R.id.etMessage);
        Button btn = findViewById(R.id.btnShowToast);
        btn.setOnClickListener(v -> {
            String msg = et.getText().toString().trim();
            if (msg.isEmpty()) msg = "Hello from Toast!";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
    }
}
