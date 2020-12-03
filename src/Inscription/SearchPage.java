package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import java.awt.Container;
import javax.swing.JSeparator;
import java.awt.Component;

public class SearchPage extends JPanel {



	JPanel panel_2;

	/**
	 * Create the application.
	 */
	public SearchPage() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 0, 0));
		panel.setBounds(0, 0, 997, 45);
		add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("All");
		button.setForeground(Color.WHITE);
		button.setBounds(95, 5, 51, 29);
		button.setSelected(true);
		button.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button.setBorder(null);
		button.setBackground(new Color(153, 0, 0));
		panel.add(button);
		
		JButton btnBook = new JButton("Book");
		btnBook.setSelected(true);
		btnBook.setForeground(Color.WHITE);
		btnBook.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnBook.setBorder(null);
		btnBook.setBackground(new Color(153, 0, 0));
		btnBook.setBounds(170, 5, 51, 29);
		panel.add(btnBook);
		
		JButton btnGen = new JButton("Genre");
		btnGen.setSelected(true);
		btnGen.setForeground(Color.WHITE);
		btnGen.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnGen.setBorder(null);
		btnGen.setBackground(new Color(153, 0, 0));
		btnGen.setBounds(248, 5, 69, 29);
		panel.add(btnGen);
		
		JButton btnWriter = new JButton("Writer");
		btnWriter.setSelected(true);
		btnWriter.setForeground(Color.WHITE);
		btnWriter.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnWriter.setBorder(null);
		btnWriter.setBackground(new Color(153, 0, 0));
		btnWriter.setBounds(342, 5, 69, 29);
		panel.add(btnWriter);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(153, 0, 0));
		separator.setBackground(new Color(153, 0, 0));
		separator.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		separator.setAlignmentX(Component.RIGHT_ALIGNMENT);
		separator.setBounds(95, 40, 59, 4);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(153, 0, 0));
		separator_1.setForeground(new Color(153, 0, 0));
		separator_1.setAlignmentY(1.0f);
		separator_1.setAlignmentX(1.0f);
		separator_1.setBounds(170, 40, 59, 4);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(153, 0, 0));
		separator_2.setBackground(new Color(153, 0, 0));
		separator_2.setAlignmentY(1.0f);
		separator_2.setAlignmentX(1.0f);
		separator_2.setBounds(248, 40, 59, 4);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(153, 0, 0));
		separator_3.setForeground(new Color(153, 0, 0));
		separator_3.setAlignmentY(1.0f);
		separator_3.setAlignmentX(1.0f);
		separator_3.setBounds(342, 40, 59, 4);
		panel.add(separator_3);
		JPanel panel_1 = new JPanel(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setPreferredSize(new Dimension(500, 400));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 51, 977, 430);
		add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 977, 430);
		panel_1.add(scrollPane);
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
	

		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(0, 0, 997, 492);
		
	}
}
