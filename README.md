# 📚 Library Management System (Java)

## 📌 Description
The Library Management System is a simple Java console-based application developed as part of the Syntecxhub Internship Program.  
It allows users to manage books in a library through a menu-driven command-line interface.

## ✨ Features
- Add new books
- Remove books using Book ID
- Search books by title
- View all available books
- User-friendly CLI interface
- Input validation and error handling

## 🛠️ Technologies Used
- Java
- Core Java concepts
- Collections (ArrayList)

## 📂 Project Structure
Book.java → Book class
Library.java → Library operations
Main.java → Main program (menu-driven)

## 📁 File Handling
This application uses file handling to store book records permanently in a text file named `books.txt`.

- The file is created automatically when the program is executed for the first time.
- Book data is saved whenever a book is added or removed.
- Data is automatically loaded from the file when the program starts.
- The `books.txt` file is not included in the repository as it is generated at runtime.

## ▶️ How to Run the Project
1. Make sure Java is installed on your system.
2. Open terminal or command prompt in the project directory.
3. Compile the files:
javac Book.java Library.java Main.java
4. Run the program:
java Main

## 🎯 Learning Outcomes
- Understanding Object-Oriented Programming (OOP)
- Working with collections in Java
- Handling user input and exceptions
- Building real-world CLI applications

## 👨‍💻 Author
**Pranith Goud**

## 📌 Internship
This project is developed as part of the **Syntecxhub Internship Program**.
