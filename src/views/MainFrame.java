package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ShowtimePanel = new JPanel();
		ShowtimePanel.setBounds(114, 48, 553, 471);
		contentPane.add(ShowtimePanel);
		ShowtimePanel.setLayout(null);
		
		JLabel lblMovieName = new JLabel("Movie name");
		lblMovieName.setBounds(211, 28, 154, 15);
		ShowtimePanel.add(lblMovieName);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(53, 86, 117, 25);
		ShowtimePanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(195, 73, 117, 25);
		ShowtimePanel.add(btnNewButton_3);
		
		JPanel MoviePanel = new JPanel();
		MoviePanel.setBounds(194, 12, 432, 379);
		contentPane.add(MoviePanel);
		MoviePanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(30, 212, 375, 112);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		MoviePanel.add(table);
		
		textField = new JTextField();
		textField.setBounds(98, 125, 114, 19);
		MoviePanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(217, 122, 117, 25);
		MoviePanel.add(btnNewButton);
		
		JPanel SeatPanel = new JPanel();
		SeatPanel.setBounds(157, 32, 442, 445);
		contentPane.add(SeatPanel);
		SeatPanel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Screen");
		btnNewButton_1.setBounds(38, 27, 351, 32);
		SeatPanel.add(btnNewButton_1);
	}
}
