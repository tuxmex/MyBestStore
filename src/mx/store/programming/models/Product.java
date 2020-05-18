package mx.store.programming.models;

import java.io.Serializable;
import java.util.UUID;

public class Product implements Serializable {

	// Fields

	private UUID itemId;
	private String name;
	private int qtyInStock;
	private double price;
	private boolean active;

	// constructor

	public Product() {
	}

	public Product(Product p) {
		new Product(p.getName(), p.getQtyInStock(), p.getPrice());
	}

	public Product(String name, int qtyInStock, double price) {
		this.itemId = UUID.randomUUID();
		this.name = name;
		this.qtyInStock = qtyInStock;
		this.price = price;
		this.active = true;
	}

	// getter setter

	public UUID getItemId() {
		return itemId;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Calculate the total of the inventory.
	 *
	 * @return inventoryValue
	 */
	public double getInventoryValue() {
		return this.price * this.qtyInStock;
	}

	/**
	 * Add more stock of the product.
	 *
	 * @param quantity
	 */
	public void addStock(int quantity) {
		this.qtyInStock += quantity;
	}

	/**
	 * Deduct stock of the product.
	 *
	 * @param quantity
	 */
	public void deductStock(int quantity) throws InventoryException {
		if (this.qtyInStock - quantity < 0)
			throw new InventoryException(
					InventoryException.BAD_STOCK + ": new stock = " + (this.qtyInStock - quantity));

		this.qtyInStock -= quantity;
	}

	@Override
	public String toString() {
		return "\n\nItem number 		: " + this.itemId.toString() + "\nName 				: " + this.name
				+ "\nQuantity in stock 	: " + this.qtyInStock + "\nPrice 				: " + this.price
				+ "\nInventory value 	: " + this.getInventoryValue() + "\nActive 			: "
				+ (this.active ? "Active" : "Deactived");
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Product))
			return false;

		Product p = (Product) obj;

		return this.itemId.equals(p.getItemId());
	}

}
