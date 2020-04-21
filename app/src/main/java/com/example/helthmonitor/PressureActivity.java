package com.example.helthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PressureActivity extends AppCompatActivity {

    private static final String TAG = AppCompatActivity.class.getSimpleName();
    private EditText upperPressureEdit;
    private EditText lowPressureEdit;
    private EditText pulsEdit;
    private CheckBox tachicardiaCheckBox;
    private DatePicker datePicker;
    private Button savePressureButton;
    private PressureClass pressureData;
    //private Map<Contact, PressureClass> contactPressureClassMap;
    private ArrayList<PressureClass> contactPressureClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        init();

        savePressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonName = savePressureButton.getText().toString();
                Log.i(TAG, "Button pressed : " + buttonName);
                String upperStr = upperPressureEdit.getText().toString();
                String lowStr = lowPressureEdit.getText().toString();
                String pulsStr = pulsEdit.getText().toString();
                Boolean tachicardBool = tachicardiaCheckBox.isChecked();
                String dateStr = datePicker.toString();
                PressureClass p;
                int upper = 0, low = 0, puls = 0;
                boolean tach = false;
                try {
                    upper = Integer.parseInt(upperStr);
                } catch (NumberFormatException e) {
                    String errorStr = getString(R.string.incorrect_integer, upperPressureEdit.getHint().toString());
                    Toast.makeText(PressureActivity.this, errorStr, Toast.LENGTH_SHORT).show();
                } finally {
                    upperPressureEdit.getText().clear();
                }
                try {
                    low = Integer.parseInt(lowStr);
                } catch (NumberFormatException e) {
                    String errorStr = getString(R.string.incorrect_integer, lowPressureEdit.getHint().toString());
                    Toast.makeText(PressureActivity.this, errorStr, Toast.LENGTH_SHORT).show();
                } finally {
                    lowPressureEdit.getText().clear();
                }

                try {
                    puls = Integer.parseInt(pulsStr);
                } catch (NumberFormatException e) {
                    String errorStr = getString(R.string.incorrect_integer, pulsEdit.getHint().toString());
                    Toast.makeText(PressureActivity.this, errorStr, Toast.LENGTH_SHORT).show();
                } finally {
                    upperPressureEdit.getText().clear();
                }
                p = new PressureClass(upper, low, puls, tach, dateStr);
                //contactPressureClassMap.put(MainActivity.getC(), p);
                contactPressureClassList.add(p);
            }
        });

    }

    private void init() {
        upperPressureEdit = findViewById(R.id.upperPressureEdit);
        lowPressureEdit = findViewById(R.id.lowPressureEdit);
        pulsEdit = findViewById(R.id.pulseEdit);
        tachicardiaCheckBox = findViewById(R.id.tachicardiaCheckBox);
        datePicker = findViewById(R.id.datePicker);
        savePressureButton = findViewById(R.id.savePressureButton);
        //contactPressureClassMap = new HashMap<>();
        contactPressureClassList=new ArrayList<>();
    }
}
