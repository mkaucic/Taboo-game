package com.example.tabooo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class GameSettingsActivity extends AppCompatActivity {
    // public messages
    public final static String TEAM_ONE_NAME = "com.example.tabooo.TEAM_ONE_NAME";
    public final static String TEAM_TWO_NAME = "com.example.tabooo.TEAM_TWO_NAME";
    public final static String NUM_ROUNDS = "com.example.tabooo.NUM_ROUNDS";
    public final static String SECONDS_PER_ROUND = "com.example.tabooo.SECONDS_PER_ROUND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);

        // initializing variables
        SeekBar numRoundsSeekBar = (SeekBar)findViewById(R.id.num_rounds_seek_bar);
        final TextView numRoundsTextView = (TextView)findViewById(R.id.num_rounds_choose_text_view);
        SeekBar timeInRoundSeekBar = (SeekBar)findViewById(R.id.time_in_round_seek_bar);
        final TextView timeInRoundTextView = (TextView)findViewById(R.id.time_in_round_choose_text_view);
        Button play_button = (Button)findViewById(R.id.to_game_button);

        assert play_button != null;

        numRoundsSeekBar.setProgress(4);
        numRoundsTextView.setText(getResources().getString(R.string.num_rounds_choose_text) + " " + (numRoundsSeekBar.getProgress()+1));

        timeInRoundSeekBar.setProgress(45);
        timeInRoundTextView.setText(getResources().getString(R.string.time_in_round_choose_text) + " " + (timeInRoundSeekBar.getProgress()+15));

        // numRoundsSeekBar setOnSeekBarChangeListener
        numRoundsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numRoundsTextView.setText(getResources().getString(R.string.num_rounds_choose_text) + " " + (progress+1));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // timeInRoundSeekBar setOnSeekBarChangeListener
        timeInRoundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                timeInRoundTextView.setText(getResources().getString(R.string.time_in_round_choose_text) + " " + (progress+15));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // play button clicked: starts Game Activity and sends info to Game Activity
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameSettingsActivity.this, GameActivity.class);

                EditText name1 = (EditText)findViewById(R.id.team_name1_editText);
                EditText name2 = (EditText)findViewById(R.id.team_name2_editText);
                SeekBar numRoundsSeekBar = (SeekBar)findViewById(R.id.num_rounds_seek_bar);
                SeekBar secondPerRoundSeekBar = (SeekBar)findViewById(R.id.time_in_round_seek_bar);

                int numRoundsProgress = numRoundsSeekBar.getProgress();
                int secondPerRoundProgress = secondPerRoundSeekBar.getProgress();

                String message1 = "";
                String message2 = "";
                if (name1.getText().equals(null)) {
                    message1 = "Team 1";
                }
                else {
                    message1 = name1.getText().toString();
                }
                if (name2.getText().equals(null)) {
                    message2 = "Team 2";
                }
                else {
                    message2 = name2.getText().toString();
                }

                intent.putExtra(TEAM_ONE_NAME, message1);
                intent.putExtra(TEAM_TWO_NAME, message2);
                intent.putExtra(NUM_ROUNDS, Integer.toString(numRoundsProgress+1));
                intent.putExtra(SECONDS_PER_ROUND, Integer.toString(secondPerRoundProgress+15));

                startActivity(intent);
            }
        });
    }
}
