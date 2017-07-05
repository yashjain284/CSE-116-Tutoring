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


public class lab2Test {
	
	
	
	// Number of records in the file.
	final private static int MAX_RECORD_NUMBER = 20;
	// Size of record.
	final private static int RECORD_LENGTH = 73;

	public static void main(String[] args) throws IOException {
		
		String id = "";
		String name = "";
		String team ="";
		String skill ="";
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
				
				//Getting the value of ID from user 
				//***********************************************************
				boolean Carryon = true;
				while(Carryon){
					
					try{
					
						String inputId = JOptionPane.showInputDialog(null," Enter ID");
						int temp = Integer.parseInt(inputId);
						if(temp>=1 && temp<=20){
							//Now we know that out id is correct.
							Carryon = false;
							id = temp+"";
							//We pad it with extra spaces.
							int len = id.length();
							while(len < 5){
								id=id+" ";
								len++;
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Please enter a valid ID");
						}
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Please enter a valid ID");
					}
						
				}
				//Getting the value of skill level from user 
				//***********************************************************
				boolean CarryonLevel = true;
				
                while(CarryonLevel){
					
					try{
					
						String inputLevel = JOptionPane.showInputDialog(null," Enter Skill Level");
						int temp1 = Integer.parseInt(inputLevel);
						if(temp1>=0 && temp1<=99){
							//Now we know that out id is correct.
							CarryonLevel = false;
							id = temp1+"";
							//We pad it with extra spaces.
							int lenL = id.length();
							while(lenL < 5){
								id=id+" ";
								lenL++;
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Please enter a valid Number");
						}
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Please enter a valid Number");
					}
					
					
				//Getting the player name
				
				//****************************************************
					
					 name = JOptionPane.showInputDialog(null," Enter Name");
					 int lenN = name.length();
					 if(lenN>26){
						 name = name.substring(0, 25);
					 }
					 else{
							while(lenN < 26){
								name=name+" ";
								lenN++;
							}
					 }
					 
				
			}
				
                name = JOptionPane.showInputDialog(null," Enter Name");
				 int lenN = name.length();
				 if(lenN>26){
					 name = name.substring(0, 25);
				 }
				 else{
						while(lenN < 26){
							name=name+" ";
							lenN++;
						}
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
}