package com.bipin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class maxNumbertest{
    maxNumber max= new maxNumber();
    @Test
    void maxNumber(){
        assertEquals(20,max.findMax(10,20));
        assertEquals(50,max.findMax(50,10));
        assertEquals(-5,max.findMax(-5,-10));
    }

}