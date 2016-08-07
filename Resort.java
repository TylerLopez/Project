import java.util.LinkedList;

public class Resort {
	private String resortName;
	private LinkedList<Checkins> checkins = new LinkedList<Checkins>();

	public void setName(String name) {
		this.resortName = name;
	}
	
	public String getName() {
		return this.resortName;
	}
	
	public String toString() {
		return resortName;
	}
	
}
