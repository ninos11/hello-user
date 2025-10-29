# hello-user - Spring Boot member management system

Web-based application for managing members of Assyriska Föreningen (The Assyrian Association), written in Java with Spring Boot and Thymeleaf.
There is an admin user who can log in and manage members.

Admin can log in, add and remove members. All visitors can view the member list.

**Admin user:**
- Username: admin
- Password: admin


## Features

* User login with username and password (admin/admin).
* Menu/Navigation bar includes:
     - Home page (open to everyone)
     - View all members (open to everyone)
     - Add member (admin only)
     - Remove member (admin only, via X button)
     - Logout (turn of session)
     - Login
* Internal storage in Java list (members saved as objects on server-side).
* Session authentication with unique token (saved in HttpSession).
* Input validation (required fields in forms, server-side check of admin session).

### Installation

* Requirements
     <------ No external dependencies except: ------>
     - Java 17 or later (any modern JDK will work)
     - Maven

* Compile and Run
     1. Clone down my repo.
     2. Open your terminal "cmd" or PowerShell.
     3. Make sure you are in the correct folder!
        - You can change folder in the terminal with this command:
          cd "your folder link ex. your folder link "C:\Users\your_name\Desktop\Projekter\hello-user"
     4. When you are sure you are in the correct folder, run this command to start the application:
          .\mvnw spring-boot:run
     5. Open web browser at http://localhost:8080

* Usage Example

     <=== Home Page (/) ===>
        - Welcome to Assyriska Föreningen
        - Navigation: View our members | Add member (admin) | Login

        Click "Login"

     <=== Login (/login) ===>
        Username: admin
        Password: admin
        
        [Login]

     <=== Menu (navbar) ===>
        - View our members
        - Add member (visible after login)
        - Logout

        Click "Add member"

     <=== Form (/addmembers) ===>
        First name: Ninos
        Last name: Chimon
        Email: ninos@example.com
        Phone: 0701234567
        Birth date: 1990-01-01
        Role: member

        [Save member]

        Member saved!

     <=== Member List (/members) ===>
        | First name | Last name | Email | Phone | Role | Actions |
        | Ninos   | Chimon    | ninos@example.com | 0701234567 | member | X (only visible for admin) |

        Click X → member removed

#### Challenge tasks I chose (VG requirements)

* Selected tasks
     1. Admin login – admin can log in with username "admin" and password "admin".
     2. Session persistence – logged in admin is saved in server-side session, so login persists across page navigation.
     3. Role-based access – everyone can view members, but only admin can add and remove.

* Why I chose these?
     1. I wanted the application to feel more like a real management system with authentication.
     2. Session-based authentication provides better security than client-side storage.
     3. Role-based access makes the system more secure and practical.

* How I implemented them?
     1. AuthController (Java) handles POST /login and validates username/password.
     2. On successful login, HttpSession is created with attributes username and a unique userToken (UUID).
     3. All protected endpoints (addmembers, remove-member) check session.username == 'admin' (server-side).
     4. Thymeleaf templates (members.html, addmembers.html) show admin functions only if ${session.username == 'admin'}.
     5. Logout invalidates the session and redirects to home page.


* Reflection
     - Implementing server-side session authentication taught me the importance of keeping security on the server.
       By storing all authentication logic in Java and using HttpSession, the system is more secure than client-side alternatives.

##### Developmental Proposals for the Future

* Password Change
     - Admin should be able to update their password and use the new one for subsequent logins.

* Database Storage
     - Switch from in-memory list to database (e.g. H2, PostgreSQL) so members are saved permanently.

* Transaction History
     - Create a simple log that stores date and type of operation (add, remove) and show history for admin.

* Edit Function
     - Add ability to edit existing members (modal or separate page).


###### Contributing

1. Submit changes
     - Create new repo in your GitHub account.
     - Create a new branch (with feature name)
     - Make your changes
     - Commit (with clear comment) and push
     - Create a pull request and merge it.

2. Code style
     - Use clear and consistent naming for classes, methods and variables.
     - Create separate methods for each function to avoid DRY (Don't Repeat Yourself).
       Write comments for each method to explain what the method does!

3. Testing
     - Run the code and make sure everything works before you push to GitHub!
     - Test login, add member, remove member and session persistence in the browser.

4. Issues and Contact
     - Create new issues for each branch to explain what you want to change or create.
     - Report bugs by opening an issue in your repo.
     - For questions, feel free to contact me:
          - Name: Ninos Chimon
          - Email: Ninos.nina@hotmail.com

###### Good luck!