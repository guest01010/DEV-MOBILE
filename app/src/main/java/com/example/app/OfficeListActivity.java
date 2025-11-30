package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class OfficeListActivity extends AppCompatActivity {

    // Add Outlook image
    int[] imgs = {
            R.drawable.word,
            R.drawable.excel,
            R.drawable.ppt,
            R.drawable.outlook   // new Outlook icon
    };

    String[] titles = { "Word", "Excel", "PowerPoint", "Outlook" };
    String[] descs = { "Éditeur de texte", "Tableur", "Présentations", "Client mail" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_list);

        ListView list = findViewById(R.id.listOffice);

        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("img", imgs[i]);
            map.put("title", titles[i]);
            map.put("desc", descs[i]);
            data.add(map);
        }

        String[] from = { "img", "title", "desc" };
        int[] to = { R.id.img, R.id.titre, R.id.description };

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.office_item, from, to);
        list.setAdapter(adapter);

        list.setOnItemClickListener((p, v, pos, id) -> {
            Intent intent = new Intent(OfficeListActivity.this, ConfirmActivity.class);
            intent.putExtra(ConfirmActivity.EXTRA_TITLE, titles[pos]);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String title = data.getStringExtra(ConfirmActivity.EXTRA_TITLE);
            boolean confirm = data.getBooleanExtra(ConfirmActivity.EXTRA_CONFIRM, false);

            if (confirm) {
                new AlertDialog.Builder(this)
                        .setTitle("✅ Confirmé")
                        .setMessage("Vous avez confirmé: " + title)
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("❌ Annulé")
                        .setMessage("Vous avez annulé: " + title)
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            }

        }
}}
