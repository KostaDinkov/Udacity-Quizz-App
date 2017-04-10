package com.android.example.myschoolquiz;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.example.myschoolquiz.models.Answer;
import com.android.example.myschoolquiz.models.AnsweredQuestion;

import java.util.ArrayList;
import java.util.List;

class WrongAnswerAdapter extends ArrayAdapter<AnsweredQuestion> {

    private Context context;
    private List<AnsweredQuestion> answeredQuestions;

    WrongAnswerAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<AnsweredQuestion> answeredQuestions) {
        super(context, resource, answeredQuestions);
        this.context = context;
        this.answeredQuestions = answeredQuestions;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        AnsweredQuestion aq = answeredQuestions.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.wrong_answer_layout, null);//// FIXME: 4/10/2017 Research this one!

        TextView question = (TextView) view.findViewById(R.id.wrong_answer_question);
        TextView selectedAnswer = (TextView) view.findViewById(R.id.wrong_answer_selected_answer);
        TextView correctAnswer = (TextView) view.findViewById(R.id.wrong_answer_correct_answer);
        TextView explanation = (TextView) view.findViewById(R.id.wrong_answer_explanation);

        question.setText(aq.question.text);
        selectedAnswer.setText(aq.answer.text);
        String correctAnswerText = "";
        for (Answer a : aq.question.allAnswers) {
            if (a.isCorrect) {
                correctAnswerText = a.text;
                break;
            }
        }

        correctAnswer.setText(correctAnswerText);

        explanation.setText(aq.question.explanation);
        return view;

    }
}
