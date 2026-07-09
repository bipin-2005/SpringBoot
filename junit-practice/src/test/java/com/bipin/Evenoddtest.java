package com.bipin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class Evenoddtest{
    Evenodd c1= new Evenodd();

    @Test
    void TestEvenPositive(){
        assertTrue(c1.isEven(2));
    }
    @Test
    void TestOddPositive(){
        assertFalse(c1.isEven(5));
    }
    @Test
    void TestZeroPositive(){
        assertTrue(c1.isEven(0));
    }
    @Test
    void TestNegativePositive(){
        assertTrue(c1.isEven(-4));
    }
}