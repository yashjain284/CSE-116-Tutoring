package Lab3;

import javax.swing.JOptionPane;

public class InputThread extends Thread {

	private String threadName;
	MTQueue updateQueue;

	InputThread(MTQueue x) {
		threadName = "Input";
		updateQueue = x;
	}
	
	public String prettyPrintObject(String record){
		String prettyString = "Writing record on the Queue\n"
							+"Player ID    : " + record.substring(0,5)+"\n"
							+"Player Name  : " + record.substring(5,31)+"\n"
							+"Team Name    : " + record.substring(31,57)+"\n"
							+"Player Skill : " + record.substring(57,62)+"\n"
							+"Date         : " + record.substring(62,71);
		return prettyString;
		
	}

	public void run() {
		
	
		String id = "";
		String playerName = "";
		String teamName = "";
		String skillLevel = "";
		String date = "";
		int currRecordCount = 0;
		String cmd = "start";

		System.out.println("------------------------------");
		System.out.println("   new : make a new record");
		System.out.println("   end : terminate the program");

		// While the user does not enter "end" command
		while (cmd.compareToIgnoreCase("end") != 0) {
			// Ask for input
			cmd = JOptionPane.showInputDialog(null, "Please input a command:");
			// Check for command "new" : User wants to make a new record
			if (cmd.compareToIgnoreCase("new") == 0) {
				currRecordCount++;

				boolean carryOn = true;
				while (carryOn) {
					String ip = JOptionPane.showInputDialog(null, "Please input the Player ID [0 - 20]");
					int inputId;
					try {
						inputId = Integer.parseInt(ip);
						if (inputId <= 20 && inputId >= 0) {
							carryOn = false;
							id = inputId + "";
							int ctr = id.length();
							while (ctr < 5) {
								id = id + " ";
								ctr++;
							}
						}
					} catch (NumberFormatException e) {
						
					}
				}

				String playerNameInput = JOptionPane.showInputDialog(null, "Please enter the player name ");
				if (playerNameInput.length() > 26) {
					playerNameInput = playerNameInput.substring(0, 25);
				} else {
					int ctr = playerNameInput.length();
					while (ctr < 26) {
						playerNameInput = playerNameInput + " ";
						ctr++;
					}
				}
				playerName = playerNameInput;

				String teamNameInput = JOptionPane.showInputDialog(null, "Please enter the team name ");
				if (teamNameInput.length() > 26) {
					teamNameInput = teamNameInput.substring(0, 25);
				} else {
					int ctr = teamNameInput.length();
					while (ctr < 26) {
						teamNameInput = teamNameInput + " ";
						ctr++;
					}
				}
				teamName = teamNameInput;

				carryOn = true;
				while (carryOn) {
					String skillInput = JOptionPane.showInputDialog(null,
							"Please input the Player Skill Level [0 - 99]");
					int skill;
					try {
						skill = Integer.parseInt(skillInput);
						if (skill <= 99 && skill > 0) {
							carryOn = false;
							skillLevel = skill + "";
							int ctr = skillLevel.length();
							while (ctr < 5) {
								skillLevel = skillLevel + " ";
								ctr++;
							}
						}
					} catch (NumberFormatException e) {
						
					}
				}

				// Ask for Today's Date
				date = JOptionPane.showInputDialog(null, "Please Enter Today's Date - Eg: 25Jun2014");
				if (date.length() > 9) {
					date = date.substring(0, 9);
				} else {
					int ctr = date.length();
					while (ctr < 9) {
						date = date + " ";
						ctr++;
					}
				}

				String record = id + playerName + teamName + skillLevel + date;
				JOptionPane.showMessageDialog(null, prettyPrintObject(record));
				updateQueue.MTPut(record);
			}
		}

	}

}
