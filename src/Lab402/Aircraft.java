package Lab402;

public class Aircraft {
	
	private int id;
	private int altitude;
	private int speed;
	private String name;
	public Aircraft next;
	public Aircraft previous;
	
	Aircraft(int i,int a, int s, String n){
		id = i;
		altitude = a;
		speed = s;
		name = n;
		next = null;
		previous = null;
	}
	
	public String getAll(){
		String str = "FLIGHT ID : "+id+"\n"
				    +"ALTITUDE : "+altitude+"\n"
				    +"SPEED : "+speed+"\n"
				    +"NAME : "+name;
		return str;
	}
	public String getName(){
		return name;
	}
	public int getId(){
		return id;
	}
	public int getAltitude(){
		return altitude;
	}
	public int getSpeed(){
		return altitude;
	}
	public void setName(String n){
		name = n;
	}
	public void setId(int i){
		id = i;
	}
	public void setAltitude(int a){
		altitude = a;
	}
	public void setSpeed(int s){
		speed = s;
	}
	

}
