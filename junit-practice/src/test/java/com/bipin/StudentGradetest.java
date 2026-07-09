package com.bipin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentGradetest{
    Student s1= new Student();
    @Test
    void studentTest1(){
        s1.setMarks(90);
        assertEquals("A",s1.getGrade());
    }
    @Test
    void studentTest2(){
        s1.setMarks(80);
        assertEquals("B",s1.getGrade());
    }
    @Test
    void studentTest3(){
        s1.setMarks(70);
        assertEquals("C",s1.getGrade());
    }
    @Test
    void studentTest4(){
        s1.setMarks(0);
        assertEquals("F",s1.getGrade());
    }

}