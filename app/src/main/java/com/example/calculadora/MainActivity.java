package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    StringBuilder firstValue = new StringBuilder();
    StringBuilder secondValue = new StringBuilder();
    char[] op = new char[1];

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
        Button borrar = findViewById(R.id.button);


        TextView result = findViewById(R.id.inputresult);


        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValue.setLength(0); //reiniciar los valores
                firstValue.trimToSize();
                secondValue.setLength(0);
                secondValue.trimToSize();
                op[0] = '.';
                result.setText("0");
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int viewId = view.getId();

                if (viewId == R.id.button1){
                    firstValue.append("1");
                    result.setText(firstValue);
                } else if (viewId == R.id.button2) {
                    firstValue.append("2");
                    result.setText(firstValue);
                } else if (viewId == R.id.button3) {
                    firstValue.append("3");
                    result.setText(firstValue);
                } else if (viewId == R.id.button4) {
                    firstValue.append("4");
                    result.setText(firstValue);
                } else if (viewId == R.id.button5) {
                    firstValue.append("5");
                    result.setText(firstValue);
                } else if (viewId == R.id.button6) {
                    firstValue.append("6");
                    result.setText(firstValue);
                } else if (viewId == R.id.button7) {
                    firstValue.append("7");
                    result.setText(firstValue);
                } else if (viewId == R.id.button8) {
                    firstValue.append("8");
                    result.setText(firstValue);
                } else if (viewId == R.id.button9) {
                    firstValue.append("9");
                    result.setText(firstValue);
                } else if (viewId == R.id.button0) {
                    firstValue.append("0");
                    result.setText(firstValue);
                } else if (viewId == R.id.button00) {
                    firstValue.append("00");
                    result.setText(firstValue);
                } else if (viewId == R.id.buttonadd) {
                    if (firstValue.length() >= 1 && secondValue.length() == 0){ //solo hace algo si ya hay un valor previo
                        secondValue.append(firstValue);
                        firstValue.setLength(0);
                        firstValue.trimToSize();
                        op[0] = '+';
                    } else if (firstValue.length() >= 1 && secondValue.length() >= 1){ //si ambos valores
                        Integer first = Integer.parseInt(secondValue.toString());
                        Integer second = Integer.parseInt(firstValue.toString());
                        int calc = first+second;
                        result.setText(Integer.toString(calc));

                        resetValues(calc); //y añadir el resultado
                    }

                } else if (viewId == R.id.buttonminus) {
                    if (firstValue.length() >= 1 && secondValue.length() == 0){ //solo hace algo si ya hay un valor previo
                        secondValue.append(firstValue);
                        firstValue.setLength(0);
                        firstValue.trimToSize();
                        op[0] = '-';
                    } else if (firstValue.length() >= 1 && secondValue.length() >= 1){ //si ambos valores
                        Integer first = Integer.parseInt(secondValue.toString());
                        Integer second = Integer.parseInt(firstValue.toString());

                        int calc = first-second;
                        result.setText(Integer.toString(calc));

                        resetValues(calc);
                        //y añadir el resultado
                    }

                } else if (viewId == R.id.buttonmult) {
                    if (firstValue.length() >= 1 && secondValue.length() == 0){ //solo hace algo si ya hay un valor previo
                        secondValue.append(firstValue);
                        firstValue.setLength(0);
                        firstValue.trimToSize();
                        op[0] = '*';
                    } else if (firstValue.length() >= 1 && secondValue.length() >= 1){ //si ambos valores
                        Integer first = Integer.parseInt(secondValue.toString());
                        Integer second = Integer.parseInt(firstValue.toString());
                        int calc = first*second;
                        result.setText(Integer.toString(calc));

                        resetValues(calc);
                    }
                } else if (viewId == R.id.buttonsplit) {
                    if (firstValue.length() >= 1 && secondValue.length() == 0){ //solo hace algo si ya hay un valor previo
                        secondValue.append(firstValue);
                        firstValue.setLength(0);
                        firstValue.trimToSize();
                        op[0] = '/';
                    } else if (firstValue.length() >= 1 && secondValue.length() >= 1){ //si ambos valores
                        Integer first = Integer.parseInt(secondValue.toString());
                        Integer second = Integer.parseInt(firstValue.toString());
                        int calc = first/second;
                        result.setText(Integer.toString(calc));

                        resetValues(calc);
                    }
                } else if (viewId == R.id.buttonequal) {
                    System.out.println("-----"+firstValue);
                    System.out.println(secondValue);
                    System.out.println(op[0]);
                    Integer res = calculate(Integer.parseInt(secondValue.toString()),Integer.parseInt(firstValue.toString()),op[0]);
                    result.setText(Integer.toString(res));
                    resetValues(res);
                   /* if(op[0] == '+'){
                        System.out.println("suma");
                        Integer first = Integer.parseInt(secondValue.toString());
                        Integer second = Integer.parseInt(firstValue.toString());

                        result.setText(Integer.toString(calculate(first,second,'+')));

                    } else if (op[0] == '-') {
                        System.out.println("resta");
                        Integer first = Integer.parseInt(secondValue.toString());
                        Integer second = Integer.parseInt(firstValue.toString());
                        int calc = first-second;
                        result.setText(Integer.toString(calc));

                    } else if (op[0] == '*') {
                        System.out.println("mult");
                        Integer first = Integer.parseInt(secondValue.toString());
                        Integer second = Integer.parseInt(firstValue.toString());
                        int calc = first*second;
                        result.setText(Integer.toString(calc));

                    } else if (op[0] == '/'){
                        System.out.println("div");
                        Integer first = Integer.parseInt(secondValue.toString());
                        Integer second = Integer.parseInt(firstValue.toString());
                        int calc = first/second;
                        result.setText(Integer.toString(calc));

                    }*/

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

    private void resetValues(int calc){
        firstValue.setLength(0); //reiniciar los valores
        firstValue.trimToSize();
        secondValue.setLength(0);
        secondValue.trimToSize();

        secondValue.append(calc);
    }

    private Integer calculate(Integer value1, Integer value2, char operator){
        if(operator == '+'){
            System.out.println("suma");
            int calc = value1+value2;
            return calc;
        } else if (operator == '-') {
            System.out.println("resta");
            int calc = value1-value2;
            return calc;
        } else if (operator == '*') {
            System.out.println("mult");
            int calc = value1*value2;
            return calc;
        } else if (operator == '/'){
            System.out.println("div");
            int calc = value1/value2;
            return calc;
        } else {
            return 0;
        }
    }

    private void operationPressed (){

    }
}