package com.example.quizApp.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.quizApp.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionsService {
    private final Map<Integer , Question> questionsMap= new HashMap<>() ;
    {
        questionsMap.put(1, new Question(
                1,
                "Which is the first satellite launched by India?",
                new ArrayList<>(List.of("Aryabhata", "Bhaskara", "Rohini", "INSAT-1A")),
                "Aryabhata"
        ));

        questionsMap.put(2, new Question(
                2,
                "Which Indian mission successfully reached Mars in 2014?",
                new ArrayList<>(List.of("Chandrayaan-1", "Chandrayaan-2", "Mangalyaan", "NISAR")),
                "Mangalyaan"
        ));

        questionsMap.put(3, new Question(
                3,
                "What is the name of India’s first lunar mission?",
                new ArrayList<>(List.of("Chandrayaan-1", "Gaganyaan", "Rover-1", "Vikram")),
                "Chandrayaan-1"
        ));

        questionsMap.put(4, new Question(
                4,
                "Which launch vehicle is known as ISRO’s workhorse?",
                new ArrayList<>(List.of("PSLV", "GSLV Mk-III", "SSLV", "Vikas")),
                "PSLV"
        ));

        questionsMap.put(5, new Question(
                5,
                "What is the name of India’s human spaceflight program?",
                new ArrayList<>(List.of("Gaganyaan", "Vikram", "Aditya-L1", "Matsya")),
                "Gaganyaan"
        ));

        questionsMap.put(6, new Question(
                6,
                "Aditya-L1 mission is related to studying which celestial body?",
                new ArrayList<>(List.of("Moon", "Sun", "Mars", "Venus")),
                "Sun"
        ));

        questionsMap.put(7, new Question(
                7,
                "Which ISRO rocket placed Chandrayaan-3 into orbit?",
                new ArrayList<>(List.of("PSLV-C55", "GSLV F13", "LVM3 M4", "ASLV")),
                "LVM3 M4"
        ));

        questionsMap.put(8, new Question(
                8,
                "Which Indian scientist is known as the Father of the Indian Space Program?",
                new ArrayList<>(List.of("APJ Abdul Kalam", "Vikram Sarabhai", "Satish Dhawan", "K. Sivan")),
                "Vikram Sarabhai"
        ));

        questionsMap.put(9, new Question(
                9,
                "Which ISRO mission was India’s first interplanetary mission?",
                new ArrayList<>(List.of("Chandrayaan-1", "Mangalyaan", "Shukrayaan", "Aditya-L1")),
                "Mangalyaan"
        ));

        questionsMap.put(10, new Question(
                10,
                "Where is the ISRO headquarters located?",
                new ArrayList<>(List.of("Hyderabad", "Chennai", "Bengaluru", "Thiruvananthapuram")),
                "Bengaluru"
        ));
    }

    public List<Question> loadQuiz(){
        return new ArrayList<>(questionsMap.values()) ;
    }
    public void addQuiz(Question question) throws Exception{
        int id = question.getId() ;
        if(!questionsMap.containsKey(id)){
            questionsMap.put(question.getId() , question) ;
        }else{
            throw new Exception("Question Id must be unique");
        }
    }
    public void deleteQuiz(int id){
        questionsMap.remove(id) ;
    }
    public void editQUiz(Question question){
        questionsMap.put(question.getId() , question) ;
    }
}
