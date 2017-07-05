package Lab501;
import javax.swing.JOptionPane;


public class MergeSort {
	public double[] array;
    public double[] tempArray;
    public double[] input;
    public int length;
    public static boolean value;
    
    public void sort(double input[]) {
        this.array = input;
        this.length = input.length;
        this.tempArray = new double[length];
        mergeSort(0, length - 1);
    }
 
    public void mergeSort(int low, int high) {
         
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(low, mid);
            mergeSort(mid+1, high);
            mergeParts(low, mid, high);
        }
    }
 
    public void mergeParts(int low, int mid, int high) {
 
        for (int i = low; i <= high; i++) {
            tempArray[i] = array[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
 
    }
    
    public static void test(){
      double[] input = new double[10];
      for (int i=0; i<10; i++){
      	input[i] = Math.random()*(50.0)+0.0;
      }
      
      System.out.println("\nArray is : \n");
      for(double i:input){
      	System.out.print(i + "\n");
      }
      //Sorting the array
      MergeSort finalSort = new MergeSort();
      finalSort.sort(input);
      
	  //Displaying the sorted array
      System.out.println("\nSorted Array is : \n");
      for(double i:input){
          System.out.print(i + "\n");
      }
      value = true;
      for(int i=1; i<=input.length-1; i++){
			if(input[i-1]>input[i]){
				value = false;	
				JOptionPane.showMessageDialog(null, "Values are not in order", "Mistake", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
      if(value){
			JOptionPane.showMessageDialog(null, "Values are in order!");
		}
    	
    }
    
    public static void main(String args[]){
    	
    	//Call this test function to test for 10 random values. Using this you can see for yourself that merge sort is working correctly.
        //test();
       
        double[] input = new double[10000];
        
        for (int i=0; i<10000; i++){
        	input[i] = Math.random();
        	
        }
//        //Displaying the original array
//        System.out.println("\nArray is : \n");
//        for(double i:input){
//        	System.out.print(i + "\n");
//        }
        
        //Sorting the array
        MergeSort finalSort = new MergeSort();
        finalSort.sort(input);
        
  	  //Displaying the sorted array
        System.out.println("\nSorted Array is : \n");
        for(double i:input){
            System.out.print(i + "\n");
        }
        value = true;
        for(int i=1; i<=input.length-1; i++){
  			if(input[i-1]>input[i]){
  				value = false;	
  				JOptionPane.showMessageDialog(null, "Values are not in order", "Mistake", JOptionPane.ERROR_MESSAGE);
  				break;
  			}
  		}
        if(value){
  			JOptionPane.showMessageDialog(null, "Values are in order!");
  		}
        
        
        
		
	}
    }
