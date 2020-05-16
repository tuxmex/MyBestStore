package mx.store;

import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {

        //Create a Scanner object for keyboard input
        Scanner in = new Scanner(System.in);

        //Create local variables
        int tempNumber;
        String tempName;
        int tempQty;
        double tempPrice;

        //Int variable maxSize
        int maxSize;

        //Ask the user to enter the product information
        System.out.println("\n\nPlease enter the product name: ");
        tempName = in.nextLine();
        System.out.println("Please enter the quantity of the esto for this product: ");
        tempQty = in.nextInt();
        System.out.println("Please enter the price for this product: ");
        tempPrice = in.nextDouble();
        System.out.println("Please enter the item number: ");
        tempNumber = in.nextInt();

        //Create the first product using information input by the user
        Product p1 = new Product(tempNumber, tempName, tempQty, tempPrice);

        //Ask the user to enter the product information
        in.nextLine();

        //Display prompt to user
        System.out.println("Enter the number of products you would like to add.");
        System.out.println("Enter 0 (zero) if you do not wish to add products: ");
        //assume that the user enters a valid
        maxSize = in.nextInt();


        System.out.println("\n\nPlease enter the product name: ");
        tempName = in.nextLine();
        System.out.println("Please enter the quantity of the esto for this product: ");
        tempQty = in.nextInt();
        System.out.println("Please enter the price for this product: ");
        tempPrice = in.nextDouble();
        System.out.println("Please enter the item number: ");
        tempNumber = in.nextInt();

        //Create the second product using information input by the user
        Product p2 = new Product(tempNumber, tempName, tempQty, tempPrice);

        Product p3 = new Product(3, "Mi producto 3", 100, 55.5);
        Product p4 = new Product(4, "Mi producto 4", 101, 66.5);
        Product p5 = new Product(5, "Mi producto 5", 102, 77.5);
        Product p6 = new Product(6, "Mi producto 6", 103, 88.5);


        //Set the active field to false
        p6.setActive(false);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);

        //Close the scanner object
        in.close();

    }
}
