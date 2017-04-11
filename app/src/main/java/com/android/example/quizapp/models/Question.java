package com.android.example.quizapp.models;

import java.util.ArrayList;

public class Question {

    public String text;
    public String explanation;
    public ArrayList<Answer> allAnswers;

    public Question(String text) {

        this.text = text;
        this.allAnswers = new ArrayList<>();
    }
}
