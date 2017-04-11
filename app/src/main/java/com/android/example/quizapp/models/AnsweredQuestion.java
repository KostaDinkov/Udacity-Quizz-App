package com.android.example.quizapp.models;

public class AnsweredQuestion {
    public Question question;
    public Answer answer;

    AnsweredQuestion(Question question, Answer givenAnswer) {
        this.question = question;
        this.answer = givenAnswer;
    }
}
