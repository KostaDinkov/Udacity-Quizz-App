package com.android.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.example.quizapp.models.AnsweredQuestion;
import com.android.example.quizapp.models.QuizSummary;

import java.util.ArrayList;

public class QuizSummaryActivity extends AppCompatActivity {

    ListView wrongAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_summary);

        wrongAnswers = (ListView) findViewById(R.id.QuizSummary_wrongAnswers_LinearLayout);
        displayResults();
    }

    private void displayResults() {

        boolean isPerfect = true;
        ArrayList<AnsweredQuestion> wrongAnsweredQuestions = new ArrayList<>();

        for (AnsweredQuestion entry : QuizSummary.getResults()) {

            if (!entry.answer.isCorrect) {

                wrongAnsweredQuestions.add(entry);
                isPerfect = false;
            }
        }

        int totalQuestions = QuizSummary.getResults().size();
        int correctAnswerCount = totalQuestions - wrongAnsweredQuestions.size();
        ((TextView) findViewById(R.id.QuizSummary_quizResults_TextView)).setText("Correct answers: " + correctAnswerCount + " of " + totalQuestions);

        if (isPerfect) {
            TextView tv = (TextView) findViewById(R.id.QuizSummary_wrongAnswers_TextView);
            tv.setText(R.string.no_wrong_answers);
            return;
        }

        renderSummary(wrongAnsweredQuestions);

    }

    private void renderSummary(ArrayList<AnsweredQuestion> wrongAnsweredQuestions) {

        ArrayAdapter<AnsweredQuestion> adapter = new WrongAnswerAdapter(this, 0, wrongAnsweredQuestions);
        wrongAnswers.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(this, QuizSelection.class));
    }

    public void onStartOverClick(View view) {

        startActivity(new Intent(this, QuizSelection.class));
    }
}
