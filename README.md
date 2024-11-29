# 🍴 Culinary Academy System  

### Revolutionizing Culinary Education Management in Sri Lanka  

---

## 🌟 Project Overview  
The **Culinary Academy System** is a cutting-edge digital platform designed to streamline and modernize the operations of a renowned culinary institution in Sri Lanka. By replacing the traditional manual methods, this system ensures efficient student registration, course management, and secure access control.  

---

## ✨ Features  

- **👩‍🎓 Student Management**  
  Add, update, delete, and view student details effortlessly.  

- **📘 Program Management**  
  Handle course information, including details like program duration and fees.  

- **🔒 Secure Authentication**  
  - Passwords encrypted using **BCrypt** for enhanced security.  
  - Role-based access for admins and coordinators.  

- **🧑‍🍳 Multi-Program Enrollment**  
  Allow students to enroll in multiple programs concurrently.  

- **🔗 Relationship Management**  
  - One-to-Many and Many-to-Many relationships via Hibernate ORM.  
  - Automatic cascade operations.  

- **🛠️ Exception Handling**  
  Custom error handling for smooth system operation.  

- **✔️ Validation**  
  Robust validation for user inputs (e.g., email, phone number) using **RegEx**.  

---

## 🛠️ Tech Stack  

| Component           | Technology             |  
|----------------------|------------------------|  
| **Backend**          | Java                  |  
| **ORM Framework**    | Hibernate             |  
| **Database**         | Hibernate Configured  |  
| **Frontend**         | JavaFX (if applicable)|  
| **Encryption**       | BCrypt                |  

---

## ⚙️ Installation  

1. **Clone the Repository**  
   ```bash  
   git clone (https://github.com/AchiniPramo/Culinary_Academy_System.git)
   cd Culinary_Academy_System  
   ```  

2. **Configure the Database**  
   - Add your database connection details in the `hibernate.cfg.xml` file.  
   - Ensure the database server is running.  

3. **Build the Project**  
   Use a build tool like **Maven** to compile the project:  
   ```bash  
   mvn clean install  
   ```  

4. **Run the Application**  
   Execute the main launcher file:  
   ```bash  
   java -jar target/Culinary_Academy_System.jar  
   ```  

---

## 📖 Usage  

1. **Login**  
   - Admin and Coordinator roles supported.  
   - Option to view or change passwords securely.  

2. **Student Registration**  
   - Add personal details, selected programs, and upfront payment info.  

3. **Program Enrollment**  
   - Students can choose multiple programs such as **Professional Cooking** or **Baking & Pastry Arts**.  

4. **Administrative Features**  
   - Manage students and courses.  
   - View details of enrolled students.  

---

## 🏗️ System Design  

- **Layered Architecture**  
  - **Controller Layer**: Handles user inputs.  
  - **Service Layer**: Implements business logic.  
  - **Data Access Layer**: Manages database interactions via Hibernate.  

- **Database Relationships**  
  - **One-to-Many**: Students and Courses.  
  - **Many-to-Many**: Program enrollments.  

---

## 🔐 Security  

- Passwords are encrypted with **BCrypt** for secure storage.  
- Role-based access control ensures restricted functionalities.  

---

## 🎯 Future Enhancements  

- Add reporting tools for analyzing student progress.  
- Enhance the UI with modern JavaFX designs.  
- Integrate payment gateways for fee transactions.  

---

## 📬 Contact  

For any queries, feel free to reach out:  
**Project Owner**: [Achini Pramodhya]  
**Email**: achinipramodhya4@gmail.com  

---  

Feel free to modify and include additional details as needed! 🎉
