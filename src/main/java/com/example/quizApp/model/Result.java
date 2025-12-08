package com.example.quizApp.model;

public class Result {
    int id ;
    String question ;
    String userAnswer ;
    String correctAnswer ;
    int correct ;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Result(int id, String question ,String userAnswer, String correctAnswer , int ans) {
        this.id = id;
        this.question = question ;
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
        this.correct = ans ;
    }
}
