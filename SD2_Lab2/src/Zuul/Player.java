package Zuul;

public class Player {
	private Room currentRoom;
	private String name;
	
	public Player(Room currentRoom, String name) {
		this.name = name;
		this.currentRoom = currentRoom; 
		
	}
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Room getRoom() {
		return this.currentRoom;
	}
	public void setRoom(Room room) {
		this.currentRoom = room;
	}

}
