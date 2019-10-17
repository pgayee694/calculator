package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double valueOne = Double.NaN;
    private double valueTwo;
    private static final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';

    private char CURRENT_ACTION;
    private DecimalFormat decimalFormat;

    Button buttonZero;
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonDot;
    Button buttonEqual;
    Button buttonAdd;
    Button buttonSubtract;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonClear;

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.##########");

        buttonZero =  findViewById(R.id.buttonZero);
        buttonOne =  findViewById(R.id.buttonOne);
        buttonTwo =  findViewById(R.id.buttonTwo);
        buttonThree =  findViewById(R.id.buttonThree);
        buttonFour =  findViewById(R.id.buttonFour);
        buttonFive =  findViewById(R.id.buttonFive);
        buttonSix =  findViewById(R.id.buttonSix);
        buttonSeven =  findViewById(R.id.buttonSeven);
        buttonEight =  findViewById(R.id.buttonEight);
        buttonNine =  findViewById(R.id.buttonNine);
        buttonAdd =  findViewById(R.id.buttonAdd);
        buttonSubtract =  findViewById(R.id.buttonSubtract);
        buttonMultiply =  findViewById(R.id.buttonMultiply);
        buttonDivide =  findViewById(R.id.buttonDivide);
        buttonClear =  findViewById(R.id.buttonClear);
        buttonDot =  findViewById(R.id.buttonDot);
        buttonEqual = findViewById(R.id.buttonEqual);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "0");
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "3");
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "6");
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                textView.setText(decimalFormat.format(valueOne) + "+");
                editText.setText(null);
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                textView.setText(decimalFormat.format(valueOne) + "-");
                editText.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                textView.setText(decimalFormat.format(valueOne) + "*");
                editText.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                textView.setText(decimalFormat.format(valueOne) + "/");
                editText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                textView.setText(textView.getText().toString() + decimalFormat.format(valueTwo)
                        + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(null);
                editText.setText(null);
                valueOne = Double.NaN;
            }
        });

    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            editText.setText(null);

            if(CURRENT_ACTION == ADDITION) {
                valueOne = this.valueOne + valueTwo;
            }

            if(CURRENT_ACTION == SUBTRACTION) {
                valueOne = this.valueOne - valueTwo;
            }

            if(CURRENT_ACTION == MULTIPLICATION) {
                valueOne = this.valueOne * valueTwo;
            }

            if(CURRENT_ACTION == DIVISION) {
                valueOne = this.valueOne / valueTwo;
            }
        }

        else {
            try {
                valueOne = Double.parseDouble(editText.getText().toString());
            }
            catch(Exception e) {

            }
        }
    }
}

