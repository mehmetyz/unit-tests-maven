package com.example.test;

import java.util.Stack;

public class Application {

    private final Stack<Student> listOfStudent;

    public Application(){
        this.listOfStudent = new Stack<>();
    }


    public void addStudent(String name, String surname, double grade)
    {
        this.listOfStudent.add(new Student(
                name,
                surname,
                grade
        ));
    }

    public void removeStudent(String name, String surname)
    {

        Student student = null;

        for (Student s : this.listOfStudent)
            if(s.getName().equals(name) && s.getSurname().equals(surname))
                student = s;


        listOfStudent.remove(student);
    }

    public Stack<Student> getStudents(String name,String surname)
    {

        Stack<Student> n = new Stack<>();
        listOfStudent.forEach(x -> {
            if(x.getName().equals(name) && (x.getSurname().equals(surname.isEmpty() ? x.getSurname() : surname)))
                n.add(x);
        });

        return n;
    }
    public Stack<Student> getStudentsByGradeEquals(double grade)
    {

        Stack<Student> n = new Stack<>();
        listOfStudent.forEach(x -> {
            if(x.getGrade() == grade)
                n.add(x);
        });

        return n;
    }

    public Stack<Student> getStudentsByGradeIsMore(double grade)
    {

        Stack<Student> n = new Stack<>();
        listOfStudent.forEach(x -> {
            if(x.getGrade() > grade)
                n.add(x);
        });

        return n;
    }

    public Stack<Student> getStudentsByGradeIsLess(double grade)
    {

        Stack<Student> n = new Stack<>();
        listOfStudent.forEach(x -> {
            if(x.getGrade() < grade)
                n.add(x);
        });

        return n;
    }

    public void printStack() {

        System.out.println();
        System.out.println();

        System.out.println("-------------STACK PRINTING--------");
        for (Student s : this.listOfStudent) {
            System.out.print("\tName: " + s.getName() + "\t");
            System.out.println("Surname: " + s.getSurname());
        }
    }

    public boolean pop()
    {
        this.listOfStudent.pop();
        return !this.listOfStudent.isEmpty();
    }

}
