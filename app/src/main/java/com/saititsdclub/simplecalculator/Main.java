package com.saititsdclub.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
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

        this.setEditTextOnlySelectable(editTextFormula);
        this.setEditTextOnlySelectable(editTextAnswer);
    }

    private void setEditTextOnlySelectable(EditText editText) {
        editText.setInputType(InputType.TYPE_NULL);
        editText.setTextIsSelectable(true);
        editText.setKeyListener(null);
    }
}
