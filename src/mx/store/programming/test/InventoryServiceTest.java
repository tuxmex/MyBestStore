package mx.store.programming.test;

import mx.store.programming.models.Inventory;
import mx.store.programming.models.Product;
import mx.store.programming.services.InventoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class InventoryServiceTest {

	private InventoryService inventoryService;

	@BeforeEach
	public void init() throws SQLException {
		this.inventoryService = new InventoryService();
	}

	@Test
	public void testAddProductAndGetInventory() throws SQLException {
		Inventory inventory = this.inventoryService.getInventory();

		Product p = ProductTest.getTestProduct();
		this.inventoryService.saveProductToInventory(p);

		Product p2 = ProductTest.getTestProduct();
		this.inventoryService.saveProductToInventory(p2);

		assertTrue(inventory.getNumItems() > 2);

	}

	@AfterEach
	public void finalize() throws SQLException {
		// File file = new File(inventoryService.INVENTORY_FILE);
		// file.delete();
		inventoryService.cleanInventory();
	}
}
