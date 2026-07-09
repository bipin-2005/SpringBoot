package com.bipin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class Parameterizedtest{
ParameterizedQuestion c1= new ParameterizedQuestion();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void TestEvenPositive(int num){
        assertTrue(c1.isEven(num));
    }
}

//mvn -Dtest=Parameterizedtest test
