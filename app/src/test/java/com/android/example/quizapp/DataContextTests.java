package com.android.example.quizapp;

import com.android.example.quizapp.models.Quiz;
import com.android.example.quizapp.utils.Utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataContextTests {

    @Test
    public void getQuizFromJson_isCorrect() throws Exception {
        String quizJson = "{\"id\":1,\"name\":\"Basic Android UI Quiz\",\"description\":\"A simple quiz with some basic questions regarding the Android user interface\",\"questions\":[{\"points\":1,\"text\":\"What is a context in android ?\",\"explanation\":\"Some quick explanation\",\"selectedAnswers\":[],\"allAnswers\":[{\"text\":\"It is an interface to store global information about an application\",\"isCorrect\":false},{\"text\":\"It is used to create new components.\",\"isCorrect\":false},{\"text\":\"Android has two contexts, those are getContext() and getApplicationContext()\",\"isCorrect\":false},{\"text\":\"All of Above\",\"isCorrect\":true},{\"text\":\"None of Above\",\"isCorrect\":false}]},{\"points\":1,\"text\":\"How many threads are there in asyncTask in android?\",\"explanation\":\"Another simple explanation\",\"selectedAnswers\":[],\"allAnswers\":[{\"text\":\"Only one\",\"isCorrect\":true},{\"text\":\"Two\",\"isCorrect\":false},{\"text\":\"AsynTask doesn\\u0027t have tread\",\"isCorrect\":false},{\"text\":\"None of the Above\",\"isCorrect\":false}]}]}";
        Quiz quiz = Utils.getQuizFromJson(quizJson);

        assertNotNull(quiz);
        assertEquals(2, quiz.questions.size());
    }

//    @Test
//    public void quizToJson_isCorrect() throws Exception{
//        QuizData context = QuizData.getData();
//        Quiz quiz = context.quizzes.get(0);
//
//        String expected = "{\"id\":1,\"name\":\"Basic Android UI Quiz\",\"description\":\"A simple quiz with some basic questions regarding the Android user interface\",\"questions\":[{\"points\":1,\"text\":\"What is a context in android ?\",\"explanation\":\"Some quick explanation\",\"selectedAnswers\":[],\"allAnswers\":[{\"text\":\"It is an interface to store global information about an application\",\"isCorrect\":false},{\"text\":\"It is used to create new components.\",\"isCorrect\":false},{\"text\":\"Android has two contexts, those are getContext() and getApplicationContext()\",\"isCorrect\":false},{\"text\":\"All of Above\",\"isCorrect\":true},{\"text\":\"None of Above\",\"isCorrect\":false}]},{\"points\":1,\"text\":\"How many threads are there in asyncTask in android?\",\"explanation\":\"Another simple explanation\",\"selectedAnswers\":[],\"allAnswers\":[{\"text\":\"Only one\",\"isCorrect\":true},{\"text\":\"Two\",\"isCorrect\":false},{\"text\":\"AsynTask doesn\\u0027t have tread\",\"isCorrect\":false},{\"text\":\"None of the Above\",\"isCorrect\":false}]}]}";
//
//        String quizJson = QuizData.quizToJson(quiz);
//        assertEquals(expected,quizJson);
//    }

}
