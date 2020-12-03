package Inscription;

import javax.swing.JPanel;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class Discussiondesp extends JPanel {
	String name; 
	int nb;
	int id;
	
	public Discussiondesp(String n , int nb , int id) {
		setBackground(new Color(255, 255, 204));
		name=n;
		this.nb=nb;
		this.id=id;
		setLayout(null);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 11, 430, 273);
		this.setPreferredSize(new Dimension(450,300));
		this.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name ");
		lblNewLabel.setBounds(10, 41, 86, 34);
		panel_3.add(lblNewLabel);
		
		JLabel lblNbreOfMembres = new JLabel("Nbre of membres");
		lblNbreOfMembres.setBounds(10, 101, 117, 14);
		panel_3.add(lblNbreOfMembres);
		
		JLabel lblNewLabel_1 = new JLabel(name);
		lblNewLabel_1.setBounds(167, 51, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Integer.toString(nb));
		lblNewLabel_2.setBounds(167, 101, 46, 14);
		panel_3.add(lblNewLabel_2);
		
		JButton btnOpenDiscussion = new JButton("Open discussion");
		/*btnOpenDiscussion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Interface window = new Interface();
					//window.frame.setVisible(true);

				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});*/
		btnOpenDiscussion.setSelected(true);
		btnOpenDiscussion.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnOpenDiscussion.setBorder(null);
		btnOpenDiscussion.setBackground(Color.WHITE);
		btnOpenDiscussion.setBounds(127, 167, 163, 48);
		panel_3.add(btnOpenDiscussion);
	}
}
