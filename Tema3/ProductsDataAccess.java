package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessLogic.WarehouseAdministration;
import DomainSpecificClasses.Product;

public class ProductsDataAccess {
	DBConnection dbC = new DBConnection();
	
	/*
	 * Metoda pentru inserarea unui produs in depozit (warehouse) - in baza de
	 * date
	 */
	public void insertProduct(Product p, int q) {
		try {
			Statement stmt = dbC.connect().createStatement();
			stmt.execute("INSERT INTO product(idProduct,Name,Price) " + "values(" + p.getIdProduct() + ",'"
					+ p.getName() + "'," + p.getPrice() + ");");
			stmt.execute("INSERT INTO warehouse(idProduct,quantity) values(" + +p.getIdProduct() + "," + q + ");");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/*
	 * Metoda pentru selectarea produselor din baza de date si transformarea lor
	 * in obiecte
	 */
	public WarehouseAdministration selectProduct() {
		try {
			Statement stmt = dbC.connect().createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM product, warehouse WHERE product.idProduct=warehouse.idProduct;");
			WarehouseAdministration w = new WarehouseAdministration();
			while (rs.next()) {
				Product p = new Product((Integer) rs.getObject(1), (String) rs.getObject(2), (Double) rs.getObject(3));
				w.addProduct(p, (Integer) rs.getObject(5));
			}
			return w;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	/*
	 * Metoda pentru modificarea cantitatii unui produs specificat prin "id"
	 * prin intermediul
	 * 
	 * interfetei. Modificarea este vizibila atat in baza de date cat si in
	 * interfata si in obiectele java.
	 */
	public void updateQuantity(int id, int q) {
		try {
			Statement stmt = dbC.connect().createStatement();
			stmt.execute("UPDATE warehouse SET quantity=" + q + " WHERE idProduct=" + id + ";");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	

	/*
	 * Metoda pentru stergerea unui produs specificat prin "id" prin intermediul
	 * interfetei. Modificarea este vizibila atat in baza de date cat si in
	 * interfata si in obiectele java.
	 */
	public void deleteProduct(int id) {
		try {
			Statement stmt = dbC.connect().createStatement();
			stmt.execute("DELETE FROM warehouse WHERE idProduct=" + id + ";");
			stmt.execute("DELETE FROM product WHERE idProduct=" + id + ";");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
