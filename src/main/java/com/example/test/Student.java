package com.example.test;

public class Student {



    private String name;
    private String surname;
    private double grade;



    public Student(String name, String surname, double grade) {
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGrade(double grade) {
        if(grade < 0 || grade > 100)
            return;


        this.grade = grade;
    }
}
