package views;

import java.awt.GridBagConstraints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private JButton btnLogin;
	private JLabel lblName;
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		Icon icon = new ImageIcon("/../resources/images/back.png");
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(45, 65, 80, 25);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(45, 25, 80, 25);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(0, 30, 70, 15);
		
		GridBagConstraints gc = new GridBagConstraints();
//		First column ////////////////////
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		add(lblName, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(btnLogin, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(btnBack, gc);
	}
}
