package com.kuldeep.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_quiz extends AppCompatActivity {
    private RelativeLayout quizLayout;
    private TextView questionTextView;
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;
    private Button option4Button;
    private TextView scoreTextView;
    private Button nextButton;

    // Other variables to track quiz state
    private int currentQuestionIndex = 0;
    private int score = 0;
    private boolean quizOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize UI elements
        quizLayout = findViewById(R.id.quizLayout);
        questionTextView = findViewById(R.id.questionTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        option4Button = findViewById(R.id.option4Button);
        scoreTextView = findViewById(R.id.scoreTextView);
        nextButton = findViewById(R.id.nextButton);

        // Initialize the quiz with the first question
        displayQuestion(currentQuestionIndex);

        // Hide the score TextView and Next button initially
        scoreTextView.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

        // Set click listeners for option buttons
        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("A"); // Replace "A" with the correct option for the current question
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("B"); // Replace "B" with the correct option for the current question
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("C"); // Replace "C" with the correct option for the current question
            }
        });

        option4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("D"); // Replace "D" with the correct option for the current question
            }
        });

        // Set click listener for the "Next" button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if there are more questions
                if (!quizOver) {
                    if (currentQuestionIndex < QuizData.getJavaQuestions().size()) {
                        displayQuestion(currentQuestionIndex);
                    } else {
                        // Quiz is over, hide the question and answer options
                        questionTextView.setVisibility(View.GONE);
                        option1Button.setVisibility(View.GONE);
                        option2Button.setVisibility(View.GONE);
                        option3Button.setVisibility(View.GONE);
                        option4Button.setVisibility(View.GONE);
                        nextButton.setVisibility(View.GONE);

                        // Show the final score
                        scoreTextView.setText("Your Score: " + score + " out of " + QuizData.getJavaQuestions().size());
                        scoreTextView.setTextSize(24); // Set the text size for the score
                        scoreTextView.setVisibility(View.VISIBLE);
                        quizOver = true; // Set quizOver to true when the quiz is finished
                    }
                }
            }
        });
    }

    // Method to update the UI with the current question or final score
    private void displayQuestion(int questionIndex) {
        if (questionIndex < QuizData.getJavaQuestions().size()) {
            Question currentQuestion = QuizData.getJavaQuestions().get(questionIndex);
            questionTextView.setText(currentQuestion.getQuestionText());
            option1Button.setText(currentQuestion.getOption1());
            option2Button.setText(currentQuestion.getOption2());
            option3Button.setText(currentQuestion.getOption3());
            option4Button.setText(currentQuestion.getOption4());

            // Show the question and answer options
            questionTextView.setVisibility(View.VISIBLE);
            option1Button.setVisibility(View.VISIBLE);
            option2Button.setVisibility(View.VISIBLE);
            option3Button.setVisibility(View.VISIBLE);
            option4Button.setVisibility(View.VISIBLE);

            // Hide the score TextView and Next button
            scoreTextView.setVisibility(View.GONE);
            nextButton.setVisibility(View.GONE);
        } else {
            // Quiz is over, hide the question and answer options
            questionTextView.setVisibility(View.GONE);
            option1Button.setVisibility(View.GONE);
            option2Button.setVisibility(View.GONE);
            option3Button.setVisibility(View.GONE);
            option4Button.setVisibility(View.GONE);

            // Show the final score
            scoreTextView.setText("Your Score: " + score + " out of " + QuizData.getJavaQuestions().size());
            scoreTextView.setTextSize(24); // Set the text size for the score
            scoreTextView.setVisibility(View.VISIBLE);
            quizOver = true; // Set quizOver to true when the quiz is finished
        }
    }

    // Method to check the selected answer
    private void checkAnswer(String selectedOption) {
        Question currentQuestion = QuizData.getJavaQuestions().get(currentQuestionIndex);

        // Check if the selected option is correct
        if (selectedOption.equals(currentQuestion.getCorrectAnswer())) {
            // Correct answer, update score
            score++;
        }

        // Move to the next question
        currentQuestionIndex++;

        // Update the UI with the next question or the final score
        displayQuestion(currentQuestionIndex);
    }
}
