package com.bipin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Palindrometest{
    Palindrome original= new Palindrome();
    @Test
    void Test1(){
        assertTrue(original.isPalindrome("madam"));
    }
    @Test
    void Test2(){
        assertFalse(original.isPalindrome("racer"));
    }
    @Test
    void Test3(){
        assertFalse(original.isPalindrome("java"));
    }
    @Test
    void Test4(){
        assertTrue(original.isPalindrome("mom"));
    }

}