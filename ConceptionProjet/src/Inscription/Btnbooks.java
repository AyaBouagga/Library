package Inscription;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.SwingUtilities;



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

public class Btnbooks extends JPanel {

	public Maconnection con ;
	ResultSet rs ;
	ResultSetMetaData rsmd;

	int idOwner;
	JLabel lblBook;
	public ArrayList<Object> data=new ArrayList<Object>();
	JPanel panel_1;
	boolean empty = true;
	public int counter=0;
	public JButton btnNewButton_1;
	public JButton button_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Btnbooks window = new Btnbooks();
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
	public Btnbooks() {
		
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Phases", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(153, 0, 0)));
		setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(21, 25, 818, 412);
		add(panel_1);
		panel_1.setLayout(new GridLayout(2, 4));

		btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);

		btnNewButton_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 13));
		btnNewButton_1.setBounds(417, 448, 46, 35);

		add(btnNewButton_1);
		button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBackground(Color.WHITE);

		button_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 13));
		button_1.setBounds(477, 448, 46, 35);
		add(button_1);

		JButton button_2 = new JButton("3");
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter=14;
				affiche();
			}
		});
		button_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 13));
		button_2.setBounds(537, 448, 46, 35);
		add(button_2);

		JButton button_3 = new JButton("....");
		button_3.setBackground(Color.WHITE);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setFont(new Font("Arabic Typesetting", Font.BOLD, 13));
		button_3.setBounds(597, 448, 46, 35);
		add(button_3);




		con=new Maconnection("conception");
		String req_select="Select * From tache";
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
					t[i-1]=rs.getObject(i);
				data.add(t );


			}
			if(!empty) {
				affiche();

				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						counter=7;
						panel_1.updateUI();
						System.out.println("update");
						SwingUtilities.updateComponentTreeUI(panel_1);
						affiche();
					}
				});
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						counter=0;
						affiche();

					}
				}); 


			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException cc) {}

		if( empty ) {
		System.out.println("NO tache "); 	
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 40, 382, 249);
		add(panel);
		panel.setLayout(null);

		JButton button = new JButton("");

		button.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\8iEbq8gyT.png"));
		button.setSelected(true);
		button.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(141, 88, 60, 60);
		panel.add(button);

		JLabel lblAddYourBooks = new JLabel("Click to add your books");
		lblAddYourBooks.setForeground(Color.LIGHT_GRAY);
		lblAddYourBooks.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblAddYourBooks.setBounds(129, 55, 136, 33);
		panel.add(lblAddYourBooks);

		JLabel lblNoResult = new JLabel("No result");
		lblNoResult.setForeground(new Color(211, 211, 211));
		lblNoResult.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblNoResult.setBounds(129, 11, 110, 60);
		panel.add(lblNoResult);}


		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(0, 0, 870, 504);
	}
	public ImageIcon ResizeImage(String ImagePath,JComponent c)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	public void affiche() {
		int j=0;
		panel_1.removeAll();
		panel_1.revalidate();
		panel_1.repaint();
		
		while(j<=7&(counter+j)<data.size()) {
			System.out.println((int)((Object[])data.get(counter+j))[0]);
			this.panel_1.add(new DescripBook((int)((Object[])data.get(counter+j))[0]));	
			System.out.println("jjjjjjjj"+(int)((Object[])data.get(counter+j))[0]);
			j++;}



	}

}
