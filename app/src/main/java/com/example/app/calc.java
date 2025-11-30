package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calc extends AppCompatActivity {

    TextView tvResult;
    String input = "";
    String op = "";
    double first = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);

        tvResult = findViewById(R.id.tvResult);

        int[] nums = { R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 };

        View.OnClickListener numClick = v -> {
            Button b = (Button) v;
            input += b.getText().toString();
            tvResult.setText(input);
        };

        for (int id : nums) {
            findViewById(id).setOnClickListener(numClick);
        }

        findViewById(R.id.btnvergule).setOnClickListener(v -> {
            if (!input.contains(".")) {
                input += ".";
                tvResult.setText(input);
            }
        });

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            input = "";
            op = "";
            first = 0;
            tvResult.setText("0");
        });

        findViewById(R.id.btnAdd).setOnClickListener(v -> setOp("+"));
        findViewById(R.id.btnSub).setOnClickListener(v -> setOp("-"));
        findViewById(R.id.btnMul).setOnClickListener(v -> setOp("*"));
        findViewById(R.id.btnDiv).setOnClickListener(v -> setOp("/"));
        findViewById(R.id.btnEqual).setOnClickListener(v -> calc());
    }

    void setOp(String o) {
        if (!input.isEmpty()) {
            first = Double.parseDouble(input);
            op = o;
            input = "";
        }
    }

    void calc() {
        if (op.isEmpty() || input.isEmpty()) return;

        double second = Double.parseDouble(input);
        double res = 0;

        switch (op) {
            case "+": res = first + second; break;
            case "-": res = first - second; break;
            case "*": res = first * second; break;
            case "/":
                if (second == 0) {
                    tvResult.setText("Erreur: division par 0");
                    return;
                }
                res = first / second;
                break;
        }

        tvResult.setText(String.valueOf(res));
        input = String.valueOf(res);
        op = "";
    }
}
