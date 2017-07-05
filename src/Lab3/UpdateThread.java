package Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class UpdateThread extends Thread {

	final private static int MAX_RECORD_NUMBER = 20;
	final private static int RECORD_LENGTH = 73;
	private int currRecord;
	MTQueue updateQueue;
	String threadName;
	String fileName;

	UpdateThread(MTQueue x, String fileParam) {

		threadName = "Update";
		updateQueue = x;
		currRecord = 0;
		fileName = fileParam;
	}

	public void prettyPrintObject(String record) {
		System.out.println("Player ID    : " + record.substring(0, 5));
		System.out.println("Player Name  : " + record.substring(5, 31));
		System.out.println("Team Name    : " + record.substring(31, 57));
		System.out.println("Player Skill : " + record.substring(57, 62));
		System.out.println("Date         : " + record.substring(62, 71));
	}

	public void run() {

		RandomAccessFile store = null;
		try {
			File myFile = new File(fileName);
			// Reading from Buffer
			boolean readFromBuffer = true;
			while (readFromBuffer) {
				store = new RandomAccessFile(myFile, "rw");
				String record = updateQueue.MTGet();
				if (record != null) {
					currRecord++;
					// find the correct location in the file
					// System.out.println("Writing : "+record);
					store.seek((RECORD_LENGTH + 2) * (currRecord - 1));
					store.writeUTF(record);

					// Reading again from file to verify
					int location = currRecord;
					store.seek((RECORD_LENGTH + 2) * (location - 1));
					String obj = store.readUTF();
					System.out.print("Seeking the same record from file ......\n");
					prettyPrintObject(obj);
				}
				store.close();
			}
		} catch (Exception e) {

		}
	}

}
