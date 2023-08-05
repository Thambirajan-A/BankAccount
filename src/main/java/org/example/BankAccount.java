package org.example;

public class BankAccount {
    private String accn;
    private double balance;
    private String accountType;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void deposit(){

    }
    public void withdraw(){


    }
//    public BankAccount(String accn, double balance) {
//        accn = accn;
//        this.balance = balance;
//    }


    public BankAccount(String accountType, String accn, double balance) {
        this.accn = accn;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccn() {
        return accn;
    }

    public void setAccn(String accn) {
        accn = accn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
