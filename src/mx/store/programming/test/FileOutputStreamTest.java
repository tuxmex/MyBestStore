package mx.store.programming.test;

import mx.store.programming.models.Product;
import mx.store.programming.persistence.FileObjectStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileOutputStreamTest {

	private FileObjectStream stream;

	public static final String FILE_TEST = "test.txt";

	@BeforeEach
	public void init() {
		stream = new FileObjectStream(FILE_TEST);
	}

	@Test
	public void testSaveAndGet() throws ClassNotFoundException, IOException {
		Product p1 = ProductTest.getTestProduct();

		stream.save(p1);
		Product p2 = (Product) stream.get();

		assertEquals(p1, p2);
	}
}
