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
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JTextField;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;


import javax.naming.spi.ResolveResult;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Toolkit;

public class Inscri extends JFrame {

	public JFrame frame;
	private JPasswordField txt_pass;
	private JTextField txt_name;
	public User u;
	public  Maconnection con;
	public int i=0;
    int compteur=0;
	String pass;
	JButton btnCancel,btnNext;
	private final JPasswordField txt_confirm_pass = new JPasswordField();
	private JTextField textField;
	ResultSet rs ;
	ResultSetMetaData rsmd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscri window = new Inscri();
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
	public Inscri() throws SQLException {
		initialize();
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(204, 0, 0));
		btnCancel.setBounds(282, 358, 90, 23);
		frame.getContentPane().add(btnCancel);

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList l= new ArrayList();
					l.add(compteur+1);
					l.add(txt_name.getText());
					l.add(textField.getText());
					l.add((new String(txt_pass.getPassword())));
					System.out.println(txt_pass.getPassword().getClass());
					l.add("");
					btnNext.transferFocus();
					try {
						con.ajout("user",l);
						frame.setVisible(false);
						PersonalisedProfil pp=new PersonalisedProfil(compteur+1);
						pp.frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(new Color(204, 0, 0));
		btnNext.setBounds(207, 358, 65, 23);
		frame.getContentPane().add(btnNext);

		JLabel label = new JLabel("Username");
		label.setBounds(84, 122, 86, 20);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(84, 153, 86, 20);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Confirm password");
		label_2.setBounds(84, 184, 126, 20);
		frame.getContentPane().add(label_2);

		txt_pass = new JPasswordField();
		txt_pass.setForeground(Color.BLACK);
		txt_pass.setBorder(null);
		txt_pass.setColumns(10);
		txt_pass.setBounds(210, 146, 111, 20);
		frame.getContentPane().add(txt_pass);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 0, 0));
		separator.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		separator.setBounds(210, 167, 105, 2);
		frame.getContentPane().add(separator);

		txt_name = new JTextField();
		txt_name.setBorder(null);
		txt_name.setBounds(210, 112, 105, 20);
		frame.getContentPane().add(txt_name);
		txt_name.setColumns(10);
		txt_confirm_pass.setBounds(208, 178, 114, 20);
		frame.getContentPane().add(txt_confirm_pass);
		txt_confirm_pass.setForeground(Color.BLACK);
		txt_confirm_pass.setColumns(10);
		txt_confirm_pass.setBorder(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(204, 0, 0));
		separator_1.setAlignmentY(1.0f);
		separator_1.setBounds(208, 202, 105, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(204, 0, 0));
		separator_2.setAlignmentY(1.0f);
		separator_2.setBounds(210, 137, 105, 2);
		frame.getContentPane().add(separator_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\1.jpg"));
		lblNewLabel.setBounds(31, 80, 332, 45);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\isar.jpg"));
		lblNewLabel_1.setBounds(35, 94, 39, 201);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\imin.jpg"));
		lblNewLabel_2.setBounds(331, 94, 39, 200);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\lota.jpg"));
		lblNewLabel_3.setBounds(33, 293, 334, 54);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CREATE MY ACCOUNT");
		lblNewLabel_4.setFont(new Font("Arabic Typesetting", Font.BOLD, 28));
		lblNewLabel_4.setForeground(new Color(153, 0, 0));
		lblNewLabel_4.setBounds(66, 24, 304, 45);
		frame.getContentPane().add(lblNewLabel_4);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 67, 377, 2);
		frame.getContentPane().add(separator_3);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(110, 280, 46, 14);
		frame.getContentPane().add(label_3);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(84, 215, 126, 20);
		frame.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(207, 209, 105, 20);
		frame.getContentPane().add(textField);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(204, 0, 0));
		separator_4.setAlignmentY(1.0f);
		separator_4.setBounds(207, 233, 105, 2);
		frame.getContentPane().add(separator_4);
		frame.setBounds(100, 100, 413, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		u=new User();
		con=new Maconnection("biblio");
		rs=(ResultSet) con.selection("SELECT count(*) FROM `user`");
		while(rs.next()) {
		compteur=rs.getInt(1);
		System.out.println(compteur);}
		pass=new String();
		btnNext.addActionListener(new Action());
		btnCancel.addActionListener(new Action());
		txt_pass.addKeyListener(new Key());
		txt_name.addKeyListener(new Key());
		btnCancel.addKeyListener(new Key());
		btnNext.addKeyListener(new Key());
		txt_pass.addFocusListener(new Focus());
		txt_confirm_pass.addKeyListener(new Key());
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


	class Key implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getSource()==txt_pass) {
			}


		}

		@SuppressWarnings("deprecation")
		@Override
		public void keyPressed(KeyEvent e) {

			if(e.getSource()==txt_pass) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					txt_pass.transferFocus();
				}else { pass+=e.getKeyChar();}
				if(KeyEvent.VK_BACK_SPACE==e.getKeyCode()) 
				{//pass=txt_confirm_pass.getPassword();     
				}
			}



			if(e.getSource()==txt_confirm_pass) 
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					if(i==pass.length())
					{

						txt_confirm_pass.transferFocus();
					}
					else {
						System.out.println("Confirm your Password please");}

				}
				else {
					if(KeyEvent.VK_BACK_SPACE==e.getKeyCode()) 
						i-=1;
					else {
						if(i>=0&pass.charAt(i)!=e.getKeyChar())
						{	System.out.println("Incompatible Password");}
						else {i+=1;}
					}

				}

			}

			if(e.getSource()==txt_name) 
				if(e.getKeyCode()==KeyEvent.VK_ENTER )
					txt_name.transferFocus();
			if(e.getSource()==btnCancel)
				if(e.getKeyCode()==KeyEvent.VK_ENTER )
					Inscri.this.dispose();
			if(e.getSource()==btnNext)
				if(e.getKeyCode()==KeyEvent.VK_ENTER )
					try {
					ArrayList l= new ArrayList();
					l.add(compteur+1);
					l.add(txt_name.getText());
					l.add(textField.getText());
					l.add(txt_pass.getPassword());
					l.add("");
					con.ajout("user",l);
					frame.setVisible(false);
					PersonalisedProfil pp=new PersonalisedProfil(compteur);
					pp.frame.setVisible(true);

					} catch (ClassNotFoundException e1) {e1.printStackTrace();} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}}


	class Focus implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			if (txt_pass.isFocusOwner())
			{    System.out.println("Please entre your Name ");

			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

		}



	}
	class User{
		String name; 
		String pass;
	}
}
