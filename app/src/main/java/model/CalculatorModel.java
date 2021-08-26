package model;

import android.annotation.SuppressLint;

import com.hfad.calculator.R;

public class CalculatorModel {
    private CalculatorState calculatorState;
    private int btnClickCounter = 0;
    private int inputNumber;
    private int action;
    private int result;

    public CalculatorModel() {
        this.calculatorState = CalculatorState.firstArgumentInput;
    }

    public void onNumberClicked(int btnId) {
        if (btnClickCounter == 0) {
            inputNumber = getNumBtnValue(btnId);
        } else {
            inputNumber = inputNumber * 10 + getNumBtnValue(btnId);
        }
        btnClickCounter++;
    }

    public void onActionBtnClicked(int btnId) {
        if (btnId == R.id.btn_reset) {
            result = 0;
            inputNumber = 0;
            btnClickCounter = 0;
            action = 0;
            calculatorState = CalculatorState.firstArgumentInput;
        } else if (calculatorState == CalculatorState.firstArgumentInput) {
            btnClickCounter = 0;
            result = inputNumber;
            action = btnId;
            inputNumber = 0;
            calculatorState = CalculatorState.secondArgumentInput;
        } else if (inputNumber != 0 && action != R.id.btn_equals) {
            calculate(action);
            btnClickCounter = 0;
            inputNumber = 0;
            action = btnId;
        } else if (action == R.id.btn_equals) {
            calculate(action);
            btnClickCounter = 0;
            inputNumber = 0;
            action = btnId;
        }
    }

    @SuppressLint("NonConstantResourceId")
    private void calculate(int action) {
        switch (action) {
            case R.id.btn_minus:
                result = result - inputNumber;
                break;
            case R.id.btn_divide:
                result = result / inputNumber;
                break;
            case R.id.btn_plus:
                result = result + inputNumber;
                break;
            case R.id.btn_multiply:
                result = result * inputNumber;
                break;
        }
    }

    public String getInputNumber() {
        return String.valueOf(inputNumber);
    }

    public String getResult() {
        return String.valueOf(result);
    }

    @SuppressLint("NonConstantResourceId")
    private int getNumBtnValue(int btnId) {

        int numBtnValue = 0;

        switch (btnId) {
            case R.id.btn_zero:
                numBtnValue = 0;
                break;
            case R.id.btn_one:
                numBtnValue = 1;
                break;
            case R.id.btn_two:
                numBtnValue = 2;
                break;
            case R.id.btn_three:
                numBtnValue = 3;
                break;
            case R.id.btn_four:
                numBtnValue = 4;
                break;
            case R.id.btn_five:
                numBtnValue = 5;
                break;
            case R.id.btn_six:
                numBtnValue = 6;
                break;
            case R.id.btn_seven:
                numBtnValue = 7;
                break;
            case R.id.btn_eight:
                numBtnValue = 8;
                break;
            case R.id.btn_nine:
                numBtnValue = 9;
                break;
        }
        return numBtnValue;
    }

}



