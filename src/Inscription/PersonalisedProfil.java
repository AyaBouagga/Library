package Inscription;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;

public class PersonalisedProfil extends JFrame {

	public static JFrame frame;
	public FormLayout layout;
	private JPanel panel_1;JPanel panelView;
	static int idOwner;
	JLabel lblViewAllQuotes ;
	JLabel lblViewAll ;
	JFileChooser file;
	String imagepath;
	Maconnection con ;
	ResultSet rs;
	JSeparator separator_10 ;
	ArrayList data_user=new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalisedProfil window = new PersonalisedProfil(1);
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
	public PersonalisedProfil(int owner) throws SQLException {
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
			ResultSetMetaData rsmd =(ResultSetMetaData) rs.getMetaData();
			int nb_col=rsmd.getColumnCount();

			while( rs.next() ) {
				// ResultSet processing here
				Object [] t= new Object[nb_col];
				for(int i=1;i<=nb_col;i++)
					t[i-1]=rs.getObject(i);
				System.out.println(0+"ajout");
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

		JPanel panel = new JPanel();
		panel.setBounds(0, 420,741, -420 );
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setToolTipText("gggg");
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 200, 633);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(164, 0, 36, 633);
		panel_2.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_2);

		JButton btnAll = new JButton("All");

		btnAll.setSelected(true);
		btnAll.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnAll.setBorder(null);
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelView.removeAll();
				BtnAll all=new BtnAll(idOwner);
				all.setVisible(true);
				panelView.add(all);
				panelView.setVisible(true);
				panelView.updateUI();

			}
		});
		btnAll.setBackground(Color.WHITE);
		btnAll.setBounds(228, 11, 89, 48);
		frame.getContentPane().add(btnAll);

		JButton btnBooks = new JButton("Books");

		btnBooks.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnBooks.setBorder(null);

		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelView.removeAll();
				Btnbooks books=new Btnbooks(idOwner);
				books.setVisible(true);
				panelView.add(books);
				panelView.setVisible(true);
				panelView.updateUI();
			}
		});
		btnBooks.setBackground(Color.WHITE);
		btnBooks.setBounds(350, 11, 89, 47);
		frame.getContentPane().add(btnBooks);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(203, 63, 25, 2);
		frame.getContentPane().add(separator);

		JSeparator separatorAll = new JSeparator();
		separatorAll.setForeground(Color.LIGHT_GRAY);
		separatorAll.setBackground(Color.LIGHT_GRAY);
		separatorAll.setBounds(228, 63, 89, 2);
		frame.getContentPane().add(separatorAll);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(317, 63, 37, 2);
		frame.getContentPane().add(separator_2);

		JSeparator separatorBooks = new JSeparator();
		separatorBooks.setForeground(Color.LIGHT_GRAY);
		separatorBooks.setBackground(Color.LIGHT_GRAY);
		separatorBooks.setBounds(350, 63, 89, 2);
		frame.getContentPane().add(separatorBooks);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.LIGHT_GRAY);
		separator_4.setBackground(Color.LIGHT_GRAY);
		separator_4.setBounds(437, 63, 41, 2);
		frame.getContentPane().add(separator_4);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.LIGHT_GRAY);
		separator_6.setBackground(Color.LIGHT_GRAY);
		separator_6.setBounds(739, 63, 470, 2);

		frame.getContentPane().add(separator_6);

		JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(1023, 78, 2, 527);
		frame.getContentPane().add(separator_1);

		panelView =new JPanel();
		panelView.setBackground(Color.WHITE);
		panelView.setBounds(210, 78, 800, 553);
		frame.getContentPane().add(panelView);
		panelView.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(0, 241, 165, 71);
		panel_1.add(panel_8);
		panel_8.setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		panel_8.add(menuBar,BorderLayout.CENTER);
		String name=((String) (((Object[])data_user.get(0))[1])).substring(1,((String) (((Object[])data_user.get(0))[1])).length());
		JMenu mnNewMenu = new JMenu((((String)(((Object[])data_user.get(0))[1])).charAt(0)+"").toUpperCase()+name);
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setForeground(new Color(153, 0, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 24));

		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Profile");
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setBackground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Home");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomePage window = new HomePage(idOwner);
					window.frame.setVisible(true);
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmDeconnection = new JMenuItem("Disconnection");
		mntmDeconnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		mntmDeconnection.setBackground(Color.BLACK);
		mntmDeconnection.setForeground(Color.WHITE);
		mnNewMenu.add(mntmDeconnection);

		btnAll.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnAll.setForeground(Color.red);
				separatorAll.setBackground(Color.red);
			}
			@Override
			public void focusLost(FocusEvent e) {
				separatorAll.setBackground(Color.LIGHT_GRAY);
				btnAll.setForeground(Color.black);
			}
		});
		btnBooks.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				btnBooks.setForeground(Color.red);
				separatorBooks.setBackground(Color.red);
			}
			@Override
			public void focusLost(FocusEvent e) {
				separatorBooks.setBackground(Color.LIGHT_GRAY);
				btnBooks.setForeground(Color.black);

			}
		});
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 445, 165, 303);
		panel_1.add(panel_4);
		panel_4.setBackground(Color.RED);
		panel_4.setLayout(null);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.WHITE);
		separator_7.setForeground(Color.WHITE);
		separator_7.setBounds(10, 46, 129, 1);
		panel_4.add(separator_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.WHITE);
		separator_8.setBackground(Color.WHITE);
		separator_8.setBounds(10, 85, 129, 1);
		panel_4.add(separator_8);

		JSeparator separator_9 = new JSeparator();
		separator_9.setForeground(Color.WHITE);
		separator_9.setBackground(Color.WHITE);
		separator_9.setBounds(10, 132, 129, 1);
		panel_4.add(separator_9);

		JButton btnDiscussionGroupes = new JButton("Discussion groupes");
		btnDiscussionGroupes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelView.removeAll();
				BtnDiscussion books=new BtnDiscussion(1);
				books.setVisible(true);
				panelView.add(books);
				panelView.setVisible(true);
				panelView.updateUI();
				
			}
		});
		btnDiscussionGroupes.setBounds(1, 11, 154, 24);
		panel_4.add(btnDiscussionGroupes);
		btnDiscussionGroupes.setForeground(Color.WHITE);
		btnDiscussionGroupes.setSelected(true);
		btnDiscussionGroupes.setFont(new Font("Arabic Typesetting", Font.BOLD, 22));
		btnDiscussionGroupes.setBorder(null);
		btnDiscussionGroupes.setBackground(Color.RED);

		JButton btnIamReading = new JButton("I'am reading");
		btnIamReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIamReading.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnIamReading.setHorizontalAlignment(0);;
		btnIamReading.setBounds(1, 50, 154, 24);
		panel_4.add(btnIamReading);
		btnIamReading.setSelected(true);
		btnIamReading.setForeground(Color.WHITE);
		btnIamReading.setFont(new Font("Arabic Typesetting", Font.BOLD, 22));
		btnIamReading.setBorder(null);
		btnIamReading.setBackground(Color.RED);

		JButton btnIWantTo = new JButton("I want to read");
		btnIWantTo.setBounds(1, 97, 154, 24);
		panel_4.add(btnIWantTo);
		btnIWantTo.setSelected(true);
		btnIWantTo.setForeground(Color.WHITE);
		btnIWantTo.setFont(new Font("Arabic Typesetting", Font.BOLD, 22));
		btnIWantTo.setBorder(null);
		btnIWantTo.setBackground(Color.RED);

		JButton btnIHaveBeen = new JButton("I have been reading");
		btnIHaveBeen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIHaveBeen.setBounds(1, 144, 154, 24);
		panel_4.add(btnIHaveBeen);
		btnIHaveBeen.setSelected(true);
		btnIHaveBeen.setForeground(Color.WHITE);
		btnIHaveBeen.setFont(new Font("Arabic Typesetting", Font.BOLD, 22));
		btnIHaveBeen.setBorder(null);
		btnIHaveBeen.setBackground(Color.RED);

		JButton button = new RoundButton("");
		button.setBounds(10, 105, 118, 125);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));

				//filter the files
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);

				//if the user click on save in Jfilechooser
				if(result == JFileChooser.APPROVE_OPTION){
					File selectedFile = file.getSelectedFile();
					imagepath = selectedFile.getAbsolutePath();
					System.out.println(imagepath );

					button.setIcon(ResizeImage("icon.rounded.png",button));
					try {
						RoundImage Rb=new RoundImage(imagepath) ;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				//if the user click on save in Jfilechooser


				else if(result == JFileChooser.CANCEL_OPTION){
					System.out.println("No File Select");
				}


			}
		});
		
		if(!((String)(((Object[])data_user.get(0))[4])).equals(""))
		{button.setIcon(ResizeImage((String)(((Object[])data_user.get(0))[5]),button));
		System.out.println("exist");}
		else {button.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\add.png"));}
		button.setSelected(true);
		button.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button.setBorder(new EmptyBorder(0, 0, 0, 0));
		button.setBackground(Color.BLACK);
		
		panel_1.add(button);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Discussion");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\email.png"));
		lblNewLabel_1.setBounds(1139, 11, 46, 48);
		frame.getContentPane().add(lblNewLabel_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(1035, 91, 174, 218);
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
		panel_5.setBounds(0, 0, 186, 37);
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

		JButton button_1 = new JButton("");
		button_1.setToolTipText("Go To Home Page ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomePage window = new HomePage(idOwner);
					window.frame.setVisible(true);
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(1069, 11, 60, 48);
		frame.getContentPane().add(button_1);
		button_1.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\home.png"));
		button_1.setSelected(true);
		button_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button_1.setBorder(null);
		button_1.setBackground(Color.WHITE);
		
		JButton btnSoundBooks = new JButton("Sound books");
		btnSoundBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelView.removeAll();
				 BtnSoundbooks books=new BtnSoundbooks(1);
				books.setVisible(true);
				panelView.add(books);
				panelView.setVisible(true);
				panelView.updateUI();
				separator_10.setBackground(Color.red);
			}
		});
		btnSoundBooks.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnSoundBooks.setBorder(null);
		btnSoundBooks.setBackground(Color.WHITE);
		btnSoundBooks.setBounds(482, 11, 115, 47);
		frame.getContentPane().add(btnSoundBooks);
		
		 separator_10 = new JSeparator();
		separator_10.setForeground(Color.LIGHT_GRAY);
		separator_10.setBackground(Color.LIGHT_GRAY);
		separator_10.setBounds(475, 63, 122, 2);
		frame.getContentPane().add(separator_10);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setForeground(Color.LIGHT_GRAY);
		separator_11.setBackground(Color.LIGHT_GRAY);
		separator_11.setBounds(594, 63, 25, 2);
		frame.getContentPane().add(separator_11);
		
				JSeparator separatorFriends = new JSeparator();
				separatorFriends.setBounds(619, 63, 122, 2);
				frame.getContentPane().add(separatorFriends);
				separatorFriends.setForeground(Color.LIGHT_GRAY);
				separatorFriends.setBackground(Color.LIGHT_GRAY);
				
						JButton btnFriends = new JButton("Friends");
						btnFriends.setBounds(626, 11, 115, 48);
						frame.getContentPane().add(btnFriends);
						btnFriends.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelView.removeAll();
								Btnfriends friends=new Btnfriends();
								friends.setVisible(true);
								panelView.add(friends);
								panelView.setVisible(true);
								panelView.updateUI();
							}
						});
						btnFriends.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
						btnFriends .setBorder(null);
						
								btnFriends.setBackground(Color.WHITE);
								btnFriends.addFocusListener(new FocusAdapter() {
									@Override
									public void focusGained(FocusEvent e) {
										btnFriends.setForeground(Color.red);
										separatorFriends.setBackground(Color.red);
									}
									@Override
									public void focusLost(FocusEvent e) {
										separatorFriends.setBackground(Color.GRAY);
										btnFriends.setForeground(Color.black);

									}
								});
		/*layout = new FormLayout("default, 3dlu, default, 3dlu, default", // cols //$NON-NLS-1$
				"p, 8dlu, p, 3dlu, p, 3dlu, p, 3dlu");
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		JPanel p  =builder.getPanel();*/
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
