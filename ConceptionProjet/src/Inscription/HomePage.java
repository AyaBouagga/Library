package Inscription;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;


import javax.swing.JSeparator;
import javax.swing.JSlider;

import com.mysql.jdbc.ResultSetMetaData;


import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import java.awt.ComponentOrientation;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HomePage extends JFrame {

	public static JFrame frame;
	static int idOwner;
	JFileChooser file;
	String imagepath;
	Maconnection con ;
	ResultSet rs;
	ArrayList data_user=new ArrayList();
	ArrayList data_search=new ArrayList();
	ArrayList data_recent_book=new ArrayList();
	ArrayList data_sound_book=new ArrayList();
	ResultSetMetaData rsmd;
	boolean test1=true,test2=true;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel label;
	private JSeparator separator;
	private JLabel label_1;
	private JPanel panel_3;
	private JLabel label_2;
	private JSeparator separator_1;
	private JLabel label_4;
	private JPanel panel_4;
	private JLabel label_5;
	private JSeparator separator_2;
	private JLabel label_6;
	private RoundButton roundButton;
	private JButton button;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel label_7;
	private JSeparator separator_3;
	private JLabel label_8;
	private JPanel panel_7;
	private JLabel label_9;
	private JSeparator separator_4;
	private JLabel label_10;
	private JPanel panel_9;
	private JLabel label_11;
	private JSeparator separator_5;
	private JLabel label_12;
	private RoundButton roundButton_1;
	private JButton button_1;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel label_13;
	private JSeparator separator_6;
	private JLabel label_14;
	private JPanel panel_12;
	private JLabel label_15;
	private JSeparator separator_7;
	private JLabel label_16;
	private JPanel panel_13;
	private JLabel label_17;
	private JSeparator separator_8;
	private JLabel label_18;
	private RoundButton roundButton_2;
	private JButton button_2;
	private JPanel panel_14;
	private JPanel panel_15;
	private JLabel label_19;
	private JSeparator separator_9;
	private JLabel label_20;
	private JPanel panel_16;
	private JLabel label_21;
	private JSeparator separator_10;
	private JLabel label_22;
	private JPanel panel_17;
	private JLabel label_23;
	private JSeparator separator_11;
	private JLabel label_24;
	private RoundButton roundButton_3;
	private JButton button_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage(1);
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public HomePage(int owner) throws SQLException {
		idOwner=owner;	
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("deprecation")
	private void initialize() throws SQLException {
		
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setBounds(0, 0,1023, 561 );
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p4 = new RoundedPanel(20);


		JPanel contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(0, 0, 997, 511);
		contentPane.setPreferredSize(new Dimension(976, 540));
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(977, 250));
		panel.setBounds(0, 0, 1030, 511);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setFocusable(true);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(10, 11, 954, 118);
		panel.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(10, 31, 191, 42);
		panel_1.add(panel_2);
		
		label = new JLabel("Membre Name :");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label.setBounds(13, 5, 127, 21);
		panel_2.add(label);
		
		separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(13, 24, 85, 2);
		panel_2.add(separator);
		
		label_1 = new JLabel("aya");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(125, 7, 109, 19);
		panel_2.add(label_1);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(221, 31, 271, 42);
		panel_1.add(panel_3);
		
		label_2 = new JLabel("Membre Diplome:");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_2.setBounds(13, 5, 127, 21);
		panel_3.add(label_2);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(13, 24, 109, 2);
		panel_3.add(separator_1);
		
		label_4 = new JLabel("Ing_inf");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(152, 5, 109, 19);
		panel_3.add(label_4);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(500, 31, 271, 42);
		panel_1.add(panel_4);
		
		label_5 = new JLabel("Membre type:");
		label_5.setForeground(Color.LIGHT_GRAY);
		label_5.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_5.setBounds(13, 5, 127, 21);
		panel_4.add(label_5);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(13, 24, 85, 2);
		panel_4.add(separator_2);
		
		label_6 = new JLabel("Info");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(125, 7, 109, 19);
		panel_4.add(label_6);
		
		roundButton = new RoundButton("");
		roundButton.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\projetjavasourses\\Imagesuser\\122491.png"));
		roundButton.setSelected(true);
		roundButton.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		roundButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		roundButton.setBackground(Color.BLACK);
		roundButton.setBounds(786, 11, 113, 96);
		panel_1.add(roundButton);
		
		button = new JButton("Affecter");
		button.setBackground(Color.RED);
		button.setBounds(338, 84, 89, 23);
		panel_1.add(button);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setFocusable(true);
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(10, 137, 954, 118);
		panel.add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(10, 31, 191, 42);
		panel_5.add(panel_6);
		
		label_7 = new JLabel("Membre Name :");
		label_7.setForeground(Color.LIGHT_GRAY);
		label_7.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_7.setBounds(13, 5, 127, 21);
		panel_6.add(label_7);
		
		separator_3 = new JSeparator();
		separator_3.setBackground(Color.LIGHT_GRAY);
		separator_3.setBounds(13, 24, 85, 2);
		panel_6.add(separator_3);
		
		label_8 = new JLabel("aya");
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(125, 7, 109, 19);
		panel_6.add(label_8);
		
		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(221, 31, 271, 42);
		panel_5.add(panel_7);
		
		label_9 = new JLabel("Membre Diplome:");
		label_9.setForeground(Color.LIGHT_GRAY);
		label_9.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_9.setBounds(13, 5, 127, 21);
		panel_7.add(label_9);
		
		separator_4 = new JSeparator();
		separator_4.setBackground(Color.LIGHT_GRAY);
		separator_4.setBounds(13, 24, 109, 2);
		panel_7.add(separator_4);
		
		label_10 = new JLabel("Ing_inf");
		label_10.setForeground(Color.WHITE);
		label_10.setBounds(152, 5, 109, 19);
		panel_7.add(label_10);
		
		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(500, 31, 271, 42);
		panel_5.add(panel_9);
		
		label_11 = new JLabel("Membre type:");
		label_11.setForeground(Color.LIGHT_GRAY);
		label_11.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_11.setBounds(13, 5, 127, 21);
		panel_9.add(label_11);
		
		separator_5 = new JSeparator();
		separator_5.setBackground(Color.LIGHT_GRAY);
		separator_5.setBounds(13, 24, 85, 2);
		panel_9.add(separator_5);
		
		label_12 = new JLabel("Info");
		label_12.setForeground(Color.WHITE);
		label_12.setBounds(125, 7, 109, 19);
		panel_9.add(label_12);
		
		roundButton_1 = new RoundButton("");
		roundButton_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\projetjavasourses\\Imagesuser\\149074.png"));
		roundButton_1.setSelected(true);
		roundButton_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		roundButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		roundButton_1.setBackground(Color.BLACK);
		roundButton_1.setBounds(803, 11, 113, 96);
		panel_5.add(roundButton_1);
		
		button_1 = new JButton("Affecter");
		button_1.setBackground(Color.RED);
		button_1.setBounds(343, 84, 89, 23);
		panel_5.add(button_1);
		
		panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setFocusable(true);
		panel_10.setBackground(Color.BLACK);
		panel_10.setBounds(10, 266, 954, 118);
		panel.add(panel_10);
		
		panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(10, 31, 191, 42);
		panel_10.add(panel_11);
		
		label_13 = new JLabel("Membre Name :");
		label_13.setForeground(Color.LIGHT_GRAY);
		label_13.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_13.setBounds(13, 5, 127, 21);
		panel_11.add(label_13);
		
		separator_6 = new JSeparator();
		separator_6.setBackground(Color.LIGHT_GRAY);
		separator_6.setBounds(13, 24, 85, 2);
		panel_11.add(separator_6);
		
		label_14 = new JLabel("aya");
		label_14.setForeground(Color.WHITE);
		label_14.setBounds(125, 7, 109, 19);
		panel_11.add(label_14);
		
		panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(Color.BLACK);
		panel_12.setBounds(221, 31, 271, 42);
		panel_10.add(panel_12);
		
		label_15 = new JLabel("Membre Diplome:");
		label_15.setForeground(Color.LIGHT_GRAY);
		label_15.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_15.setBounds(13, 5, 127, 21);
		panel_12.add(label_15);
		
		separator_7 = new JSeparator();
		separator_7.setBackground(Color.LIGHT_GRAY);
		separator_7.setBounds(13, 24, 109, 2);
		panel_12.add(separator_7);
		
		label_16 = new JLabel("Ing_inf");
		label_16.setForeground(Color.WHITE);
		label_16.setBounds(152, 5, 109, 19);
		panel_12.add(label_16);
		
		panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(Color.BLACK);
		panel_13.setBounds(500, 31, 271, 42);
		panel_10.add(panel_13);
		
		label_17 = new JLabel("Membre type:");
		label_17.setForeground(Color.LIGHT_GRAY);
		label_17.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_17.setBounds(13, 5, 127, 21);
		panel_13.add(label_17);
		
		separator_8 = new JSeparator();
		separator_8.setBackground(Color.LIGHT_GRAY);
		separator_8.setBounds(13, 24, 85, 2);
		panel_13.add(separator_8);
		
		label_18 = new JLabel("Info");
		label_18.setForeground(Color.WHITE);
		label_18.setBounds(125, 7, 109, 19);
		panel_13.add(label_18);
		
		roundButton_2 = new RoundButton("");
		roundButton_2.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\projetjavasourses\\Imagesuser\\167750.png"));
		roundButton_2.setSelected(true);
		roundButton_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		roundButton_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		roundButton_2.setBackground(Color.BLACK);
		roundButton_2.setBounds(807, 11, 113, 96);
		panel_10.add(roundButton_2);
		
		button_2 = new JButton("Affecter");
		button_2.setBackground(Color.RED);
		button_2.setBounds(348, 84, 89, 23);
		panel_10.add(button_2);
		
		panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setFocusable(true);
		panel_14.setBackground(Color.BLACK);
		panel_14.setBounds(10, 389, 954, 122);
		panel.add(panel_14);
		
		panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.BLACK);
		panel_15.setBounds(10, 31, 191, 42);
		panel_14.add(panel_15);
		
		label_19 = new JLabel("Membre Name :");
		label_19.setForeground(Color.LIGHT_GRAY);
		label_19.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_19.setBounds(13, 5, 127, 21);
		panel_15.add(label_19);
		
		separator_9 = new JSeparator();
		separator_9.setBackground(Color.LIGHT_GRAY);
		separator_9.setBounds(13, 24, 85, 2);
		panel_15.add(separator_9);
		
		label_20 = new JLabel("aya");
		label_20.setForeground(Color.WHITE);
		label_20.setBounds(125, 7, 109, 19);
		panel_15.add(label_20);
		
		panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBackground(Color.BLACK);
		panel_16.setBounds(221, 31, 271, 42);
		panel_14.add(panel_16);
		
		label_21 = new JLabel("Membre Diplome:");
		label_21.setForeground(Color.LIGHT_GRAY);
		label_21.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_21.setBounds(13, 5, 127, 21);
		panel_16.add(label_21);
		
		separator_10 = new JSeparator();
		separator_10.setBackground(Color.LIGHT_GRAY);
		separator_10.setBounds(13, 24, 109, 2);
		panel_16.add(separator_10);
		
		label_22 = new JLabel("Ing_inf");
		label_22.setForeground(Color.WHITE);
		label_22.setBounds(152, 5, 109, 19);
		panel_16.add(label_22);
		
		panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBackground(Color.BLACK);
		panel_17.setBounds(500, 31, 271, 42);
		panel_14.add(panel_17);
		
		label_23 = new JLabel("Membre type:");
		label_23.setForeground(Color.LIGHT_GRAY);
		label_23.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		label_23.setBounds(13, 5, 127, 21);
		panel_17.add(label_23);
		
		separator_11 = new JSeparator();
		separator_11.setBackground(Color.LIGHT_GRAY);
		separator_11.setBounds(13, 24, 85, 2);
		panel_17.add(separator_11);
		
		label_24 = new JLabel("Info");
		label_24.setForeground(Color.WHITE);
		label_24.setBounds(125, 7, 109, 19);
		panel_17.add(label_24);
		
		roundButton_3 = new RoundButton("");
		roundButton_3.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\projetjavasourses\\Imagesuser\\149074.png"));
		roundButton_3.setSelected(true);
		roundButton_3.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		roundButton_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		roundButton_3.setBackground(Color.BLACK);
		roundButton_3.setBounds(807, 0, 109, 107);
		panel_14.add(roundButton_3);
		
		button_3 = new JButton("Affecter");
		button_3.setBackground(Color.RED);
		button_3.setBounds(357, 84, 89, 23);
		panel_14.add(button_3);
 frame.getContentPane().add(contentPane);
		

		

		
	}
	public ImageIcon ResizeImage(String ImagePath,JComponent c)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
}
