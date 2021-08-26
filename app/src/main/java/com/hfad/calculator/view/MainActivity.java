package com.hfad.calculator.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hfad.calculator.R;

import model.CalculatorModel;


public class MainActivity extends AppCompatActivity {

    private TextView inputText;
    private static final String ARG_CALC_INPUT_VALUE = "CALC_INPUT_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input_text);

        int[] numBtn = {
                R.id.btn_zero,
                R.id.btn_one,
                R.id.btn_two,
                R.id.btn_three,
                R.id.btn_four,
                R.id.btn_five,
                R.id.btn_six,
                R.id.btn_seven,
                R.id.btn_eight,
                R.id.btn_nine,
        };

        int[] actionBtn = {
                R.id.btn_divide,
                R.id.btn_minus,
                R.id.btn_multiply,
                R.id.btn_plus,
                R.id.btn_equals,
                R.id.btn_reset,
        };

        CalculatorModel calculatorModel = new CalculatorModel();

        View.OnClickListener numBtnClick = view -> {
            calculatorModel.onNumberClicked(view.getId());
            inputText.setText(calculatorModel.getInputNumber());
        };

        for (int j : numBtn) {
            findViewById(j).setOnClickListener(numBtnClick);
        }

        View.OnClickListener actionBtnClick = view -> {
            calculatorModel.onActionBtnClicked(view.getId());
            inputText.setText(calculatorModel.getResult());
        };

        for (int j : actionBtn) {
            findViewById(j).setOnClickListener(actionBtnClick);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_CALC_INPUT_VALUE, inputText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        inputText.setText(savedInstanceState.getString(ARG_CALC_INPUT_VALUE));
    }
}