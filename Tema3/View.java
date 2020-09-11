package Presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.OrderProcessing;
import BusinessLogic.WarehouseAdministration;
import DataAccess.DBConnection;
import DomainSpecificClasses.Customer;
import DomainSpecificClasses.Order;
import DomainSpecificClasses.Product;

import java.lang.*;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel1, panel2, panel3;
	private JMenuBar menu;
	private JTable table1, table2, table3;
	private JLabel AddNewProd, DelProd, UpdateQuant, numeProd, pretProd, quantityProd, idProdDel, idProdUpdate,
			quantityUp;
	private JLabel AddNewCl, DelCl, numeCl, phoneCl, idClDel;
	private JLabel AddNewOrder, DelOrder, idProd, quantity, idClient, idOrder;
	private JTextField numeProdAdd, pretProdAdd, quantProdAdd, idProductDel, idProdUp, quantityProdUp;
	private JTextField numeClientAdd, phoneClientAdd, idClientDel;
	private JTextField idProdOrdered, quantityOrder, idClientOrder, idOrdered;
	private JButton AddProdButton, DelProdButton, UpdateProdButton;
	private JButton AddClButton, DelClButton;
	private JButton AddOrder, DeleteOrder, Final;
	private JMenu option1, option2, option3;
	private DefaultTableModel model1, model2, model3;
	private JScrollPane ScrollP1, ScrollP2, ScrollP3;
	private WarehouseAdministration wh= new WarehouseAdministration();
	private DBConnection db;
	DataAccess.ProductsDataAccess dbP = new DataAccess.ProductsDataAccess();
	DataAccess.ClientsDataAccess dbC = new DataAccess.ClientsDataAccess();
	DataAccess.OrdersDataAccess dbO = new DataAccess.OrdersDataAccess();
	private ArrayList<Customer> cl;
	private ArrayList<Product> prod;
	private ArrayList<Integer> quant;
	private int idCl;
	private OrderProcessing orderproc = new OrderProcessing(null);

	public View() {
		super("Order Manager");
		panel1 = new JPanel();
		panel1.setLayout(null);
		setSize(800, 600);
		setResizable(true);

		panel2 = new JPanel();
		panel2.setLayout(null);
		setSize(800, 600);
		setResizable(true);

		panel3 = new JPanel();
		panel3.setLayout(null);
		setSize(800, 600);
		setResizable(true);

		menu = new JMenuBar();
		setJMenuBar(menu);
		option1 = new JMenu("Produse");
		menu.add(option1);

		option2 = new JMenu("Clienti");
		menu.add(option2);

		option3 = new JMenu("Comenzi");
		menu.add(option3);
		// produs
		// new
		// table
		model1 = new DefaultTableModel(null, new Object[] { "Id Produs", "Nume", "Pret", "Cantitate", "Status" });
		table1 = new JTable(model1);
		ScrollP1 = new JScrollPane(table1);

		// filtre
		AddNewProd = new JLabel("Adauga produs nou: ");
		DelProd = new JLabel("Stergere produs dupa id: ");
		UpdateQuant = new JLabel("Modifica cantitate stoc: ");
		numeProd = new JLabel("Nume:");
		pretProd = new JLabel("Pret:");
		quantityProd = new JLabel("Cantitate:");
		idProdDel = new JLabel("Id P:");
		idProdUpdate = new JLabel("Id Produs:");
		quantityUp = new JLabel("Cantitate:");
		numeProdAdd = new JTextField("");
		pretProdAdd = new JTextField("");
		quantProdAdd = new JTextField("");
		idProductDel = new JTextField("");
		idProdUp = new JTextField("");
		quantityProdUp = new JTextField("");
		AddProdButton = new JButton("Adauga Produs");
		DelProdButton = new JButton("Sterge Produs");
		UpdateProdButton = new JButton("Modifica Cantitate");
		// add to panel
		ScrollP1.setBounds(90, 30, 600, 250);
		ScrollP1.setVisible(true);
		panel1.add(ScrollP1);
		// add
		AddNewProd.setBounds(30, 300, 150, 30);
		AddNewProd.setVisible(true);
		panel1.add(AddNewProd);

		numeProd.setBounds(250, 300, 50, 30);
		numeProd.setVisible(true);
		panel1.add(numeProd);

		numeProdAdd.setBounds(300, 300, 100, 30);
		numeProdAdd.setVisible(true);
		panel1.add(numeProdAdd);

		pretProd.setBounds(430, 300, 50, 30);
		pretProd.setVisible(true);
		panel1.add(pretProd);

		pretProdAdd.setBounds(470, 300, 50, 30);
		pretProdAdd.setVisible(true);
		panel1.add(pretProdAdd);

		quantityProd.setBounds(550, 300, 100, 30);
		quantityProd.setVisible(true);
		panel1.add(quantityProd);

		quantProdAdd.setBounds(610, 300, 50, 30);
		quantProdAdd.setVisible(true);
		panel1.add(quantProdAdd);

		AddProdButton.setBounds(670, 300, 130, 30);
		AddProdButton.setVisible(true);
		panel1.add(AddProdButton);

		// delete
		DelProd.setBounds(30, 350, 150, 30);
		DelProd.setVisible(true);
		panel1.add(DelProd);

		idProdDel.setBounds(250, 350, 100, 30);
		idProdDel.setVisible(true);
		panel1.add(idProdDel);

		idProductDel.setBounds(330, 350, 50, 30);
		idProductDel.setVisible(true);
		panel1.add(idProductDel);

		DelProdButton.setBounds(400, 350, 150, 30);
		DelProdButton.setVisible(true);
		panel1.add(DelProdButton);

		// update
		UpdateQuant.setBounds(30, 400, 150, 30);
		UpdateQuant.setVisible(true);
		panel1.add(UpdateQuant);

		idProdUpdate.setBounds(250, 400, 150, 30);
		idProdUpdate.setVisible(true);
		panel1.add(idProdUpdate);

		idProdUp.setBounds(330, 400, 50, 30);
		idProdUp.setVisible(true);
		panel1.add(idProdUp);

		quantityUp.setBounds(450, 400, 150, 30);
		quantityUp.setVisible(true);
		panel1.add(quantityUp);

		quantityProdUp.setBounds(530, 400, 50, 30);
		quantityProdUp.setVisible(true);
		panel1.add(quantityProdUp);

		UpdateProdButton.setBounds(600, 400, 150, 30);
		UpdateProdButton.setVisible(true);
		panel1.add(UpdateProdButton);

		this.add(panel1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);

		// client
		// new
		// table
		model2 = new DefaultTableModel(null, new Object[] { "Id Client", "Nume", "Telefon" });
		table2 = new JTable(model2);
		ScrollP2 = new JScrollPane(table2);

		// filtre
		AddNewCl = new JLabel("Adauga client nou: ");
		DelCl = new JLabel("Stergere client dupa id: ");
		numeCl = new JLabel("Nume:");
		phoneCl = new JLabel("Telefon:");
		idClDel = new JLabel("Id Client:");
		numeClientAdd = new JTextField("");
		phoneClientAdd = new JTextField("");
		idClientDel = new JTextField("");
		AddClButton = new JButton("Adauga Client");
		DelClButton = new JButton("Sterge Client");

		// add to panel
		ScrollP2.setBounds(90, 30, 600, 250);
		ScrollP2.setVisible(true);
		panel2.add(ScrollP2);
		// add
		AddNewCl.setBounds(30, 300, 150, 30);
		AddNewCl.setVisible(true);
		panel2.add(AddNewCl);
		numeCl.setBounds(250, 300, 50, 30);
		numeCl.setVisible(true);
		panel2.add(numeCl);

		numeClientAdd.setBounds(300, 300, 100, 30);
		numeClientAdd.setVisible(true);
		panel2.add(numeClientAdd);

		phoneCl.setBounds(430, 300, 50, 30);
		phoneCl.setVisible(true);
		panel2.add(phoneCl);

		phoneClientAdd.setBounds(500, 300, 50, 30);
		phoneClientAdd.setVisible(true);
		panel2.add(phoneClientAdd);

		AddClButton.setBounds(600, 300, 130, 30);
		AddClButton.setVisible(true);
		panel2.add(AddClButton);

		// delete
		DelCl.setBounds(30, 350, 150, 30);
		DelCl.setVisible(true);
		panel2.add(DelCl);

		idClDel.setBounds(220, 350, 100, 30);
		idClDel.setVisible(true);
		panel2.add(idClDel);

		idClientDel.setBounds(330, 350, 50, 30);
		idClientDel.setVisible(true);
		panel2.add(idClientDel);

		DelClButton.setBounds(400, 350, 150, 30);
		DelClButton.setVisible(true);
		panel2.add(DelClButton);

		panel2.setVisible(true);

		this.add(panel2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);

		/*
		 * Order
		 */
		/*
		 * new
		 */
		/*
		 * table
		 */
		model3 = new DefaultTableModel(null,
				new Object[] { "Id Client", "Nume Client", "Id Produs", "Nume Produs", "Cantitate" });
		table3 = new JTable(model3);
		ScrollP3 = new JScrollPane(table3);

		/*
		 * filtre
		 */
		AddNewOrder = new JLabel("Adauga comanda: ");
		DelOrder = new JLabel("Stergere Comanda: ");
		idProd = new JLabel("Id Produs:");
		quantity = new JLabel("Cantitate:");
		idClient = new JLabel("Id Client:");
		idOrder = new JLabel("Id Order:");
		idProdOrdered = new JTextField("");
		quantityOrder = new JTextField("");
		idClientOrder = new JTextField("");
		idOrdered = new JTextField("");
		AddOrder = new JButton("Adauga Comanda");
		DeleteOrder = new JButton("Sterge Comanda");
		Final = new JButton("Finalizare Comanda");
		// add to panel
		ScrollP3.setBounds(90, 30, 600, 250);
		ScrollP3.setVisible(true);
		panel3.add(ScrollP3);
		// add
		AddNewOrder.setBounds(30, 300, 150, 30);
		AddNewOrder.setVisible(true);
		panel3.add(AddNewOrder);

		idProd.setBounds(150, 300, 150, 30);
		idProd.setVisible(true);
		panel3.add(idProd);

		idProdOrdered.setBounds(210, 300, 50, 30);
		idProdOrdered.setVisible(true);
		panel3.add(idProdOrdered);

		quantity.setBounds(290, 300, 100, 30);
		quantity.setVisible(true);
		panel3.add(quantity);

		quantityOrder.setBounds(350, 300, 50, 30);
		quantityOrder.setVisible(true);
		panel3.add(quantityOrder);

		idClient.setBounds(210, 350, 50, 30);
		idClient.setVisible(true);
		panel3.add(idClient);

		idClientOrder.setBounds(290, 350, 50, 30);
		idClientOrder.setVisible(true);
		panel3.add(idClientOrder);

		AddOrder.setBounds(420, 300, 150, 30);
		AddOrder.setVisible(true);
		panel3.add(AddOrder);

		Final.setBounds(420, 350, 150, 30);
		Final.setVisible(true);
		panel3.add(Final);

		// delete
		DelOrder.setBounds(30, 400, 150, 30);
		DelOrder.setVisible(true);
		panel3.add(DelOrder);

		idOrder.setBounds(170, 400, 100, 30);
		idOrder.setVisible(true);
		panel3.add(idOrder);

		idOrdered.setBounds(250, 400, 50, 30);
		idOrdered.setVisible(true);
		panel3.add(idOrdered);

		DeleteOrder.setBounds(350, 400, 150, 30);
		DeleteOrder.setVisible(true);
		panel3.add(DeleteOrder);

		this.add(panel3);
		// actiuni
		// meniu
		option1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				panel1.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);

			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});

		option2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				panel1.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});

		option3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(true);
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});
		// butoane
		AddProdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsActionPerformed(evt);
			}
		});

		DelProdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsActionPerformed(evt);
			}
		});

		UpdateProdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsActionPerformed(evt);
			}
		});
		AddClButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsActionPerformed(evt);
			}
		});
		DelClButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsActionPerformed(evt);
			}
		});
		AddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsActionPerformed(evt);
			}
		});
		Final.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsActionPerformed(evt);
			}
		});
		DeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsActionPerformed(evt);
			}
		});
		/*
		 * Connexiunea cu baza de date
		 */
		db = new DBConnection();
		db.connect();
		
		/*
		 * Selectare produse existente deja in baza de date "SELECT"
		 */
		wh = dbP.selectProduct();
		model1.setRowCount(0);
		for (Product p : wh.getWarehouse().keySet())
			model1.addRow(new Object[] { p.getIdProduct(), p.getName(), p.getPrice(), wh.getWarehouse().get(p),
					wh.getStatus(p.getIdProduct()) });

		cl = new ArrayList<Customer>();
		//DataAccess.ClientsDataAccess dbC = new DataAccess.ClientsDataAccess();
		cl = dbC.selectCustomer();
		model2.setRowCount(0);
		for (int i = 0; i < cl.size(); i++)
			model2.addRow(new Object[] { cl.get(i).getIdCustomer(), cl.get(i).getName(), cl.get(i).getPhone() });
		
		//DataAccess.OrdersDataAccess dbO = new DataAccess.OrdersDataAccess();
		orderproc = dbO.getOrders();
		prod = new ArrayList<Product>();
		quant = new ArrayList<Integer>();
		model3.setRowCount(0);
		for (Order o : orderproc.getOrderProcessing())
			for (int i = 0; i < o.getProd().size(); i++)
				model3.addRow(new Object[] { o.getCustomer().getIdCustomer(), o.getCustomer().getName(),
						o.getProd().get(0).getIdProduct(), o.getProd().get(0).getName(), o.getCant().get(i) });
	}

	public void optionsActionPerformed(ActionEvent e) {
		String a = e.getActionCommand();
		if (a.equals("Adauga Produs")) {
			try {
				String n = numeProdAdd.getText();
				double p = Double.parseDouble(pretProdAdd.getText());
				int c = Integer.parseInt(quantProdAdd.getText());
				Product prod = new Product(wh.getId() + 1, n, p);
				wh.addProduct(prod, c);
				dbP.insertProduct(prod, c);
				model1.setRowCount(0);
				for (Product pr : wh.getWarehouse().keySet())
					model1.addRow(new Object[] { pr.getIdProduct(), pr.getName(), pr.getPrice(),
							wh.getWarehouse().get(pr), wh.getStatus(pr.getIdProduct()) });
			} catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null, "Date incorecte!");
			}

		} else if (a.equals("Sterge Produs")) {
			try {
				int k = Integer.parseInt(idProductDel.getText());
			
				dbP.deleteProduct(k);
				model1.setRowCount(0);
				wh.delete(wh.searchProduct(k));
				for (Product p : wh.getWarehouse().keySet())
					model1.addRow(new Object[] { p.getIdProduct(), p.getName(), p.getPrice(), wh.getWarehouse().get(p),
							wh.getStatus(p.getIdProduct()) });
			} catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null, "Date incorecte!");
			}

		} else if (a.equals("Modifica Cantitate")) {
			try {
				int k = Integer.parseInt(idProdUp.getText());
				int q = Integer.parseInt(quantityProdUp.getText());
				dbP.updateQuantity(k, q);
				model1.setRowCount(0);
				wh.updateQuantity(k, q);
				for (Product p : wh.getWarehouse().keySet())
					model1.addRow(new Object[] { p.getIdProduct(), p.getName(), p.getPrice(), wh.getWarehouse().get(p),
							wh.getStatus(p.getIdProduct()) });
			} catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null, "Date incorecte!");
			}

		} else if (a.equals("Adauga Client")) {
			try {
				String n = numeClientAdd.getText();
				String t = phoneClientAdd.getText();
				int k = cl.size();
				Customer c = new Customer(cl.get(k - 1).getIdCustomer() + 1, n, t);
				cl.add(c);
				dbC.insertCustomer(c);
				model2.setRowCount(0);
				for (int i = 0; i < cl.size(); i++)
					model2.addRow(
							new Object[] { cl.get(i).getIdCustomer(), cl.get(i).getName(), cl.get(i).getPhone() });
			} catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null, "Date incorecte!");
			}
		} else if (a.equals("Sterge Client")) {
			try {
				int k = Integer.parseInt(idClientDel.getText());
				dbC.deleteCustomer(k);
				model2.setRowCount(0);
				for (int i = 0; i < cl.size(); i++) {
					if (cl.get(i).getIdCustomer() == k) {
						cl.remove(i);
					}
				}
				for (int i = 0; i < cl.size(); i++)
					model2.addRow(
							new Object[] { cl.get(i).getIdCustomer(), cl.get(i).getName(), cl.get(i).getPhone() });
			} catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null, "Date incorecte!");
			}
		} else if (a.equals("Adauga Comanda")) {
			try {
				int ip = Integer.parseInt(idProdOrdered.getText());
				int k = Integer.parseInt(quantityOrder.getText());
				idCl = Integer.parseInt(idClientOrder.getText());
				Product pr = wh.searchProduct(ip);
				prod.add(pr);
				quant.add(k);
				if((wh.getWarehouse().get(pr) - k)>=0){
					
				
				dbP.updateQuantity(ip, wh.getWarehouse().get(pr) - k);
				wh.updateQuantity(ip, (wh.getWarehouse().get(pr) - k));
				}
				else{
					JOptionPane.showMessageDialog(null, "Cantitate depasita!");
					
				}
				model1.setRowCount(0);
				for (Product p : wh.getWarehouse().keySet())
					model1.addRow(new Object[] { p.getIdProduct(), p.getName(), p.getPrice(), wh.getWarehouse().get(p),
							wh.getStatus(p.getIdProduct()) });
			} catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null, "Date incorecte!");
			}
		} else if (a.equals("Sterge Comanda")) {
			int io = Integer.parseInt(idOrdered.getText());
			orderproc.deleteOrder(orderproc.searchOrder(io));
			dbO.deleteOrder(io);
			model3.setRowCount(0);
			for (Order o : orderproc.getOrderProcessing())
				for (int i = 0; i < o.getProd().size(); i++)
					model3.addRow(new Object[] { o.getCustomer().getIdCustomer(), o.getCustomer().getName(),
							o.getProd().get(i).getIdProduct(), o.getProd().get(i).getName(), o.getCant().get(i) });
		} else if (a.equals("Finalizare Comanda")) {
			orderproc = dbO.getOrders();
			Order or = new Order(orderproc.getOrderProcessing().size() + 1, getCl(idCl), prod, quant);
			dbO.insertOrder(or);
			dbO.insertOrderHasProduct(or);
			orderproc = dbO.getOrders();
			prod.clear();
			quant.clear();

			model3.setRowCount(0);
			for (Order o : orderproc.getOrderProcessing())
				for (int i = 0; i < o.getProd().size(); i++)
					model3.addRow(new Object[] { o.getCustomer().getIdCustomer(), o.getCustomer().getName(),
							o.getProd().get(i).getIdProduct(), o.getProd().get(i).getName(), o.getCant().get(i) });
		}
	}

	public Customer getCl(int id) {
		for (int i = 0; i < cl.size(); i++) {
			if (cl.get(i).getIdCustomer() == id) {
				return cl.get(i);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		new View();
	}
}
