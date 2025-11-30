package com.example.app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    private EditText editPrenom, editNom, editEmail, editMoyenne;
    private RadioGroup radioAnnee;
    private Spinner spinnerMatiere;
    private Button btnEnregistrer;
    private TableLayout tableResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_etudiant_main);// la redirection a la vue content_etudiant_main


        editPrenom = findViewById(R.id.editPrenom);
        editNom = findViewById(R.id.editNom);
        editEmail = findViewById(R.id.editEmail);
        editMoyenne = findViewById(R.id.editMoyenne);
        radioAnnee = findViewById(R.id.radioAnnee);
        spinnerMatiere = findViewById(R.id.spinnerMatiere);
        btnEnregistrer = findViewById(R.id.btnEnregistrer);
        tableResult = findViewById(R.id.tableResult);


        String[] matieres = {"Informatique", "Math", "Réseaux"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, matieres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMatiere.setAdapter(adapter);





        btnEnregistrer.setOnClickListener(v -> {
            try {
                // Récupération des données
                String prenom = editPrenom.getText().toString().trim();
                String nom = editNom.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String matiere = spinnerMatiere.getSelectedItem().toString();
                int annee = (radioAnnee.getCheckedRadioButtonId() == R.id.annee1) ? 1 : 2;

                String moyenneText = editMoyenne.getText().toString().trim();
                double moyenne = moyenneText.isEmpty() ? 0.0 : Double.parseDouble(moyenneText);

                Etudiant e = new Etudiant(prenom, nom, email, annee, matiere, moyenne);


                ajouterLigneEtudiant(e);


                afficherHTMLDialog(e);


                editPrenom.setText("");
                editNom.setText("");
                editEmail.setText("");
                editMoyenne.setText("");
                radioAnnee.clearCheck();

            } catch (Exception ex) {
                Toast.makeText(this, "Erreur : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void ajouterEnteteTable() {
        TableRow header = new TableRow(this);
        String[] titres = {"Prénom", "Nom", "Email", "Année", "Matière", "Moyenne"};

        for (String titre : titres) {
            TextView tv = new TextView(this);
            tv.setText(titre);
            tv.setTextSize(16);
            tv.setPadding(8, 8, 8, 8);
            tv.setBackgroundColor(0xFF2196F3);
            tv.setTextColor(0xFFFFFFFF);
            header.addView(tv);
        }
        tableResult.addView(header);
    }

    private void ajouterLigneEtudiant(Etudiant e) {
        TableRow row = new TableRow(this);

        ajouterCellule(row, e.getPrenom());
        ajouterCellule(row, e.getNom());
        ajouterCellule(row, e.getMail());
        ajouterCellule(row, e.getAnnee() + "ᵉ");
        ajouterCellule(row, e.getMatiere());
        ajouterCellule(row, String.valueOf(e.getMoyenne()));

        tableResult.addView(row);
    }

    private void ajouterCellule(TableRow row, String valeur) {
        TextView tv = new TextView(this);
        tv.setText(valeur);
        tv.setTextSize(15);
        tv.setPadding(8, 8, 8, 8);
        tv.setBackgroundColor(0xFFE3F2FD);
        row.addView(tv);
    }



    private void afficherHTMLDialog(Etudiant e) {
        String html = "<html><body>" +
                "<h3 style='color:#2196F3'>Informations Étudiant</h3>" +
                "<table border='1' cellspacing='0' cellpadding='4'>" +
                "<tr><th>Prénom</th><th>Nom</th><th>Email</th><th>Année</th><th>Matière</th><th>Moyenne</th></tr>" +
                "<tr>" +
                "<td>" + e.getPrenom() + "</td>" +
                "<td>" + e.getNom() + "</td>" +
                "<td>" + e.getMail() + "</td>" +
                "<td>" + e.getAnnee() + "ᵉ</td>" +
                "<td>" + e.getMatiere() + "</td>" +
                "<td>" + e.getMoyenne() + "</td>" +
                "</tr>" +
                "</table></body></html>";


    }

}
