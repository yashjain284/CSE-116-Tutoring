package Lab502;

public class quickSort extends Thread{


    private static double[] nums;
    private int left, right;

    public quickSort(int size){
        initialize(size);
    }

    private quickSort(int left, int right){
        this.left = left;
        this.right = right;
        start();
    }

    public static void initialize(int size){

        nums = new double[size];
        for (int i = 0; i < size; i++){
            nums[i] = Math.random( );
        }

        quickSort qst = new quickSort(0, size - 1);

//      for (int i = 0; i < nums.length; i++){
//    	  System.out.println(nums[i]);
//      		}

        try{
            qst.join();
        }catch(InterruptedException e){
            System.err.println( "QuickSort Exception " + e );}

//test if list is sorted and prints
        for(int i=1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                System.out.println("List not sorted.");
                break;
            }
            else{
                System.out.println(nums[0]);
                System.out.println(nums[1]);
                System.out.println(nums[2]);
                System.out.println(nums[3]);
                System.out.println(nums[4]);
                System.out.println(nums[5]);
                System.out.println(nums[6]);

                System.out.println("List sorted.");
                break;
            }

        }
    }


    public void run(){
        quickSort leftSorted = null;
        quickSort rightSorted = null;
        int ndx = partition(left, right);

        if (right > (ndx + 1))
            rightSorted = new quickSort(ndx + 1, right);

        if ((ndx - 1) > left)
            leftSorted = new quickSort( left, ndx - 1 );

        try{
            if ( rightSorted != null )
                rightSorted.join();

            if ( leftSorted != null )
                leftSorted.join();}

        catch( InterruptedException e ){
            System.err.println( "QuickSort Exception " + e );
        }}

    private static int partition( int lefty, int righty ){
        double pivot = nums[lefty];
        int l = lefty, r = righty;
        boolean done = false;

        while(!done){
            if (nums[l + 1] > pivot){

                while((r > l + 1) && (nums[r] > pivot)){
                    r--;
                }

                if(r > l + 1){
                    l++;
                    swap(l, r);
                    done = (l >= r - 1);
                }else
                    done = true;
            }
            else{
                l++;
                done = ( l >= r );
            }
        }

        swap(lefty, l);
        return l;
    }

    private static void swap(int lefty, int righty){
        double temp = nums[lefty];

        nums[lefty] = nums[righty];
        nums[righty] = temp;
    }
}

