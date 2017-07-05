package Lab2;

import java.io.*;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

/*length of record : 
 * Player ID (int[1-20]) -> (String[5])      5 
 * Player Name (string[any] -> (String[26])  26 
 * Team Name  (string[any] -> (String[26])   26
 * Skill Level (int[0-99] -> (String[5])     5
 * Today's date (string[9] -> (String[9])    9
 * 
 *___________________________________Total = 71 + 2 = 73
 */


public class Lab02 {
	
	
	
	// Number of records in the file.
	final private static int MAX_RECORD_NUMBER = 20;
	// Size of record.
	final private static int RECORD_LENGTH = 73;

	public static void main(String[] args) throws IOException {
		
		String id = "";
		String playerName = "";
		String teamName ="";
		String skillLevel ="";
		String date="";
		int currRecordCount = 0;
		String where = "0";
		String cmd = "start";
		
		
		String filepath = JOptionPane.showInputDialog(null, "Please enter file location");
		String filename = JOptionPane.showInputDialog(null, "Please enter file name (with extension)");
		//filepath="/Users/yashjain284/Documents/workspace/CSE 116 Tutoring/src/Lab2/";
		//filename="records.txt";
		RandomAccessFile store=null;
		
		File myFile = new File(filepath + filename);
		if(myFile.exists()){
			JOptionPane.showMessageDialog(null, "File Already Exists");
		}
		else{
			JOptionPane.showMessageDialog(null, "File Does not Exists. Creating a new file");
//			store = new RandomAccessFile(myFile, "rw");
//			String Dummy = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//			System.out.println(Dummy.length());
//			for (int i = 0; i < MAX_RECORD_NUMBER; ++i) {
//				store.writeUTF(Dummy); // Fill file with dummy records.
			}
		
		store = new RandomAccessFile(myFile, "rw");
		
		System.out.println("------------------------------");
		System.out.println("   new : make a new record");
		System.out.println("   old : retrieve and display an existing record");
		System.out.println("   end : terminate the program");
	
		//While the user does not enter "end" command
		while (cmd.compareToIgnoreCase("end") != 0) {
			
			//Ask for input
			cmd = JOptionPane.showInputDialog(null, "Please input a command:");
			
			//Check for command "new" : User wants to make a new record
			if (cmd.compareToIgnoreCase("new") == 0) {
				currRecordCount++;
				
				boolean carryOn = true;
				while(carryOn){
					String ip = JOptionPane.showInputDialog(null, "Please input the Player ID [1 - 20]");
					int inputId;
					try{
						inputId = Integer.parseInt(ip);
						if(inputId <= 20 && inputId >=1){
							carryOn=false;
							id = inputId+"";
							int ctr = id.length();
							while(ctr < 5){
								id = id+" ";
								ctr++;
							}
						}
					}
					catch(NumberFormatException e){
						e.printStackTrace();
					}
				}
			
				String playerNameInput = JOptionPane.showInputDialog(null, "Please enter the player name ");
				if(playerNameInput.length()>26){
					playerNameInput = playerNameInput.substring(0, 25);
				}
				else{
					int ctr = playerNameInput.length();
					while(ctr < 26){
						playerNameInput = playerNameInput+" ";
						ctr++;
					}
				}
				playerName = playerNameInput;
				
				
				String teamNameInput = JOptionPane.showInputDialog(null, "Please enter the team name ");
				if(teamNameInput.length()>26){
					teamNameInput = teamNameInput.substring(0, 25);
				}
				else{
					int ctr = teamNameInput.length();
					while(ctr < 26){
						teamNameInput = teamNameInput+" ";
						ctr++;
					}
				}
				teamName = teamNameInput;
				
				carryOn = true;
				while(carryOn){
					String skillInput = JOptionPane.showInputDialog(null, "Please input the Player Skill Level [0 - 99]");
					int skill;
					try{
						skill = Integer.parseInt(skillInput);
						if(skill <= 99 && skill >0){
							carryOn=false;
							skillLevel = skill+"";
							int ctr = skillLevel.length();
							while(ctr < 5){
								skillLevel = skillLevel+" ";
								ctr++;
							}
						}
					}
					catch(NumberFormatException e){
						e.printStackTrace();
					}
				}
				
				
				// Ask for Today's Date
				date = JOptionPane.showInputDialog(null, "Please Enter Today's Date - Eg: 25Jun2014");
				if(date.length()>9){
					date = date.substring(0, 8);
				}
				else{
					int ctr = date.length();
					while(ctr < 9){
						date = date+" ";
						ctr++;
					}
				}
				
				
				
				// find the correct location in the file
				store.seek((RECORD_LENGTH + 2) * (currRecordCount - 1));
				String record = id+playerName+teamName+skillLevel+date;
//				System.out.println("Length of id stored : "+id.length());
//				System.out.println("Length of player name stored : "+playerName.length());
//				System.out.println("Length of team name stored : "+teamName.length());
//				System.out.println("Length of skill level stored : "+skillLevel.length());
//				System.out.println("Length of date stored : "+date.length());
//				System.out.println("Length of record stored : "+record.length());
				store.writeUTF(record);
			}

			if (cmd.compareToIgnoreCase("old") == 0) {
				// Command is "old" - user wants to see an existing record
				String loc = JOptionPane.showInputDialog(null, "Please enter the record number:");
				int location = Integer.parseInt(loc);

				store.seek((RECORD_LENGTH + 2) * (location - 1));
				String obj = store.readUTF();
				JOptionPane.showMessageDialog(null, obj);
			}
		}
	}
}