package Inscription;


import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.SystemColor;

public class BookPdf2 extends JPanel{

	public JFrame frame;
	int compteur=0;
	 int id;
	boolean empty=true;
	String pass;
	JButton btnCancel,btnNext;
	JFileChooser file;
	JLabel label;
	public ArrayList<Object> data=new ArrayList<Object>();

    Maconnection con;
	ResultSet rs ;
	ResultSetMetaData rsmd;
	
	ArrayList listKey;
	String ch="" ;
	String imagepath,path;
	
	static int idOwner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookPdf2 window = new BookPdf2(1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public BookPdf2(int id) throws SQLException {
		
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException
	{
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181.png"));
		frame.setBounds(new Rectangle(400, 200, 400, 4000));
		this.setBounds(400, 700, 424, 358);
		frame.setBackground(new Color(153, 0, 0));
		frame.getContentPane().setFocusCycleRoot(true);
		frame.getContentPane().setBackground(new Color(153, 0, 0));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		con=new Maconnection("biblio");
		ResultSet rs=(ResultSet) con.selection("SELECT count(*) FROM `book`");
		while(rs.next()) {
		compteur=rs.getInt(1);}
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(204, 0, 0));
		btnCancel.setBounds(317, 491, 78, 23);
		frame.getContentPane().add(btnCancel);

		btnNext = new JButton("Ok");
		/*btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList l= new ArrayList();
				l.add(compteur+1);
				l.add(idOwner);
				l.add(txt_name.getText());
				l.add(textWriter.getText());
				l.add(comboBox.getSelectedItem());
				l.add(textKey.getText());
				l.add(path);
				l.add(imagepath);
				l.add(0);
				l.add("pdf");
				System.out.println(l.get(l.size()-1));
				try {
					con.ajout("book",l);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});*/
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(new Color(204, 0, 0));
		btnNext.setBounds(242, 491, 65, 23);
		frame.getContentPane().add(btnNext);

		JLabel lblNewLabel_4 = new JLabel("Membre");
		lblNewLabel_4.setFont(new Font("Arabic Typesetting", Font.BOLD, 34));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(35, 21, 151, 45);
		frame.getContentPane().add(lblNewLabel_4);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 67, 385, 2);
		frame.getContentPane().add(separator_3);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(110, 280, 46, 14);
		frame.getContentPane().add(label_3);
		listKey= new ArrayList();

		String tab[]= {"Fantast","Science Fiction","Mystery Fiction","Memoir","Biography","Westerns","Dystopia","Add Another"};

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String response = javax.swing.JOptionPane.showInputDialog("Are you sure that you want to leave this page !! (yes|no) "); 
				if (response.equals("yes")) {
					PersonalisedProfil pp;
					try {
						pp = new PersonalisedProfil(idOwner);
					
					frame.dispose();
					pp.frame.setVisible(true);} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}

			}
		});
		label_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181 - Copie.png"));
		label_1.setBounds(335, 11, 60, 55);
		frame.getContentPane().add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(35, 97, 346, 347);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(10, 22, 271, 56);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblResponsble = new JLabel("Membre Name :");
		lblResponsble.setBounds(13, 5, 127, 21);
		panel_1.add(lblResponsble);
		lblResponsble.setForeground(Color.LIGHT_GRAY);
		lblResponsble.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(13, 24, 85, 2);
		panel_1.add(separator);
		separator.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewlabel = new JLabel("Newlabel");
		lblNewlabel.setForeground(Color.WHITE);
		lblNewlabel.setBounds(125, 7, 109, 19);
		panel_1.add(lblNewlabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(187, 38, 46, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(10, 89, 271, 56);
		panel.add(panel_2);
		
		JLabel lblMembreDiplome = new JLabel("Membre Diplome:");
		lblMembreDiplome.setForeground(Color.LIGHT_GRAY);
		lblMembreDiplome.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		lblMembreDiplome.setBounds(13, 5, 127, 21);
		panel_2.add(lblMembreDiplome);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(13, 24, 109, 2);
		panel_2.add(separator_1);
		
		JLabel label_4 = new JLabel("Newlabel");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(152, 5, 109, 19);
		panel_2.add(label_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 158, 271, 56);
		panel.add(panel_3);
		
		JLabel lblMembreType = new JLabel("Membre type:");
		lblMembreType.setForeground(Color.LIGHT_GRAY);
		lblMembreType.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		lblMembreType.setBounds(13, 5, 127, 21);
		panel_3.add(lblMembreType);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(13, 24, 85, 2);
		panel_3.add(separator_2);
		
		JLabel label_5 = new JLabel("Newlabel");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(125, 7, 109, 19);
		panel_3.add(label_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(10, 227, 271, 56);
		panel.add(panel_4);
		
		JLabel lblIdTache = new JLabel("Id tache");
		lblIdTache.setForeground(Color.LIGHT_GRAY);
		lblIdTache.setFont(new Font("Arabic Typesetting", Font.BOLD, 18));
		lblIdTache.setBounds(13, 5, 127, 21);
		panel_4.add(lblIdTache);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.LIGHT_GRAY);
		separator_4.setBounds(13, 24, 85, 2);
		panel_4.add(separator_4);
		
		JLabel label_6 = new JLabel("Newlabel");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(125, 7, 109, 19);
		panel_4.add(label_6);
		frame.setBounds(100, 100, 413, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pass=new String();

		
		con=new Maconnection("conception");
		
		empty=true;
		String req_select="SELECT s.idmembre, s.Name, s.idtache, s.idequipe, s.type, s.diplome FROM membre s INNER JOIN tache hp on s.idtache = hp.idmembre and hp.idtache="+id;
		rs=con.selection(req_select);
		try { 


			rsmd =(ResultSetMetaData) rs.getMetaData();
			int nb_books=0;
			int nb_col=rsmd.getColumnCount();

			while( rs.next() ) {
				empty = false;
				nb_books++;
				Object [] t= new Object[nb_col];

				for(int i=1;i<=nb_col;i++)
					{t[i-1]=rs.getObject(i);
				    System.out.println(t[i-1]);}
				    data.add(t );

				    System.out.println(((Object[])data.get(0))[0]);
					System.out.println(((Object[])data.get(0))[1]);
					System.out.println(((Object[])data.get(0))[2]);
					System.out.println(((Object[])data.get(0))[3]);
					System.out.println(((Object[])data.get(0))[4]);
			}
			if(!empty) {
				lblNewlabel.setText((String)((Object[])data.get(0))[1]);
				label_4.setText((String)((Object[])data.get(0))[5]);
				label_5.setText((String)((Object[])data.get(0))[4]);
				label_6.setText(Integer.toString((int)((Object[])data.get(0))[2]));
				
			}
			else{System.out.println(" hethyyyyy yeziii addd");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException cc) {}
		btnNext.addActionListener(new Action());
		btnCancel.addActionListener(new Action());
		}

	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
		}


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