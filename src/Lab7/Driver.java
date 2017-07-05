package Lab7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Driver {
	
	public static void main(String[] args) {
		
		vMem myMemory= new vMem(1000,100);
		for(int i=0;i < 1000; i++)
			myMemory.put(1000-i,i);
		
		
		for(int i=0;i <1000; i++)
		{
			long num = myMemory.get(i);
			//check for descending order.
			if(num != 1000-i)
			{
				System.out.println("Error in values");
				break;
			}
			System.out.println(num);
		}
	}
	
}
