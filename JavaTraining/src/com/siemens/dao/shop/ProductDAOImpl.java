package com.siemens.dao.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

import com.siemens.beans.shop.Product;

public class ProductDAOImpl implements ProductDAO {

	Connection con;

	public ProductDAOImpl(String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/siemensdb", user, password);
	}

	public ProductDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public int insertProduct(Product prod) throws SQLException {
		PreparedStatement stmAdd;
		stmAdd = con.prepareStatement(
				"INSERT INTO `siemensdb`.`product`\r\n" + "(`Name`,`Price`,`Desc`)\r\n" + "VALUES (?,?,?);",
				PreparedStatement.RETURN_GENERATED_KEYS);

		stmAdd.setString(1, prod.getName());
		stmAdd.setDouble(2, prod.getPrice());
		stmAdd.setString(3, prod.getDescription());

		stmAdd.executeUpdate();

		ResultSet rs = stmAdd.getGeneratedKeys();

		int rowId = -1;

		if (rs.next()) {
			rowId = rs.getInt(1);
		}

		if (rowId < 0) {
			return -1;
		}

		prod.setId(rowId);

		return rowId;
	}

	@Override
	public boolean deleteProduct(int prodId) throws SQLException {
		if (prodId <= 0) {
			return false;
		}

		PreparedStatement stm;
		stm = con.prepareStatement("DELETE FROM `siemensdb`.`product`\r\n" + "WHERE\r\n" + "ProductID = ?;");

		stm.setInt(1, prodId);

		int result = stm.executeUpdate();

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateProduct(Product prod) throws SQLException {
		PreparedStatement stm;
		stm = con.prepareStatement("UPDATE `siemensdb`.`product`\r\n" + "SET\r\n" + "`Name` = ?,\r\n"
				+ "`Price` = ?,\r\n" + "`Desc` = ?\r\n" + "WHERE\r\n" + "ProductID = ?;");

		stm.setString(1, prod.getName());
		stm.setDouble(2, prod.getPrice());
		stm.setString(3, prod.getDescription());
		stm.setInt(4, prod.getId());

		int result = stm.executeUpdate();

		if (result < 0)
			return false;

		return true;
	}

	@Override
	public Product fetchProductById(int prodId) throws SQLException {
		if (prodId <= 0) {
			return null;
		}
		
		PreparedStatement stm = con.prepareStatement("SELECT * FROM `siemensdb`.`product` WHERE `ProductID` = ?;");
		stm.setInt(1, prodId);

		ResultSet prodResult = stm.executeQuery();

		if (prodResult.next()) {
			return generateProduct(prodResult);
		}

		return null;
	}

	@Override
	public ListIterator<Product> fetchAllProducts() throws SQLException {
		ArrayList<Product> prodList = new ArrayList<>();
		PreparedStatement stm = con.prepareStatement("SELECT * FROM `siemensdb`.`product`;");
		ResultSet prodResult = stm.executeQuery();
		while (prodResult.next()) {
			prodList.add(generateProduct(prodResult));
		}
		return prodList.listIterator();
	}

	private Product generateProduct(ResultSet prodSet) throws SQLException {
		Product p = new Product();
		p.setId(prodSet.getInt("ProductID"));
		p.setName(prodSet.getString("Name"));
		p.setPrice(prodSet.getDouble("Price"));
		p.setDescription(prodSet.getString("Desc"));
		return p;
	}
	
}
