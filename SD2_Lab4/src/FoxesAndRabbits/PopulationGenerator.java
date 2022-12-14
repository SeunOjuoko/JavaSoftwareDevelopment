package FoxesAndRabbits;

import java.util.List;
import java.util.Random;

public class PopulationGenerator {
	
	private static final double FOX_CREATION_PROBABILITY = 0.02;
	 // The probability that a rabbit will be created in any given grid position.
	  private static final double RABBIT_CREATION_PROBABILITY = 0.08;  
	  private static final double SNAKES_CREATION_PROBABILITY = 0.06;
	    
	  public void populate(Field field, List<Animal> animals)
	    {
	        Random rand = Randomizer.getRandom();
	        field.clear();
	        for(int row = 0; row < field.getDepth(); row++) {
	            for(int col = 0; col < field.getWidth(); col++) {
	                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
	                    Location location = new Location(row, col);
	                    Fox fox = new Fox(true, field, location);
	                    animals.add(fox);
	                }
	                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
	                    Location location = new Location(row, col);
	                    Rabbit rabbit = new Rabbit(true, field, location);
	                    animals.add(rabbit);
	                }
	                else if(rand.nextDouble() <= SNAKES_CREATION_PROBABILITY) {
	                    Location location = new Location(row, col);
	                    Snakes snakes = new Snakes(true, field, location);
	                    animals.add(snakes);
	                }
	                // else leave the location empty.
	            }
	        }
	    }
}

