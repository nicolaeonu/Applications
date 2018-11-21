package com.nicolae;

public class BankAccountApp {

    public static void main(String[] args) {



        Checking chckacc1 = new Checking("Nico Onu", "123456789",1500);

        Savings savacc1 = new Savings("Andrei Onu", "987654321", 2500);

        chckacc1.showInfo();

        System.out.println("============================");

        savacc1.showInfo();

        System.out.println("============================");

        savacc1.compound();

    }
}
