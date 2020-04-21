package com.example.helthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button lifeDataButton;
    private Button pressureButton;
    private Button saveButton;
    private EditText firstName;
    private EditText lastName;
    private EditText fatherName;
    private EditText ageEdit;
    private ArrayList<Contact> contacts;
    private Contact c;

    //public static Contact getC() {
      //  return c;
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = new Contact();
        init();
        lifeDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonName = lifeDataButton.getText().toString();
                Log.i(TAG, "Button pressed : " + buttonName);
                Intent intent = new Intent(MainActivity.this, LifeActivity.class);
                startActivity(intent);
            }
        });

        pressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonName = pressureButton.getText().toString();
                Log.i(TAG, "Button pressed : " + buttonName);
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonName = saveButton.getText().toString();
                Log.i(TAG, "Button pressed : " + buttonName);
                String name = firstName.getText().toString();
                String lname = lastName.getText().toString();
                String fname = fatherName.getText().toString();
                String ageStr = ageEdit.getText().toString();
                Integer age=0;

                if (name.length() == 0) {
                    String errorStr = getString(R.string.check_message, firstName.getHint().toString());
                    Toast.makeText(MainActivity.this, errorStr, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (lname.length() == 0) {
                    String errorStr = getString(R.string.check_message, lastName.getHint().toString());
                    Toast.makeText(MainActivity.this, errorStr, Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    age = Integer.parseInt(ageStr);

                } catch (NumberFormatException e) {
                    String errorStr = getString(R.string.incorrect_integer, ageEdit.getHint().toString());
                    Toast.makeText(MainActivity.this, errorStr, Toast.LENGTH_SHORT).show();
                } finally {
                    ageEdit.getText().clear();
                }
                c.setName(name);
                c.setSurname(lname);
                c.setFathername(fname);
                c.setAge(age);

                contacts.add(c);


            }
        });
    }

    private void init() {
        lifeDataButton = findViewById(R.id.lifeDataButton);
        pressureButton = findViewById(R.id.pressureButton);
        saveButton = findViewById(R.id.saveButton);
        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editLastName);
        fatherName = findViewById(R.id.editFatherName);
        ageEdit = findViewById(R.id.editAge);
        contacts = new ArrayList<>();
    }
}
