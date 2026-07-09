package com.bipin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcTest{
    Calculator c1 = new Calculator();
    @Test
    void testAddition(){
        assertEquals(4,c1.add(2,2));
    }

    @Test
    void testMultiplication(){
        assertEquals(10,c1.mul(5,2));
    }

    @Test
    void testSubtraction(){
        assertEquals(0,c1.sub(2,2));
    }

    @Test
    void testDivision(){
        assertEquals(5,c1.div(10,2));
    }
}
