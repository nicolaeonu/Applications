package com.nicolae;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultPasswordLenght =10;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();;

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLenght);
        System.out.println("Your password is " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + "\nDepartments code\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter departemt code: ");
        Scanner in = new Scanner(System.in);
        int depChoise = in.nextInt();
        if(depChoise == 1){
            return "Sales";
        }else if(depChoise == 2){
            return "Development";
        }else if(depChoise == 3){
            return "Accounting";
        }else{
            return "none";
        }
    }

    // Generate a random password
    private String randomPassword(int lenght){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[lenght];
        for(int i = 0; i<lenght; i++){
           int rand = (int)(Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity (int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password;
    public void changePassword(String password){
        this.password = password;
    }

    // Get methods
    public int getMailboxCapacity(){ return mailboxCapacity;}
    public String getAlternateEmail(){ return "Your alternate email is: "+ alternateEmail;}
    public String getPassword(){ return password;}

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + " MB";
    }

}
