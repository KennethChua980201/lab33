package com.example.taruc.lab33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.age_group, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Position" + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view) {
        int ageGroup;
        float premium = 0;
        float extraPayment = 0;
        int gender = radioGroupGender.getCheckedRadioButtonId();
        ageGroup = spinnerAge.getSelectedItemPosition();
        if (ageGroup == 0) {
            premium = 50;
        } else if (ageGroup == 1) {
            premium = 55;

        } else if (ageGroup == 2) {
            premium = 60;
        } else if (ageGroup == 3) {
            premium = 70;
        } else if (ageGroup == 4) {
            premium = 90;
        } else if (ageGroup == 5) {
            premium = 120;
        } else if (ageGroup == 6) {
            premium = 160;
        } else if (ageGroup == 7) {
            premium = 150;
        }

        if (gender == R.id.radioButtonMale) {//TODO calculate extra premium for male}

            if (ageGroup == 3) {
                premium += 50;
            } else if (ageGroup == 4) {
                premium += 100;
            } else if (ageGroup == 5) {
                premium += 150;
            } else if (ageGroup == 6) {
                premium += 200;
            } else if (ageGroup == 7) {
                premium += 200;
            }
        }

        if(checkBoxSmoker.isChecked())
        {if (ageGroup == 3) {
            premium += 100;
        } else if (ageGroup == 4) {
            premium += 150;
        } else if (ageGroup == 5) {
            premium += 200;
        } else if (ageGroup == 6) {
            premium += 250;
        } else if (ageGroup == 7) {
            premium += 300;
        }}
         textViewPremium.setText(String.format("RM %.2f",premium));
    }
}

