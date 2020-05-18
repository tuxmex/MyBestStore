package mx.store.programming.test;

import mx.store.programming.models.DVD;
import mx.store.programming.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DVDTest {

	private DVD dvd;
	private Product product;

	public static final double STOCK_FACTOR = 1.05;

	@BeforeEach
	public void init() {
		product = ProductTest.getTestProduct();
		dvd = new DVD(product, 234, 34, "test studio");
	}

	@Test
	public void testGetInventoryValue() {
		double value = dvd.getInventoryValue();

		assertEquals(value, STOCK_FACTOR * product.getInventoryValue());
	}
}
