package Inscription;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.ResultSetMetaData;


import javax.swing.UIManager;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Scrollbar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BtnAll extends JPanel {
	JPanel panel;
	ArrayList data_recent_book=new ArrayList();
	CardLayout cl,cl1,cl2;
	Maconnection con ;
	ResultSet rs;
	int idOwner;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BtnAll window = new BtnAll(2);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param owner 
	 */
	public BtnAll(int owner) {
		idOwner=owner;
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Alll", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(153, 0, 0)));
		setLayout(null);
		
		JLabel lblRecentActivity = new JLabel("Recent Activity");
		lblRecentActivity.setBackground(Color.WHITE);
		lblRecentActivity.setForeground(new Color(153, 0, 0));
		lblRecentActivity.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblRecentActivity.setBounds(10, 40, 88, 29);
		add(lblRecentActivity);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 750, 2);
		add(separator);
		
		JLabel lblRecentQuotes = new JLabel("Recent Quotes");
		lblRecentQuotes.setForeground(new Color(153, 0, 0));
		lblRecentQuotes.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblRecentQuotes.setBackground(Color.WHITE);
		lblRecentQuotes.setBounds(10, 298, 88, 29);
		add(lblRecentQuotes);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 338, 750, 2);
		add(separator_1);
		
		JLabel lblViewAll = new JLabel("View all");
		lblViewAll.setForeground(Color.LIGHT_GRAY);
		lblViewAll.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblViewAll.setBounds(726, 31, 52, 29);
		add(lblViewAll);
		
		JLabel label = new JLabel("View all");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		label.setBounds(711, 311, 52, 29);
		add(label);
		
panel = new JPanel();
		panel.setBounds(10, 107, 738, 180);
		add(panel);
		con=new Maconnection("biblio");
		cl2=new CardLayout();
		panel.setLayout(cl2);
		rs=con.selection("SELECT * FROM book where type='pdf'");
		try {
			ResultSetMetaData rsmd =(ResultSetMetaData) rs.getMetaData();

			int nb_col=rsmd.getColumnCount();

			while( rs.next() ) {
				Object [] t= new Object[nb_col];
				for(int i=1;i<=nb_col;i++)
					t[i-1]=rs.getObject(i);
				data_recent_book.add(t );}} catch (SQLException e2) {e2.printStackTrace();}
		 int counter=0;
		int j=0;
		while(counter+6<data_recent_book.size()-1) {

			panel.add(new Theupload2(idOwner,new DescripBook((int)((Object[])data_recent_book.get(counter+0))[0],(String)((Object[])data_recent_book.get(counter+0))[2],(String)((Object[])data_recent_book.get(counter+0))[3],(String)((Object[])data_recent_book.get(counter+0))[7],(String)((Object[])data_recent_book.get(counter+0))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+1))[0],(String)((Object[])data_recent_book.get(counter+1))[2],(String)((Object[])data_recent_book.get(counter+1))[3],(String)((Object[])data_recent_book.get(counter+1))[7],(String)((Object[])data_recent_book.get(counter+1))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+2))[0],(String)((Object[])data_recent_book.get(counter+2))[2],(String)((Object[])data_recent_book.get(counter+2))[3],(String)((Object[])data_recent_book.get(counter+2))[7],(String)((Object[])data_recent_book.get(counter+2))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+3))[0],(String)((Object[])data_recent_book.get(counter+3))[2],(String)((Object[])data_recent_book.get(counter+3))[3],(String)((Object[])data_recent_book.get(counter+3))[7],(String)((Object[])data_recent_book.get(counter+3))[6],0,0)), "Panel"+counter);	
			panel.revalidate();
			panel.repaint();
			counter++;

			j=0;

		}
		
		JLabel lblRecentBooks = new JLabel("Recent books");
		lblRecentBooks.setForeground(new Color(153, 0, 0));
		lblRecentBooks.setFont(new Font("Arabic Typesetting", Font.PLAIN, 15));
		lblRecentBooks.setBackground(Color.WHITE);
		lblRecentBooks.setBounds(10, 67, 88, 29);
		add(lblRecentBooks);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(761, 58, 17, 461);
		add(scrollbar);
		initialize();
		Animation2 a=new Animation2();
		a.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(0, 0, 788, 529);
	}
	class Animation2 extends Thread{
		public void run() {
			while(true) {
				try {
					System.out.println("    ");
					cl2.next(panel);
					Thread.sleep(1000);
				} 
				catch (InterruptedException e1) {System.out.println("Exception de thread sleep");}
				catch( NullPointerException e2) {System.out.println("NullPointerException hna");}

			}
		}}
}
