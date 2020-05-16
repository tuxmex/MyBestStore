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

        //Ask the user to enter the product information
        System.out.println("\n\nPlease enter the product name: ");
        tempName = in.nextLine();
        System.out.println("Please enter the quantity of the esto for this product: ");
        tempQty = in.nextInt();
        System.out.println("Please enter the price for this product: ");
        tempPrice = in.nextDouble();
        System.out.println("Please enter the item number: ");
        tempNumber = in.nextInt();


    }
}
