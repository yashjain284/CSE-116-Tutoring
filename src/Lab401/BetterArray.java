package Lab401;

public class BetterArray {
	
	public Node head;
	public Node tail;
	public int length;
	public int recentNodeIndex;
	public Node recentNode;
	
	
	//Constructors for default values
	BetterArray(){
		length = 0;
		head = null;
		tail = null;
		recentNodeIndex = 0;
		recentNode = null;
	}
	
	//Constructor to create a LinkedList of given length
	BetterArray(int noOfElements){
		
		length = 0;
		head = new Node(); //Create a new node and make it the "Head Node"
		//head.set(1);
		length++;
		
		//System.out.println(head.get());//Testing line
		
		tail = head;
		Node current=null;
		for(int i=2;i<=noOfElements;i++){
			
			current = new Node();
//			current.set(i);//Testing Lines
//			System.out.println(current.get());//testing Line
			current.previous = tail;
			tail.next = current;
			tail= current;
			length++;
		}
	}
	
	public boolean isEmpty(){
		if(head==null)
			return true;
		else 
			return false;
	}
	
	public int get(int index){
		
		Node current = head;
		for(int i=0;i<index;i++){
			current = current.next;
		}
		int value = current.get();
		return value;
	}
	public void put(int value, int index){
//		if(head==null&&tail==null){
//			Node newNode = new Node(value);
//			head = newNode;
//			tail = newNode;
//		}
//		
		if(index<=length-1){
			//Normal case scenario where the required index is within the size of the list.
			Node current = head;
			for(int i=0;i<index;i++){
				current = current.next;
			}
			current.set(value);	
		}
		else{
			Node current=null;
			for(int i=length;i<=index;i++){
				
				current = new Node();
				if(head==null&&tail==null){
					head = current;
					tail = current;
				}
				current.previous = tail;
				tail.next = current;
				tail= current;
				length++;
			}
			current.set(value);
			
		}
		
		
		
	}
	public void insert(int value, int index){
		
		if(index==0){
			//We want to insert at the head node.
			Node newNode = new Node(value);
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			length++;
		}
		else if(index>0 && index<=(length-1)){
			Node current = head;
			Node nextNode = null, previousNode = null;
			for(int i=0;i<index-1;i++){
				current = current.next;
			}
			previousNode = current;
			nextNode = current.next;
			Node newNode = new Node(value);
			previousNode.next = newNode;
			newNode.previous = previousNode;
			newNode.next = nextNode;
			nextNode.previous = newNode;
			length++;
		}
		else{
			
			Node current=null;
			for(int i=length;i<=index;i++){
				current = new Node();
//				current.set(i);//Testing Lines
//				System.out.println(current.get());//testing Line
				current.previous = tail;
				tail.next = current;
				tail= current;
				length++;
			}
			current.set(value);
		}
	}
	public void delete(int index){
		//Check if index to be deleted is the head node.
		if(index == 0){
			Node current = head.next;
			head.next = null;
			current.previous = null;
			head = current;
			length--;
		}
		//Check if index to be deleted is the tail node.
		else if(index == length -1){
			Node current = tail.previous;
			tail.previous = null;
			current.next = null;
			tail = current;
			length--;
		}
		//Normal Delete
		else if(index > 0 && index <=(length-1)){
			
			Node current = head;
			for(int i=0;i<index;i++){
				current = current.next;
			}
			Node previousNode = current.previous;
			current.previous = null;
			Node nextNode = current.next;
			current.next = null;
			previousNode.next = nextNode;
			nextNode.previous = previousNode;
			length--;
			
		}
		else{
			//Invalid index passed
			System.out.println("Index Out of Bounds");
			
		}
		
	}
	public void sortList(){
		if(length<=1){
			return;
		}
		
		for(int i=0;i<length;i++){
			
			Node fastNode = head.next;
			Node slowNode = head;
			for(int j=1;j<(length-i);j++){
				
				if(slowNode.get() > fastNode.get()){
					int temp = slowNode.get();
					slowNode.set(fastNode.get());
					fastNode.set(temp);
				}
				fastNode = fastNode.next;
				slowNode = slowNode.next;
			}
		}
	}
	
	public boolean validateList(){
		
		Node current=head;
		Node fastNode = head.next;
		for(int i=0;i<length-1;i++){
			if(current.get()>fastNode.get()){
				return false;
			}
			current = current.next;
			fastNode = fastNode.next;
		}
		return true;
	}
	public void printList(){
		Node current = head;
		for(int i=0;i<length;i++){
			System.out.println(current.get());
			current = current.next;
		}
	}
}
