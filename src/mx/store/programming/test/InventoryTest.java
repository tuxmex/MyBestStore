package mx.store.programming.test;

import mx.store.programming.models.Inventory;
import mx.store.programming.models.InventoryException;
import mx.store.programming.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryTest {

	private Inventory inventory;

	public static final int ADD_PRODUCTS = 3;

	@BeforeEach
	public void init() {
		this.inventory = new Inventory();

		int numItems = ADD_PRODUCTS;
		while (numItems > 0) {
			inventory.addToInventory(ProductTest.getTestProduct());
			numItems--;
		}
	}

	@Test
	public void testAddToInventory() {
		assertEquals(inventory.getNumItems(), ADD_PRODUCTS);
	}

	@Test
	public void testFindProduct() throws InventoryException {
		Product originalProduct = ProductTest.getTestProduct();
		inventory.addToInventory(originalProduct);

		Product foundProduct = inventory.findProduct(originalProduct.getItemId());

		assertEquals(originalProduct, foundProduct);
	}

	@Test
	public void testFindProductWhenNotExist() {
		Exception e = assertThrows(InventoryException.class, () -> inventory.findProduct(UUID.randomUUID()));

		assertEquals(e.getMessage(), InventoryException.NOT_FOUND_PRODUCT);
	}
}
