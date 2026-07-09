/*Question 4: Palindrome

Create:

boolean isPalindrome(String word)

Test with:

madam
racecar
hello
java*/

package com.bipin;
public class Palindrome{
    boolean isPalindrome(String original){
        String reversed = new StringBuilder(original).reverse().toString();
        if(original.equals(reversed))
            return true;
        else
            return false;
    }
}