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
import java.awt.GridLayout;
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

public class Theupload extends JPanel {

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
	JPanel p,c,d;
	JPanel e;JPanel f;JPanel g;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Theupload window = new Theupload(idOwner);
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
	public Theupload(int owner,JPanel p, JPanel c,JPanel d,JPanel e,JPanel f,JPanel g ) {
		initialize();
		idOwner=owner;
		this.p=p;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
		this.g=g;
		this.add(p);
		this.add(c);
		this.add(d);
		this.add(e);
		this.add(f);
		this.add(g);

		
	}
	public Theupload(int owner,JPanel p) {
		initialize();
		idOwner=owner;
		this.p=p;
		this.add(p);

	}
	public Theupload(int owner,JPanel p,JPanel c) {
		initialize();
		idOwner=owner;
		this.c=c;
		this.p=p;
		this.add(p);
		this.add(c);
	}
	public Theupload(int owner)
	{
		initialize();
		idOwner=owner;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		this.setBounds(400, 700, 973, 176);
	    setLayout(new GridLayout(1,3));
		
		Panel panel = new Panel();
		panel.setBounds(new Rectangle(0, 0, 975, 177));
		panel.setLayout(null);
		con=new Maconnection("biblio");
		listKey= new ArrayList();
		setBackground( Color.red);
	
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