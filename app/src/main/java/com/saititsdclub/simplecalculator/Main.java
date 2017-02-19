package com.saititsdclub.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    EditText editTextFormula;
    EditText editTextAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        editTextFormula = (EditText)findViewById(R.id.editTextFormula);
        editTextAnswer = (EditText)findViewById(R.id.editTextAnswer);

        addActionListenersToNumberButtons();
        addActionListenerToBackButton();

        this.setEditTextOnlySelectable(editTextFormula);
        this.setEditTextOnlySelectable(editTextAnswer);
    }

    private void setEditTextOnlySelectable(EditText editText) {
        editText.setInputType(InputType.TYPE_NULL);
        editText.setTextIsSelectable(true);
        editText.setKeyListener(null);
    }

    private void addActionListenersToNumberButtons(){
        Button buttonZero = (Button) findViewById(R.id.buttonZero);
        Button buttonOne = (Button) findViewById(R.id.buttonOne);
        Button buttonTwo = (Button) findViewById(R.id.buttonTwo);
        Button buttonThree = (Button) findViewById(R.id.buttonThree);
        Button buttonFour = (Button) findViewById(R.id.buttonFour);
        Button buttonFive = (Button) findViewById(R.id.buttonFive);
        Button buttonSix = (Button) findViewById(R.id.buttonSix);
        Button buttonSeven = (Button) findViewById(R.id.buttonSeven);
        Button buttonEight = (Button) findViewById(R.id.buttonEight);
        Button buttonNine = (Button) findViewById(R.id.buttonNine);
        addActionListenerToNumberButton(buttonZero, 0);
        addActionListenerToNumberButton(buttonOne, 1);
        addActionListenerToNumberButton(buttonTwo, 2);
        addActionListenerToNumberButton(buttonThree, 3);
        addActionListenerToNumberButton(buttonFour, 4);
        addActionListenerToNumberButton(buttonFive, 5);
        addActionListenerToNumberButton(buttonSix, 6);
        addActionListenerToNumberButton(buttonSeven, 7);
        addActionListenerToNumberButton(buttonEight, 8);
        addActionListenerToNumberButton(buttonNine, 9);
    }

    private void addActionListenerToBackButton(){
        Button backButton = (Button) findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextFormula.getText().toString();
                if(input.length()>0){
                    input = input.substring(0, input.length()-1);
                    editTextFormula.setText(input);
                }
            }
        });
    }

    private void addActionListenerToNumberButton(Button button, final int number){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextFormula.getText().toString();
                input = input + Integer.toString(number);
                editTextFormula.setText(input);
            }
        });
    }
}
