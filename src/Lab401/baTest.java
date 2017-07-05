package Lab401;
import java.util.Random;
public class baTest 
{
	public static void main(String [] args)
	{
		System.out.println("\n************************************************************************************");
		Random rand = new Random();
		// make a default BetterArray
		
		BetterArray testArray = new BetterArray();
		System.out.println("Created a Better Array of Size 10...\n");
		System.out.println("Initialization of the array with 10 random elements [Index from 0-9]");
		// Use it as it was designed
		for (int i = 0; i < 10; ++i)
		{
			int  n = rand.nextInt(100) + 1;
			testArray.put(n, i);
		}
		for (int i = 0; i < 10; ++i)
		{
			System.out.print(testArray.get(i) + "  ");
		}
		System.out.println("\n");
		System.out.println("Initialization of the array with 20 random elements (To push the length to 20)");
		// Now go beyond current array bounds
		for (int i = 0; i < 20; ++i)
		{
			int  n = rand.nextInt(100) + 1;
			testArray.put(n, i);
		}
		for (int i = 0; i < 20; ++i)
		{
			System.out.print(testArray.get(i) + "  ");
		}
		System.out.println("\n");
		System.out.println("Inserting 999 before element 14 (To insert a new element at index 14)");
		testArray.insert(999,14);
		for (int i = 0; i < 21; ++i)
		{
			System.out.print(testArray.get(i) + "  ");
		}
		System.out.println("\n");
		System.out.println("Deleting the element 15 (To delete a element at index 15)");
		testArray.delete(15);
		for (int i = 0; i < 20; ++i)
		{
			System.out.print(testArray.get(i) + "  ");
		}
		System.out.println("\n************************************************************************************");
		
		
		
		System.out.println("Created a Better Array of Size 1000...\n");
		BetterArray testArray2 = new BetterArray(1000);
		System.out.println("Initialization of the array with 1000 random elements");
		// Use it as it was designed
		
		for (int i = 0; i < 1000; ++i)
		{
			int  n = rand.nextInt(1000) + 1;
			testArray2.put(n, i);
		}
		for (int i = 0; i < 1000; ++i)
		{
			System.out.print(testArray2.get(i) + "  ");
		}
		
		testArray2.sortList();
		System.out.println("\n");
		System.out.println("Sorting the array with 1000 random elements in the ASCENDING ORDER : ");	
		for (int i = 0; i < 1000; ++i)
		{
			System.out.print(testArray2.get(i) + "  ");
		}
		System.out.println("\n");
		System.out.println("Validating the list for sorted order......");
		if(testArray2.validateList()){
			System.out.println("LIST IS SORTED CORRECTLY");
		}
		else{
			System.out.println("LIST NOT SORTED CORRECTLY");
		}
		System.out.println("\n************************************************************************************");
		
	}
}
