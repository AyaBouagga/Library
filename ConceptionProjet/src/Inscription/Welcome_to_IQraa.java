package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;

public class Welcome_to_IQraa extends JFrame{

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome_to_IQraa window = new Welcome_to_IQraa();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome_to_IQraa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.getContentPane().setBackground(Color.WHITE);
		this.setBounds(400, 200, 543, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IQraa...");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(204, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(182, 56, 230, 75);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\tumblr_mio4anJ5CE1rudrp1o1_400.gif"));
		lblNewLabel_1.setBounds(-156, 123, 517, 226);
		this.getContentPane().add(lblNewLabel_1);
	       
		System.out.println("++++++");
		lblNewLabel_1.setFocusable(true);
		 Wait w =new Wait();
         w.start();
	
	}
	   class Wait extends Thread{
	    	public void run() {
	    		try {Thread.sleep(10000);} catch (InterruptedException e1) {System.out.println("Exception de thread sleep");}
	    		Welcome_to_IQraa.this.dispose();	
				Acceuil acc=new Acceuil();
				acc.frame.setVisible(true);
	    	}}
	    
}
