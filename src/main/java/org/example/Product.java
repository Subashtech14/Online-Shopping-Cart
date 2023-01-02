package org.example;

import java.io.FileWriter;
import java.util.Scanner;

public class Product {
    String ProductName,Product_Description,Quantity,UserName;
    int Price;

    public Product(String productName, int price, String product_Description, String quantity, String username) {
        ProductName = productName;
        Product_Description = product_Description;
        Quantity = quantity;
        UserName=username;
        Price=price;
    }

    public void ProductFileWriter(){
        try {
            String currentDirectory = System.getProperty("user.dir");
            FileWriter myWriter = new FileWriter(currentDirectory + "\\DATABASES\\Products.txt");
            myWriter.write("Seller : "+UserName.toString()+"\n"+"Product Name : "+ProductName.toString() + " \n" + Product_Description.toString() +" \n"+"Price : "+Price+" \n" +"Quantity : "+Quantity.toString()+ "\n");
            myWriter.close();
            System.out.println("Product Added Successfully ");
            System.out.println("""
                    Do You want to add More Products
                    1 -> Add More
                    2 -> View Products
                    """);
            Scanner input=new Scanner(System.in);
            int Option=input.nextInt();
            switch (Option){
                case 1 ->{new Seller(UserName).addProduct();}
                case 2 -> Main.productList();
                default -> {
                    System.out.println("Invalid Option");
                    Main.getStarted();
                }
            }

        }catch (Exception e){

        }

    }

}
