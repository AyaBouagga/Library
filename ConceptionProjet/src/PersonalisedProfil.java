


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


import javax.swing.JSeparator;
import javax.swing.JSlider;

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
import java.sql.ResultSetMetaData;
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
import javax.swing.JComboBox;

public class PersonalisedProfil extends JFrame {

	public static JFrame frame;JPanel panelView;
	static int idOwner;
	JFileChooser file;
	String imagepath;
	Maconnection con ;
	ResultSet rs;
	ArrayList data_user=new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			PersonalisedProfill2 window = nePersonalisedProfill2(1);
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
		frame.setBounds(0, 0,1028, 672 );

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(0, 420,741, -420 );
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separatorAll = new JSeparator();
		separatorAll.setForeground(Color.LIGHT_GRAY);
		separatorAll.setBackground(Color.LIGHT_GRAY);
		separatorAll.setBounds(41, 11, 971, 15);
		frame.getContentPane().add(separatorAll);

		panelView =new JPanel();
		panelView.setBackground(Color.WHITE);
		panelView.setBounds(42, 117, 960, 505);
		frame.getContentPane().add(panelView);
		panelView.setLayout(null);
								
										JPanel panel_2 = new JPanel();
										panel_2.setBounds(0, -2, 36, 633);
										frame.getContentPane().add(panel_2);
										panel_2.setBackground(new Color(0, 0, 0));
										
										JPanel panel_1 = new JPanel();
										panel_1.setBackground(Color.WHITE);
										panel_1.setBounds(41, 22, 418, 37);
										frame.getContentPane().add(panel_1);
										panel_1.setLayout(null);
										
										JLabel lblProject = new JLabel("Project:");
										lblProject.setBounds(10, 0, 113, 39);
										panel_1.add(lblProject);
										lblProject.setBackground(new Color(153, 0, 0));
										lblProject.setForeground(new Color(153, 0, 0));
										lblProject.setFont(new Font("Arabic Typesetting", Font.BOLD, 34));
										   String t []= {"Name of the project","project1","project2"};
										JComboBox comboBox = new JComboBox(t);
										comboBox.setBackground(new Color(255, 204, 255));
										comboBox.setFont(new Font("Arabic Typesetting", Font.BOLD, 13));
										comboBox.setBounds(124, 10, 158, 20);
										panel_1.add(comboBox);
										
										JSeparator separator = new JSeparator();
										separator.setForeground(Color.LIGHT_GRAY);
										separator.setBackground(Color.LIGHT_GRAY);
										separator.setBounds(41, 107, 971, 15);
										frame.getContentPane().add(separator);
										
										JButton btnShowAllPh = new JButton("Show all phase");
										btnShowAllPh.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												panelView.removeAll();
												Btnbooks books=new Btnbooks(idOwner);
												books.setVisible(true);
												panelView.add(books);
												panelView.setVisible(true);
												panelView.updateUI();
											}
										});
										btnShowAllPh.setSelected(true);
										btnShowAllPh.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
										btnShowAllPh.setBorder(null);
										btnShowAllPh.setBackground(Color.WHITE);
										btnShowAllPh.setBounds(41, 65, 147, 37);
										frame.getContentPane().add(btnShowAllPh);
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
