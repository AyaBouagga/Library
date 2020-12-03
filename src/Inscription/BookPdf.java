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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.ResultSet;


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

public class BookPdf extends JPanel{

	public JFrame frame;
	private JTextField txt_name;
	public User u;
	public int i=0;
	int compteur=0;
	String pass;
	JButton btnCancel,btnNext;
	private JTextField textWriter;
	private JTextField textKey;
	JFileChooser file;
	JLabel label;
	public  Maconnection con;
	JComboBox comboBox;
	JButton button_1;
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
					BookPdf window = new BookPdf(idOwner);
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
	public BookPdf(int owner) throws SQLException {
		initialize();
		idOwner=owner;
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181.png"));
		frame.setBounds(new Rectangle(400, 200, 400, 4000));
		this.setBounds(400, 700, 424, 358);
		frame.setBackground(new Color(153, 0, 0));
		frame.getContentPane().setFocusCycleRoot(true);
		frame.getContentPane().setBackground(new Color(153, 0, 0));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		con=new Maconnection("biblio");
		ResultSet rs=(ResultSet) con.selection("SELECT count(*) FROM `book`");
		while(rs.next()) {
		compteur=rs.getInt(1);}
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(204, 0, 0));
		btnCancel.setBounds(317, 491, 78, 23);
		frame.getContentPane().add(btnCancel);

		btnNext = new JButton("Ok");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList l= new ArrayList();
				l.add(compteur+1);
				l.add(idOwner);
				l.add(txt_name.getText());
				l.add(textWriter.getText());
				l.add(comboBox.getSelectedItem());
				l.add(textKey.getText());
				l.add(path);
				l.add(imagepath);
				l.add(0);
				l.add("pdf");
				System.out.println(l.get(l.size()-1));
				try {
					con.ajout("book",l);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(new Color(204, 0, 0));
		btnNext.setBounds(242, 491, 65, 23);
		frame.getContentPane().add(btnNext);

		JLabel lblBookName = new JLabel("BooK Name");
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookName.setBounds(35, 118, 86, 20);
		frame.getContentPane().add(lblBookName);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 0, 0));
		separator.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		separator.setBounds(165, 171, 105, 2);
		frame.getContentPane().add(separator);

		txt_name = new JTextField();
		txt_name.setBorder(null);
		txt_name.setBounds(165, 118, 105, 20);
		frame.getContentPane().add(txt_name);
		txt_name.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(204, 0, 0));
		separator_1.setAlignmentY(1.0f);
		separator_1.setBounds(165, 203, 105, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(204, 0, 0));
		separator_2.setAlignmentY(1.0f);
		separator_2.setBounds(165, 139, 105, 2);
		frame.getContentPane().add(separator_2);

		JLabel lblNewLabel_4 = new JLabel("Add Book");
		lblNewLabel_4.setFont(new Font("Arabic Typesetting", Font.BOLD, 34));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(35, 21, 151, 45);
		frame.getContentPane().add(lblNewLabel_4);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 67, 385, 2);
		frame.getContentPane().add(separator_3);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(110, 280, 46, 14);
		frame.getContentPane().add(label_3);

		JLabel lblBookGenre = new JLabel("BooK genre");
		lblBookGenre.setForeground(Color.WHITE);
		lblBookGenre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookGenre.setBounds(35, 149, 86, 20);
		frame.getContentPane().add(lblBookGenre);

		JLabel lblEcrivan = new JLabel("Writer ");
		lblEcrivan.setForeground(Color.WHITE);
		lblEcrivan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEcrivan.setBounds(35, 182, 86, 20);
		frame.getContentPane().add(lblEcrivan);

		textWriter = new JTextField();
		textWriter.setColumns(10);
		textWriter.setBorder(null);
		textWriter.setBounds(165, 182, 105, 20);
		frame.getContentPane().add(textWriter);

		textKey = new JTextField();
		listKey= new ArrayList();

		textKey.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if(e.getKeyCode()!=KeyEvent.VK_SPACE&e.getKeyCode()!=KeyEvent.VK_ENTER ) {
					ch +=e.getKeyChar();
					System.out.println(e.getKeyChar());
				}
			}

			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					listKey.add(ch);
					System.out.println(ch);
					ch="";
				}
			}
		});
		textKey.setColumns(10);
		textKey.setBorder(null);
		textKey.setBounds(165, 220, 206, 64);
		frame.getContentPane().add(textKey);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(204, 0, 0));
		separator_4.setAlignmentY(1.0f);
		separator_4.setBounds(165, 285, 206, 2);
		frame.getContentPane().add(separator_4);

		String tab[]= {"Fantast","Science Fiction","Mystery Fiction","Memoir","Biography","Westerns","Dystopia","Add Another"};

		comboBox = new JComboBox(tab);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Add Another")) {
					try {
						String response = javax.swing.JOptionPane.showInputDialog("Add genre"); 
						if (!response.isEmpty()){
							comboBox.removeItem("Add Another");
							comboBox.addItem(response);
							comboBox.addItem("Add Another");
						}}catch(NullPointerException conceladd) {}
				}}
		});
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.GRAY);
		comboBox.setBounds(165, 149, 105, 20);
		frame.getContentPane().add(comboBox);


		JButton button = new JButton("+\r\n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filepdf = new JFileChooser();
				filepdf.setCurrentDirectory(new File(System.getProperty("user.home")));

				//filter the files
				FileNameExtensionFilter  pdf = new FileNameExtensionFilter("Pdf file(.pdf)", "pdf");

				filepdf.addChoosableFileFilter(pdf);
				int result = filepdf.showSaveDialog(null);

				//if the user click on save in Jfilechooser
				if(result == JFileChooser.APPROVE_OPTION){
					File selectedFile = filepdf.getSelectedFile();
					path = selectedFile.getAbsolutePath();
					button.setIcon(ResizeImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\ok.png"));
					button.setText("");
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setSelected(true);
		button.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button.setBorder(null);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(51, 388, 105, 82);
		frame.getContentPane().add(button);

		JLabel lblImageDacceuilPour = new JLabel("Select file of the book ");
		lblImageDacceuilPour.setForeground(Color.WHITE);
		lblImageDacceuilPour.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblImageDacceuilPour.setBounds(10, 357, 206, 20);
		frame.getContentPane().add(lblImageDacceuilPour);

		button_1 = new JButton("+\r\n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


		     	file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));

				//filter the files
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);

				//if the user click on save in Jfilechooser
				if(result == JFileChooser.APPROVE_OPTION){
					File selectedFile = file.getSelectedFile();
					imagepath = selectedFile.getAbsolutePath();
					System.out.println(imagepath );
					button_1.setText("");
					button_1.setIcon(ResizeImage(imagepath));

				}

				//if the user click on save in Jfilechooser


				else if(result == JFileChooser.CANCEL_OPTION){
					System.out.println("No File Select");
				}

			}
		});
		button_1.setSelected(true);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button_1.setBorder(null);
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(226, 388, 105, 82);
		frame.getContentPane().add(button_1);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 335, 393, 2);
		frame.getContentPane().add(separator_5);

		JLabel lblKeyWords = new JLabel("Key Words");
		lblKeyWords.setForeground(Color.WHITE);
		lblKeyWords.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKeyWords.setBounds(35, 223, 78, 20);
		frame.getContentPane().add(lblKeyWords);

		JLabel lblBookImage = new JLabel("Book Image");
		lblBookImage.setForeground(Color.WHITE);
		lblBookImage.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBookImage.setBounds(226, 357, 120, 20);
		frame.getContentPane().add(lblBookImage);

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String response = javax.swing.JOptionPane.showInputDialog("Are you sure that you want to leave this page !! (yes|no) "); 
				if (response.equals("yes")) {
					PersonalisedProfil pp;
					try {
						pp = new PersonalisedProfil(idOwner);
					
					frame.dispose();
					pp.frame.setVisible(true);} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}

			}
		});
		label_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181 - Copie.png"));
		label_1.setBounds(335, 11, 60, 55);
		frame.getContentPane().add(label_1);
		frame.setBounds(100, 100, 413, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		u=new User();
		con=new Maconnection("biblio");
		pass=new String();

		btnNext.addActionListener(new Action());
		btnCancel.addActionListener(new Action());

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


	public ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(button_1.getWidth(), button_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

	


	class User{
		String name; 
		String pass;
	}

}