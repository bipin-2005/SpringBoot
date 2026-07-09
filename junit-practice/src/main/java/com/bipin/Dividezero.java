/*Question 7: Division Exception
Calculator:
divide(int a, int b)
If divisor is zero:
Throw
ArithmeticException
Write a JUnit test using:

assertThrows()*/

package com.bipin;
public class Dividezero{
        int divide(int num1,int num2) {
                return num1 / num2;
        }
}