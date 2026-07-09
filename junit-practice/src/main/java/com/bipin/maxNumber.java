/*Question 3: Maximum Number

Create:

int findMax(int a, int b)

Test cases:

(10, 20)
(50, 10)
(-5, -10)*/

package com.bipin;
public class maxNumber{
    int findMax(int num1,int num2){
        if(num1 > num2 ){
            return num1;
        }
        else return num2;
    }
}