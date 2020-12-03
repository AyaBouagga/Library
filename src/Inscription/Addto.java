package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
import java.awt.Dimension;
import javax.swing.JPanel;

public class Addto extends JFrame {

	public JFrame frame;
	public User u;
	public int i=0;
	int compteur=0;
	int idbook;
	String pass;
	JFileChooser file;
	JLabel label;
	public  Maconnection con;
	JButton btnIHaveBeaan;
	ArrayList listKey;
	String ch="" ;
	String imagepath,path;
	int idOwner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addto window = new Addto(0,0);
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
	public Addto(int owner,int idbook) {
		initialize();
		idOwner=owner;
		this.idbook=idbook;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setUndecorated(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181.png"));
		frame.setBounds(new Rectangle(400, 200, 400, 300));
		this.setBounds(400, 700, 424, 208);
		frame.setBackground(new Color(153, 0, 0));
		frame.getContentPane().setFocusCycleRoot(true);
		frame.getContentPane().setBackground(new Color(153, 0, 0));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		con=new Maconnection("biblio");

		JLabel lblNewLabel_4 = new JLabel("Add to ");
		lblNewLabel_4.setFont(new Font("Arabic Typesetting", Font.BOLD, 40));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(143, 107, 126, 69);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(110, 280, 46, 14);
		frame.getContentPane().add(label_3);
		listKey= new ArrayList();

		String tab[]= {"Fantast","Science Fiction","Mystery Fiction","Memoir","Biography","Westerns","Dystopia","Add Another"};


		JButton btnIamReading = new JButton("I'am reading");
		btnIamReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnIamReading.setForeground(Color.WHITE);
		btnIamReading.setSelected(true);
		btnIamReading.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnIamReading.setBorder(null);
		btnIamReading.setBackground(Color.LIGHT_GRAY);
		btnIamReading.setBounds(146, 187, 105, 82);
		frame.getContentPane().add(btnIamReading);

		btnIHaveBeaan = new JButton("<html> I have been<br> readed</html>");
		
		btnIHaveBeaan.setSelected(true);
		btnIHaveBeaan.setForeground(Color.WHITE);
		btnIHaveBeaan.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnIHaveBeaan.setBorder(null);
		btnIHaveBeaan.setBackground(Color.LIGHT_GRAY);
		btnIHaveBeaan.setBounds(271, 187, 112, 82);
		frame.getContentPane().add(btnIHaveBeaan);
		
		JButton btnToRead = new JButton("To read");
		btnToRead.setSelected(true);
		btnToRead.setForeground(Color.WHITE);
		btnToRead.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnToRead.setBorder(null);
		btnToRead.setBackground(Color.LIGHT_GRAY);
		btnToRead.setBounds(25, 187, 105, 82);
		frame.getContentPane().add(btnToRead);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 413, 56);
		frame.getContentPane().add(panel);
				panel.setLayout(null);
		
				JLabel label_1 = new JLabel("");
				label_1.setBounds(0, 0, 60, 56);
				panel.add(label_1);
				label_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String response = javax.swing.JOptionPane.showInputDialog("Are you sure that you want to leave this page !! (yes|no) "); 
						if (response.equals("yes")) {
							PersonalisedProfil pp;
							try {
								pp = new PersonalisedProfil(idOwner);
								frame.dispose();
								pp.frame.setVisible(true);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}

					}
				});
				label_1.setIcon(ResizeImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181 - Copie.png",label_1));
				
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\error.png"));
				button.setSelected(true);
				button.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
				button.setBorder(null);
				button.setBackground(Color.WHITE);
				button.setBounds(368, 11, 35, 34);
				panel.add(button);
				
				JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
				separator.setBounds(135, 186, 10, 83);
				frame.getContentPane().add(separator);
				
				JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
				separator_1.setBounds(259, 187, 10, 83);
				frame.getContentPane().add(separator_1);
		frame.setBounds(100, 100, 416, 336);
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


	public ImageIcon ResizeImage(String ImagePath,Component c)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(c.getWidth(),c.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

	


	class User{
		String name; 
		String pass;
	}
}