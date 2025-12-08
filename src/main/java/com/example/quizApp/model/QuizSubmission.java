package com.example.quizApp.model;

import java.util.HashMap;
import java.util.Map;

public class QuizSubmission {
    private  Map<Integer , String > quizAnswers ;
    public  QuizSubmission(){
        quizAnswers = new HashMap<>() ;
    }
    public Map<Integer,String> getQuizAnswers(){
        return quizAnswers ;
    }
    public void setQuizAnswers(Map<Integer, String> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }
}
