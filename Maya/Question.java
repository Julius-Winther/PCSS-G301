package com.example.javafxtest;

import javafx.beans.property.SimpleStringProperty;


public class Question {
    private SimpleStringProperty questionText;


    public Question(String questionText) {
        this.questionText = new SimpleStringProperty(questionText);

    }

    
    public String getQuestionText() {
        return questionText.get();
    }

    public void setQuestionText(String firstName) {
        this.questionText = new SimpleStringProperty(firstName);
    }

    public String toString()
    {
        return String.format("", questionText);
    }
}
