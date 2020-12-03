package Inscription;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.JSeparator;
import javax.swing.JSlider;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.ResultSetMetaData;


import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import java.awt.ComponentOrientation;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HomePage extends JFrame {

	public static JFrame frame;
	public FormLayout layout;
	static int idOwner;
	JLabel lblViewAllQuotes ;
	JLabel lblViewAll ;
	JFileChooser file;
	String imagepath;
	Maconnection con ;
	ResultSet rs;
	ArrayList data_user=new ArrayList();
	ArrayList data_search=new ArrayList();
	ArrayList data_recent_book=new ArrayList();
	ArrayList data_sound_book=new ArrayList();
	private JTextField textField;
	ResultSetMetaData rsmd;
	JPanel p;
	JScrollPane scrollPane;
	JPanel panel_10;
	CardLayout cl,cl1,cl2;
	JPanel panel_15;
	boolean test1=true,test2=true;
	Animation a;
	Animation2 b;
	JPanel panel_13 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage(2);
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
	public HomePage(int owner) throws SQLException {
		idOwner=owner;	
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("deprecation")
	private void initialize() throws SQLException {
		try {
		con=new Maconnection("biblio");
		String req_sel="SELECT * FROM `user` WHERE `user`.`id`="+idOwner;
		rs=con.selection(req_sel);
		rsmd =(ResultSetMetaData) rs.getMetaData();
		int nb_col=rsmd.getColumnCount();

		while( rs.next() ) {
			// ResultSet processing here
			Object [] t= new Object[nb_col];
			for(int i=1;i<=nb_col;i++)
				t[i-1]=rs.getObject(i);
			data_user.add(t );
		}
		}catch (NullPointerException cc) {}

		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181 - Copie.png"));

		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setBounds(0, 0,1235, 672 );

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(1023, 110, 8, 492);
		frame.getContentPane().add(separator_1);
		String name=((String) (((Object[])data_user.get(0))[1])).substring(1,((String) (((Object[])data_user.get(0))[1])).length());;


		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(1035, 102, 174, 207);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblViewAllQuotes.setForeground(Color.black);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblViewAllQuotes.setForeground(Color.LIGHT_GRAY);
			}
		});
		panel_5.setFocusable(true);
		panel_5.setBounds(0, 11, 186, 37);
		panel_6.add(panel_5);
		panel_5.setBackground(Color.WHITE);
		panel_5.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 4, 20, 20);
		panel_5.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\Inkwell_icon_-_Noun_Project_2512.svg.png"));

		JLabel lblQuotes = new JLabel("0 Quotes");
		lblQuotes.setBounds(50, -2, 46, 33);
		panel_5.add(lblQuotes);
		lblQuotes.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblQuotes.setForeground(Color.LIGHT_GRAY);

		lblViewAllQuotes = new JLabel("View All");
		lblViewAllQuotes.setBounds(130, -2, 46, 33);
		panel_5.add(lblViewAllQuotes);
		lblViewAllQuotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton()==MouseEvent.BUTTON1 & e.getClickCount()==1) {
					lblViewAllQuotes.setForeground(Color.black);
					System.out.println("Vienw all Quotes");}
			}
		});
		lblViewAllQuotes.setForeground(Color.LIGHT_GRAY);
		lblViewAllQuotes.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(15, 27, 166, 2);
		panel_5.add(separator_3);
		separator_3.setBackground(new Color(211, 211, 211));
		separator_3.setForeground(Color.WHITE);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\quote.png"));
		label_1.setBounds(55, 85, 64, 64);
		panel_6.add(label_1);

		JButton btnAddYourFavorite = new JButton("Add your  favorite quote");
		btnAddYourFavorite.setForeground(Color.LIGHT_GRAY);
		btnAddYourFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddYourFavorite.setFont(new Font("Arabic Typesetting", Font.BOLD, 15));
		btnAddYourFavorite.setBorder(null);
		btnAddYourFavorite.setBackground(Color.WHITE);
		btnAddYourFavorite.setBounds(0, 159, 174, 28);
		panel_6.add(btnAddYourFavorite);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(1027, 331, 182, 274);
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblViewAll.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {

				lblViewAll.setForeground(Color.LIGHT_GRAY);
			}
		});
		panel_3.setBounds(0, 11, 186, 55);
		panel_7.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(10, 13, 20, 20);
		panel_3.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\t\u00E9l\u00E9chargement (3).png"));

		JLabel lblFollo = new JLabel("0 Following");
		lblFollo.setBounds(40, 11, 56, 33);
		panel_3.add(lblFollo);
		lblFollo.setForeground(Color.LIGHT_GRAY);
		lblFollo.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));

		lblViewAll = new JLabel("View All");
		lblViewAll.setBounds(130, 11, 46, 33);
		panel_3.add(lblViewAll);
		lblViewAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton()==MouseEvent.BUTTON1 & e.getClickCount()==1) {

					System.out.println("Vienw all Following");}

			}
		});
		lblViewAll.setForeground(Color.LIGHT_GRAY);
		lblViewAll.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 44, 166, 2);
		panel_3.add(separator_5);
		separator_5.setForeground(Color.WHITE);
		separator_5.setBackground(new Color(211, 211, 211));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(-58, 0, 1277, 97);
		frame.getContentPane().add(panel_2);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.BLACK);
		panel_2.setLayout(null);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(85, 33, 60, 47);
		panel_2.add(label_2);
		label_2.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\atlantic books 192x181 - .png"));

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(293, 33, 76, 47);
		panel_2.add(btnHome);
		btnHome.setEnabled(false);
		btnHome.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnHome.setBorder(null);
		btnHome.setBackground(Color.BLACK);

		JButton btnIqraa = new JButton("IQraa");
		btnIqraa.setEnabled(false);
		btnIqraa.setForeground(Color.WHITE);
		btnIqraa.setBounds(155, 33, 68, 48);
		panel_2.add(btnIqraa);
		btnIqraa.setSelected(true);
		btnIqraa.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnIqraa.setBorder(null);
		btnIqraa.setBackground(Color.BLACK);
		JPanel p4 = new RoundedPanel(20);

		JPanel panel_4 = new RoundedPanel(40, Color.WHITE);
		panel_4.setVisible(true);
		panel_4.setOpaque(false);
		panel_4.setBounds(379, 33, 541, 47);
		panel_2.setLayout(null);
		panel_2.add(panel_4);
		panel_4.setBackground(Color.WHITE);

		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cl.next(panel_10);
			}
		});
		button_1.setDoubleBuffered(true);
		button_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		button_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\search.png"));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(481, 5, 50, 36);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs=con.selection("SELECT * FROM `book` WHERE 'name'like '%a%' or 'writer'like '%a%' or 'genre'like '%a%'");
				try {
					rsmd =(ResultSetMetaData) rs.getMetaData();

					int nb_col=rsmd.getColumnCount();

					while( rs.next() ) {
						Object [] t= new Object[nb_col];
						for(int i=1;i<=nb_col;i++)
							t[i-1]=rs.getObject(i);
						data_search.add(t );}} catch (SQLException e2) {e2.printStackTrace();}
				p.setVisible(false);
				SearchPage panel = new SearchPage();
				for (int i = 0; i <data_search.size(); i++) {
					panel.panel_2.add(new DescripBookforsearch((int)((Object[])data_search.get(i))[0],(String)((Object[])data_search.get(i))[2],(String)((Object[])data_search.get(i))[3],(String)((Object[])data_search.get(i))[7],(String)((Object[])data_search.get(i))[6],0,0));
				}
				panel.setVisible(true);
				scrollPane.setViewportView(panel);
				btnHome.setEnabled(true);


			}
		});
		panel_4.setLayout(null);
		panel_10=new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				test1=false;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				test1=true;
				//a.start();
			}
		});
		panel_10.setFocusable(true);
		panel_10.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				test1=false;
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				test1=true;
			}
		});
		cl= new CardLayout();
		panel_10.setLayout(cl);
		//panel_10.add(panel_101);
		//____________________________________________________Remplissage de panel_101 the upload
		//panel_101.add(new DescripBook(int)((Object[])data_search.get(counter+j))[0],(String)((Object[])data.get(counter+j))[2],(String)((Object[])data.get(counter+j))[3],(String)((Object[])data.get(counter+j))[7],(String)((Object[])data.get(counter+j))[6],0,0))
		rs=con.selection("SELECT * FROM book ORDER BY date_ajout DESC");
		try {
			rsmd =(ResultSetMetaData) rs.getMetaData();

			int nb_col=rsmd.getColumnCount();

			while( rs.next() ) {
				Object [] t= new Object[nb_col];
				for(int i=1;i<=nb_col;i++)
					t[i-1]=rs.getObject(i);
				data_recent_book.add(t );}} catch (SQLException e2) {e2.printStackTrace();}
		int counter=0;
		int j=0;
		while(counter+6<data_recent_book.size()-1) {

			panel_10.add(new Theupload(idOwner,new DescripBook((int)((Object[])data_recent_book.get(counter+0))[0],(String)((Object[])data_recent_book.get(counter+0))[2],(String)((Object[])data_recent_book.get(counter+0))[3],(String)((Object[])data_recent_book.get(counter+0))[7],(String)((Object[])data_recent_book.get(counter+0))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+1))[0],(String)((Object[])data_recent_book.get(counter+1))[2],(String)((Object[])data_recent_book.get(counter+1))[3],(String)((Object[])data_recent_book.get(counter+1))[7],(String)((Object[])data_recent_book.get(counter+1))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+2))[0],(String)((Object[])data_recent_book.get(counter+2))[2],(String)((Object[])data_recent_book.get(counter+2))[3],(String)((Object[])data_recent_book.get(counter+2))[7],(String)((Object[])data_recent_book.get(counter+2))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+3))[0],(String)((Object[])data_recent_book.get(counter+3))[2],(String)((Object[])data_recent_book.get(counter+3))[3],(String)((Object[])data_recent_book.get(counter+3))[7],(String)((Object[])data_recent_book.get(counter+3))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+4))[0],(String)((Object[])data_recent_book.get(counter+4))[2],(String)((Object[])data_recent_book.get(counter+4))[3],(String)((Object[])data_recent_book.get(counter+4))[7],(String)((Object[])data_recent_book.get(counter+4))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+5))[0],(String)((Object[])data_recent_book.get(counter+5))[2],(String)((Object[])data_recent_book.get(counter+5))[3],(String)((Object[])data_recent_book.get(counter+5))[7],(String)((Object[])data_recent_book.get(counter+5))[6],0,0)), "Panel"+counter);	
			panel_10.revalidate();
			panel_10.repaint();
			counter++;

			j=0;

		}






		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {System.out.println("hey !");}}
		});

		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setBounds(21, 5, 441, 36);
		textField.setMargin(new Insets(24, 242, 20, 42));
		panel_4.add(textField);
		textField.setColumns(10);
		panel_4.add(button_1);

		RoundButton roundButton = new RoundButton("");
		roundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalisedProfil window;
				try {
					window = new PersonalisedProfil(idOwner);
					window.frame.setVisible(true);
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		roundButton.setBounds(941, 33, 49, 47);
		if(!((String)(((Object[])data_user.get(0))[5])).isEmpty())
		{roundButton.setIcon(ResizeImage((String)(((Object[])data_user.get(0))[5]),roundButton));
		roundButton.setToolTipText("Profil");}
		else {roundButton.setToolTipText("Add you photo");
		roundButton.setIcon(ResizeImage("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\add.png",roundButton));
		}

		panel_2.add(roundButton);
		roundButton.setSelected(true);
		roundButton.setOpaque(false);
		roundButton.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		roundButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		roundButton.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1018, 37, 108, 43);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 2, 122, 50);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.BLACK);
		panel_1.add(menuBar);
		JMenu mnNewMenu = new JMenu((((String)(((Object[])data_user.get(0))[1])).charAt(0)+"").toUpperCase()+name);
		mnNewMenu.setToolTipText("Click for navigate");
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setFont(new Font("Arabic Typesetting", Font.BOLD, 24));

		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Profile");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalisedProfil window;
				try {
					window = new PersonalisedProfil(idOwner);
					window.frame.setVisible(true);
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setBackground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmDeconnection = new JMenuItem("Disconnection");
		mntmDeconnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		mntmDeconnection.setBackground(Color.BLACK);
		mntmDeconnection.setForeground(Color.WHITE);
		mnNewMenu.add(mntmDeconnection);

		panel_1.setBackground(Color.BLACK);

		JSeparator separator_2 = new JSeparator(SwingConstants.VERTICAL);
		separator_2.setForeground(new Color(105, 105, 105));
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(258, 40, 2, 32);
		panel_2.add(separator_2);
		JButton roundButton_1 = new JButton("");
		roundButton_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\mail1.png"));
		roundButton_1.setToolTipText("Discussion");
		roundButton_1.setSelected(true);
		roundButton_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		roundButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		roundButton_1.setBackground(Color.BLACK);
		roundButton_1.setBounds(1136, 33, 49, 47);
		panel_2.add(roundButton_1);
		JLabel label_3 = new JLabel("");
		label_3.setBounds(893, 295, 46, 14);
		frame.getContentPane().add(label_3);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(16, 103, 997, 492);
		frame.getContentPane().add(panel_8);

		panel_8.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 997, 492);


		JPanel contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(0, 0, 997, 492);
		contentPane.setPreferredSize(new Dimension(500, 400));
		contentPane.add(scrollPane);
		p= new JPanel();
		p.setBackground(Color.WHITE);
		scrollPane.setViewportView(p);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(977,250));
		p.add(panel);
		panel.setLayout(null);

		JLabel lblTheUpload = new JLabel("The Upload");
		lblTheUpload.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		lblTheUpload.setBounds(10, 11, 128, 33);
		panel.add(lblTheUpload);

		JLabel lblNewLabel_1 = new JLabel("Newly posted tracks. Just for you");
		lblNewLabel_1.setForeground(new Color(102, 153, 153));
		lblNewLabel_1.setFont(new Font("Arabic Typesetting", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 45, 199, 14);
		panel.add(lblNewLabel_1);


		panel_10.setBounds(10, 70, 975, 177);
		panel.add(panel_10);

		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(977,250));
		//p.add(panel_9);
		panel_9.setLayout(null);

		JLabel lblMoreOfWhat = new JLabel("More of what you like");
		lblMoreOfWhat.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		lblMoreOfWhat.setBounds(10, 11, 211, 33);
		panel_9.add(lblMoreOfWhat);

		JLabel lblSuggestionsBasedOn = new JLabel("Suggestions based on what you've liked ");
		lblSuggestionsBasedOn.setForeground(new Color(102, 153, 153));
		lblSuggestionsBasedOn.setFont(new Font("Arabic Typesetting", Font.ITALIC, 16));
		lblSuggestionsBasedOn.setBounds(10, 41, 199, 14);
		panel_9.add(lblSuggestionsBasedOn);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(10, 75, 975, 159);
		panel_9.add(panel_11);

		JPanel panel_12 = new JPanel();
		panel_12.setPreferredSize(new Dimension(977,250));
		p.add(panel_12);
		panel_12.setLayout(null);

		JLabel lblBooksRecentlyAdded = new JLabel("Books");
		lblBooksRecentlyAdded.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		lblBooksRecentlyAdded.setBounds(10, 11, 211, 33);
		panel_12.add(lblBooksRecentlyAdded);

		JLabel lblBooksRecentlyAdded_1 = new JLabel("Books recently added");
		lblBooksRecentlyAdded_1.setForeground(new Color(102, 153, 153));
		lblBooksRecentlyAdded_1.setFont(new Font("Arabic Typesetting", Font.ITALIC, 16));
		lblBooksRecentlyAdded_1.setBounds(10, 43, 199, 14);
		panel_12.add(lblBooksRecentlyAdded_1);

		 panel_13 = new JPanel();
		panel_13.setBounds(10, 55, 975, 159);
		panel_12.add(panel_13);
		cl2=new CardLayout();
		panel_13.setLayout(cl2);
		rs=con.selection("SELECT * FROM book where type='pdf'");
		try {
			rsmd =(ResultSetMetaData) rs.getMetaData();

			int nb_col=rsmd.getColumnCount();

			while( rs.next() ) {
				Object [] t= new Object[nb_col];
				for(int i=1;i<=nb_col;i++)
					t[i-1]=rs.getObject(i);
				data_recent_book.add(t );}} catch (SQLException e2) {e2.printStackTrace();}
		 counter=0;
		j=0;
		while(counter+6<data_recent_book.size()-1) {

			panel_13.add(new Theupload(idOwner,new DescripBook((int)((Object[])data_recent_book.get(counter+0))[0],(String)((Object[])data_recent_book.get(counter+0))[2],(String)((Object[])data_recent_book.get(counter+0))[3],(String)((Object[])data_recent_book.get(counter+0))[7],(String)((Object[])data_recent_book.get(counter+0))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+1))[0],(String)((Object[])data_recent_book.get(counter+1))[2],(String)((Object[])data_recent_book.get(counter+1))[3],(String)((Object[])data_recent_book.get(counter+1))[7],(String)((Object[])data_recent_book.get(counter+1))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+2))[0],(String)((Object[])data_recent_book.get(counter+2))[2],(String)((Object[])data_recent_book.get(counter+2))[3],(String)((Object[])data_recent_book.get(counter+2))[7],(String)((Object[])data_recent_book.get(counter+2))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+3))[0],(String)((Object[])data_recent_book.get(counter+3))[2],(String)((Object[])data_recent_book.get(counter+3))[3],(String)((Object[])data_recent_book.get(counter+3))[7],(String)((Object[])data_recent_book.get(counter+3))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+4))[0],(String)((Object[])data_recent_book.get(counter+4))[2],(String)((Object[])data_recent_book.get(counter+4))[3],(String)((Object[])data_recent_book.get(counter+4))[7],(String)((Object[])data_recent_book.get(counter+4))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+5))[0],(String)((Object[])data_recent_book.get(counter+5))[2],(String)((Object[])data_recent_book.get(counter+5))[3],(String)((Object[])data_recent_book.get(counter+5))[7],(String)((Object[])data_recent_book.get(counter+5))[6],0,0)), "Panel"+counter);	
			panel_13.revalidate();
			panel_13.repaint();
			counter++;

			j=0;

		}
		JPanel panel_14 = new JPanel();
		panel_14.setPreferredSize(new Dimension(977,250));
		p.add(panel_14);
		panel_14.setLayout(null);

		JLabel lblSoundBooks = new JLabel("Sound books");
		lblSoundBooks.setBounds(10, 11, 117, 29);
		lblSoundBooks.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		panel_14.add(lblSoundBooks);

		JLabel lblVocalBooksRecently = new JLabel("vocal books recently added");
		lblVocalBooksRecently.setForeground(new Color(102, 153, 153));
		lblVocalBooksRecently.setFont(new Font("Arabic Typesetting", Font.ITALIC, 16));
		lblVocalBooksRecently.setBounds(10, 39, 199, 14);
		panel_14.add(lblVocalBooksRecently);
		cl1= new CardLayout();
		panel_15 = new JPanel();
		panel_15.setBounds(10, 63, 975, 177);
		panel_15.setPreferredSize(new Dimension( 975, 177));
		panel_15.setLayout(cl1);
		panel_14.add(panel_15);
		panel_8.add(contentPane);
		rs=con.selection("SELECT * FROM `book` WHERE type='sound'");
		try {
			rsmd =(ResultSetMetaData) rs.getMetaData();

			int nb_col=rsmd.getColumnCount();

			while( rs.next() ) {
				Object [] t= new Object[nb_col];
				for(int i=1;i<=nb_col;i++)
					t[i-1]=rs.getObject(i);
				data_sound_book.add(t );}
			} catch (SQLException e2) {e2.printStackTrace();}
		
		counter=0;
		j=0;
		while(counter+6<data_sound_book.size()-1) {
			//System.out.println("---------------------------------------");

			panel_15.add(new Theupload(idOwner,new DescripBook((int)((Object[])data_sound_book.get(counter+0))[0],(String)((Object[])data_sound_book.get(counter+0))[2],(String)((Object[])data_sound_book.get(counter+0))[3],(String)((Object[])data_sound_book.get(counter+0))[7],(String)((Object[])data_sound_book.get(counter+0))[6],0,0),
					new DescripBook((int)((Object[])data_sound_book.get(counter+1))[0],(String)((Object[])data_sound_book.get(counter+1))[2],(String)((Object[])data_sound_book.get(counter+1))[3],(String)((Object[])data_sound_book.get(counter+1))[7],(String)((Object[])data_sound_book.get(counter+1))[6],0,0),
					new DescripBook((int)((Object[])data_sound_book.get(counter+2))[0],(String)((Object[])data_sound_book.get(counter+2))[2],(String)((Object[])data_sound_book.get(counter+2))[3],(String)((Object[])data_sound_book.get(counter+2))[7],(String)((Object[])data_sound_book.get(counter+2))[6],0,0),
					new DescripBook((int)((Object[])data_sound_book.get(counter+3))[0],(String)((Object[])data_sound_book.get(counter+3))[2],(String)((Object[])data_sound_book.get(counter+3))[3],(String)((Object[])data_sound_book.get(counter+3))[7],(String)((Object[])data_sound_book.get(counter+3))[6],0,0),
					new DescripBook((int)((Object[])data_sound_book.get(counter+4))[0],(String)((Object[])data_sound_book.get(counter+4))[2],(String)((Object[])data_sound_book.get(counter+4))[3],(String)((Object[])data_sound_book.get(counter+4))[7],(String)((Object[])data_sound_book.get(counter+4))[6],0,0),
					new DescripBook((int)((Object[])data_sound_book.get(counter+5))[0],(String)((Object[])data_sound_book.get(counter+5))[2],(String)((Object[])data_sound_book.get(counter+5))[3],(String)((Object[])data_sound_book.get(counter+5))[7],(String)((Object[])data_recent_book.get(counter+5))[6],0,0)), "Panel"+counter);	
			System.out.println("*****");
			panel_15.revalidate();
			panel_15.repaint();
			counter++;

			j=0;

		}
		 a= new Animation(); 
		a.start(); 
		Animation2 b= new Animation2(); 
		b.start();
	}
	public ImageIcon ResizeImage(String ImagePath,JComponent c)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

	class Animation extends Thread{
		public void run() {
			while(test1) {
				try {
					System.out.println("    ");
					
					cl.next(panel_10);
					pack();
					Thread.sleep(1000);
				} 
				catch (InterruptedException e1) {System.out.println("Exception de thread sleep");}
				catch( NullPointerException e2) {System.out.println("NullPointerException hna");}

			}
		}}
	class Animation2 extends Thread{
		public void run() {
			while(test2) {
				try {
					System.out.println("    ");
					cl1.next(panel_15);
					cl2.next(panel_13);
					pack();
					Thread.sleep(1000);
				} 
				catch (InterruptedException e1) {System.out.println("Exception de thread sleep");}
				catch( NullPointerException e2) {System.out.println("NullPointerException hna");}

			}
		}}
}
