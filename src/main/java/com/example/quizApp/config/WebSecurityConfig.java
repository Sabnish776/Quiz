package com.example.quizApp.config;

import com.example.quizApp.service.QuizUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final QuizUserDetailsService quizUserDetailsService ;

    public WebSecurityConfig(QuizUserDetailsService quizUserDetailsService) {
        this.quizUserDetailsService = quizUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authorize ->authorize
                .requestMatchers("/login", "/register").permitAll()
                .requestMatchers("/quizList").hasRole("ADMIN")
                .requestMatchers("/quiz", "/result").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                )
                .formLogin(form->form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true))
                .csrf(csrf->csrf.disable())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );
        return http.build()  ;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class) ;
        authenticationManagerBuilder
                .userDetailsService(quizUserDetailsService)
                .passwordEncoder(passwordEncoder()) ;
        return authenticationManagerBuilder.build() ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
