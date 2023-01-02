/* Project Description : Online Shopping Management System
 * Author : SUBASH M
 * Created Date : 10/12/2022
 * Last Modified Date : 29/12/2022
 * Reviewed Date : --
 * Reviewed By : --
 * */

package org.example;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        DirectoryChecker();
         getStarted();

    }
    private static void DirectoryChecker() throws  IOException {
        String currentDirectory = System.getProperty("user.dir");
        File file=new File(currentDirectory+"\\DATABASES");
        if(file.exists()) {
            System.out.println("Directory Exists at the location "+currentDirectory);
        }
        else {
            file.mkdir();
            File obj=new File(currentDirectory+"\\DATABASES\\UserNameandPassword.txt");
            obj.createNewFile();
        }

    }
    public static void getStarted()  {
        int Option=1;
        System.out.println("""
                1 -> Login
                2 -> SignUp
                3 -> View Product Details
                """);
        Scanner scanner=new Scanner(System.in);
        try{
         Option=scanner.nextInt();}
        catch (Exception e){
            System.out.println("Illegal Argument");
            getStarted();
        }
        switch (Option){
            case 1 ->{new Login().SignIn();}
            case 2 ->{ new SiginUp().on();}
            case 3 ->{ productList();}
            default -> {
                System.out.println("""
                        Selected is not a Valid Option
                        Please Select Another One
                        """);
                getStarted();
            }
            }
        }

    public static void productList() {
        try {
            String currentDirectory = System.getProperty("user.dir");
//	FileReader reader=new FileReader(currentDirectory+"\\DATABASES\\UserNameandPassword.txt");
            FileInputStream fis = new FileInputStream(currentDirectory + "\\DATABASES\\Products.txt");
            Scanner scn = new Scanner(fis);    //file to be scanned
            //returns true if there is another line to read
            while (scn.hasNextLine()) {
                String Credientals = scn.nextLine();
                Credientals = Credientals.toString();
                System.out.println(Credientals);
                //returns the line that was skipped
//                String[] UserCredientals = Credientals.split("\\s+");
//                System.out.println(UserCredientals[0] +"\n"+UserCredientals[1]+"\n"+UserCredientals[3]);


            }
            scn.close();
        } catch(Exception e) {

        }
    }
}
