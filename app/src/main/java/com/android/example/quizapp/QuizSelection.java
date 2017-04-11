package com.android.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.example.quizapp.data.QuizData;
import com.android.example.quizapp.models.Quiz;
import com.android.example.quizapp.utils.Constants;

public class QuizSelection extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selection);
        getSupportActionBar().hide();
        radioGroup = (RadioGroup) findViewById(R.id.quiz_selection);
        displayQuizzes();
    }

    private void displayQuizzes() {

        QuizData quizDb = QuizData.getData();

        for (Quiz q : quizDb.quizzes) {

            RadioButton rb = new RadioButton(this);
            rb.setText(q.name);
            rb.setTag(q);
            radioGroup.addView(rb);
        }
    }

    public void onSelectQuizClick(View view) {

        RadioButton selectedRb = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        if (selectedRb == null) {

            Toast.makeText(this, "Choose a quiz to continue", Toast.LENGTH_SHORT).show();
            return;
        }
        int selectedQuizId = ((Quiz) selectedRb.getTag()).getId();
        Intent intent = new Intent(this, QizInfoActivity.class);

        intent.putExtra(Constants.EXTRA_QUIZZ_ID, selectedQuizId);
        startActivity(intent);
    }

}
