/*Question 5: Bank Account

Create:

deposit()

withdraw()

getBalance()

Before every test create a BankAccount with ₹1000.

Write tests for:
Deposit
Withdraw
Balance*/

package com.bipin;
public class BankAcc{
    double current_balance = 0;
    double deposit(double amt){
        current_balance+=amt;
        return current_balance;
    }

    double withdraw(double amt){
        current_balance-=amt;
        return current_balance;
    }

    double getbalance(){
        return current_balance;
    }
}