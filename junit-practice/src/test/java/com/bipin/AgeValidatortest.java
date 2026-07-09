package com.bipin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeValidatortest{
    AgeValidator age= new AgeValidator();

    @Test
    void testunderage(){
        assertThrows(IllegalArgumentException.class,()->age.validate(17));
    }
    @Test
    void testage(){
        assertEquals(20,age.validate(20));
    }
}