/*Question 6: Student Grade

Create a Student class.

Methods:

setName()

setMarks()

getGrade()*/

package com.bipin;
public class Student{
    float marks;
    String name;
    void setMarks(float marks){
        this.marks=marks;
    }
    void setName(String name){
        this.name=name;

    }
    String getGrade(){
        if(marks>=90) return "A";
        else if(marks>=80) return "B";
        else if(marks>=70) return "C";
        else if(marks>=60) return "D";
        else return "F";
    }
}