package com.example.garcia_prac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Activity Registration");
        setContentView(R.layout.activity_main);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);
        et = findViewById(R.id.editText);
    }


    public void save (View v) {
        String data = et.getText().toString();

        String gather = "";
        if (cb1.isChecked()) {
            gather = gather + cb1.getText().toString() + "\n";
        }
        if (cb2.isChecked()) {
            gather = gather + cb2.getText().toString() + "\n";
        }
        if (cb3.isChecked()) {
            gather = gather + cb3.getText().toString() + "\n";
        }
        if (cb4.isChecked()) {
            gather = gather + cb4.getText().toString() + "\n";
        }
        if (cb5.isChecked()) {
            gather = gather + cb5.getText().toString() + "\n";
        }
        if (cb6.isChecked()) {
            gather = gather + cb6.getText().toString() + "\n";
        }
        if (cb7.isChecked()) {
            gather = gather + cb7.getText().toString() + "\n";
        }
        if (cb8.isChecked()) {
            gather = gather + cb8.getText().toString() + "\n";
        }


        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(gather.getBytes());
            writer = openFileOutput("data2.txt", MODE_PRIVATE);
            writer.write(data.getBytes());

        } catch (FileNotFoundException e) {
            Log.d("error", "file not found...");

        } catch (IOException e) {
            Log.d("error", "file not found...");

        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "file not found...");
            }
            Toast.makeText(this, "data saved...", Toast.LENGTH_LONG).show();
        }
    }

    public void next (View v) {
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(i);
    }
}
