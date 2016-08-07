import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class companyMain extends JFrame {
	JComboBox<Site> site = new JComboBox<Site>();
	JComboBox<Resort> resorts = new JComboBox<Resort>();
	static LinkedList<Site> sites = new LinkedList<Site>();
	static LinkedList<Resort> resortList = new LinkedList<Resort>();
	LinkedList<Checkins> checkins = new LinkedList<Checkins>();
	
	int count = 0;
	int sitesIndex;
	
	Container defaultPanel;
	Container sitesContainer = new Container();
	boolean mainInitialized = false;

	private static void saveData() {
		try {
			File file = new File("FileList.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			// Scanner fileScan = new Scanner(file);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			for (Site site : sites) {
				pw.println("Site: " + site);
				for (Resort resort : resortList) {
					pw.println("Resort: " + resort);
				}
				pw.println("");
			}
			
			pw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File IO Exception");
			e.printStackTrace();
		}
	}

	Site selectedSite = new Site();

	public companyMain() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 800);
		setTitle("Marketing Reports");
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		// setting up the window
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				saveData();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		JPanel topPanel = new JPanel();
		JLabel title = new JLabel("Company Main");
		topPanel.add(title);
		add(topPanel, BorderLayout.NORTH);
		// add stuff to NORTH of borderlayout(top)

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 2));
		JPanel center1_1 = new JPanel();
		center1_1.setLayout(new GridLayout(6, 1));
		JPanel center2_1 = new JPanel();
		center2_1.setLayout(new FlowLayout());
		JPanel center1_2 = new JPanel();
		center1_2.setLayout(new GridLayout(6, 1));
		JPanel center2_2 = new JPanel();
		center2_2.setLayout(new FlowLayout());

		JLabel blank = new JLabel("");
		JLabel blank1 = new JLabel("");
		JLabel checkIns = new JLabel("Check-ins");
		JLabel checkinsDisplay = new JLabel("CheckinDisplay");
		JLabel booked = new JLabel("Booked");
		JLabel bookedDisplay = new JLabel("BookedDisplay");
		JLabel canceled = new JLabel("Canceled");
		JLabel canceledDisplay = new JLabel("CancedDisplay");
		JLabel noShows = new JLabel("No-shows");
		JLabel noshowsDisplay = new JLabel("NoShowDisplay");
		JLabel netAppt = new JLabel("Net Appointments");
		JLabel netApptDisplay = new JLabel("NetApptDisplay");
		JLabel penRate = new JLabel("Penetration Rate");
		JLabel penrateDisplay = new JLabel("PenDisplay");

		center1_1.add(checkIns);
		center1_1.add(booked);
		center1_1.add(canceled);
		center1_1.add(noShows);
		center1_1.add(netAppt);
		center1_1.add(penRate);
		center1_2.add(checkinsDisplay);
		center1_2.add(bookedDisplay);
		center1_2.add(canceledDisplay);
		center1_2.add(noshowsDisplay);
		center1_2.add(netApptDisplay);
		center1_2.add(penrateDisplay);
		center2_1.add(blank1);
		center2_2.add(blank);
		center.add(center1_1);
		center.add(center1_2);
		center.add(center2_1);
		center.add(center2_2);
		add(center);
		// center of window

		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(25, 1));
		JButton addNewSite = new JButton("Add New Site");
		// JButton addNewEntry = new JButton("Add New Weekly Entry");
		//
		// ADD NEW WEEKLY ENTRY IS WHERE YOU ENTER IN ANY AND ALL DATA FOR SITES
		//
		defaultPanel = getContentPane();

		JPanel addNewSitePanel = new JPanel();
		addNewSitePanel.setLayout(new BorderLayout());
		JLabel siteName = new JLabel("Site Name: ");
		JTextField siteNameText = new JTextField(10);
		JPanel centerAddNewPanel = new JPanel(new BorderLayout());
		JButton save = new JButton("Save");
		JButton back = new JButton("Back");
		JLabel formLabel = new JLabel("         ---Add New Site Form---");

		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();

		centerAddNewPanel.add(formLabel);
		centerPanel.add(siteName);
		centerPanel.add(siteNameText);
		southPanel.add(save);
		southPanel.add(back);

		centerAddNewPanel.add(southPanel, BorderLayout.SOUTH);
		centerAddNewPanel.add(centerPanel, BorderLayout.CENTER);
		addNewSitePanel.add(centerAddNewPanel, BorderLayout.CENTER);
		// add new site form

		// JPanel south = new JPanel();
		// south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		// for(int i = 0; i < sites.size(); i++) {
		// Site site = new Site();
		// site = sites.get(i);
		// JLabel label = new JLabel(site.getName());
		// south.add(label);
		// }
		//
		// add(south, BorderLayout.SOUTH);
		// ADD TO SOUTH THE INFO ABOUT THE SITES PEN RATES EACH, MAKE BOXlAYOUT
		// FOR EASY EXTENDING FOR NEW SITES

		// if(mainInitialized == false) {
		// addNewEntry.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// addNewEntry();
		// revalidate();
		// }
		// });
		// }

		if (mainInitialized == false) {
			back.addActionListener(new ActionListener() {// actionlistener for
															// back
															// button to go to
															// main
															// page

				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(defaultPanel);
					topPanel.add(title);
					setSize(1000, 800);
					revalidate();
				}
			});
		}

		Site defaultSite = new Site();
		defaultSite.setName("Select An Option");
		sites.add(defaultSite);
		for (int i = 0; i < sites.size(); i++) {
			site.addItem(sites.get(i));
		} // adding sites to comboBox

		if (mainInitialized == false) {
			site.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Site Actionlistener Called");
					sitesIndex = site.getSelectedIndex();
					
					if (sites.get(sitesIndex) == null) {
						return;
					}
					
					if ((sites.get(sitesIndex)).getName().equals("Select An Option")) {
						return;
					}

					
					JOptionPane.showMessageDialog(null, "Going into site: " + sites.get(sitesIndex).getName());// Needed
																					// or
																					// program
																					// breaks.
																					// Don't
																					// know
					if (count == 0) {
						showSiteDetails();
					} else {
						setContentPane(mainPanelSiteDetails);
					}
					revalidate();
					// actionListener for the comboBox
				}
			});
		}

		if (mainInitialized == false) {
			save.addActionListener(new ActionListener() {// actionlistener for
															// save
															// button to go to
															// main
															// page

				@Override
				public void actionPerformed(ActionEvent e) {
					Site siteForAddingCombo = new Site();
					siteForAddingCombo.setName(siteNameText.getText());
					sites.add(siteForAddingCombo);
					site.addItem(siteForAddingCombo);
					JOptionPane.showMessageDialog(null, siteForAddingCombo.getName() + " has been added!");
					setContentPane(defaultPanel);
					topPanel.add(title);
					setSize(1000, 800);
					revalidate();
					siteNameText.setText("");
				}
			});
		}

		if (mainInitialized == false) {
			addNewSite.addActionListener(new ActionListener() {// actionlistener
																// for
																// add new site
																// button on
																// main
																// page

				@Override
				public void actionPerformed(ActionEvent event) {
					setContentPane(addNewSitePanel);
					setSize(200, 300);
					revalidate();

				}
			});
		}

		JLabel blank2 = new JLabel("");
		// eastPanel.add(addNewEntry);
		eastPanel.add(blank2);
		eastPanel.add(addNewSite);
		eastPanel.add(blank);
		eastPanel.add(site);

		add(eastPanel, BorderLayout.EAST);
		setVisible(true);// leave at bottom
	}

	boolean sitesInitialized = false;
	JPanel mainPanelSiteDetails = new JPanel();
	public void showSiteDetails() {

		if (sitesInitialized == false && resortList.size() < 1) {
			Resort defaultResort = new Resort();
			defaultResort.setName("Select An Option");
			resortList.add(defaultResort);
		}

		while (resorts.getItemCount() > 0) {
			resorts.removeItemAt(0);
		}
		for (int i = 0; i < resortList.size(); i++) {
			resorts.addItem(resortList.get(i));
		} // adding resorts to comboBox
		
		
		mainPanelSiteDetails.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		north.add(new JLabel(sites.get(sitesIndex).getName()));
		mainPanelSiteDetails.add(north, BorderLayout.NORTH);

		JPanel east = new JPanel();
		east.setLayout(new GridLayout(25, 1));
		JLabel blankSpace = new JLabel("");
		JButton backToMain = new JButton("Back To Main");
		JButton changeSiteName = new JButton("Change Site Name");
		JButton removeSite = new JButton("Remove Site");
		JButton addResort = new JButton("Add A Resort");

		east.add(addResort);
		east.add(changeSiteName);
		east.add(removeSite);
		Container siteContainer = getContentPane();

		JPanel addNewSitePanel = new JPanel();
		addNewSitePanel.setLayout(new BorderLayout());
		JLabel siteName = new JLabel("Resort Name: ");
		JTextField siteNameText = new JTextField(10);
		JPanel centerAddNewPanel = new JPanel(new BorderLayout());
		JButton save = new JButton("Save");
		JButton back = new JButton("Back To Main");
		JLabel formLabel = new JLabel("         ---Add New Resort Form---");

		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();

		centerAddNewPanel.add(formLabel);
		centerPanel.add(siteName);
		centerPanel.add(siteNameText);
		southPanel.add(save);
		southPanel.add(back);
		addNewSitePanel.add(southPanel, BorderLayout.SOUTH);
		addNewSitePanel.add(centerPanel, BorderLayout.CENTER);
		add(addNewSitePanel);

		JPanel siteChangeNamePanel = new JPanel();
		siteChangeNamePanel.setLayout(new BorderLayout());
		JPanel center1 = new JPanel();
		center1.setLayout(new FlowLayout());
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton saveNameChange = new JButton("Save");
		JLabel changeNameLabel = new JLabel("Name To Change To: ");
		JTextField nameChangeField = new JTextField(10);
		nameChangeField.setText("");
		center1.add(changeNameLabel);
		center1.add(nameChangeField);
		south.add(saveNameChange);
		south.add(backToMain);
		siteChangeNamePanel.add(south, BorderLayout.SOUTH);
		siteChangeNamePanel.add(center1, BorderLayout.CENTER);
		add(siteChangeNamePanel);
		Container changeName = getContentPane();

		if (sitesInitialized == false) {
			saveNameChange.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					sites.get(sitesIndex).setName(nameChangeField.getText());
					setContentPane(changeName);
					setSize(1000, 800);

					revalidate();
				}
			});
		}

		if (sitesInitialized == false) {
			removeSite.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					site.removeItem(site.getItemAt(sitesIndex));
					sites.remove(sites.get(sitesIndex));
					setContentPane(defaultPanel);
					revalidate();

				}
			});
		}

		if (sitesInitialized == false) {
			changeSiteName.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(siteChangeNamePanel);
					setSize(200, 300);
					revalidate();
				}
			});
		}

		if (sitesInitialized == false) {
			addResort.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(addNewSitePanel);
					setSize(200, 300);
					revalidate();
				}
			});
		}

		if (sitesInitialized == false) {
			back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setContentPane(siteContainer);
					setSize(1000, 800);
					revalidate();
					resorts.setSelectedIndex(0);
				}
			});
		}

		if (sitesInitialized == false) {
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Resort resortForAddingCombo = new Resort();
					resortForAddingCombo.setName(siteNameText.getText());
					resortList.add(resortForAddingCombo);
					resorts.addItem(resortForAddingCombo);
					JOptionPane.showMessageDialog(null, resortForAddingCombo.getName() + " has been added!");
					setContentPane(mainPanelSiteDetails);
					setSize(1000, 800);
					revalidate();
					siteNameText.setText("");

				}
			});
		}

		if (sitesInitialized == false) {
			resorts.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Resorts Actionlistener Called");
					Resort selectedResort = (Resort) resorts.getSelectedItem();
					if (selectedResort == null) {
						return;
					}
					if (((Resort) resorts.getSelectedItem()).getName().equals("Select An Option")) {
						return;
					}

					String name = selectedResort.getName();
					JOptionPane.showMessageDialog(null, "Going into resort: " + name);// Needed
																						// or
																						// program
																						// breaks.
																						// Don't
																						// know
					if (resortcount == 0) {												// why
						selectedResort1 = selectedResort;
						showResortDetails();
					} else {
						selectedResort1 = selectedResort;
						setContentPane(mainPanelResort);
					}
					revalidate();
				}
			});
		}

		east.add(backToMain);
		east.add(blankSpace);
		east.add(resorts);
		mainPanelSiteDetails.add(east, BorderLayout.EAST);

		if (sitesInitialized == false) {
			backToMain.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setContentPane(defaultPanel);
					resorts.setSelectedIndex(0);
				}
			});
		}

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 2));
		JPanel center1_1 = new JPanel();
		center1_1.setLayout(new GridLayout(6, 1));
		JPanel center2_1 = new JPanel();
		center2_1.setLayout(new FlowLayout());
		JPanel center1_2 = new JPanel();
		center1_2.setLayout(new GridLayout(6, 1));
		JPanel center2_2 = new JPanel();
		center2_2.setLayout(new FlowLayout());

		JLabel blank = new JLabel("");
		JLabel blank1 = new JLabel("");
		JLabel checkIns = new JLabel("Check-ins");
		JLabel checkinsDisplay = new JLabel("CheckinDisplay");
		JLabel booked = new JLabel("Booked");
		JLabel bookedDisplay = new JLabel("BookedDisplay");
		JLabel canceled = new JLabel("Canceled");
		JLabel canceledDisplay = new JLabel("CancedDisplay");
		JLabel noShows = new JLabel("No-shows");
		JLabel noshowsDisplay = new JLabel("NoShowDisplay");
		JLabel netAppt = new JLabel("Net Appointments");
		JLabel netApptDisplay = new JLabel("NetApptDisplay");
		JLabel penRate = new JLabel("Penetration Rate");
		JLabel penrateDisplay = new JLabel("PenDisplay");

		center1_1.add(checkIns);
		center1_1.add(booked);
		center1_1.add(canceled);
		center1_1.add(noShows);
		center1_1.add(netAppt);
		center1_1.add(penRate);
		center1_2.add(checkinsDisplay);
		center1_2.add(bookedDisplay);
		center1_2.add(canceledDisplay);
		center1_2.add(noshowsDisplay);
		center1_2.add(netApptDisplay);
		center1_2.add(penrateDisplay);
		center2_1.add(blank1);
		center2_2.add(blank);
		center.add(center1_1);
		center.add(center1_2);
		center.add(center2_1);
		center.add(center2_2);
		mainPanelSiteDetails.add(center);
		add(mainPanelSiteDetails);
		setContentPane(mainPanelSiteDetails);
		sitesContainer = getContentPane();
		sitesInitialized = true;
		revalidate();
		count++;
	}

	boolean resortsIntitialized = false;
	JPanel mainPanelResort = new JPanel();
	int resortcount = 0;
	Resort selectedResort1 = new Resort();
	public void showResortDetails() {
		mainPanelResort.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		north.add(new JLabel(selectedResort1.getName()));
		mainPanelResort.add(north, BorderLayout.NORTH);

		JPanel east = new JPanel();
		east.setLayout(new GridLayout(25, 1));
		JLabel blankSpace = new JLabel("");
		JButton backToMain = new JButton("Back To Main");
		JButton backToMain2 = new JButton("Back To Main");
		JButton changeResortName = new JButton("Change Resort Name");
		JButton removeResort = new JButton("Remove Resort");

		east.add(changeResortName);
		east.add(removeResort);
		east.add(backToMain2);

		east.add(blankSpace);
		mainPanelResort.add(east, BorderLayout.EAST);

		JPanel resortChangeNamePanel = new JPanel();
		resortChangeNamePanel.setLayout(new BorderLayout());
		JPanel center1 = new JPanel();
		center1.setLayout(new FlowLayout());
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton saveNameChange = new JButton("Save");
		JLabel changeNameLabel = new JLabel("Name To Change To: ");
		JTextField nameChangeField = new JTextField(10);
		nameChangeField.setText("");
		center1.add(changeNameLabel);
		center1.add(nameChangeField);
		south.add(saveNameChange);
		south.add(backToMain);
		resortChangeNamePanel.add(south, BorderLayout.SOUTH);
		resortChangeNamePanel.add(center1, BorderLayout.CENTER);
		add(resortChangeNamePanel);

		if (resortsIntitialized == false) {
			backToMain2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(defaultPanel);
					setSize(1000, 800);
					resorts.setSelectedIndex(0);
					revalidate();
				}
			});
		}

		if (resortsIntitialized == false) {
			changeResortName.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setContentPane(resortChangeNamePanel);
					setSize(200, 300);
					revalidate();
				}
			});
		}

		if (resortsIntitialized == false) {
			saveNameChange.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					selectedResort1.setName(nameChangeField.getText());
					setContentPane(defaultPanel);
					setSize(1000, 800);
					revalidate();
				}
			});
		}

		if (resortsIntitialized == false) {
			removeResort.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					resorts.setSelectedIndex(0);
					resortList.remove(selectedResort1);
					resorts.removeItem(selectedResort1);
					setContentPane(mainPanelSiteDetails);
					revalidate();
				}
			});
		}

		if (resortsIntitialized == false) {
			backToMain.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setContentPane(defaultPanel);
					setSize(1000, 800);
					revalidate();
					resorts.setSelectedIndex(0);
				}
			});
		}

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 2));
		JPanel center1_1 = new JPanel();
		center1_1.setLayout(new GridLayout(6, 1));
		JPanel center2_1 = new JPanel();
		center2_1.setLayout(new FlowLayout());
		JPanel center1_2 = new JPanel();
		center1_2.setLayout(new GridLayout(6, 1));
		JPanel center2_2 = new JPanel();
		center2_2.setLayout(new FlowLayout());

		JLabel blank = new JLabel("");
		JLabel blank1 = new JLabel("");
		JLabel checkIns = new JLabel("Check-ins");
		JLabel checkinsDisplay = new JLabel("CheckinDisplay");
		JLabel booked = new JLabel("Booked");
		JLabel bookedDisplay = new JLabel("BookedDisplay");
		JLabel canceled = new JLabel("Canceled");
		JLabel canceledDisplay = new JLabel("CancedDisplay");
		JLabel noShows = new JLabel("No-shows");
		JLabel noshowsDisplay = new JLabel("NoShowDisplay");
		JLabel netAppt = new JLabel("Net Appointments");
		JLabel netApptDisplay = new JLabel("NetApptDisplay");
		JLabel penRate = new JLabel("Penetration Rate");
		JLabel penrateDisplay = new JLabel("PenDisplay");

		center1_1.add(checkIns);
		center1_1.add(booked);
		center1_1.add(canceled);
		center1_1.add(noShows);
		center1_1.add(netAppt);
		center1_1.add(penRate);
		center1_2.add(checkinsDisplay);
		center1_2.add(bookedDisplay);
		center1_2.add(canceledDisplay);
		center1_2.add(noshowsDisplay);
		center1_2.add(netApptDisplay);
		center1_2.add(penrateDisplay);
		center2_1.add(blank1);
		center2_2.add(blank);
		center.add(center1_1);
		center.add(center1_2);
		center.add(center2_1);
		center.add(center2_2);
		mainPanelResort.add(center);
		add(mainPanelResort);
		setContentPane(mainPanelResort);
		resortsIntitialized = true;
		revalidate();
		resortcount++;
	}

	// public void addNewEntry() {
	//
	// JPanel mainPanel = new JPanel();
	// mainPanel.setLayout(new BorderLayout());
	//
	// JPanel northPanel = new JPanel();
	// northPanel.setLayout(new FlowLayout());
	// JLabel title = new JLabel("Add New Entry Form");
	// northPanel.add(title);
	// mainPanel.add(northPanel, BorderLayout.NORTH);
	//
	// JPanel centerPanel = new JPanel();
	// centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
	// for(Site site : sites) {
	// JLabel
	// }
	//
	//
	//
	//
	//
	//
	// add(mainPanel);
	// revalidate();
	// }

}