package com.example.garcia_prac2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    EditText show1, show2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        setTitle("SUMMARY");
        show1 = findViewById(R.id.editText2);
        show2 = findViewById(R.id.editText3);

        FileInputStream reader = null;
        String msg = "";
        try {
            reader = openFileInput("data1.txt");
            int token;

            while((token = reader.read()) != -1){
                msg = msg + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found.");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        }
        String cmt = "";
        try {
            reader = openFileInput("data2.txt");
            int token;

            while((token = reader.read()) != -1){
                cmt = cmt + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found.");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        }
        show1.setText(msg);
        show2.setText(cmt);

    }
    public void send (View v) {
        Toast.makeText(this, "registration sent", Toast.LENGTH_LONG).show();
    }

    public void prev (View v) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
