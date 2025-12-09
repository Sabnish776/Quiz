📘 Quiz Application – Spring Boot + Thymeleaf
    A simple and interactive Quiz Management System built using Spring Boot, Thymeleaf, and Spring Security.

This project includes:

**Admin login**
* Add / Edit / Delete quiz questions
* Take quiz as a user
* Evaluate score
* Show detailed results (correct/wrong answers)
* In-memory storage (no database required

 **Features**
 
**Authentication**
  * Login & Registration
  * In-memory users
  * Role-based access (ADMIN / USER)
  * Logout functionality
 
**Admin Features**
  * Add new quiz questions
  * Edit existing questions
  * Delete questions
  * View all quiz items

**User Features**
  * Take quiz with multiple-choice questions
  * Submit answers
  * Score calculation
  * Detailed result page with:
  * ✔ Correct answers (green)
  * ✘ Wrong answers (red)

**Technologies Used**
  * Spring Boot 3
  * Spring Security 6
  * Thymeleaf
  * HTML + CSS
  * Java Collections (Map, List)
  * Maven

**_How to Run the Project_**
* Clone the repository
   git clone https://github.com/Sabnish776/Quiz.git
   cd quizApp
* Run using Maven 
    -> mvn clean install
    -> mvn spring-boot:run
* Open in browser http://localhost:8080/login
* OR https://quizeyy.onrender.com -> hosted online 

**Default Admin User (You can add more users through Register)**
* username -> admin
* password -> admin

**How Quiz Works**
    * User selects quiz answers
    * Submission is processed in backend
    * Score is calculated
    * Result page shows:
    * Your answer
    * Correct answer
    * Color-coded correctness

**Security Configuration**
    * Custom login page
    * CSRF disabled for simplicity
    * GET /logout enabled for logout button
    * Redirects based on user role

**License**
* This project is for educational purposes.
* You may modify or use it freely.

**Author**
* Sabnish Seetharaman 
* B.Tech IT — Quiz Application Project
