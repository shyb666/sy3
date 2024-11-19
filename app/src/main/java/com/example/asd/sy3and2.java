package com.example.asd;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sy3and2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sy3_2);

        Button showDialogButton = findViewById(R.id.showDialogButton);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        Button showDialogButton1 = findViewById(R.id.showDialogButton1);
        showDialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title")
                .setMessage("This is a simple message.")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked Yes button
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked No button
                        dialog.cancel();
                    }
                });

        // Create the AlertDialog object and show it
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_login, null);
        builder.setView(dialogView)
                .setTitle("Custom Dialog")
                .setCancelable(false);

        AlertDialog alert = builder.create();

        // Find views by ID and set click listeners
        Button customPositiveButton = dialogView.findViewById(R.id.btnLogin);
        customPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  EditText input = dialogView.findViewById(R.id.customInput);
              //  String inputText = input.getText().toString();
                // Handle input text
                alert.dismiss();
            }
        });
        alert.show();
    }
}