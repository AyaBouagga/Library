package Inscription;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Maconnection {
	Connection con;
	public Statement st;
 	Maconnection (String base_name){
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			 con =DriverManager.getConnection("jdbc:mysql://127.0.0.1/"+base_name,"root","");//sqlexception
			 st=con.createStatement();
        } 
	catch(ClassNotFoundException e) {System.out.println("ClassNotFoundException");}
	catch(SQLException se){System.out.println("hna");}
		}

 	int ajout(String table ,ArrayList l) throws ClassNotFoundException {
 		String values="";
 		int i,n=l.size();
        for(i=0;i<n;i++) {
        	if(!l.get(i).getClass().equals("int") )
        	   {values+="'"+l.get(i)+"',";}
        	else {
            	
            		values+=l.get(i)+",";
            	}
        }
      /* if(!l.get(i).getClass().equals("int") )
 	   {values+="'"+l.get(i)+"'";}
 	   else {values+=l.get(i);}
        System.out.println(values);*/
        
        values+="NOW()";
       
 		String req_ajout="Insert into "+table+" values("+values+")";
 		int a=0;
 		try {
 			a =st.executeUpdate(EditingPath(req_ajout));
 		}catch(SQLException se){System.out.println("ajout excp");}
 		 
 		return a;
 	}
ResultSet selection(String req_select) {
	ResultSet rs = null;
	try {
		rs = st.executeQuery (req_select);
	} catch(SQLException se){System.out.println("SQl select excep");}
	catch(NullPointerException cc) {System.out.println("");}
	return rs;
}
int suppression(String req_supp ) {
	int a=0;
	try {
		a = st.executeUpdate(req_supp);
	}catch(SQLException se){System.out.println("SQLException");}
	
	return a;
}
int modifier(String req_modif) {
	int a=0;
	try {
		a = st.executeUpdate(req_modif);
	}catch(SQLException se){System.out.println("Modifier exception");}
	 
	return a;
}
public String EditingPath(String path) {
	String pathdouble=""; 
	for(int i=0;i<path.length();i++)
	{   pathdouble+=Character.toString(path.charAt(i));
		if(Character.toString(path.charAt(i)).equals("\\")){
			 pathdouble+="\\";
		}
		}
	System.out.println(pathdouble);
	return pathdouble;
}

}
