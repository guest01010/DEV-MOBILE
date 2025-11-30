package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "item_title";
    public static final String EXTRA_CONFIRM = "item_confirm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        TextView question = findViewById(R.id.questionText);
        Button yesButton = findViewById(R.id.btnYes);
        Button noButton = findViewById(R.id.btnNo);

        String itemTitle = getIntent().getStringExtra(EXTRA_TITLE);
        if (itemTitle == null) itemTitle = "";
        question.setText("Voulez-vous utiliser " + itemTitle + " comme client ?");

        String finalItemTitle = itemTitle;

        yesButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_TITLE, finalItemTitle);
            intent.putExtra(EXTRA_CONFIRM, true);
            setResult(RESULT_OK, intent);
            finish();
        });

        noButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_TITLE, finalItemTitle);
            intent.putExtra(EXTRA_CONFIRM, false);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
