package Lab7;

import java.util.Random;

public class vMemTest 
{
	private final static int ARRAYSIZE = 1000;
	private final static int VIRTRATIO = 100;
	
	public static void main(String [] args)
	{
		// make an array of ARRAYSIZE elements
		vMem array = new vMem(ARRAYSIZE, ARRAYSIZE/VIRTRATIO);
		
		Random random = new Random();

		int index;
		long value;
		long gotten = 0;
		long startTime;
		long endTime;
		System.out.println("*************STARTING PART 1***************");
		startTime = System.nanoTime();
		for (int j = 0; j < ARRAYSIZE; ++j)
		{
			for (int i = 0; i < ARRAYSIZE; ++i)
			{
				
				index = random.nextInt(ARRAYSIZE);
				value = random.nextLong();
				
				try
				{
					array.put(index, value);
					gotten = array.get(index);
				}
				catch(IndexOutOfBoundsException e)
				{
					long upper = ARRAYSIZE - 1;
					System.out.println("The value " + index + " is outside 0.." + upper);
				}
				
				// check for error
				if ( gotten != value )
				{
					System.out.println("error at " + i + " index : "+index);
					return;
				}
			}
			if (j == 0)
			{
				System.out.print("Working .");
			}
			else
			{
				if ((j % 50) == 0)
				{
					System.out.print(" .");
				}
			}
		}
		endTime = System.nanoTime();
		long millisec = (endTime - startTime)/1000000;
		long minutes = (millisec / 1000)  / 60;
		long seconds = (millisec / 1000) % 60;
		System.out.println("\nElapsed time - part 1 : "+minutes+"minutes "+seconds+"seconds");
		System.out.println("*************PART 1 ENDS***************");
		System.out.println("\n\n\n");
		System.out.println("*************STARTING PART 2***************");

		int j;
		startTime = System.nanoTime();
		for (int i = 0; i < ARRAYSIZE; ++i)
		{
			array.put(i, i);
			gotten = array.get(i);
			if (i != gotten)
			{
				System.out.println("error01");
			}

			j = (ARRAYSIZE - 1) - i;
			array.put(j, j);
			gotten = array.get(j);
			if (j != gotten)
			{
				System.out.println("error02");
			}
		}
		endTime = System.nanoTime();
		millisec = (endTime - startTime)/1000000;
		minutes = (millisec / 1000)  / 60;
		seconds = (millisec / 1000) % 60;
		System.out.println("\nElapsed time - part 1 : "+minutes+"minutes "+seconds+"seconds");
		System.out.println("*************PART 2 ENDS***************");
		
		System.out.println("\n\n\n");
		System.out.println("*************STARTING PART 2***************");
		
		int indexValue01 = random.nextInt(ARRAYSIZE);
		int prevIndex = indexValue01;
		long storeValue01 = random.nextLong();
		array.put(indexValue01, storeValue01);
		System.out.println("Index = "+indexValue01 + " Value = "+storeValue01);

		int indexValue02;
		//Loop to make sure the indexValue02 is not equal to indexValue01
		while (prevIndex == (indexValue02 = random.nextInt(ARRAYSIZE)));
		prevIndex = indexValue02;
		long storeValue02 = random.nextLong();
		System.out.println("Index = "+indexValue02 + " Value = "+storeValue02);
		array.put(indexValue02, storeValue02);
		
		startTime = System.nanoTime();
		for (int i = 0; i < (ARRAYSIZE*ARRAYSIZE); ++i)
		{
			if(i%1000==0){
				System.out.println(i);
			}
			
			gotten = array.get(indexValue01);
			
			if (gotten != storeValue01)
			{
				System.out.println("Value Stored : "+storeValue01 + " Value Retrived : "+gotten);
				System.out.println("error03");
				return;
			}
			gotten = array.get(indexValue02);
			if (gotten != storeValue02)
			{
				System.out.println("error04");
			}
			while (prevIndex == (indexValue01 = random.nextInt(ARRAYSIZE)));
			prevIndex = indexValue01;
			storeValue01 = random.nextLong();
			array.put(indexValue01, storeValue01);

			while (prevIndex == (indexValue02 = random.nextInt(ARRAYSIZE)));
			prevIndex = indexValue02;
			storeValue02 = random.nextLong();
			array.put(indexValue02, storeValue02);
		}
		endTime = System.nanoTime();
		millisec = (endTime - startTime)/1000000;
		minutes = (millisec / 1000)  / 60;
		seconds = (millisec / 1000) % 60;
		System.out.println("\nElapsed time - part 1 : "+minutes+"minutes "+seconds+"seconds");
		
		System.out.println("Test complete");
	}
}
