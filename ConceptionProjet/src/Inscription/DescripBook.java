package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;



import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class DescripBook extends JPanel {
	public JButton btnimgbook;
	int identifiant;
	public String tache;
	public int nb_pages,nb_like;
	public String path;
	public JPanel paneldescrip;
	Maconnection con=new Maconnection("biblio");
	ResultSet rs ;
  int id;
	
	public DescripBook(int id ) {
		this.id=id;
		setForeground(new Color(0, 0, 0));
	this.setPreferredSize(new Dimension(149, 176));
		this.tache=tache;
	
		setBackground(Color.WHITE);
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(211, 211, 211)));
		setLayout(null);
		
		CardLayout cl = new CardLayout();
		JPanel content = new RoundedPanel(20, Color.WHITE);
		content.setBorder(new CompoundBorder());
		content.setOpaque(false);
		content.setBounds(3, 3, 143, 172);
		
        
		JPanel panel = new JPanel();
		
		panel.setFocusable(true);
		
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(3, 4, 166, 150);
		
		btnimgbook = new JButton("");
		btnimgbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ouvrir Jframe add membre Jtable bara 
				//tache affecter a list user
				BookPdf window;
				try {		System.out.println("id"+id);

					window = new BookPdf(id);
					window.frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
		btnimgbook.setText("tache"+Integer.toString(id));
		btnimgbook.setSelected(true);
		btnimgbook.setFont(new Font("Arabic Typesetting", Font.BOLD, 21));
		btnimgbook.setBorder(null);
		btnimgbook.setBackground(Color.GRAY);
		btnimgbook.setBounds(0, 0, 143, 171);
		panel.add(btnimgbook);
		
		content.setLayout(cl);
	    content.add(panel, "Panel1");
	    add(content);
	    
	    
		
		
		
		initialize();
		
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
	
	}
	public ImageIcon ResizeImage(String ImagePath,JComponent c)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
}
