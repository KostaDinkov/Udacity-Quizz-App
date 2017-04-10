package com.android.example.myschoolquiz.utils;

import com.android.example.myschoolquiz.models.Quiz;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Utils {

    public static String quizToJson(Quiz quiz) {

        Gson gson = new Gson();
        return gson.toJson(quiz);
    }

    public static Quiz getQuizFromJson(String json) {

        Gson gson = new Gson();
        return gson.fromJson(json, Quiz.class);
    }

    public static Quiz findQuizById(int id, ArrayList<Quiz> quizCollection) {

        for (Quiz q : quizCollection) {
            if (q.getId() == id) {
                return q;
            }
        }
        return null;

    }
}
