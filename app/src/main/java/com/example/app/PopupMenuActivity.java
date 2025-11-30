package com.example.app;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PopupMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
        Button btn = findViewById(R.id.btnPopup);
        btn.setOnClickListener(v -> {
            PopupMenu pm = new PopupMenu(this, v);
            pm.getMenuInflater().inflate(R.menu.popup_menu, pm.getMenu());
            pm.setOnMenuItemClickListener((MenuItem item) -> {
                Toast.makeText(this, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });
            pm.show();
        });
    }
}

