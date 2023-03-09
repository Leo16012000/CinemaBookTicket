package views;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.MovieDao;
import models.Movie;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable MovieTable;
	private JTable ReservationTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MainFrame() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new MainPanel();
		mainPanel.setBounds(1100, -16, 133, 120);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
//		JButton btnLogin = new JButton("Login");
//		btnLogin.setBounds(45, 25, 40, 25);
//		AccountPanel.add(btnLogin);
//		
//		JLabel lblName = new JLabel("Name");
//		lblName.setBounds(0, 30, 70, 15);
//		AccountPanel.add(lblName);
		
//		JPanel ReservationPanel = new JPanel();
//		ReservationPanel.setBounds(24, 32, 686, 445);
//		contentPane.add(ReservationPanel);
//		ReservationPanel.setLayout(null);
//		
//		ReservationTable = new JTable();
//		ReservationTable.setBounds(155, 54, 375, 64);
//		ReservationTable.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column", "New column"
//			}
//		));
//		ReservationPanel.add(ReservationTable);
//		
//		JPanel ShowtimePanel = new JPanel();
//		ShowtimePanel.setBounds(114, 32, 553, 471);
//		contentPane.add(ShowtimePanel);
//		ShowtimePanel.setLayout(null);
//		
//		JLabel lblMovieName = new JLabel("Movie name");
//		lblMovieName.setBounds(211, 28, 154, 15);
//		ShowtimePanel.add(lblMovieName);
//		
//		JButton btnNewButton_2 = new JButton("New button");
//		btnNewButton_2.setBounds(53, 86, 117, 25);
//		ShowtimePanel.add(btnNewButton_2);
//		
//		JButton btnNewButton_3 = new JButton("New button");
//		btnNewButton_3.setBounds(211, 86, 117, 25);
//		ShowtimePanel.add(btnNewButton_3);
//		
//		JButton btnNewButton_4 = new JButton("New button");
//		btnNewButton_4.setBounds(360, 86, 117, 25);
//		ShowtimePanel.add(btnNewButton_4);
//		
		ArrayList<Movie> movies = new ArrayList<>(MovieDao.getInstance().getAll());
		MoviePanel moviePanel = new MoviePanel(movies);
		moviePanel.setBounds(194, 32, 432, 379);
		contentPane.add(moviePanel);
		moviePanel.setLayout(null);
//        // Add the table to a JScrollPane
//        JScrollPane scrollPane = new JScrollPane(moviePanel.getMovieTable());
//
//        // Add the JScrollPane to the JFrame
//        contentPane.add(scrollPane);
		moviePanel.getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Movie> movies;
				try {
					contentPane.remove(moviePanel);
					movies = new ArrayList<>(
							MovieDao.getInstance().searchByKey("title", moviePanel.getTextField().getText()));
					moviePanel.updatePanel(movies);
					moviePanel.setBounds(194, 32, 432, 379);
					contentPane.add(moviePanel);
					moviePanel.setLayout(null);
					SwingUtilities.updateComponentTreeUI(contentPane);
					System.out.println("trigger search " + moviePanel.getTextField().getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
//		JTable table= moviePanel.getMovieTable();
//		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//	        public void valueChanged(ListSelectionEvent event) {
//	            // do some actions here, for example
//	            // print first column value from selected row
//	            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
//	        }
//		
//		MovieTable = new JTable();
//		MovieTable.setBounds(30, 212, 375, 112);
//		MovieTable.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column", "New column"
//			}
//		));
//		MoviePanel.add(MovieTable);
//		
//		textField = new JTextField();
//		textField.setBounds(98, 125, 114, 19);
//		MoviePanel.add(textField);
//		textField.setColumns(10);
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(217, 122, 117, 25);
//		MoviePanel.add(btnNewButton);
//		
//		JPanel SeatPanel = new JPanel();
//		SeatPanel.setBounds(157, 32, 442, 445);
//		contentPane.add(SeatPanel);
//		SeatPanel.setLayout(null);
//		
//		JButton btnNewButton_1 = new JButton("Screen");
//		btnNewButton_1.setBounds(38, 27, 351, 32);
//		SeatPanel.add(btnNewButton_1);
//		
//		JButton btnBack = new JButton("Back");
//		btnBack.setBounds(12, 0, 117, 25);
//		contentPane.add(btnBack);
	}
}
