package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListNavActivity extends AppCompatActivity {

    private static class Dest {
        final String title;
        final Class<?> cls;

        Dest(String t, Class<?> c) {
            title = t;
            cls = c;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    private final Dest[] dests = new Dest[]{
            new Dest("🟢 Cercle", cercle.class),
            new Dest("💱 Convertisseur Devises", MainActivity2.class),
            new Dest("🧮 Calculatrice", calc.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nav);

        ListView list = findViewById(R.id.listNav);

        // Modern ArrayAdapter with default simple_list_item_1
        ArrayAdapter<Dest> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dests);

        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            Dest dest = dests[position];
            startActivity(new Intent(this, dest.cls));
        });
    }
}
