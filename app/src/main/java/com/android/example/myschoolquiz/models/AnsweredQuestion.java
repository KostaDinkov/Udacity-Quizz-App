package com.android.example.myschoolquiz.models;

public class AnsweredQuestion {
    public Question question;
    public Answer answer;

    AnsweredQuestion(Question question, Answer givenAnswer) {
        this.question = question;
        this.answer = givenAnswer;
    }
}
