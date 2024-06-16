package com.example.prashiksha;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.prashiksha.databinding.ActivityInterfaceBinding; // Ensure this matches your layout file name

import java.util.Locale;

public class ActivityInterface extends AppCompatActivity {

    private ActivityInterfaceBinding binding;  // Correct the binding class name

    private TextView questionNumberTextView;
    private TextView timerTextView;
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1RadioButton;
    private RadioButton option2RadioButton;
    private RadioButton option3RadioButton;
    private RadioButton option4RadioButton;
    private Button nextButton;

    private String[] questions = {
            "You are given a list of 10 new vocabulary words. After 5 minutes, you are asked to select the word that means \"to reduce in size.\"",
            "You are shown a sequence of shapes for 30 seconds. Which shape was not in the sequence?",
            "After reading a short passage about photosynthesis, which of the following is the main product of this process?",
            "Read a passage about the water cycle. What is the process called when water vapor cools and turns into liquid?",
            "You are given a list of historical events. Which event happened first?",
            "Given a mathematical function, f(x) = 2x + 3, what is the value of f(2)?",
            "If all roses are flowers and some flowers fade quickly, can we conclude that some roses fade quickly?",
            "Which of the following statements is a logical conclusion if all cats are mammals and all mammals are animals?",
            "If you have a deck of cards and you draw one card at random, what is the probability of drawing an Ace?",
            "A company is considering a new project that has a 70% chance of success. If the project fails, the company will lose $1 million. If it succeeds, the company will gain $3 million. Should the company proceed with the project?",
            "In a study, researchers found that increasing sleep duration improves memory retention. Which of the following would strengthen this conclusion?",
            "You have two jars, one with 3 red and 7 blue marbles, and another with 5 red and 5 blue marbles. You randomly choose one jar and then a marble from that jar. What is the probability of drawing a red marble?",
            "Given the chemical equation for photosynthesis: 6CO2 + 6H2O -> C6H12O6 + 6O2. If a plant has 18 molecules of CO2, how many molecules of glucose can it produce?",
            "A car travels 60 miles in 1.5 hours. What is its average speed?",
            "If the interest rate on a loan is 5% per year, what will be the total amount to be paid after one year on a $1,000 loan?"
    };

    private String[][] options = {
            {"Amplify", "Minimize", "Inflate", "Expand"},
            {"Circle", "Triangle", "Square", "Hexagon"},
            {"Oxygen", "Carbon Dioxide", "Water", "Glucose"},
            {"Evaporation", "Precipitation", "Condensation", "Transpiration"},
            {"The signing of the Declaration of Independence", "The fall of the Berlin Wall", "The first moon landing", "The invention of the printing press"},
            {"5", "7", "8", "11"},
            {"Yes", "No", "Not necessarily", "All roses fade quickly"},
            {"Some cats are animals.", "All animals are cats.", "All cats are animals.", "No animals are cats."},
            {"1/52", "4/52", "1/13", "4/13"},
            {"Yes, because the potential gain is higher than the potential loss.", "No, because the risk of losing $1 million is too high.", "Yes, because the expected value is positive.", "No, because a 30% failure rate is too risky."},
            {"A study showing no change in memory with increased sleep.", "A study showing improved memory with reduced sleep.", "A study showing increased cognitive function with increased sleep.", "A study showing decreased memory retention with increased screen time."},
            {"3/10", "1/2", "4/10", "7/20"},
            {"1", "2", "3", "6"},
            {"40 mph", "50 mph", "60 mph", "80 mph"},
            {"$50", "$1,050", "$1,500", "$1,500"}
    };

    private int[] correctAnswers = {1, 3, 3, 2, 3, 1, 2, 3, 2, 2, 2, 3, 2, 1, 1};

    private int currentQuestionIndex = 0;
    private int score = 0;
    private long startTime = 0L;
    private Handler timerHandler = new Handler();
    private int minutes = 0; // Declare variables here to make them accessible
    private int seconds = 0;
    int visualSpatialScore = 0;
    int fastLearnerScore = 0;
    int methodicalScore = 0;
    int holisticScore = 0;
    int intuitiveScore = 0;
    int reflectiveScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterfaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = binding.navView;
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_bits, R.id.navigation_cult, R.id.navigation_fix, R.id.navigation_resources)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        questionNumberTextView = findViewById(R.id.questionNumberTextView);
        timerTextView = findViewById(R.id.timerTextView);
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        option1RadioButton = findViewById(R.id.option1RadioButton);
        option2RadioButton = findViewById(R.id.option2RadioButton);
        option3RadioButton = findViewById(R.id.option3RadioButton);
        option4RadioButton = findViewById(R.id.option4RadioButton);
        nextButton = findViewById(R.id.nextButton);

        if (savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt("currentQuestionIndex");
            score = savedInstanceState.getInt("score");
            startTime = savedInstanceState.getLong("startTime");
        }

        loadQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion();
                } else {
                    finishTest();
                }
            }
        });

        startTime = SystemClock.uptimeMillis();
        timerHandler.postDelayed(updateTimerThread, 0);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentQuestionIndex", currentQuestionIndex);
        outState.putInt("score", score);
        outState.putLong("startTime", startTime);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentQuestionIndex = savedInstanceState.getInt("currentQuestionIndex");
        score = savedInstanceState.getInt("score");
        startTime = savedInstanceState.getLong("startTime");
    }

    private void loadQuestion() {
        questionNumberTextView.setText("Question " + (currentQuestionIndex + 1));
        questionTextView.setText(questions[currentQuestionIndex]);
        option1RadioButton.setText(options[currentQuestionIndex][0]);
        option2RadioButton.setText(options[currentQuestionIndex][1]);
        option3RadioButton.setText(options[currentQuestionIndex][2]);
        option4RadioButton.setText(options[currentQuestionIndex][3]);
        optionsRadioGroup.clearCheck();
    }

    private void checkAnswer() {
        int selectedOptionIndex = optionsRadioGroup.indexOfChild(findViewById(optionsRadioGroup.getCheckedRadioButtonId()));
        if (selectedOptionIndex == correctAnswers[currentQuestionIndex]) {
            score++;
        }
    }

    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            long elapsedTime = SystemClock.uptimeMillis() - startTime;
            seconds = (int) (elapsedTime / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            timerTextView.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds));
            timerHandler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerHandler.removeCallbacks(updateTimerThread);
    }

    private void finishTest() {
        // Calculate scores in different categories
        int logicalThinkingScore = calculateScoreInRange(6, 9); // Q6 to Q9
        int understandingMemorizationScore = calculateScoreInRange(1, 5); // Q1 to Q5
        int criticalThinkingScore = calculateScoreInRange(10, 12); // Q10 to Q12
        int applicationConceptsScore = calculateScoreInRange(13, 15); // Q13 to Q15

        // Determine personality type
        PersonalityType personalityType = determinePersonalityType(logicalThinkingScore, understandingMemorizationScore,
                criticalThinkingScore, applicationConceptsScore);

        // Start AnalysisActivity with personality type
        Intent intent = new Intent(ActivityInterface.this, AnalysisActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("timeTaken", String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds));
        intent.putExtra("personalityType", personalityType.toString());
        startActivity(intent);
        finish();
    }

    private int calculateScoreInRange(int startQuestionIndex, int endQuestionIndex) {
        int score = 0;
        for (int i = startQuestionIndex; i <= endQuestionIndex; i++) {
            if (correctAnswers[i - 1] == 1) { // correctAnswers array is 0-based
                score++;
            }
        }
        return score;
    }

    private PersonalityType determinePersonalityType(int logicalScore, int understandingScore,
                                                     int criticalScore, int applicationScore) {
        // Determine personality type based on scores
        if (logicalScore >= 3 && criticalScore >= 2) {
            return PersonalityType.ANALYTICAL_THINKER;
        } else if (understandingScore >= 3) {
            return PersonalityType.DETAIL_ORIENTED_LEARNER;
        } else if (visualSpatialScore >= 2) {
            return PersonalityType.VISUAL_SPATIAL_LEARNER;
        } else if (fastLearnerScore >= 3) {
            return PersonalityType.FAST_LEARNER;
        } else if (methodicalScore >= 2) {
            return PersonalityType.METHODICAL_LEARNER;
        } else if (holisticScore >= 2) {
            return PersonalityType.HOLISTIC_LEARNER;
        } else if (intuitiveScore >= 3) {
            return PersonalityType.INTUITIVE_LEARNER;
        } else if (reflectiveScore >= 2) {
            return PersonalityType.REFLECTIVE_LEARNER;
        } else {
            // Default to some type (if necessary)
            return PersonalityType.DETAIL_ORIENTED_LEARNER; // or any other default
        }
    }

}