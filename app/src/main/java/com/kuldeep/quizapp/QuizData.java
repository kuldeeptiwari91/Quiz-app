package com.kuldeep.quizapp;


import java.util.ArrayList;
import java.util.List;

public class QuizData {
    public static List<Question> getJavaQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What is the purpose of the 'public' keyword in a Java class?",
                "A. To specify the class can only be accessed from within its own package.",
                "B. To define a class as public so that it can be accessed from any package.",
                "C. To indicate that the class is final and cannot be extended.",
                "D. To declare a variable that can be accessed throughout the program.",
                "B"));

        questions.add(new Question(
                "Which keyword is used to create an instance of a class in Java?",
                "A. new",
                "B. this",
                "C. class",
                "D. object",
                "A"));

        questions.add(new Question(
                "What is the correct way to declare a constant in Java?",
                "A. final constantName = value;",
                "B. constant constantName = value;",
                "C. const constantName = value;",
                "D. final int constantName = value;",
                "D"));

        questions.add(new Question(
                "In Java, which of the following is NOT a primitive data type?",
                "A. int",
                "B. float",
                "C. string",
                "D. boolean",
                "C"));

        questions.add(new Question(
                "What is the default value of a boolean variable in Java?",
                "A. true",
                "B. false",
                "C. 0",
                "D. 1",
                "B"));

        questions.add(new Question(
                "Which Java keyword is used for inheritance?",
                "A. extends",
                "B. implements",
                "C. inherits",
                "D. derives",
                "A"));

        questions.add(new Question(
                "What does the 'static' keyword mean in Java?",
                "A. The variable or method belongs to the class rather than instances of the class.",
                "B. The variable or method can only be accessed from within the same package.",
                "C. The variable or method can be modified by multiple threads simultaneously.",
                "D. The variable or method is dynamic and can change its value during runtime.",
                "A"));

        questions.add(new Question(
                "Which of the following is used to prevent method overriding in Java?",
                "A. final",
                "B. static",
                "C. abstract",
                "D. public",
                "A"));

        questions.add(new Question(
                "What is the Java virtual machine (JVM)?",
                "A. A program used for debugging Java code.",
                "B. A tool for compiling Java source code.",
                "C. A runtime environment that executes Java bytecode.",
                "D. A code analysis tool for Java applications.",
                "C"));

        questions.add(new Question(
                "Which data structure is used to implement a stack in Java?",
                "A. ArrayList",
                "B. LinkedList",
                "C. Array",
                "D. HashMap",
                "B"));

        return questions;
    }
}


