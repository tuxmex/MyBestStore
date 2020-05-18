package mx.store.programming.persistence;

import mx.store.programming.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DAOProduct implements IDAOProduct {

	private Connection connection;
	private String url = "jdbc:postgresql://ec2-34-234-228-127.compute-1.amazonaws.com:5432/d55c1099ninri6";
	private String user = "tmscugaaqvzvjb";
	private String password = "236758264778245419dbeeb81726dbac9b647c8169f0b4eafb0b2cc8f6bb2373";

	@Override
	public List<Product> findAll() throws SQLException {
		String sqlQuery = "SELECT * FROM Product;";

		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgrSQL");

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			ArrayList<Product> users = new ArrayList<Product>();

			while (rs.next())
				users.add(extractProductFromResultSet(rs));

			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			connection.close();
		}
	}

	@Override
	public Product findById(UUID id) throws SQLException {
		String sqlQuery = "SELECT * FROM Product WHERE itemid = ? ;";

		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgreSQL");

			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setObject(1, id);

			ResultSet rs = ps.executeQuery();

			Product product = null;

			if (rs.next())
				product = extractProductFromResultSet(rs);

			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			connection.close();
		}
	}

	@Override
	public boolean insert(Product entity) throws SQLException {
		String sqlQuery = "INSERT INTO Product VALUES (?, ?, ?, ?, ?);";

		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgreSQL");

			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setObject(1, entity.getItemId());
			ps.setString(2, entity.getName());
			ps.setInt(3, entity.getQtyInStock());
			ps.setDouble(4, entity.getPrice());
			ps.setBoolean(5, entity.isActive());

			int flag = ps.executeUpdate();

			return flag == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			connection.close();
		}
	}

	@Override
	public boolean update(Product entity) throws SQLException {
		String sqlQuery = "UPDATE Product SET name = ?, qtyInStock = ? , price = ? , active = ? WHERE itemid = ?";

		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgreSQL");

			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, entity.getName());
			ps.setInt(2, entity.getQtyInStock());
			ps.setDouble(3, entity.getPrice());
			ps.setBoolean(4, entity.isActive());
			ps.setObject(5, entity.getItemId());

			int flag = ps.executeUpdate();

			return flag == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			connection.close();
		}
	}

	@Override
	public boolean delete(UUID id) throws SQLException {
		String sqlQuery = "DELETE FROM Product WHERE itemid = ? ;";

		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgreSQL");

			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setObject(1, id);

			int flag = ps.executeUpdate();

			return flag == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			connection.close();
		}
	}

	private Product extractProductFromResultSet(ResultSet rs) throws SQLException {
		Product product = new Product();

		product.setItemId((UUID) rs.getObject("itemid"));
		product.setName(rs.getString("name"));
		product.setQtyInStock(rs.getInt("QtyInStock"));
		product.setPrice(rs.getDouble("Price"));
		product.setActive(rs.getBoolean("active"));

		return product;
	}
}
