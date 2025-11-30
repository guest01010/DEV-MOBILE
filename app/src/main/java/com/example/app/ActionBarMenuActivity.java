package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActionBarMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar_menu);

        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("ILCS");
        getSupportActionBar().setSubtitle("DEV MOBILE APP");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_home) {
            Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_profile) {
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_settings) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_logout) {
            Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
