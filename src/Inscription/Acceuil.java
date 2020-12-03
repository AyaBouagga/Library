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
import javax.swing.border.BevelBorder;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Acceuil {

	public JFrame frame;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Acceuil() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 200,500, 300);
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
		
		JButton btnNew = new JButton("Sign up");
		btnNew.setSelected(true);
		btnNew.setForeground(Color.WHITE);
		btnNew.setFocusTraversalKeysEnabled(false);
		btnNew.setFocusPainted(false);
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNew.setDoubleBuffered(true);
		btnNew.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		btnNew.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNew.setBounds(10, 179, 213, 36);
		btnNew.setMargin(new Insets(10, 10, 10, 10));
		btnNew.setToolTipText("Create your accout\r\n");
		btnNew.setBackground(new Color(153, 0, 0));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscri i;
				try {
					i = new Inscri();
					frame.setVisible(false);
					i.frame.setVisible(true);
					btnNew.transferFocus();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnNew);
		JButton btnLogin = new JButton("Log In ");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER )
				{Login window = new Login();
				window.frame.setVisible(true);
			}}
		});
		btnLogin.setDoubleBuffered(true);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFocusPainted(false);
		btnLogin.setFocusTraversalKeysEnabled(false);
		btnLogin.setFocusable(false);

		//JButton btnLogin = new JButton("Log In ");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window = new Login();
				window.frame.setVisible(true);
			}
		});
		btnLogin.setToolTipText("Login ");
		btnLogin.setMargin(new Insets(10, 10, 10, 10));
		btnLogin.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		btnLogin.setBackground(new Color(153, 0, 0));
		btnLogin.setAlignmentX(0.5f);
		btnLogin.setBounds(259, 179, 213, 36);
		panel_2.add(btnLogin);
		
		JLabel CloseLabel = new JLabel("");
		CloseLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton()==MouseEvent.BUTTON1 & e.getClickCount()==1) {
					frame.dispose();
				}

			}
		});
		//CloseLabel .setVisible(false);
		CloseLabel.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\t\u00E9l\u00E9chargement (2).png"));
		CloseLabel.setBounds(456, 0, 55, 42);
		panel_2.add(CloseLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 55));
		lblNewLabel_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1.setBounds(141, 44, 251, 87);
		panel_2.add(lblNewLabel_1);
	}
}
