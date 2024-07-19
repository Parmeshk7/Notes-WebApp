# Notes App

### Objective
The objective of this assignment is to develop a user-friendly application for note-taking, catering to the storage needs of different users. This application should ensure data security, user access control, and efficient management of notes. Users will be able to log in, create notes with specific character limitations, delete their notes, and retrieve their most recent notes. Additionally, the system should automatically purge notes that are not part of the user's latest 10 notes on an hourly basis. This project emphasizes data validation, security, and a seamless user experience while maintaining data integrity and performance.

### Implementation
This project has been implemented using Angular for the front-end and Spring Boot for the back-end, with the integration of JSON Web Tokens (JWT) for enhanced security. The Angular front-end provides a user-friendly interface for logging in, creating notes, viewing recent notes, and deleting notes. The Spring Boot back-end serves as the API, handling user authentication, note storage, and note management. JWT tokens are used to secure the communication between the front-end and back-end, ensuring data privacy and access control. The system also enforces strict data validation rules, limiting notes to 500 characters and allowing only specific special characters. Additionally, an automated process runs hourly to purge old notes, keeping the user's latest 10 notes intact. This implementation combines robust security measures with a seamless user experience for efficient note management.


### Steps to Run the Application

1. Clone the repository.
2. Open Terminal window in root folder. And run command ```cd notesapp``` to move to backend folder.
3. Now run command **```mvn clean package```** to create jar file in the **target** folder.
4. The jar file is created in target folder of notesapp. Run command **```cd target```** to move to the target folder.
5. Before starting backend server create a database in MySQL named **```notesapp```**
6. Run command java **```-jar <Jar-file-name>.jar```**. Now your backend server is running on http://localhost:8081
7. Now open another CMD window in the notesapp **frontend folder**.
8. Run the command **```npm install```** to install all the required packages and dependencies.
9. After completion of installation Run command **```ng serve -o```** this will start the frontend server and the website will be opened in the browser at http://localhost:4200





