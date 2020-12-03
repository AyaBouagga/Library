package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.DebugGraphics;
import java.awt.Insets;

public class AddBook extends JFrame {

	public JFrame frame;
	public User u;
	public int i=0;
	int compteur=0;
	String pass;
	JFileChooser file;
	JLabel label;
	public  Maconnection con;
	ArrayList listKey;
	String ch="" ;
	String imagepath,path;
	static int idOwner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook(1);
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
	public AddBook(int owner) {
		initialize();
		idOwner=owner;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181.png"));
		frame.setBounds(new Rectangle(400, 200, 400, 4000));
		this.setBounds(400, 700, 424, 358);
		frame.setBackground(new Color(153, 0, 0));
		frame.getContentPane().setFocusCycleRoot(true);
		frame.getContentPane().setBackground(new Color(153, 0, 0));
		frame.getContentPane().setForeground(Color.WHITE);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnPdf = new JButton("Pdf");new RoundButton("");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookPdf window;
				try {
					window = new BookPdf(idOwner);
					window.frame.setVisible(true);
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPdf.setToolTipText("pdf");
		btnPdf.setMargin(new Insets(10, 10, 10, 10));
		btnPdf.setForeground(Color.DARK_GRAY);
		btnPdf.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPdf.setFocusable(false);
		btnPdf.setFocusTraversalKeysEnabled(false);
		btnPdf.setFocusPainted(false);
		btnPdf.setDoubleBuffered(true);
		btnPdf.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		btnPdf.setBackground(Color.WHITE);
		btnPdf.setAlignmentX(0.5f);
		btnPdf.setBounds(22, 167, 213, 36);
		panel.add(btnPdf);
		
		JButton btnSound = new JButton("Sound");
		btnSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BookSound window = new BookSound(idOwner);
					window.frame.setVisible(true);
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSound.setToolTipText("Sound");
		btnSound.setMargin(new Insets(10, 10, 10, 10));
		btnSound.setForeground(Color.DARK_GRAY);
		btnSound.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSound.setFocusable(false);
		btnSound.setFocusTraversalKeysEnabled(false);
		btnSound.setFocusPainted(false);
		btnSound.setDoubleBuffered(true);
		btnSound.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		btnSound.setBackground(Color.WHITE);
		btnSound.setAlignmentX(0.5f);
		btnSound.setBounds(268, 167, 213, 36);
		panel.add(btnSound);
		
		JLabel label_3 = new JLabel("Add Book");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arabic Typesetting", Font.BOLD, 34));
		label_3.setBounds(34, 24, 151, 45);
		panel.add(label_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 80, 447, 2);
		panel.add(separator);
		
		JLabel lblWhichCategoryTo = new JLabel("Which category to prefer ?");
		lblWhichCategoryTo.setForeground(new Color(211, 211, 211));
		lblWhichCategoryTo.setFont(new Font("Arabic Typesetting", Font.PLAIN, 16));
		lblWhichCategoryTo.setBounds(33, 122, 162, 25);
		panel.add(lblWhichCategoryTo);
		//___________________________________________________________
		con=new Maconnection("biblio");
		listKey= new ArrayList();

		String tab[]= {"Fantast","Science Fiction","Mystery Fiction","Memoir","Biography","Westerns","Dystopia","Add Another"};
		frame.setBounds(100, 100, 519, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		u=new User();
		con=new Maconnection("biblio");
		pass=new String();

	}

	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}}


	class Mouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}}


	
	


	class User{
		String name; 
		String pass;
	}
}