📘 Quiz Application – Spring Boot + Thymeleaf
    A simple and interactive Quiz Management System built using Spring Boot, Thymeleaf, and Spring Security.

This project includes:

**Admin login**
* Add / Edit / Delete quiz questions
* Take quiz as a user
* Evaluate score
* Show detailed results (correct/wrong answers)
* In-memory storage (no database required

⭐ **Features**
  🔐 **Authentication**
  * Login & Registration
  * In-memory users
  * Role-based access (ADMIN / USER)
  * Logout functionality
  🛠 **Admin Features**
  * Add new quiz questions
  * Edit existing questions
  * Delete questions
  * View all quiz items
  * 🎯 **User Features**
  * Take quiz with multiple-choice questions
  * Submit answers
  * Score calculation
  * Detailed result page with:
  * ✔ Correct answers (green)
  * ✘ Wrong answers (red)
  * 💡 **Technologies Used**
  * Spring Boot 3
  * Spring Security 6
  * Thymeleaf
  * HTML + CSS
  * Java Collections (Map, List)
  * Maven

📂 **Project Structure**
    src/
    ├── main/
    │   ├── java/com/example/quizApp/
    │   │   ├── controller/
    │   │   ├── model/
    │   │   ├── service/
    │   │   └── config/
    │   └── resources/
    │       ├── templates/
    │       │    ├── login.html
    │       │    ├── register.html
    │       │    ├── quizList.html
    │       │    ├── addQuiz.html
    │       │    ├── editQuiz.html
    │       │    ├── quiz.html
    │       │    └── result.html
    │       └── application.properties

🚀 **_How to Run the Project_**
    1. Clone the repository
       git clone https://github.com/Sabnish776/Quiz.git
       cd quizApp
    2. Run using Maven 
        -> mvn clean install
        -> mvn spring-boot:run
    3. Open in browser
       http://localhost:8080/login

🔑 **Default Admin User (You can add more users through Register)**
    username -> admin
    password -> admin

📝 **How Quiz Works**
* User selects quiz answers
* Submission is processed in backend
* Score is calculated
* Result page shows:
* Your answer
* Correct answer
* Color-coded correctness

🔒 **Security Configuration**
* Custom login page
* CSRF disabled for simplicity
* GET /logout enabled for logout button
* Redirects based on user role

All pages styled with clean CSS for a smooth user experience.

📄 License
This project is for educational purposes.
You may modify or use it freely.

🙌 Author
Sabnish Seetharaman 
B.Tech IT — Quiz Application Project