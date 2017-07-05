package Lab401;

public class Node {
	
	private int data;
	//meta data 
	public Node next;
	public Node previous;
	
	Node(){
		data = 0;
		next = null;
		previous = null;
	}
	
	Node(int value){
		data = value;
		next = null;
		previous = null;
	}
	
	public int get(){
		return data;
		
	}
	public void set(int value){
		data = value;
	}
}
