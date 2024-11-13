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

        StringBuilder input = new StringBuilder();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int viewId = view.getId();
                System.out.println(viewId);
                int x = R.id.buttonequal;

                if (viewId == R.id.button1){
                    input.append("1");
                } else if (viewId == R.id.button2) {
                    input.append("2");
                } else if (viewId == R.id.button3) {
                    input.append("3");
                } else if (viewId == R.id.button4) {
                    input.append("4");
                } else if (viewId == R.id.button5) {
                    input.append("5");
                } else if (viewId == R.id.button6) {
                    input.append("6");
                } else if (viewId == R.id.button7) {
                    input.append("7");
                } else if (viewId == R.id.button8) {
                    input.append("8");
                } else if (viewId == R.id.button9) {
                    input.append("9");
                } else if (viewId == R.id.button0) {
                    input.append("0");
                } else if (viewId == R.id.button00) {
                    input.append("00");
                } else if (viewId == R.id.buttonadd) {
                    String temp = input.toString();
                    char y = temp.charAt(temp.length()-1);
                    if(Character.isDigit(y)){
                        input.append("+");
                    } else {
                        input.deleteCharAt(input.length() - 1);
                        input.append("+");
                    }
                } else if (viewId == R.id.buttonminus) {
                    String temp = input.toString();
                    char y = temp.charAt(temp.length()-1);
                    if(Character.isDigit(y)){
                        input.append("-");
                    } else {
                        input.deleteCharAt(input.length() - 1);
                        input.append("-");
                    }
                } else if (viewId == R.id.buttonmult) {
                    String temp = input.toString();
                    char y = temp.charAt(temp.length()-1);
                    if(Character.isDigit(y)){
                        input.append("*");
                    } else {
                        input.deleteCharAt(input.length() - 1);
                        input.append("*");
                    }
                } else if (viewId == R.id.buttonsplit) {
                    String temp = input.toString();
                    char y = temp.charAt(temp.length()-1);
                    if(Character.isDigit(y)){
                        input.append("/");
                    } else {
                        input.deleteCharAt(input.length() - 1);
                        input.append("/");
                    }
                } else if (viewId == R.id.buttonequal) {
                    System.out.println(input);

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