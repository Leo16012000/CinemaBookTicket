package views;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.UserFramePanels.MoviesPanel;
import views.UserFramePanels.SessionsPanel;
import views.UserFramePanels.TicketsPanel;

public class UserFrame extends JFrame {
    private JPanel mainPanel;
    private MoviesPanel filmsPanel;
    private TicketsPanel ticketsPanel;
    private int auditoriumId, showtimeId;
    private CardLayout cl = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
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
	public UserFrame() {
	        mainPanel = new JPanel();
	        mainPanel.setSize(800, 600);
	        mainPanel.setLayout(cl);
	        	
//	        ticketsPanel = new TicketsPanel(auditoriumId, showtimeId);

	        filmsPanel = new MoviesPanel();
	        

	        mainPanel.add(filmsPanel, "1");
//	        mainPanel.add(ticketsPanel, "3");
	        cl.show(mainPanel, "1");

	        this.getContentPane().add(mainPanel);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setSize(800, 600);
	        this.setTitle("Cinema_0371");
	        this.setLocationRelativeTo(null);
	        this.setLayout(cl);
	        this.setVisible(true);
	}

}
