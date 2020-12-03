package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class Btnfriends extends JPanel {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//BtnAll window = new BtnAll();
					//window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Btnfriends () {
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Friends", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(153, 0, 0)));
		setLayout(null);
		
		JLabel lblDate = new JLabel("date");
		lblDate.setForeground(Color.LIGHT_GRAY);
		lblDate.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblDate.setBounds(360, 64, 52, 29);
		add(lblDate);
		
		JLabel lblRecentActivity = new JLabel("Recent friends");
		lblRecentActivity.setBackground(Color.WHITE);
		lblRecentActivity.setForeground(new Color(153, 0, 0));
		lblRecentActivity.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblRecentActivity.setBounds(10, 40, 88, 29);
		add(lblRecentActivity);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 392, 2);
		add(separator);
		
		JLabel lblRecentQuotes = new JLabel("Suggestions");
		lblRecentQuotes.setForeground(new Color(153, 0, 0));
		lblRecentQuotes.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblRecentQuotes.setBackground(Color.WHITE);
		lblRecentQuotes.setBounds(10, 169, 88, 29);
		add(lblRecentQuotes);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 191, 392, 2);
		add(separator_1);
		
		JLabel lblViewAll = new JLabel("View all");
		lblViewAll.setForeground(Color.LIGHT_GRAY);
		lblViewAll.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblViewAll.setBounds(350, 40, 52, 29);
		add(lblViewAll);
		
		JLabel label = new JLabel("View all");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		label.setBounds(350, 169, 52, 29);
		add(label);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(0, 0, 412, 340);
	}

}
