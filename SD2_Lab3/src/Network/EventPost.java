package Network;

public class EventPost extends Post {
	private String eventType;
	public EventPost(String author, String eventType) {
		super(author);
		this.eventType = eventType;
		
		// TODO Auto-generated constructor stub
	}	/**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
	public void display()
    {
    	super.display();
        System.out.println(eventType);
    }
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}