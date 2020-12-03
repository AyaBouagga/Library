


import java.io.Serializable;

public class Note implements Serializable {

	int num; 
	String contenu ;
public Note(int n , String c){
	num=n; 
	contenu=c;
}
public Note(){
	
}
public String toString() {
	return "Note [num=" + num + ", contenu=" + contenu + "]";
}
public String getContenu() {
	return contenu;
}
public void setContenu(String contenu) {
	this.contenu = contenu;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}


}
