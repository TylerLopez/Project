import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		try {
			companyMain gui = new companyMain();
//			load();

		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

	
	
//	private static void load() {// loads info
//		File file = new File("ResortList.txt");
//
//		try {
//			Scanner fileScan = new Scanner(file);
//			while (fileScan.hasNextLine()) {
//				int checkins = fileScan.nextInt();
//				int booked = fileScan.nextInt();
//				int canceled = fileScan.nextInt();
//				int noShows = fileScan.nextInt();
//				int netAppt = (booked - canceled - noShows);
//				float penetrationRate = (float) (netAppt * 100) / (checkins);
//				Checkins data = new Checkins();
//				data.setCheckins(checkins);
//				data.setBooked(booked);
//				data.setCancelations(canceled);
//				data.setNoShows(noShows);
//				//adding function
//				fileScan.nextLine();// may not need
//			}
//
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found.");
//			System.exit(0);
//		}
//
//	}

}
