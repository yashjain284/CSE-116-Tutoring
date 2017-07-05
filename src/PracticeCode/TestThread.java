package PracticeCode;
public class TestThread{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableDemo t1 = new RunnableDemo("First Thread");
		t1.start();
		
		RunnableDemo t2 = new RunnableDemo("Second Thread");
		t2.start();
		
		

	}
}