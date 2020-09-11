package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DomainSpecificClasses.Customer;

public class ClientsDataAccess {
	DBConnection dbC = new DBConnection();
	/*
	 * Metoda pentru inserarea unui client nou in baza de date
	 */
	public void insertCustomer(Customer c) {
		try {
			Statement stmt = dbC.connect().createStatement();
			stmt.execute("INSERT INTO customer (idCustomer,Name,Phone) value(" + c.getIdCustomer() + ",'" + c.getName()
					+ "'," + c.getPhone() + ");");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Metoda pentru selectarea clientilor din baza de date si transformarea lor
	 * in obiecte
	 */
	public ArrayList<Customer> selectCustomer() {
		try {
			ArrayList<Customer> cl = new ArrayList<Customer>();
			Statement stmt = dbC.connect().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from customer;");
			while (rs.next()) {
				Customer c = new Customer((Integer) rs.getObject(1), (String) rs.getObject(2),
						(String) rs.getObject(3));
				cl.add(c);
			}
			return cl;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	

	/*
	 * Metoda pentru stergerea unui client specificat prin "id" prin intermediul
	 * interfetei. Modificarea este vizibila atat in baza de date cat si in
	 * interfata si in obiectele java.
	 */
	public void deleteCustomer(int id) {
		try {
			Statement stmt = dbC.connect().createStatement();
			stmt.execute("DELETE FROM customer WHERE idCustomer=" + id + ";");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
