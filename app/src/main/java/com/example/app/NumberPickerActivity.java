package com.example.app;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NumberPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);

        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        TextView tvValue = findViewById(R.id.tvValue);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(100);
        numberPicker.setValue(10);

        // ✔ wrapSelectorWheel must be in Java (NOT XML)
        numberPicker.setWrapSelectorWheel(true);

        // block keyboard, scroll only by touch
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        numberPicker.setOnValueChangedListener((picker, oldVal, newVal) ->
                tvValue.setText("Selected: " + newVal)
        );
    }
}
