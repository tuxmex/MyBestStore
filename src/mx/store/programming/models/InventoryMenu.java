package mx.store.programming.models;

import mx.store.programming.services.InventoryService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class InventoryMenu {

	private static InventoryService inventoryService;

	public static void main(String[] args) throws SQLException, IOException {

		Scanner in = new Scanner(System.in);
		inventoryService = new InventoryService();

		int numProducts = 1;
		String userOption;

		int menuOption = -1;
		do {
			menuOption = getMenuOption(in);
			executeAction(in, menuOption);
		} while (menuOption != 0);

		in.close();

	}

	/**
	 * Display all products.
	 */
	static void displayInventory() {
		System.out.println("Display from Array List");
		System.out.println(inventoryService.getInventory().toString());
	}

	/**
	 * Add a new product to the inventory.
	 *
	 * @param in - Scanner
	 */
	static Product addToInventory(Scanner in) {
		String nameTemp;
		double priceTemp;
		int qtyTemp;

		System.out.print("Please enter name : ");
		nameTemp = in.next();
		System.out.print("Please enter price : ");
		priceTemp = in.nextDouble();
		System.out.print("Please enter quantity : ");
		qtyTemp = in.nextInt();

		Product product = new Product(nameTemp, qtyTemp, priceTemp);

		return product;
	}

	static DVD addDVDToInventory(Scanner in) {
		String studioTemp;
		int agerangeTemp;
		int durationTemp;

		Product product = addToInventory(in);

		System.out.print("Please enter studio : ");
		studioTemp = in.next();
		System.out.print("Please enter age range : ");
		agerangeTemp = in.nextInt();
		System.out.print("Please enter duration : ");
		durationTemp = in.nextInt();

		DVD dvd = new DVD(product, durationTemp, agerangeTemp, studioTemp);
		return dvd;
	}

	static CD addCDToInventory(Scanner in) {
		String artistTemp;
		String discOwnerTemp;
		int numOfSongsTemp;

		Product product = addToInventory(in);

		System.out.print("Please enter the artist : ");
		artistTemp = in.next();
		System.out.println("Please enter the disc owner : ");
		discOwnerTemp = in.next();
		System.out.println("Please enter the num of songs : ");
		numOfSongsTemp = in.nextInt();

		CD cd = new CD(product, artistTemp, numOfSongsTemp, discOwnerTemp);
		return cd;
	}

	static int getMenuOption(Scanner in) {
		int menuOption = -1;

		do {
			try {
				System.out.println("\n\n 1. View Inventory " + "\n 2. Add Stock" + "\n 3. Deduct Stock"
						+ "\n 4. Discontinue Product" + "\n 5. Add Product" + "\n 0. Exit");
				System.out.print("Please enter a menu option : ");
				menuOption = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type");
				in.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				in.nextLine();
			}

		} while (menuOption < 0 || menuOption > 7);

		in.nextLine();
		return menuOption;
	}

	/**
	 * Execute the particular action
	 *
	 * @param menuOption
	 * @throws IOException
	 * @throws SQLException
	 */
	static void executeAction(Scanner in, int menuOption) throws IOException, SQLException {
		Product product = null;
		String idString = "";

		switch (menuOption) {
			case 1:
				displayInventory();
				break;
			case 2:
				do {
					try {
						System.out.print("Insert the product id : ");
						idString = in.nextLine();
						UUID id = UUID.fromString(idString);
						System.out.print("Insert the additional stock : ");
						int quantity = in.nextInt();
						in.nextLine();
						product = inventoryService.getInventory().findProduct(id);
						product.addStock(quantity);
						inventoryService.saveProductToInventory(product);
					} catch (InventoryException e) {
						System.out.println(e.getMessage() + " with id = " + idString);
					}
				} while (product == null);
				break;
			case 3:
				do {
					try {
						System.out.print("Insert the product id : ");
						idString = in.nextLine();
						UUID id = UUID.fromString(idString);
						product = inventoryService.getInventory().findProduct(id);
						try {
							System.out.print("Insert the deduct stock : ");
							int quantity = in.nextInt();
							in.nextLine();
							product.deductStock(quantity);
							inventoryService.saveProductToInventory(product);
						} catch (InventoryException e) {
							System.out.println(e.getMessage() + " final stock = " + (product.getQtyInStock()));
							product = null;
						}
					} catch (InventoryException e) {
						System.out.println(e.getMessage() + " with id = " + idString);
					}
				} while (product == null);
				break;
			case 4:
				do {
					try {
						System.out.print("Insert the product id : ");
						idString = in.nextLine();
						UUID id = UUID.fromString(idString);
						product = inventoryService.getInventory().findProduct(id);
						product.setActive(false);
						inventoryService.saveProductToInventory(product);
					} catch (InventoryException e) {
						System.out.println(e.getMessage() + " with id = " + idString);
					}
				} while (product == null);

				break;
			case 5:
				String productType;
				ProductType type;
				Product newProduct = null;
				System.out.print("Which product do you want to create? : ");
				productType = in.next();

				type = ProductType.valueOf(productType);

				switch (type) {
					case CD:
						newProduct = addCDToInventory(in);
						break;
					case DVD:
						newProduct = addDVDToInventory(in);
						break;
				}

				inventoryService.saveProductToInventory(newProduct);

		}
	}

}
