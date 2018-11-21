package com.nicolae;

public abstract class Account implements IBaseRate {
    // List common properties for savings and checking accounts
    private String name;
    private String sSN; // social security number
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;


    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();
    }

    // Interface methods
    @Override
    public double getBaseRate() {
        return 2.5;
    }

    @Override
    public double setRate() {
        return rate;
    }

    private String setAccountNumber(){
        String lastTwoSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID= index;
        int randomNumber = (int) (Math.random()* Math.pow(10, 3));
        return lastTwoSSN + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    // List common methods - transaction
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void trasfer(String toWhere, double amount){
        balance -= amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo(){
        System.out.println(
                "NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance+
                "\nRATE: " + setRate() + "%"
        );
    }

}
