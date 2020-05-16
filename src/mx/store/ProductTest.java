package mx.store;

import java.util.InputMismatchException;
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
        int maxSize = -1;

        //prompt the user until they enter a number >= zero
        do {
            try {
                //Display prompt to user
                System.out.println("Enter the number of products you would like to add.");
                System.out.println("Enter 0 (zero) if you do not wish to add products: ");
                //assume that the user enters a valid
                maxSize = in.nextInt();
                if (maxSize < 0)
                    System.out.println("Incorrect value entered");
                //endif
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type entered!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        } while (maxSize < 0);

        if (maxSize == 0) {
            //Display a no products message if zero is entered
            System.out.println("No products required!");
        } else {
            Product[] products = new Product[maxSize];
            for (int i = 0; i < maxSize; i++) {
                in.nextLine();
                //Ask the user to enter the product information
                System.out.println("\n\nPlease enter the product name: ");
                tempName = in.nextLine();
                System.out.println("Please enter the quantity of the esto for this product: ");
                tempQty = in.nextInt();
                System.out.println("Please enter the price for this product: ");
                tempPrice = in.nextDouble();
                System.out.println("Please enter the item number: ");
                tempNumber = in.nextInt();
                //Create a product object and store it in the products array
                products[i] = new Product(tempNumber, tempName, tempQty, tempPrice);

            }//endfor
        }//endif





        //Ask the user to enter the product information
        in.nextLine();

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

        //System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);

        //Close the scanner object
        in.close();

    }
}
