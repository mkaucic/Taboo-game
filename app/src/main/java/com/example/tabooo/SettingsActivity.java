package com.example.tabooo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioSelectGroup;
    private RadioButton radioSelectButton;
    private Button selectButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        addListenerOnButton();
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_button_basic:
                if (checked)
                    // basic difficulty is selected
                    DifficultySettings.setDifficulty(Difficulty.EASY);
                    break;
            case R.id.radio_button_intermediate:
                if (checked)
                    // intermediate difficulty is selected
                    DifficultySettings.setDifficulty(Difficulty.MEDIUM);
                    break;
        }
    }

    public void addListenerOnButton() {

        radioSelectGroup = (RadioGroup) findViewById(R.id.settings_radio_group);
        selectButton = (Button) findViewById(R.id.settings_select_button);

        selectButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSelectGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSelectButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(SettingsActivity.this,
                        radioSelectButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

    }

    public static class DifficultySettings{

        public static Difficulty currentDifficulty = Difficulty.EASY;

        public static void setDifficulty (Difficulty newDifficulty){
            currentDifficulty = newDifficulty;
        }
    }

    public enum Difficulty{

        EASY, HARD, MEDIUM
    }

}

