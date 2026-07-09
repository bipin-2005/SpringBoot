package com.bipin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Dividezerotest{
    Dividezero c1= new Dividezero();
    @Test
    void test1(){
        assertThrows(ArithmeticException.class,()->c1.divide(10,0));
    }
}