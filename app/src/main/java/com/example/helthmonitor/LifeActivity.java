package com.example.helthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LifeActivity extends AppCompatActivity {
    private static final String TAG = LifeActivity.class.getSimpleName();


    private Button saveLifeButton;
    private EditText weightEdit;
    private EditText stepsEdit;
    private LifeClass lifeData;
    //private Map<Contact, LifeClass> contactLifeDataMap;
    private ArrayList<LifeClass> contactLifeDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        init();

        saveLifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonName = saveLifeButton.getText().toString();
                Log.i(TAG, "Button pressed : " + buttonName);

                float weight = 0;
                int steps = 0;

                String weightStr = weightEdit.getText().toString();
                String stepsStr = stepsEdit.getText().toString();


                try {
                    weight = Float.parseFloat(weightStr);
                } catch (NumberFormatException e) {
                    String errorStr = getString(R.string.incorrect_float, weightEdit.getHint().toString());
                    Toast.makeText(LifeActivity.this, errorStr, Toast.LENGTH_SHORT).show();
                } finally {
                    weightEdit.getText().clear();
                }

                try {
                    steps = Integer.parseInt(stepsStr);

                } catch (NumberFormatException e) {
                    String errorStr = getString(R.string.incorrect_integer, stepsEdit.getHint().toString());
                    Toast.makeText(LifeActivity.this, errorStr, Toast.LENGTH_SHORT).show();
                } finally {
                    stepsEdit.getText().clear();
                }
                lifeData = new LifeClass(weight, steps);
                //contactLifeDataMap.put(MainActivity.getC(), lifeData);
                contactLifeDataList.add(lifeData);
            }
        });

    }

    private void init() {
        saveLifeButton = findViewById(R.id.saveLifeButton);
        weightEdit = findViewById(R.id.weightEdit);
        stepsEdit = findViewById(R.id.stepsEdit);
        //contactLifeDataMap = new HashMap<>();
        contactLifeDataList=new ArrayList<>();
    }
}
