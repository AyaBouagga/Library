package Inscription;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.ResultSet;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Button;
import javax.swing.JTextField;
import javax.xml.bind.ParseConversionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Inscription {

	public  JFrame frame;
	private JTextField txt_name;
	private JLabel l_pass;

	private final JLabel l_ConfirmPassword = new JLabel("Confirm password");
	private JPasswordField txt_confirm_pass,txt_pass;
	private JButton btnNext;
	private JLabel l_Welcome;
	public  Maconnection con;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private JButton btnCancel;
	String  pass;
	public boolean cfocus=false;
	public int i=0;
	int compteur=0;
	User u;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription window = new Inscription();
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
	public Inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		u=new User();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p_n=new JPanel();
		l_Welcome = new JLabel("Welcome to Ikraa ");
		p_n.add(l_Welcome);

		frame.getContentPane().add(p_n, BorderLayout.NORTH);
		JPanel p_glob=new JPanel();
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(3, 2));
		p_glob.add(panel);
		frame.getContentPane().add(p_glob, BorderLayout.CENTER);


		JLabel l_nom = new JLabel("Username");
		panel.add(l_nom);

		txt_name = new JTextField();

		panel.add(txt_name);
		txt_name.setColumns(10);

		l_pass = new JLabel("Password");
		panel.add(l_pass);

		txt_pass = new JPasswordField();
		panel.add(txt_pass);
		txt_pass.setColumns(10);
		panel.add(l_ConfirmPassword);

		txt_confirm_pass = new JPasswordField();
		txt_confirm_pass.setColumns(10);
		panel.add(txt_confirm_pass);
		JPanel p =new JPanel();
		p.setLayout(new FlowLayout());

		horizontalStrut_4 = Box.createHorizontalStrut(250);
		p.add(horizontalStrut_4);

		btnCancel = new JButton("Cancel");
		p.add(btnCancel);


		btnNext = new JButton("Next");
		p.add(btnNext);
		frame.getContentPane().add(p,BorderLayout.SOUTH);

		con=new Maconnection("biblio");
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
					System.out.println("you have pressed \"ENTRY\" , retry please ");
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
						/*String rquet_selection_num="Select count(*) From user ";   
					try {
				    ResultSet rs=(ResultSet) con.selection(rquet_selection_num);
			  		if(rs.wasNull()) 
			  		{System.out.println("bien");}
					else 
					{System.out.println("First user");}
			  		}catch(NullPointerException | SQLException e3){}
						 */

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
					btnCancel.transferFocus();
			if(e.getSource()==btnNext)
				if(e.getKeyCode()==KeyEvent.VK_ENTER )
					//try {
						compteur+=1;
					//	con.ajout("user",compteur,txt_name.getText(),"");
						frame.setVisible(false);
					//	PersonalisedProfil pp=new PersonalisedProfil();
						//pp.frame.setVisible(true);
					//} catch (ClassNotFoundException e1) {e1.printStackTrace();}
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
	}}