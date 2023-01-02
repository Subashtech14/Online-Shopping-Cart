package org.example;

import java.util.Scanner;


public class SiginUp {
    public void on(){
        String Username,Password,Role,Description,Phone_Number,Email = null;
        Scanner input=new Scanner(System.in);

        System.out.println("Enter the User Name ");
        Username=input.nextLine();
        System.out.println("Enter the Password ");
        Password=input.nextLine();
        System.out.println("Enter the Email ");
        Email=input.nextLine();
        System.out.println("Enter the Phone Number ");
        Phone_Number=input.nextLine();
        System.out.println("""
                Enter the Role 
                Seller
                Buyer""");
        Role=input.nextLine();
        System.out.println("Description ");
        Description=input.nextLine();
        System.out.println();
        new Validator(Username,Password,Role,Description,Phone_Number,Email).validate();
    }

}
