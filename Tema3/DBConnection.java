package DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeSet;

import BusinessLogic.OrderProcessing;
import BusinessLogic.WarehouseAdministration;
import DomainSpecificClasses.Customer;
import DomainSpecificClasses.Order;
import DomainSpecificClasses.Product;

public class DBConnection {
	private Connection con;

	/*
	 * Metoda care realizeaza conexiunea cu baza de date
	 */
	public Connection connect() {
		try {
			String host = "jdbc:mysql://localhost:3306/db";
			String uName = "root";
			String uPass = "raluca";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host, uName, uPass);
		} catch (SQLException err) {
			System.out.println(err.getMessage());
		} catch (ClassNotFoundException err) {
			System.out.println(err.getMessage());
		}
		return con;
	}

	
	
}