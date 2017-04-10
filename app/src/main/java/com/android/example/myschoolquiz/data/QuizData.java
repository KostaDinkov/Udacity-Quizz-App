package com.android.example.myschoolquiz.data;

import android.content.res.AssetManager;

import com.android.example.myschoolquiz.models.App;
import com.android.example.myschoolquiz.models.Quiz;
import com.android.example.myschoolquiz.utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuizData {

    private static QuizData data;
    public ArrayList<Quiz> quizzes;

    private QuizData() {
        this.quizzes = new ArrayList<>();
    }

    public static QuizData getData() {

        if (data != null) {
            return data;
        }
        data = new QuizData();
        data.loadQuizData();
        return data;
    }

    private void loadQuizData() {

        AssetManager am = App.get().getAssets();

        try {
            String[] allQuizzes = am.list("");

            for (String file : allQuizzes) {
                if (!file.contains(".json")) continue;
                BufferedReader r = new BufferedReader(new InputStreamReader(am.open(file)));
                StringBuilder quizJson = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    quizJson.append(line).append('\n');
                }

                quizzes.add(Utils.getQuizFromJson(quizJson.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
