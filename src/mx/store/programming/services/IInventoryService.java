package mx.store.programming.services;

import mx.store.programming.models.Inventory;
import mx.store.programming.models.Product;

import java.sql.SQLException;


public interface IInventoryService {

	public Inventory getInventory();

	public void saveProductToInventory(Product p) throws SQLException;

	public void cleanInventory() throws SQLException;


}
