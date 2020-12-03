


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;



public interface MyServes extends Remote {
	//________________________________msg simple string___________________________________
	//public void setMessage(String m)throws RemoteException;
	//public String getMessage()throws RemoteException;
	
	//________________________________Note class simple ___________________________________
	//String getNote()throws RemoteException;
	//void setNote(int n, String c)throws RemoteException;
	
	
	//________________________________Array list Note  ___________________________________
    void Addmsg(Note n)throws RemoteException;
    ArrayList Viewall()throws RemoteException;
}
