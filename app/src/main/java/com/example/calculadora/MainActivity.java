package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button one = findViewById(R.id.button1);
        Button two = findViewById(R.id.button2);
        Button three = findViewById(R.id.button3);
        Button four = findViewById(R.id.button4);
        Button five = findViewById(R.id.button5);
        Button six = findViewById(R.id.button6);
        Button seven = findViewById(R.id.button7);
        Button eight = findViewById(R.id.button8);
        Button nine = findViewById(R.id.button9);
        Button zero = findViewById(R.id.button0);
        Button zerozero = findViewById(R.id.button00);
        Button add = findViewById(R.id.buttonadd);
        Button minus = findViewById(R.id.buttonminus);
        Button mult = findViewById(R.id.buttonmult);
        Button split = findViewById(R.id.buttonsplit);
        Button equal = findViewById(R.id.buttonequal);

        StringBuilder textinput = new StringBuilder();


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int viewId = view.getId();

                if (viewId == R.id.button1){

                } else if (viewId == R.id.button2) {

                } else if (viewId == R.id.button3) {

                } else if (viewId == R.id.button4) {

                } else if (viewId == R.id.button5) {

                } else if (viewId == R.id.button6) {

                } else if (viewId == R.id.button7) {

                } else if (viewId == R.id.button8) {

                } else if (viewId == R.id.button9) {

                } else if (viewId == R.id.button0) {

                } else if (viewId == R.id.button00) {

                } else if (viewId == R.id.buttonadd) {

                } else if (viewId == R.id.buttonminus) {

                } else if (viewId == R.id.buttonmult) {

                } else if (viewId == R.id.buttonsplit) {

                } else if (viewId == R.id.buttonequal) {

                }
            }
        };


        int[] buttonIds = {
                R.id.button1, R.id.button2, R.id.button3, // Continue listing all buttons
                R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8,
                R.id.button9, R.id.button0, R.id.button00, R.id.buttonadd, R.id.buttonminus,
                R.id.buttonmult, R.id.buttonsplit, R.id.buttonequal
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(listener);
        }
    }
}