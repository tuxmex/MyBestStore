package mx.store.programming.services;

import mx.store.programming.models.Inventory;
import mx.store.programming.models.InventoryException;
import mx.store.programming.models.Product;
import mx.store.programming.persistence.DAOProduct;

import java.sql.SQLException;

public class InventoryService implements IInventoryService {

	private DAOProduct daoProduct;
	private Inventory inventory;

	public static final String INVENTORY_FILE = "Inventory.orcl";

	public InventoryService() throws SQLException {
		this.daoProduct = new DAOProduct();
		this.inventory = new Inventory();
		this.inventory.setProducts(this.daoProduct.findAll());
	}

	@Override
	public Inventory getInventory() {
		return this.inventory;
	}

	@Override
	public void saveProductToInventory(Product product) throws SQLException {
		try {
			this.inventory.findProduct(product.getItemId());
			daoProduct.update(product);
		} catch (InventoryException e) {
			this.inventory.addToInventory(product);
			daoProduct.insert(product);
		}
	}

	@Override
	public void cleanInventory() throws SQLException {
		for (Product p : this.inventory.getProducts())
			daoProduct.delete(p.getItemId());
	}

}
