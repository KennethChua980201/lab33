package com.example.taruc.lab33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 private Spinner spinnerAge;
 private RadioGroup radioGroupGender;
 private RadioButton radioButtonMale, radioButtonFemale;
 private CheckBox checkBoxSmoker;
 private TextView textViewPremium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge= findViewById(R.id.spinnerAge);
        radioGroupGender= findViewById(R.id.radioGroupGender);
        radioButtonMale=findViewById(R.id.radioButtonMale);
        radioButtonFemale=findViewById(R.id.radioButtonFemale);
        checkBoxSmoker=findViewById(R.id.checkBoxSmoker);
        textViewPremium=findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(
                this, R.array.age_group, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);

    }
}
