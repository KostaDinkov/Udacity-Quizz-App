package com.android.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.quizapp.data.QuizData;
import com.android.example.quizapp.models.Answer;
import com.android.example.quizapp.models.Question;
import com.android.example.quizapp.models.Quiz;
import com.android.example.quizapp.models.QuizSummary;
import com.android.example.quizapp.utils.Constants;
import com.android.example.quizapp.utils.Utils;

public class QuestionActivity extends AppCompatActivity {

    private Quiz currentQuiz;
    private int currentQuestionIndex = 0;
    private int totalQuestions;
    private RadioGroup questionsRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionsRadioGroup = (RadioGroup) findViewById(R.id.all_answers);

        int currentQuizId = getIntent().getIntExtra(Constants.EXTRA_QUIZZ_ID, 0);
        currentQuiz = Utils.findQuizById(currentQuizId, QuizData.getData().quizzes);
        assert currentQuiz != null;
        this.totalQuestions = currentQuiz.questions.size();
        renderQuestion(currentQuiz.questions.get(currentQuestionIndex));
    }

    private void renderQuestion(Question currentQuestion) {

        questionsRadioGroup.removeAllViews();
        ((TextView) findViewById(R.id.question_text)).setText(currentQuestion.text);
        ((TextView) findViewById(R.id.question_progress)).setText("Question " + (currentQuestionIndex + 1) + " of " + totalQuestions);

        for (Answer answer : currentQuestion.allAnswers) {

            RadioButton rb = new RadioButton(this);
            rb.setText(answer.text);
            rb.setTag(answer);
            questionsRadioGroup.addView(rb);
        }
    }

    public void onNextQuestionClick(View view) {

        Question currentQuestion = currentQuiz.questions.get(currentQuestionIndex);

        RadioButton selectedRadioButton = (RadioButton) findViewById(questionsRadioGroup.getCheckedRadioButtonId());
        if (selectedRadioButton == null) {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
            return;
        }
        Answer selectedAnswer = (Answer) selectedRadioButton.getTag();
        QuizSummary.addResult(currentQuestion, selectedAnswer);

        currentQuestionIndex++;
        if (currentQuestionIndex >= currentQuiz.questions.size()) {
            startActivity(new Intent(this, QuizSummaryActivity.class));
            return;
        }

        currentQuestion = currentQuiz.questions.get(currentQuestionIndex);
        renderQuestion(currentQuestion);

    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(this, QuizSelection.class));
        finish();
    }

}
