package org.example;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    //Role Buyer Seller Admin
     String Username,Password,Role,Description,Email;
    String Phone_Number;

    public Validator(String username, String password, String role, String description, String phone_Number, String email) {
        Username = username;
        Password = password;
        Role = role;
        Description = description;
        Phone_Number = phone_Number;
        Email=email;
    }
    public  void validate()  {
        emailValid();
        passwordValid();
        phoneNumberValid();
        roleValid();
        detailsWriter();
        Main.getStarted();
    }

    private void detailsWriter() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            FileWriter myWriter = new FileWriter(currentDirectory + "\\DATABASES\\UserNameandPassword.txt");
            myWriter.append(Username.toString() + " " + Password.toString() +" "+ Email+" "+Phone_Number+" "+Role+" "+Description+ "\n");
            myWriter.close();
            System.out.println("Account created Successfully \n Please Re-Login");
        }catch (Exception e){

        }
    }

    private  void emailValid() {
        //Based on RFC 5322 For Email Validation
        String emailPattern="^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern=Pattern.compile(emailPattern);
        Matcher matcher=pattern.matcher(Email);
        if(matcher.matches()){
            System.out.println("Email id Verified");
        }
        else{
            System.out.println("Email not Matched");
        }


    }

    private  void passwordValid() {
        String password="^[A-Za-z0-9]+@$";
        Pattern pattern=Pattern.compile(password);
        Matcher matcher=pattern.matcher(Password);
        if(matcher.matches()){
            System.out.println("Password Valid");
        }
        else {
            System.out.println("Weak Password");
        }
    }

    private  void phoneNumberValid() {
        if (Phone_Number.length() ==10){
            System.out.println("Your Phone Number "+Phone_Number+" is Valid ");
        }
        else {
            System.out.println("Not Valid Phone Number");
        }
    }

    private  void roleValid() {
        if (Role.equals("Buyer") || Role.equals("Seller")  || Role.equals("Admin")){
            System.out.println(Role+" is a Valid Role");
        }
        else {
            System.out.println("Invalid Role");
        }

    }
}
