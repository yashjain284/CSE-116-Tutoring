package Lab3;

import java.io.File;

import javax.swing.JOptionPane;

public class lab03 {
	
	//String filePath= "/Users/yashjain284/Documents/workspace/CSE 116 Tutoring/src/Lab3/";
	
	public static MTQueue updateQueue = new MTQueue();//Object created of MTQueue. Constructor initializes the Queue.
	public static void main(String[] args) throws InterruptedException{
		
		// Open or create new file
		// *********************************************************************************************
		try {
			String filepath = JOptionPane.showInputDialog(null, "Please enter file location");
			String filename = JOptionPane.showInputDialog(null, "Please enter file name (with extension)");
			String fileParameters = filepath+filename;
		
			File myFile = new File(fileParameters);
			if (myFile.exists())
				JOptionPane.showMessageDialog(null, "File Already Exists");
			else
				JOptionPane.showMessageDialog(null, "File Does not Exists. Creating a new file");
			
			InputThread ip = new InputThread(updateQueue);
			ip.start();
			UpdateThread up = new UpdateThread(updateQueue,fileParameters);
			up.start();
		}
		catch(Exception e){
			
		}

		// *********************************************************************************************
		
		
		
		
		
		
		
		
		
		
//		
//		updateQueue.MTPut("Hello");
//		updateQueue.MTPut("This ");
//		updateQueue.MTPut("is");
//		updateQueue.MTPut("Yash");
		
		
//		System.out.println(updateQueue.MTGet() + "   ->  "+updateQueue.MTGet() + "   ->  "+updateQueue.MTGet() + "   ->  "+updateQueue.MTGet());
//		System.out.println(updateQueue.MTGet());
		
	}

}
