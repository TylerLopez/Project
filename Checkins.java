import java.util.Date;

public class Checkins {
	private Date date = new Date();
	
	private int checkins;
	private int booked;
	private int noShows;
	private int cancelations;
	private float penetration;
	
	public String getDate() {
		return date.toString();
	}
	
	public void setCheckins(int checkins) {
		this.checkins = checkins;
	}
	
	public void setBooked(int booked) {
		this.booked = booked;
	}
	
	public void setNoShows(int noShows) {
		this.noShows = noShows;
	}
	
	public void setCancelations(int cancelations) {
		this.cancelations = cancelations;
	}
	
	public int getCheckins() {
		return this.checkins;
	}
	
	public int getBooked() {
		return this.booked;
	}
	
	public int getNoShows() {
		return this.noShows;
	}
	
	public int getCancelations() {
		return this.cancelations;
	}
	
	public float getPenetration() {
		this.penetration = (float)(this.checkins) / (this.noShows + this.cancelations);
		return this.penetration;
	}
}
