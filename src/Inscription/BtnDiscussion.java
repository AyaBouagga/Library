package Inscription;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.jgoodies.forms.layout.FormLayout;
import com.itextpdf.text.pdf.PdfReader;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.ResultSetMetaData;


import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

public class BtnDiscussion extends JPanel implements ActionListener {

	public Maconnection con ;
	ResultSet rs ;
	ResultSetMetaData rsmd;
	JTabbedPane jtp ;
	JButton b_quitter;
	JScrollPane  p; 
	JPanel p_center;
	JTable jt;
	 
	
	int idOwner;
	JLabel lblBook;
	public ArrayList<Object> data=new ArrayList<Object>();
	boolean empty = true;
	public int counter=0;
	private final JLabel label = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Btnbooks window = new Btnbooks(1);
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
	public BtnDiscussion(int owner) {
		idOwner=owner;
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Discussion", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(153, 0, 0)));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(10, 79, 681, 414);
		add(panel);
		
		JPanel panel_1 = new JPanel((LayoutManager) null);
		panel_1.setPreferredSize(new Dimension(500, 400));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(5, 10, 669, 468);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 669, 466);
		panel_1.add(scrollPane);
		
		
		
		
		
		
		con=new Maconnection("biblio");
		
		System.out.println("after connexion base btn book");
		String req_select="Select * From discussion";
		rs=con.selection(req_select);
		System.out.println("after result set");
		try { 
			
			
			rsmd =(ResultSetMetaData) rs.getMetaData();
			int nb_books=0;
			int nb_col=rsmd.getColumnCount();

			while( rs.next() ) {
				// ResultSet processing here
				empty = false;
				nb_books++;
				Object [] t= new Object[nb_col];

				for(int i=1;i<=nb_col;i++)
					t[i-1]=rs.getObject(i);
				    data.add(t );
				

			}
				
			
			System.out.println("nn");
			
			
	


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException cc) {}

		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		label.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181 - Copie.png"));
		label.setBounds(600, 20, 46, 48);
		add(label);
		
		
		System.out.println("jvfskhfjvhjfhvjfkvhjjkfv"+data.size());
		for(int i=0; i<data.size();i++) {
			//
			panel_2.add(new Discussiondesp((String)((Object[])data.get(i))[1],0,(int)((Object[])data.get(i))[0]));
		}
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(0, 0, 701, 504);
		b_quitter=new JButton ("Quitter");
		//p_north.add(b_quitter);
		con= new Maconnection("tpjava");

	

		 jt=new JTable(); 
		 p=new JScrollPane(jt);
	}
	public ImageIcon ResizeImage(String ImagePath,JComponent c)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
		
	}
  


    	

    	@Override
    	public void actionPerformed(ActionEvent e) {
    		
    	}
  

    }


