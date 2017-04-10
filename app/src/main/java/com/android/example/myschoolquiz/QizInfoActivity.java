package com.android.example.myschoolquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.example.myschoolquiz.data.QuizData;
import com.android.example.myschoolquiz.models.Quiz;
import com.android.example.myschoolquiz.models.QuizSummary;
import com.android.example.myschoolquiz.utils.Constants;
import com.android.example.myschoolquiz.utils.Utils;

public class QizInfoActivity extends AppCompatActivity {

    int quizId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qizz_info);
        displayQuizInfo();
        QuizSummary.Clear();
    }

    private void displayQuizInfo() {

        QuizData quizDb = QuizData.getData();
        quizId = getIntent().getIntExtra(Constants.EXTRA_QUIZZ_ID, 0);

        Quiz selectedQuiz = Utils.findQuizById(quizId, quizDb.quizzes);

        ((TextView) findViewById(R.id.quiz_name)).setText(selectedQuiz.name);
        ((TextView) findViewById(R.id.quiz_description)).setText("Description: " + selectedQuiz.description); // FIXME: 4/10/2017
        ((TextView) findViewById(R.id.quiz_quest_count)).setText("Number of questions: " + selectedQuiz.questions.size());// FIXME: 4/10/2017
    }

    public void onStartQuizClick(View view) {

        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra(Constants.EXTRA_QUIZZ_ID, quizId);
        startActivity(intent);
        finish();
    }
}
