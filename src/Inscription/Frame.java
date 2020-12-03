package Inscription;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Frame extends JFrame {
	Animation a ;
	CardLayout cl ;
	JPanel content;
	JPanel panel;
	JButton btnNewButton;
	boolean test=true;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
			}
		});
	}
public Frame(){
	a= new Animation(); 
    a.start(); 
	content = new JPanel();
	cl= new CardLayout();

	content.setLayout(cl);
	panel = new JPanel();
	
	panel.setPreferredSize(new Dimension(400,400));
	panel.setBackground(new Color(0, 255, 255));
	
	 JPanel panel_2 = new JPanel();
	    panel_2.setPreferredSize(new Dimension(400,400));
	    panel_2.setBackground(new Color(128, 128, 128));
    content.add(panel_2, "Panel1");
    
   btnNewButton = new JButton("New button");
   btnNewButton.addFocusListener(new FocusAdapter() {
   	@Override
   	public void focusGained(FocusEvent e) {
   	test=false;
   	}
   	@Override
   	public void focusLost(FocusEvent e) {
   		test=true;
   	}
   });
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.out.println("Aya");
    	}
    });
    panel.add(btnNewButton);
    
    JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(400,400));
    panel_1.setBackground(new Color(255, 0, 0));
    content.add(panel_1, "klkl");
    
    
    content.add(panel, "name_736776844709100");
    this.getContentPane().add(content);
    }
class Animation extends Thread{
	public void run() {
		  while(test) {
	        	try {
	    		System.out.println("    ");
	        	cl.next(content);
	        	pack();
	        	Thread.sleep(1000);} 
	        	catch (InterruptedException e1) {System.out.println("Exception de thread sleep");}
	        	catch( NullPointerException e2) {System.out.println("NullPointerException hna");}
	        	
	            }
	}}
}

