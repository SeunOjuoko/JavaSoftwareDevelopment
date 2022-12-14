package lab8.club;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    private ArrayList<Membership> Hive;
    private ArrayList<Membership> purged;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
    	Hive = new ArrayList<Membership>();
    	purged = new ArrayList<Membership>();
        
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
    	Hive.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return Hive.size();
    }
    
    public int joinedInMonth(int month) {
    	int membersJoined = 0;
    	for(int index = 0; index < Hive.size(); index++ ) {
    	Membership memberName = Hive.get(index);
    	int memberMonth = memberName.getMonth();
    	if (memberMonth == month) {
    		membersJoined++;
    		}
    	}
    	return membersJoined;
   	}
    
    public ArrayList<Membership> purge (int month, int year){
    	Iterator<Membership> it = Hive.iterator();
    	while (it.hasNext()) {
    		Membership disUn = it.next();
    		if(disUn.getMonth()==month) {
    			if(disUn.getYear()==year) {
    				purged.add(disUn);
    			}
    		}
    	}
    	return purged;
    }
    
    public void printPurged(){
    	for(int index = 0; index < purged.size(); index++ ){
  		  Membership guy = purged.get(index);
  		  System.out.println(guy.toString());
  	  }
    }
    public static void main(String[] args) {
  	  Club Atik = new Club();
  	  Membership Steve = new Membership("Seun", 7, 20);
  	  Atik.join(Steve);
  	  Membership Derek = new Membership("Stan Lee", 8, 15);
  	  Atik.join(Derek);
  	  
  	  System.out.println("The amount of members are " + (Atik.numberOfMembers()));
  	  System.out.println("The amount of members that joined in the third month is " + Atik.joinedInMonth(3));
  	  System.out.println("");	  
  	  Atik.purge(2, 15);
  	  
  	  }
}