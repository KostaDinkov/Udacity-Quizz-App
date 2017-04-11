package com.android.example.quizapp.models;

import java.util.ArrayList;

public class Quiz {

    private static int idCounter = 1;
    public String name;
    public String description;
    public ArrayList<Question> questions;
    private int id;

    public Quiz(String name) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.questions = new ArrayList<>();

    }

    public int getId() {
        return id;
    }
}

