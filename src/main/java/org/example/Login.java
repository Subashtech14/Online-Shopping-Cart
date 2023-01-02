package org.example;

import java.io.FileInputStream;

import java.util.Scanner;

public class Login {
   protected void SignIn() {
       String Username,Password;
       System.out.println(" Enter the User Name ");
       Scanner input=new Scanner(System.in);
       Username=input.nextLine();
       System.out.println("Enter the Password ");
       Password=input.nextLine();
        checker(Username,Password);
   }

    private void checker(String Username,String Password )  {
       String Role="Seller";
        try {
            String currentDirectory = System.getProperty("user.dir");
//	FileReader reader=new FileReader(currentDirectory+"\\DATABASES\\UserNameandPassword.txt");
            FileInputStream fis = new FileInputStream(currentDirectory + "\\DATABASES\\UserNameandPassword.txt");
            Scanner scn = new Scanner(fis);    //file to be scanned
            //returns true if there is another line to read
            while (scn.hasNextLine()) {
                String Credientals = scn.nextLine();
                Credientals = Credientals.toString();
//                System.out.println("Enter the Password " + Credientals);
                //returns the line that was skipped
                String UserCredientals[] = Credientals.split("\\s+");

                if (Username.equals(UserCredientals[0].toString()) && Password.equals(UserCredientals[1].toString())) {
                    System.out.println("Account Login Successfull ");
                    if (Role.equals(UserCredientals[4].toString())){
                        new Seller(Username).optionsMenu();
                    }
                    else {
                        Main.productList();
                    }

                } else {
                    System.out.println("Account Login not Sucessfull " + Username+" "+ Password);
//                    System.out.println(Username+" "+Password);
                }
            }
            scn.close();
        } catch(Exception e) {

        }
    }


}
