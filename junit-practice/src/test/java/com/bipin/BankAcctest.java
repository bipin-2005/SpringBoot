package com.bipin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAcctest{
    BankAcc account;
    @BeforeEach
    void setup(){
        account= new BankAcc();
        account.current_balance=1000;
    }

    @Test
    void deposittest(){
        assertEquals(3000,account.deposit(2000));
    }

    @Test
    void withdrawtest(){
        assertEquals(-1000,account.withdraw(2000));
    }

    @Test
    void balancetest(){
        assertEquals(1000,account.getbalance());
    }

}
