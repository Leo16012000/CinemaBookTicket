package views;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dao.MovieDao;
import models.Movie;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MoviePanel extends JPanel {
	private JTable movieTable = new JTable();
	private JTextField textField = new JTextField();
	private JButton btnSearch = new JButton("Search"); 
    private DefaultTableModel model = new DefaultTableModel();
	/**
	 * Create the panel.
	 */
	public MoviePanel(ArrayList<Movie> movies) {
		this.updatePanel(movies);
	}
	public void updatePanel(ArrayList<Movie> movies) {
		model = new DefaultTableModel();
		// Add columns to the table
        model.addColumn("Title");
        model.addColumn("Country");
        model.addColumn("Duration time");
        model.addColumn("Ticket price");
		// Add rows to the table
        for (Movie obj : movies) {
            String[] row = {obj.getTitle(), obj.getCountry(), Integer.toString(obj.getDurationTime()), Integer.toString(obj.getPrice())};
            model.addRow(row);
        }
		movieTable.setBounds(30, 212, 375, 112);
//				movieTable.setModel(new DefaultTableModel(
//					new Object[][] {
//						{1, 2, 3, null, null},
//						{null, null, null, null, null},
//						{null, null, null, null, null},
//						{null, null, null, null, null},
//						{null, null, null, null, null},
//						{null, null, null, null, null},
//						{null, null, null, null, null},
//					},
//					new String[] {
//						"New column", "New column", "New column", "New column", "New column"
//					}
//				));
		        movieTable.setModel(model);
		        this.add(movieTable);
		
		textField.setBounds(98, 125, 114, 19);
		this.add(textField);
		textField.setColumns(10);
		
		getBtnSearch().setBounds(217, 122, 117, 25);
		this.add(getBtnSearch());
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTable getMovieTable() {
		return movieTable;
	}
}
