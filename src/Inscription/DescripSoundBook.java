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

import com.itextpdf.text.pdf.PdfReader;


import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class DescripSoundBook extends JPanel {
	public JButton btnimgbook;
	int identifiant;
	public String bookWriter;
	public int nb_pages,nb_like;
	public String path;
	private final JButton btnShowDetails = new JButton("Show details ");
	public JPanel paneldescrip;
	public JPanel panel_1;
	public JButton buttonLike;
	Maconnection con=new Maconnection("biblio");
	ResultSet rs ;

	
	public DescripSoundBook(int id ,String BookName ,String  bookw,String imgbook,String path,int nb_pages,int nb_like) {
		setForeground(new Color(0, 0, 0));
	this.setPreferredSize(new Dimension(149, 176));
		this.identifiant=id;
		this.nb_pages=nb_pages;
	    this.nb_like=nb_like;
		this.path=path;
		
		
		setBackground(Color.WHITE);
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(211, 211, 211)));
		setLayout(null);
		CardLayout cl = new CardLayout();
		JPanel content = new RoundedPanel(20, Color.WHITE);
		content.setBorder(new CompoundBorder());
		content.setOpaque(false);
		content.setBounds(3, 3, 143, 171);
		
        
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setVisible(true);
				paneldescrip.setVisible(false);
				cl.next(content);

			}
			
		});
		panel.setFocusable(true);
		panel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cl.next(content);
			}
		});
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(3, 4, 166, 150);
		
		btnimgbook = new JButton("");
		btnimgbook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cl.next(content);

			}
		});
		btnimgbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PdfReader pdfReader = 
							new PdfReader(path);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				    if (Desktop.isDesktopSupported()) {
				        try {
				            File myFile = new File(path);
				            Desktop.getDesktop().open(myFile);
				        } catch (IOException ex) {
				            // no application registered for PDFs
				        }}

			}
		});
		btnimgbook.setSelected(true);
		btnimgbook.setFont(new Font("Arabic Typesetting", Font.BOLD, 21));
		btnimgbook.setBorder(null);
		btnimgbook.setBackground(Color.WHITE);
		btnimgbook.setBounds(0, 0, 143, 127);
	    btnimgbook.setIcon(ResizeImage(imgbook,btnimgbook));
		panel.add(btnimgbook);

		JPanel panel2 = new JPanel();
		panel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			@Override
			public void mouseExited(MouseEvent e) {
				cl.next(content);

			}
		});
		panel2.setBackground(Color.WHITE);
		
		content.setLayout(cl);
	    content.add(panel, "Panel1");
	    
	    JLabel label_2 = new JLabel("");
	    label_2.setText(bookw);
	    label_2.setForeground(Color.ORANGE);
	    label_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 34));
	    label_2.setBounds(10, 133, 123, 34);
	    panel.add(label_2);
	    
	    
	    content.add(panel2, "Panel2");
	    panel2.setLayout(null);
	    
	    panel_1 = new JPanel();
	    panel_1.setBackground(Color.WHITE);
	    panel_1.setBounds(0, 0, 143, 180);
	    panel2.add(panel_1);
	    panel_1.setLayout(null);
	    
	   buttonLike = new JButton("");
	   buttonLike.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		Ajoutlike();
	   		
	   	}
	   });
	    
	    buttonLike.setBounds(10, 25, 40, 47);
	    panel_1.add(buttonLike);
	    
	    		buttonLike.setIcon(ResizeImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\like.png",buttonLike));
	    	    buttonLike.setToolTipText("Like");
	    	    buttonLike.setSelected(true);
	    	    buttonLike.setFont(new Font("Arabic Typesetting", Font.BOLD, 8));
	    	    buttonLike.setBorder(null);
	    	    buttonLike.setBackground(Color.WHITE);
	    
	    JButton btnNewButton = new JButton(" Book open");
	    btnNewButton.setBounds(14, 81, 109, 23);
	    panel_1.add(btnNewButton);
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
	    btnNewButton.setForeground(new Color(153, 0, 0));
	    btnNewButton.setBackground(Color.WHITE);
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    		} catch (Exception ex) {
	    			ex.printStackTrace();
	    		}
	    		
	    		SwingUtilities.invokeLater(new Runnable() {
	    			
	    			@Override
	    			public void run() {
	    				new Playaudio(path).setVisible(true);
	    			}
	    		});

	    	}
	    });
	    paneldescrip = new JPanel();
		paneldescrip.setLayout(null);
		paneldescrip.setBackground(Color.WHITE);
		paneldescrip.setBounds(0, 11, 143, 158);
		
		
		JLabel label = new JLabel("Pages:");
		label.setForeground(new Color(153, 0, 0));
		label.setFont(new Font("Arabic Typesetting", Font.BOLD, 15));
		label.setBounds(10, 40, 33, 18);
		paneldescrip.add(label);
		
		JLabel label_1 = new JLabel("0");
		label_1.setForeground(new Color(153, 0, 0));
		label_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 15));
		label_1.setBounds(77, 39, 72, 20);
		paneldescrip.add(label_1);
		
		JLabel label_21 = new JLabel("Writer:");
		label_21.setForeground(new Color(153, 0, 0));
		label_21.setFont(new Font("Arabic Typesetting", Font.BOLD, 15));
		label_21.setBounds(10, 11, 51, 20);
		paneldescrip.add(label_21);
		
		JLabel label_3 = new JLabel("<dynamic>");
		label_3.setForeground(new Color(153, 0, 0));
		label_3.setFont(new Font("Arabic Typesetting", Font.BOLD, 15));
		label_3.setBounds(67, 11, 72, 20);
		paneldescrip.add(label_3);
		
		JLabel label_4 = new JLabel("Description:");
		label_4.setForeground(new Color(153, 0, 0));
		label_4.setFont(new Font("Arabic Typesetting", Font.BOLD, 15));
		label_4.setBounds(10, 70, 72, 18);
		paneldescrip.add(label_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 99, 123, 48);
		paneldescrip.add(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 26, 33, 2);
		paneldescrip.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 57, 33, 2);
		paneldescrip.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 89, 59, 2);
		paneldescrip.add(separator_2);
	    btnShowDetails.setBounds(18, 107, 105, 29);
	    panel_1.add(btnShowDetails);
	    btnShowDetails.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel_1.setVisible(false);
	    		paneldescrip.setVisible(true);
	    		panel2.add(paneldescrip);
	    		

	    	}
	    });
	    btnShowDetails.setSelected(true);
	    btnShowDetails.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
	    btnShowDetails.setBorder(null);
	    btnShowDetails.setBackground(Color.WHITE);
	    
	    JButton button_1 = new JButton("");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Addto addcateg=new Addto(0,0);
	    		PersonalisedProfil.frame.setExtendedState(Frame.ICONIFIED);
	    		addcateg.frame.setVisible(true);
	    		System.out.println("eeee");
	    	}
	    });
	    button_1.setBounds(52, 25, 40, 47);
	    panel_1.add(button_1);
	    
	    	    button_1.setIcon(ResizeImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\addto.png",button_1));
	    	    button_1.setToolTipText("Add to .. ");
	    	    button_1.setSelected(true);
	    	    button_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 8));
	    	    button_1.setBorder(null);
	    	    button_1.setBackground(Color.WHITE);
	    
	    JButton button_2 = new JButton("");
	    button_2.setBounds(93, 25, 40, 47);
	    panel_1.add(button_2);
	    
	    	    button_2.setIcon(ResizeImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\msg.png",button_2));
	    	    button_2.addActionListener(new ActionListener() {
	    	    	public void actionPerformed(ActionEvent e) {
	    	    	}
	    	    });
	    	    button_2.setToolTipText("Enjoy discussion");
	    	    button_2.setSelected(true);
	    	    button_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
	    	    button_2.setBorder(null);
	    	    button_2.setBackground(Color.WHITE);
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
	public void Ajoutlike() {
		if (con.modifier("UPDATE `book` SET `likes` = '"+Integer.toString(nb_like++)+"' WHERE `book`.`id` = "+Integer.toString(identifiant))!=0) {
			System.out.println("Like <3 ");
		}
	}
}
