package com.example.prashiksha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnalysisActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private TextView timeTakenTextView;
    private TextView personalityTypeTextView;
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis_layout);

        scoreTextView = findViewById(R.id.scoreTextView);
        timeTakenTextView = findViewById(R.id.timeTakenTextView);
        personalityTypeTextView = findViewById(R.id.personalityTypeTextView);
        finishButton = findViewById(R.id.finishButton);

        Intent intent = getIntent();
        if (intent != null) {
            int score = intent.getIntExtra("score", 0);
            String timeTaken = intent.getStringExtra("timeTaken");
            String personalityType = intent.getStringExtra("personalityType");

            scoreTextView.setText("Your Score: " + score + "/15");
            timeTakenTextView.setText("Time Taken: " + timeTaken);
            personalityTypeTextView.setText("Your Personality Type: " + personalityType);
        }

        findViewById(R.id.finishButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisActivity.this, com.example.prashiksha.Interface2Activity.class);
                startActivity(intent);
            }
        });
    }
}
