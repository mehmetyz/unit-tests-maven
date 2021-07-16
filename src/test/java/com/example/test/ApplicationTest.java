package com.example.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest {
    static Application app = new Application();


    @BeforeAll
    public static void beforeAll()
    {
        app.addStudent("Mehmet", "Yıldız", 100);
        app.addStudent("Ahmet", "İçin", 85);
        app.addStudent("Baturalp", "Kaya", 70);
        app.addStudent("Elif", "Akın", 80);
        app.addStudent("Özgür", "Kulen", 45);
        app.addStudent("Ahmet", "Kara", 33);
        app.addStudent("Mehmet", "Çetin", 60);
    }


    @Test
    @DisplayName("Adding student test method")
    public void addStudentTest(){
        app.addStudent("Alihan","Toktamış",85);
        Assertions.assertFalse(app.getStudents("Alihan","Toktamış").empty());

    }


    @Test
    @DisabledOnOs(value = OS.WINDOWS)
    public void getStudentTest()
    {
        Assertions.assertFalse(app.getStudents("Mehmet","").empty());
    }

    @Test
    public void removeStudentTest()
    {
        app.removeStudent("Elif","Akın");
        Assertions.assertTrue(app.getStudents("Elif","Akın").empty());
    }

    @Test
    public void hasGradesMoreThan70()
    {
        Assertions.assertFalse(app.getStudentsByGradeIsMore(70).empty());
    }

    @Test
    public void hasGradesLessThan70()
    {
        Assertions.assertFalse(app.getStudentsByGradeIsLess(70).empty());
    }

    @Test
    public void hasGradesLessThan30()
    {
        Assertions.assertFalse(app.getStudentsByGradeIsLess(30).empty());
    }

    @AfterEach
    public void print()
    {
    }

    @RepeatedTest(value = 5)
    @DisplayName("Repated Test Demo")
    public void repeatedTest()
    {
        Assertions.assertTrue(app.pop());
    }


    @ParameterizedTest
    @ValueSource( doubles = {100.0,70.0,80.0,30.0 } )
    public void parameterizedTest(double index)
    {
        Assertions.assertFalse(app.getStudentsByGradeEquals(index).empty());
    }


    @ParameterizedTest
    @MethodSource("testValues")
    public void parameterizedTestMethod(double index)
    {
        Assertions.assertFalse(app.getStudentsByGradeEquals(index).empty());
    }

    private static double[] testValues(){

        return new double[] {
            100.0,70.0,80.0,30.0
        };
    }


    @ParameterizedTest
    @CsvSource({"100.0","70.0","80.0","30.0"})
    public  void parameterizedCsvDemo(String index)
    {
        Assertions.assertFalse(app.getStudentsByGradeEquals(Double.parseDouble(index.trim())).empty());
    }


    @ParameterizedTest
    @CsvFileSource(resources =  "/data.csv")
    public void parameterizedCsvFileDemo(String index)
    {
        Assertions.assertFalse(app.getStudentsByGradeEquals(Double.parseDouble(index.trim())).empty());
    }

    @AfterAll
    public static void afterAll()
    {
        app.printStack();
    }

}
