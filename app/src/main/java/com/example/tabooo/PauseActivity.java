package com.example.tabooo;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PauseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);

        //initializing buttons
        Button resume_game_button = (Button)findViewById(R.id.resume_game_button);
        Button home_button = (Button)findViewById(R.id.go_home_button);



        // resume game clicked
        resume_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "done");
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });


        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PauseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

