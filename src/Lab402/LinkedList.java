package Lab402;
public class LinkedList {
	
	private int length;
	Aircraft head;
	Aircraft tail;
	
	LinkedList(){
		length = 0;
		head = null;
		tail = null;
	}
	
	public int getCount(){
		return length;
	}
	
	//Function to add a flight to list.
	public void add(int id,int alt, int sp, String name){
		//Write the code to add a element in the linked list.
		if(head==null&&tail==null){
			//Our linked list is empty.
			Aircraft newAircraft = new Aircraft(id,alt,sp,name);
			head = newAircraft;
			tail = newAircraft;
		}
		else{
			//When the list in non empty.
			Aircraft newAircraft = new Aircraft(id,alt,sp,name);
			newAircraft.previous = tail;
			tail.next = newAircraft;
			tail = newAircraft;
		}
		length++;
	}
	
	//Function to show the details of the flight given the flight number/flight ID
	public String showNumber(int location){
		
		//Write the code to show 
		String result="";
		Aircraft current=head;
		for(int i=0;i<location;i++){
			current = current.next;
		}
		result = current.getAll();
		return result;
	}
	
	//Function to search the flight list for a given flight name
	public int showName(String name){
		int location = -1;
		Aircraft current=head;
		for(int i=0;i<length;i++){
			if(current.getName().equals(name)){
				location = i;
				return location;
			}
			current = current.next;
		}
		return location;
	}
	
	//Function to delete a flight from the flight list.
	public boolean delete(String name){
		
		//If list is empty
		if(head==null&&tail==null&&length==0){
			//Nothing to delete
			return true;
		}
		//If the list has just one element and that has to be deleted.
		else if(head==tail && head.getName().equals(name)){
			head = null;
			tail = null;
			length--;
			return true;
		}
		//If we have to remove the head
		else if(head.getName().equals(name)){
			Aircraft newHead = head.next;
			newHead.previous = null;
			head = newHead;
			length--;
			return true;
		}
		//If we have to remove the tail
		else if(tail.getName().equals(name)){
			Aircraft newTail = tail.previous;
			newTail.next = null;
			tail = newTail;
			length--;
			return true;
		}
		//Normal remove
		else{
			Aircraft current = head;
			Aircraft nodetodelete=null;
			while(current!=null){
				if(current.getName().equals(name)){
					nodetodelete = current;
					break;
				}
				current = current.next;
			}
			if(nodetodelete==null){
				return false;
			}
			Aircraft nextNode = nodetodelete.next;
			Aircraft previousNode = nodetodelete.previous;
			previousNode.next = nextNode;
			nextNode.previous = previousNode;
			nodetodelete.next = null;
			nodetodelete.previous = null;
			length--;
			return true;
		}
	}
	
	//Function to delete all the flights from the list.
	public void deleteAll(){
		head = null;
		tail = null;
	}
	//Function to sort the Aircraft List
	public void sortList(){
		if(length<=1){
			return;
		}
		
		for(int i=0;i<length;i++){
			
			Aircraft fastNode = head.next;
			Aircraft slowNode = head;
			for(int j=1;j<(length-i);j++){
				
				if(slowNode.getAltitude() > fastNode.getAltitude()){
					
					int tempAlt = slowNode.getAltitude();
					int tempId = slowNode.getId();
					int tempSp = slowNode.getSpeed();
					String tempName = slowNode.getName();
					
					slowNode.setAltitude(fastNode.getAltitude());
					slowNode.setId(fastNode.getId());
					slowNode.setSpeed(fastNode.getSpeed());
					slowNode.setName(fastNode.getName());
					
					fastNode.setAltitude(tempAlt);
					fastNode.setId(tempId);
					fastNode.setSpeed(tempSp);
					fastNode.setName(tempName);
				}
				fastNode = fastNode.next;
				slowNode = slowNode.next;
			}
		}
	}
	
	//Function to display existing flight list
	public String displayList(){
		String result = "";
		Aircraft current = head;
		for(int i=0;i<length;i++){
			
			result = result +current.getName()+" ALT : "+current.getAltitude() + "\n";
			
			current = current.next;
		}
		return result;
		
		
	}
}
