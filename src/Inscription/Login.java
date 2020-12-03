package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Window;
import java.awt.Button;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.border.SoftBevelBorder;

import com.mysql.jdbc.ResultSetMetaData;


import javax.swing.border.BevelBorder;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class Login {
	public Maconnection con ;
	ResultSet rs ;
	ResultSetMetaData rsmd;
	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		con=new Maconnection("biblio");

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181 - Copie.png"));
		frame.setBounds(400, 200,553, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);

		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		Panel panel_1 = new Panel();
		panel.add(panel_1, BorderLayout.NORTH);

		Panel panel_2 = new Panel();
		panel.add(panel_2, BorderLayout.CENTER);

		JButton btnNew = new JButton("Cancel");
		btnNew.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnNew.setForeground(Color.WHITE);
		btnNew.setFocusTraversalKeysEnabled(false);
		btnNew.setFocusPainted(false);
		btnNew.setFocusable(false);
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNew.setDoubleBuffered(true);
		btnNew.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		btnNew.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNew.setBounds(349, 243, 118, 36);
		btnNew.setMargin(new Insets(10, 10, 10, 10));
		btnNew.setToolTipText("Create your accout\r\n");
		btnNew.setBackground(new Color(153, 0, 0));
		//btnNew.setBorder(new RoundedBorder(50)); 





		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil i;
				i = new Acceuil();
				frame.setVisible(false);
				i.frame.setVisible(true);

			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnNew);

		JButton btnOk = new JButton("OK");
		btnOk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					btnOk.transferFocus();}
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs=con.selection("SELECT `id`, `Name`, `email`, `Password`, `imagepath`, `date_ajout` FROM `user` WHERE email='"+textField.getText()+"'");
				boolean exist =false;
				try {
					while(rs.next()) {
						exist=true;
						System.out.println("User exist");
						if(  (rs.getString(4)).equals(new String(passwordField.getPassword()))) {
							System.out.println("Tous va bien");
							frame.dispose();
							PersonalisedProfil pp=new PersonalisedProfil(rs.getInt(1));
							pp.frame.setVisible(true);
						}
					}
					if(!exist) {System.out.println("User n'exist pas");}
					

				} catch (SQLException e1) {e1.printStackTrace();}
			}});
		btnOk.setToolTipText("Create your accout\r\n");
		btnOk.setMargin(new Insets(10, 10, 10, 10));
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOk.setFocusable(false);
		btnOk.setFocusTraversalKeysEnabled(false);
		btnOk.setFocusPainted(false);
		btnOk.setDoubleBuffered(true);
		btnOk.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		btnOk.setBackground(new Color(153, 0, 0));
		btnOk.setAlignmentX(0.5f);
		btnOk.setBounds(200, 243, 118, 36);
		panel_2.add(btnOk);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					textField.transferFocus();}
			}
		});
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(212, 117, 202, 36);
		panel_2.add(textField);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 0, 0));
		separator.setAlignmentY(1.0f);
		separator.setBounds(212, 155, 202, 9);
		panel_2.add(separator);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(67, 125, 86, 20);
		panel_2.add(lblEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(67, 165, 86, 20);
		panel_2.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					btnOk.isFocusOwner();}
			}
		});
		passwordField.setForeground(Color.BLACK);
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBounds(212, 163, 202, 25);
		panel_2.add(passwordField);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(204, 0, 0));
		separator_1.setAlignmentY(1.0f);
		separator_1.setBounds(212, 193, 202, 9);
		panel_2.add(separator_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181 - .png"));
		label.setBounds(0, 0, 73, 55);
		panel_2.add(label);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(128, 128, 128));
		lblLogin.setFont(new Font("Arabic Typesetting", Font.BOLD | Font.ITALIC, 36));
		lblLogin.setBounds(83, 11, 151, 45);
		panel_2.add(lblLogin);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(153, 0, 0));
		separator_2.setBounds(10, 66, 533, 2);
		panel_2.add(separator_2);
	}
}
