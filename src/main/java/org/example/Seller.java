package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Seller {
    String Username;

    public Seller(String username) {
        Username = username;
    }
    public void optionsMenu(){
        System.out.println("""
                1 -> Add a Product 
                2 -> View a Product 
                """);
        int Option;
        Scanner scanner=new Scanner(System.in);
        Option=scanner.nextInt();
        switch (Option){
            case 1 ->{addProduct(); }
            case 2 ->{Main.productList();}
            default -> {
                System.out.println("Invalid Option");
                optionsMenu();
            }
        }
    }

    public void addProduct() {
        Scanner input=new Scanner(System.in);
        String ProductName,Product_Description,Quantity;
        System.out.println("Enter the Product Name ");
        ProductName=input.nextLine();
        System.out.println("Enter the Product Description ");
        Product_Description=input.nextLine();
        System.out.println("Enter the Quantity ");
        Quantity=input.nextLine();
        System.out.println("Enter the Product Price ");
        int Price=input.nextInt();

            new Product(ProductName,Price,
                    Product_Description,
                    Quantity,
                    Username).ProductFileWriter();

    }
}
