


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.ImageIcon;

public class Interface {
	public Maconnection con ;
	public ArrayList<Object> data=new ArrayList<Object>();

	ResultSet rs ;
	ResultSetMetaData rsmd;
	public JFrame frame;
	private final JSeparator separator = new JSeparator();
	private JTextField textField;
	String Ip="127.0.0.01"; 
	int port=2001;
	MyServes ms;
	JTextArea textArea;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	boolean empty=true ;
	private JLabel lblNameOfBook;
	private JLabel lblTitle;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 */
	public Interface() throws RemoteException, NotBoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	private void initialize() throws RemoteException, NotBoundException {
		frame = new JFrame();

		frame.setBounds(100, 100, 450, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String response = javax.swing.JOptionPane.showInputDialog("Saisi votre num "); 
		int n=Integer.parseInt(response);
		frame.setTitle("User "+1);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 320);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnEnvoyer = new JButton("Commenter");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnvoyer.setSelected(true);
		btnEnvoyer.setFont(new Font("Arabic Typesetting", Font.BOLD, 25));
		btnEnvoyer.setBorder(null);
		btnEnvoyer.setBackground(Color.WHITE);
		btnEnvoyer.setBounds(289, 223, 113, 35);
		panel.add(btnEnvoyer);
		separator.setBounds(289, 261, 89, 31);
		panel.add(separator);

		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.GRAY));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(33, 94, 319, 118);
		panel.add(textArea);

		textField = new JTextField();
		textField.setBounds(33, 223, 233, 35);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblDiscussionInstantan = new JLabel("Discussion instantan\u00E9");
		lblDiscussionInstantan.setBounds(10, 286, 172, 23);
		panel.add(lblDiscussionInstantan);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(33, 11, 72, 72);	
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(224, 11, 101, 30);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(224, 52, 101, 31);
		panel.add(lblNewLabel_2);
		
		con=new Maconnection("biblio");
		
		String req_select="Select * From book";
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
		
        ResultSet rs2=con.selection("SELECT s.contenu , s.id FROM message s INNER JOIN discussion hp on s.id = hp.idmessage INNER JOIN user h on hp.iduser = h.id and h.id=5");
        
		lblNewLabel.setIcon(new ImageIcon((String)((Object[])data.get(0))[7]));
		lblNewLabel_1.setText((String)((Object[])data.get(0))[2]);
		lblNewLabel_2 .setText((String)((Object[])data.get(0))[3]);
		
		lblNameOfBook = new JLabel("Name of book:");
		lblNameOfBook.setForeground(new Color(153, 0, 0));
		lblNameOfBook.setFont(new Font("Arabic Typesetting", Font.BOLD, 16));
		lblNameOfBook.setBounds(125, 11, 113, 30);
		panel.add(lblNameOfBook);
		
		lblTitle = new JLabel("Title");
		lblTitle.setForeground(new Color(153, 0, 0));
		lblTitle.setFont(new Font("Arabic Typesetting", Font.BOLD, 16));
		lblTitle.setBounds(125, 52, 113, 30);
		panel.add(lblTitle);
		//______________________________________________________________________
		System.out.println("Lancement Client");
		Registry reg =LocateRegistry.getRegistry(Ip,port);
		Remote r = reg.lookup("remote");
		if(r instanceof MyServes) {
			ms=(MyServes)r ;
			ThreadView a= new ThreadView(); 
			a.start();
			btnEnvoyer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ms.Addmsg(new Note(n,textField.getText()));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

		}
		

	}
	class ThreadView extends Thread{

		public void run() {
			while(true) {
				try {Thread.sleep(3000);} catch (InterruptedException e1) {System.out.println("Exception de thread sleep");}
				try {
					String text="";
					ArrayList<Note> Alldisv=ms.Viewall();
					for(int i=0;i<Alldisv.size();i++) {
						text+=Alldisv.get(i).num+" : "+Alldisv.get(i).contenu;
					}
					textArea.setText(text);
				} catch (RemoteException e) {System.out.println("Interface run thread ");;}
			}
		}}

}


