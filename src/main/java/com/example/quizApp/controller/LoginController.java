package com.example.quizApp.controller;
//Implement a controller that handles these API requests:
//
//GET request for retrieving the login page
//GET request for retrieving the registration page
//POST request for registering user


import com.example.quizApp.service.QuestionsService;
import com.example.quizApp.service.QuizUserDetailsService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    QuestionsService questionsService ;
    QuizUserDetailsService quizUserDetailsService ;
    AuthenticationManager authenticationManager ;
    public LoginController(QuestionsService questionsService , QuizUserDetailsService quizUserDetailsService , AuthenticationManager authenticationManager) {
        this.questionsService = questionsService ;
        this.quizUserDetailsService = quizUserDetailsService ;
        this.authenticationManager = authenticationManager ;
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication()  ;
        if(authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken){
            return "redirect:/login" ;
        }
        String username = authentication.getName() ;
        model.addAttribute("username", username) ;
        String role = authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER") ;
        if(role.equals("ROLE_ADMIN")){
            return "redirect:/quizList" ;
        }else {
            return "redirect:/quiz";
        }
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username , @RequestParam String email , @RequestParam String password , @RequestParam String role
        ) {
        try{
            quizUserDetailsService.registerUsers(username,email,password,role) ;
        }catch (Exception e){
            System.out.println(e.getMessage()) ;
            return "redirect:/register?error";
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        ) ;
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/login?success";
    }

}
