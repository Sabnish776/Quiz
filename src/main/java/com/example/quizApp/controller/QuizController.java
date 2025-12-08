package com.example.quizApp.controller;

import com.example.quizApp.model.Question;
import com.example.quizApp.model.QuizSubmission;
import com.example.quizApp.model.Result;
import com.example.quizApp.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuizController {

    QuestionsService questionsService ;
    public QuizController(QuestionsService questionsService) {
        this.questionsService = questionsService ;
    }
    // admin Home page
    @GetMapping("/quizList")
    public String quizListPage(Model model) {
        model.addAttribute("questions", questionsService.loadQuiz()) ;
        return "quizList";
    }
    // Admin functionalities
    @GetMapping("/addQuiz")
    public String addQuizPage(Model model) {
        model.addAttribute("Question",new Question()) ;
        return "addQuiz";
    }
    @PostMapping("/addQuiz")
    public String addQuiz(@ModelAttribute("Question") Question question ) {
        try{
            questionsService.addQuiz(question);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "redirect:/quizList" ;
        }
        return "redirect:/quizList" ;
    }
    @GetMapping("/editQuiz/{id}")
    public String editQuizPage(@PathVariable int id , Model model) {
        List<Question> questions = questionsService.loadQuiz() ;
        Question question = null ;
        for(Question q : questions){
            if(q.getId() == id){
                question = q ;
                break ;
            }
        }
        if(question != null){
            model.addAttribute("Question" , question) ;
            return "editQuiz" ;
        }else{
            return "redirect:/quizList" ;
        }
    }
    @PostMapping("/editQuiz")
    public String editQuiz(@ModelAttribute("Question") Question question ) {
        questionsService.editQUiz(question);
        return "redirect:/quizList" ;
    }

    @GetMapping("/delete/{id}")
    public String deleteQuiz(@PathVariable int id) {
        questionsService.deleteQuiz(id);
        return "redirect:/quizList" ;
    }

    // User functionalities
    @GetMapping("/quiz")
    public String quizPage(Model model) {
        model.addAttribute("questions", questionsService.loadQuiz()) ;
        model.addAttribute("quizSubmission",new QuizSubmission()) ;
        return "quiz";
    }
    @PostMapping("/quiz")
    public String submitAnswers(@ModelAttribute("quizSubmission")QuizSubmission quizSubmission, Model model) {

        Map<Integer , Result> resultMap = new HashMap<>() ;
        int score = 0;
        // Process answers
        List<Question> questions = questionsService.loadQuiz() ;
        Map<Integer,String> answers = quizSubmission.getQuizAnswers() ;
        for(Question q : questions){
            String userAnswer = answers.get(q.getId()) ;
            String correctAnswer = q.getCorrectAnswer() ;
            if( userAnswer!=null && userAnswer.equals(correctAnswer)){
                resultMap.put(q.getId(),new Result(q.getId(), q.getQuestionText() ,userAnswer,correctAnswer,1)) ;
                score++ ;
            }else{
                resultMap.put(q.getId(),new Result(q.getId(),q.getQuestionText(),userAnswer,correctAnswer,0)) ;
            }
        }
        model.addAttribute("score",score) ;
        model.addAttribute("result",resultMap.values()) ;
        model.addAttribute("total",questionsService.loadQuiz().size()) ;
        return "result" ;
    }
}
