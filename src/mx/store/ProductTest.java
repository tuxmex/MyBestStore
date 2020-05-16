package mx.store;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {

        //Create a Scanner object for keyboard input
        Scanner in = new Scanner(System.in);
        int maxSize = getNumProducts(in);

        if (maxSize == 0) {
            //Display a no products message if zero is entered
            System.out.println("No products required!");
        } else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);
            displayInventory(products);
        }//endif

        //Close the scanner object
        in.close();

    }

    static int getNumProducts(Scanner in) {
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
        return maxSize;
    }

    static int getMenuOption(Scanner in){
        int menuOption = -1;

        System.out.println("\n\n 1. View inventory\n2. Add Stock \n3. Deduct stock \n4. Discontinue Product\n0. Exit");
        System.out.println("Please enter a menu option:");
        menuOption = in.nextInt();

        // return the valid input from the user
        return menuOption;
    }//end method getMenuOption


    static void addToInventory(Product[] products, Scanner in) {
        //Create local variables
        int tempNumber;
        String tempName;
        int tempQty;
        double tempPrice;

        for (int i = 0; i < products.length; i++) {
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
    }//end method addToInventory

    static void displayInventory(Product[] products) {
        for (Product product : products) {
            System.out.println(product);
        } //end for
    }//end method displayInventory


}
