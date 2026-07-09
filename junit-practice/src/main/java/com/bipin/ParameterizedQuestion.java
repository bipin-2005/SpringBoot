/*Question 2: Even or Odd

Create a method:

boolean isEven(int number)

Test it with:

        2
        5
        0
        -4*/

package com.bipin;

public class ParameterizedQuestion {
    boolean isEven(int num){
        if(num%2==0){
            return true;
        }
        else return false;
    }
}