import java.util.LinkedList;
import javax.swing.JFrame;

public class Site extends JFrame{
	private String siteName;
//	private LinkedList<Resort> resorts = new LinkedList<Resort>();
//
//	public LinkedList<Resort> getResorts() {
//		return resorts;
//	}
	
	public void setName(String name) {
		this.siteName = name;
	}
	
	public String getName() {
		return this.siteName;
	}
	
	public String toString() {
		return siteName;
	}
	
	public void addNewResort(String name) {
		Resort resort = new Resort();
		resort.setName(name);
		
	}
	
	
}
