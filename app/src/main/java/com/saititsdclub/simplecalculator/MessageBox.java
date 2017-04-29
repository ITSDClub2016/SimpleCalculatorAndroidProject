package com.saititsdclub.simplecalculator;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class MessageBox extends DialogFragment {
    private final String title = "Simple Calculator App";
    private String message;

    public MessageBox() {
        message = "";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // You don't have to do anything here if you just want it dismissed when clicked
            }
        });

        return builder.create();
    }
}
