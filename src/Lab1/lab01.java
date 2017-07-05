package Lab1;
import java.util.*;
import javax.swing.JOptionPane;

public class lab01 {
	
	private static int sideA = 0;
	private static int sideB = 0;
	
	public static void main(String args[]) {
		System.out.println("Usage: Supply 2 integer values as triangle sides.");
		System.out.println("   A - integer value");
		System.out.println("   B - integer value");
		System.out.println("   C - attempt a pythagorean calculation");
		System.out.println("   Q - quit the program");
		
		String value;
		String side;
		
		boolean carryOn = true;
		while(carryOn){
			
			try{
			side = JOptionPane.showInputDialog(null, "A or B?");
			char input = side.charAt(0);
			if(!Character.isLetter(input))
				throw new Exception();
			}catch(Exception e){
				System.out.println("Enter a Valid Option");
				continue;
			}
			switch(side) {
			case "Q":
				carryOn = false;
				break;
			
			case "A":
				boolean enterA = true;
				while(enterA){
					value = JOptionPane.showInputDialog(null, "Enter A");
					try{
						sideA = Integer.parseInt(value);
						enterA= false;
					}catch(NumberFormatException exception){
						System.out.println("Please enter a valid integer value");
						continue;
					}
				}
				
				break;
			
			case "B":
				boolean enterB = true;
				while(enterB){
					value = JOptionPane.showInputDialog(null, "Enter B");
					try{
						sideB = Integer.parseInt(value);
						enterB= false;
					}catch(NumberFormatException exception){
						System.out.println("Please enter a valid integer value");
						continue;
					}
				}
				break;
			
			case "C":
				double temporary = (sideA * sideA) + (sideB * sideB);
				double result = java.lang.Math.sqrt(temporary);
				System.out.println("The hypotenuse value is " + result);
				break;
			default:
				System.out.println("Please enter a valid option");
			}
		}
		System.out.println("Thank you. Goodbye!");
		return;
	}
}

