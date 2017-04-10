package com.android.example.myschoolquiz.models;

import java.util.ArrayList;

public class QuizSummary {

    private static ArrayList<AnsweredQuestion> results = new ArrayList<>();

    public static void addResult(Question question, Answer answer) {

        results.add(new AnsweredQuestion(question, answer));
    }

    public static ArrayList<AnsweredQuestion> getResults() {
        return results;
    }

    public static void Clear() {
        results.clear();
    }

}
