package Lab402;

import javax.swing.JOptionPane;

public class DriverClass {
	
	public static void main(String[] args){
		
		System.out.println("------------------------------");
		System.out.println("   press e for entering : A new flight is entering the airspace");
		System.out.println("   press l for leaving : A flight is leaving the arispace");
		System.out.println("   press s for show    : Show flight details for a flight name");
		System.out.println("   press d for display : Display all flight details");
		System.out.println("   press q for quit : terminate the program");
		String cmd = "start";

		LinkedList list = new LinkedList();
		
		while (cmd.compareToIgnoreCase("q") != 0) {
			
			//Ask for input
			cmd = JOptionPane.showInputDialog(null, "Please input a command:");
			
			//Check for command "new" : User wants to make a new record
			if (cmd.compareToIgnoreCase("e") == 0) {
				int id=0,alt=0,sp=0;
				String name="";
				boolean carryOnid = true;
				while(carryOnid){
					try{
						id = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter flight ID :"));
						carryOnid = false;
					}catch(Exception e){
						continue;
					}
				}
				
				boolean carryOnalt = true;
				while(carryOnalt){
					try{
						alt = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter flight altitude :"));
						carryOnalt = false;
					}catch(Exception e){
						continue;
					}
				}
				
				boolean carryOnsp = true;
				while(carryOnsp){
					try{
						sp = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter flight speed :"));
						carryOnsp = false;
					}catch(Exception e){
						continue;
					}
				}
				boolean carryOnname = true;
				while(carryOnname){
					try{
						name = JOptionPane.showInputDialog(null, "Please enter the flight name:");
						if(name.equals("")){
							continue;
						}
						else
							carryOnname = false;
					}catch(Exception e){
						continue;
					}
				}
				
				
				list.add(id, alt, sp, name);
			}

			if (cmd.compareToIgnoreCase("l") == 0) {
				System.out.println("");
				String name = JOptionPane.showInputDialog(null, "Please enter the flight name:");
				boolean x = list.delete(name);
				if(x==false){
					JOptionPane.showMessageDialog(null, "Flight Not found");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "FLIGHT DELETED");
				}
			}
			if (cmd.compareToIgnoreCase("s") == 0) {
				
				
				String name = JOptionPane.showInputDialog(null, "Please enter the flight name:");
				int location = list.showName(name);
				if(location==-1){
					JOptionPane.showMessageDialog(null, "Flight Not found");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "FLIGHT FOUND \n "+list.showNumber(location));
				}
			}
			if (cmd.compareToIgnoreCase("d") == 0) {
				
				String flightList = list.displayList();
				if(flightList.equals("")){
					flightList=" Empty ";
				}
				JOptionPane.showMessageDialog(null, "Flight List is : \n"+flightList);
				list.sortList();
				flightList = list.displayList();
				if(flightList.equals("")){
					flightList=" Empty ";
				}
				JOptionPane.showMessageDialog(null, "List after sorting by increasing order of altitude : \n"+flightList);
			}	
			if (cmd.compareToIgnoreCase("q") == 0) {
				
				list.deleteAll();
				JOptionPane.showMessageDialog(null, "Quitting and Deleting the list....");
				
			}	
		}
		
	}
}
