package org.example;

public class SavingsAccount extends BankAccount{
//    public SavingsAccount(String accn, double balance) {
//        super(accn, balance);
//    }


    public SavingsAccount(String accountType, String accn, double balance) {
        super(accountType, accn, balance);
    }

    @Override
    public void withdraw() {
        if (super.getBalance()>100){

        }
    }
}
