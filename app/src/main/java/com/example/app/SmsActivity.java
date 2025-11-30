package com.example.app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SmsActivity extends AppCompatActivity {

    private static final int SMS_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        EditText etPhone = findViewById(R.id.etPhone);
        EditText etBody = findViewById(R.id.etBody);
        Button btnSend = findViewById(R.id.btnSendSms);

        btnSend.setOnClickListener(v -> {

            // ask permission if not granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CODE);
                return;
            }

            String phone = etPhone.getText().toString().trim();
            String body = etBody.getText().toString().trim();

            try {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phone, null, body, null, null);
                Toast.makeText(this, "SMS envoyé avec succès", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Erreur: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == SMS_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission acceptée. Réessayez d'envoyer.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission refusée. Impossible d'envoyer un SMS.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
