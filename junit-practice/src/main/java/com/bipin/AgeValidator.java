/*Question 8: Age Validator
Create:
validateAge(int age)
If age < 18
Throw
IllegalArgumentException
Test both valid and invalid ages.*/

package com.bipin;
public class AgeValidator{
        int validate(int age){
                if(age < 18) {
                        throw new IllegalArgumentException("Age else than 18");
                }
               return age;
        }
}