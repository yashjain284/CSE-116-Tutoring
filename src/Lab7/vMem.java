package Lab7;
import java.io.RandomAccessFile;

public class vMem {

	private long[] ram;
	static int currentPage;

	vMem(int size,int ratio){
		
		ram  = new long[100];
		currentPage=0;
		try {
			//Creating a new file.
			RandomAccessFile virtualRam = new RandomAccessFile("/Users/yashjain284/Documents/workspace/CSE 116 Tutoring/src/Lab7/vMem.txt", "rw");
			virtualRam.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long get(int index) {
		
//		System.out.println("Reading at Index :"+index);
		
		if(index<0 && index>999){
			return Long.MIN_VALUE;
		}
		int pageIndex = 100*(index/100);
//		System.out.println("Page Index :"+pageIndex);
//		System.out.println("Current Page : "+currentPage+" Required Page :"+pageIndex);
		//If the index required is within the current page in the RAM.
		if(pageIndex==currentPage){
//			System.out.println("Printing out the whole array");
//			for(int i=0;i<100;i++){
//				System.out.println("Index :"+i + " Value : "+ram[i]);
//			}
//			System.out.println("\n\nWohho no extra costs");
			int mIndex = index%100;
//			System.out.println("Accessing Index : "+mIndex +"Value Accessed : "+ram[mIndex]);
			
			return ram[mIndex];
			
		}
		else{
			//If the page required is not the current page, then we have to fetch it from our swap file.
			try {
				RandomAccessFile virtualRam = new RandomAccessFile("/Users/yashjain284/Documents/workspace/CSE 116 Tutoring/src/Lab7/vMem.txt", "rw");
				//Seeking to the start of the required page.
				virtualRam.seek(8*pageIndex);
				
				//Copying all the 100 elements from that page to the RAM array.
				for(int i=0;i<=99;i++){
					ram[i] = virtualRam.readLong();
				}
				
				currentPage = pageIndex;
				virtualRam.close();
				
				return ram[index%100];
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ram[index%100];
		}
	}
	
	

	public int put(int index,long value) {
		
		if(index<0 && index>999){
			return -1;
		}
		try{
			//Opening random access file.
			ram[index] = value;
		}catch(IndexOutOfBoundsException e){
			//Do nothing.
			//System.out.println("Index Out of bounds at Index : "+index+" Value : "+value);
			int pageIndex = 100*(index/100);
			currentPage = 0;
			
		}
		int fileFlag = writeToFile(value,index);
		
		return fileFlag;
	}
	
	public int writeToFile(long value,int index){
		RandomAccessFile vRam;
		try {
			vRam = new RandomAccessFile("/Users/yashjain284/Documents/workspace/CSE 116 Tutoring/src/Lab7/vMem.txt", "rw");
			vRam.seek(0);
			vRam.seek(8*index);
			vRam.writeLong(value);
			vRam.close();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
