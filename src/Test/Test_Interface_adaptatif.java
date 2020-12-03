package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Dimension;

public class Test_Interface_adaptatif extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_Interface_adaptatif window = new Test_Interface_adaptatif();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test_Interface_adaptatif() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setToolTipText("gggg");
		panel.setBackground(Color.WHITE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(40, 64, 70, 70);
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 421, 177, 210);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.RED);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(10, 46, 129, 1);
		panel_2.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(10, 85, 129, 1);
		panel_2.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(10, 132, 129, 1);
		panel_2.add(separator_2);
		
		JButton button = new JButton("Discussion groupes");
		button.setSelected(true);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arabic Typesetting", Font.BOLD, 22));
		button.setBorder(null);
		button.setBackground(Color.RED);
		button.setBounds(1, 11, 154, 24);
		panel_2.add(button);
		
		JButton button_1 = new JButton("I'am reading");
		button_1.setSelected(true);
		button_1.setHorizontalAlignment(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 22));
		button_1.setBorder(null);
		button_1.setBackground(Color.RED);
		button_1.setAlignmentX(0.0f);
		button_1.setBounds(1, 50, 154, 24);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("I want to read");
		button_2.setSelected(true);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 22));
		button_2.setBorder(null);
		button_2.setBackground(Color.RED);
		button_2.setBounds(1, 97, 154, 24);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("I have been reading");
		button_3.setSelected(true);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Arabic Typesetting", Font.BOLD, 22));
		button_3.setBorder(null);
		button_3.setBackground(Color.RED);
		button_3.setBounds(1, 144, 154, 24);
		panel_2.add(button_3);
		
		JLabel label = new JLabel("Name ");
		label.setBounds(53, 145, 101, 14);
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(20, 4, 20, 20);
		panel_5.add(label_1);
		
		JLabel label_2 = new JLabel("0 Quotes");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		label_2.setBounds(50, -2, 46, 33);
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("View All");
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		label_3.setBounds(135, -2, 46, 33);
		panel_5.add(label_3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBackground(new Color(211, 211, 211));
		separator_3.setBounds(15, 27, 166, 2);
		panel_5.add(separator_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(10, 13, 20, 20);
		panel_6.add(label_4);
		
		JLabel label_5 = new JLabel("0 Following");
		label_5.setForeground(Color.LIGHT_GRAY);
		label_5.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		label_5.setBounds(40, 11, 56, 33);
		panel_6.add(label_5);
		
		JLabel label_6 = new JLabel("View All");
		label_6.setForeground(Color.LIGHT_GRAY);
		label_6.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		label_6.setBounds(130, 11, 46, 33);
		panel_6.add(label_6);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBackground(new Color(211, 211, 211));
		separator_4.setBounds(10, 44, 166, 2);
		panel_6.add(separator_4);
		
		JSeparator separator_5 = new JSeparator(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.LIGHT_GRAY);
		separator_5.setBackground(Color.LIGHT_GRAY);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
							.addGap(34)
							.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
								.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)))))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(175, 0, 37, 631);
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_1.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(menuBar);
		panel.add(label);
		panel.add(panel_2);
		panel.add(panel_1);
		
		JButton button_4 = new JButton("All");
		button_4.setSelected(true);
		button_4.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button_4.setBorder(null);
		button_4.setBackground(Color.WHITE);
		
		JButton button_5 = new JButton("Books");
		button_5.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button_5.setBorder(null);
		button_5.setBackground(Color.WHITE);
		
		JButton button_6 = new JButton("Friends");
		button_6.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button_6.setBorder(null);
		button_6.setBackground(Color.WHITE);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setAlignmentX(Component.LEFT_ALIGNMENT);
		separator_7.setForeground(Color.LIGHT_GRAY);
		separator_7.setBackground(Color.LIGHT_GRAY);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.LIGHT_GRAY);
		separator_8.setBackground(Color.LIGHT_GRAY);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.LIGHT_GRAY);
		separator_6.setBackground(Color.LIGHT_GRAY);
		separator_6.setAlignmentX(0.0f);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setForeground(Color.LIGHT_GRAY);
		separator_10.setBackground(Color.LIGHT_GRAY);
		separator_10.setAlignmentX(0.0f);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setForeground(Color.LIGHT_GRAY);
		separator_11.setBackground(Color.LIGHT_GRAY);
		separator_11.setAlignmentX(0.0f);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setForeground(Color.LIGHT_GRAY);
		separator_9.setBackground(Color.LIGHT_GRAY);
		separator_9.setAlignmentX(0.0f);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setPreferredSize(new Dimension(0, 0));
		separator_12.setForeground(Color.LIGHT_GRAY);
		separator_12.setBackground(Color.LIGHT_GRAY);
		separator_12.setAlignmentX(0.0f);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_6, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addGap(2)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addComponent(separator_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_10, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(10)
							.addComponent(button_5))
						.addComponent(separator_8, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(separator_11, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(separator_12, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(separator_9, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
						.addComponent(button_6))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_10, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
								.addComponent(separator_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_12, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_11, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		frame.getContentPane().setLayout(groupLayout);

	}
}
