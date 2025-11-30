package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView maListViewPerso;

    private static class Entry {
        final String title;
        final String className;

        Entry(String t, String cn) {
            title = t;
            className = cn;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    private final Entry[] entries = new Entry[]{
            new Entry("🔵 app1: périmètre du cercle", "com.example.app.cercle"),
            new Entry("💱 app2: convertisseur dirham-dollar-euro", "com.example.app.MainActivity2"),
            new Entry("🎓 app3: étudiant (matière, année)", "com.example.app.MainActivity1"),
            new Entry("🖱️ app4: ProjetClick", "com.example.app.ProjetClickActivity"),
            new Entry("⚡ app5: convertir la consommation", "com.example.app.ConsumptionConverterActivity"),
            new Entry("🌡️ app6: celsius → fahrenheit", "com.example.app.TempConverterActivity"),
            new Entry("ℹ️ app7: affichage info (toast)", "com.example.app.ToastInfoActivity"),
            new Entry("🧮 app8: calculatrice", "com.example.app.calc"),
            new Entry("📄 app9: listview (word / ppt / excel)", "com.example.app.OfficeListActivity"),
            new Entry("➡️ app10: navigation entre activity", "com.example.app.ListNavActivity"),
            new Entry("📩 app11: SMS", "com.example.app.SmsActivity"),
            new Entry("🟦 app12: menu actionbar", "com.example.app.ActionBarMenuActivity"),
            new Entry("📌 app13: menu popup", "com.example.app.PopupMenuActivity"),
            new Entry("🔢 app14: NumberPicker", "com.example.app.NumberPickerActivity")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        maListViewPerso = findViewById(R.id.listviewperso);

        ArrayAdapter<Entry> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                entries
        );
        maListViewPerso.setAdapter(adapter);

        maListViewPerso.setOnItemClickListener((parent, view, position, id) -> {
            Entry e = entries[position];
            try {
                Class<?> cls = Class.forName(e.className);
                startActivity(new Intent(MainActivity.this, cls));
            } catch (ClassNotFoundException ex) {
                Toast.makeText(this, "Cette app n'est pas encore implémentée: " + e.title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
