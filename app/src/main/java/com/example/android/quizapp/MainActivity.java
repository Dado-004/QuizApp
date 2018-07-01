package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays questions and the results as a score.
 */


public class MainActivity extends AppCompatActivity {

    int initialScore = 0;
    RadioGroup radioGroup1, radioGroup2;
    RadioButton radioButton1, radioButton2;
    Button submitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup_one);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup_two);

        submitButton=(Button)findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioGroup1.getCheckedRadioButtonId();
                radioButton1=(RadioButton)findViewById(selectedId);

                int selectedId2=radioGroup2.getCheckedRadioButtonId();
                radioButton2=(RadioButton)findViewById(selectedId2);

            }

        });

    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitResult (View view) {

        EditText answerField = findViewById(R.id.answer_field);
        String answer = answerField.getText().toString();
        if (answer == "New Delhi"){
            initialScore += 1;
        }
        else {
            initialScore += 0;
        }

        CheckBox usaCheckbox = (CheckBox) findViewById(R.id.usa_checkbox);
        boolean isUsa = usaCheckbox.isChecked();
        CheckBox canadaCheckbox = (CheckBox) findViewById(R.id.canada_checkbox);
        boolean isCanada = canadaCheckbox.isChecked();
        CheckBox mexicoCheckbox = (CheckBox) findViewById(R.id.mexico_checkbox);
        boolean isMexico = mexicoCheckbox.isChecked();
        CheckBox brazilCheckbox = (CheckBox) findViewById(R.id.brazil_checkbox);
        boolean isBrazil = brazilCheckbox.isChecked();
        CheckBox superCheckbox = (CheckBox) findViewById(R.id.super_checkbox);
        boolean isSuper = superCheckbox.isChecked();
        CheckBox digitalCheckbox = (CheckBox) findViewById(R.id.digital_checkbox);
        boolean isDigital = digitalCheckbox.isChecked();
        CheckBox analogCheckbox = (CheckBox) findViewById(R.id.analog_checkbox);
        boolean isAnalog = analogCheckbox.isChecked();
        CheckBox microCheckbox = (CheckBox) findViewById(R.id.micro_checkbox);
        boolean isMicro = microCheckbox.isChecked();

        int score = calculateScore(isUsa, isCanada, isMexico, isBrazil, isSuper, isDigital, isAnalog, isMicro);


        Toast.makeText(this, "Your Score is " + initialScore, Toast.LENGTH_SHORT).show();

    }

    /**
     * Calculates the score from the checkboxes.
     *
     */

    public int calculateScore(boolean Usa, boolean Canada, boolean Mexico, boolean Brazil, boolean Super, boolean Digital, boolean Analog, boolean Micro) {
        
        //if the user selects usa.
        if (Usa) {
            initialScore = initialScore + 1;
        }

        //if the user selects canada.
        if (Canada) {
            initialScore = initialScore + 1;
        }

        //if the user selects mexico.
        if (Mexico) {
            initialScore = initialScore + 1;
        }

        //if the user selects brazil.
        if (Brazil) {
            initialScore = initialScore + 0;
        }

        //if the user selects super computers.
        if (Super) {
            initialScore = initialScore + 1;
        }

        //if the user selects digital computers
        if (Digital) {
            initialScore = initialScore + 0;
        }

        //if the user selects analog computers
        if (Analog) {
            initialScore = initialScore+ 0;
        }

        //if the user selects micro computers.
        if (Micro) {
            initialScore = initialScore + 1;
        }

        return initialScore;

    }

    /**
     * handles the radio buttons.
     *
     */

    public int onRadioButtonClicked(View v) {

        int radioButtonId1 = radioGroup1.getCheckedRadioButtonId();
        radioButton1 = (RadioButton) findViewById(radioButtonId1);

        int radioButtonId2 = radioGroup2.getCheckedRadioButtonId();
        radioButton2 = (RadioButton) findViewById(radioButtonId2);

        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        int initialScore = 0;

        // Check which radio button was clicked
        switch(v.getId()) {

            case R.id.radio_empty:
                if (checked)
                    initialScore += 0;
                    break;
            case R.id.radio_ocean:
                if (checked)
                    initialScore += 0;
                    break;
            case R.id.radio_atmosphere:
                if (checked)
                    initialScore = initialScore + 1;
                break;
            case R.id.radio_north:
                if (checked)
                    initialScore += 0;
                break;
            case R.id.radio_mozart:
                if (checked)
                    initialScore += 0;
                break;
            case R.id.radio_bach:
                if (checked)
                    initialScore += 0;
                break;
            case R.id.radio_beethoven:
                if (checked)
                    initialScore += 0;
                break;
            case R.id.radio_vivaldi:
                if (checked)
                    initialScore = initialScore + 1;
                break;
        }

        Context context = getApplicationContext();
        CharSequence text = "Selection made";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        return initialScore;
    }

    public MainActivity() {

    }

}
