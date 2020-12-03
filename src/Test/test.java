package Test;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.mysql.jdbc.ResultSetMetaData;

import Inscription.DescripBook;

//import Inscription.RoundButton;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Rectangle;

public class test {
	Maconnection con ;
	ResultSet rs;
	ArrayList data_recent_book=new ArrayList();

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		con=new Maconnection("biblio");
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		Playaudio p=new Playaudio("");
		panel.add(p);
		p.setBounds(new Rectangle(10, 0, 400, 150));
		
		p.setVisible(true);
		int counter=0;
		int idOwner=1;
		rs=con.selection("SELECT * FROM book ORDER BY date_ajout DESC");
		/*Jtry {
			ResultSetMetaData rsmd =(ResultSetMetaData) rs.getMetaData();

			int nb_col=rsmd.getColumnCount();

			while( rs.next() ) {
				Object [] t= new Object[nb_col];
				for(int i=1;i<=nb_col;i++)
					t[i-1]=rs.getObject(i);
				data_recent_book.add(t );}} catch (SQLException e2) {e2.printStackTrace();}
		frame.getContentPane().add(new Theupload(idOwner,new DescripBook((int)((Object[])data_recent_book.get(counter+0))[0],(String)((Object[])data_recent_book.get(counter+0))[2],(String)((Object[])data_recent_book.get(counter+0))[3],(String)((Object[])data_recent_book.get(counter+0))[7],(String)((Object[])data_recent_book.get(counter+0))[6],0,0),
					new DescripBook((int)((Object[])data_recent_book.get(counter+1))[0],(String)((Object[])data_recent_book.get(counter+1))[2],(String)((Object[])data_recent_book.get(counter+1))[3],(String)((Object[])data_recent_book.get(counter+1))[7],(String)((Object[])data_recent_book.get(counter+1))[6],0,0),
			new DescripBook((int)((Object[])data_recent_book.get(counter+2))[0],(String)((Object[])data_recent_book.get(counter+2))[2],(String)((Object[])data_recent_book.get(counter+2))[3],(String)((Object[])data_recent_book.get(counter+2))[7],(String)((Object[])data_recent_book.get(counter+2))[6],0,0)));
		Button btnAyaay = new RoundButton("");
		btnAyaay.setIcon(new ImageIcon("C:\\Users\\eya\\Desktop\\java\\Biblio\\src\\Image\\8iEbq8gyT.png"));
		btnAyaay.setBounds(250, 203, 90, 84);
		panel.add(btnAyaay);
		JPanel p=new JPanel();
		JButton b =new JButton();
		p.add(b);*/
	
	}

}
