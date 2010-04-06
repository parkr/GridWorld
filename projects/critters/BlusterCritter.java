/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: GridWorld
 * Description: This <code>BlusterCritter</code> looks at all of the neighbors within two steps of its current location, counts them and, if there are fewer critters than its courage (int variable), the color gets brighter. Otherwise, the BlusterCritter darkens.
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class BlusterCritter extends Critter {

	/**
	 * This integer is the arbitrary value of courage that this <code>BlusterCritter</code> has. It represents the amount of critters that this BlusterCritter can "stand up to."
	 */
	private int courage;
	/**
	 * This <code>DARKENING_FACTOR</code> is, by default, set to one half. It is used to darken the color of the chameleon.
	 */
	private static final double DARKENING_FACTOR = 0.5;
	
	/**
	 * 
	 */
	public BlusterCritter(int c) {
		courage = c;
		setColor(Color.BLUE);
	}
	
	/**
	 * 
	 */
	public BlusterCritter(Color c, int courage){
		setColor(c);
		this.courage = courage;
	}

	/* (non-Javadoc)
	 * @see info.gridworld.actor.Critter#getActors()
	 */
	@Override
	public ArrayList<Actor> getActors() {
		HashSet<Actor> temp = new HashSet<Actor>();
		temp.addAll(super.getActors());
		for(int dir=0; dir<360; dir += 45)
			temp.addAll(getGrid().getNeighbors(getLocation().getAdjacentLocation(dir)));
		temp.remove(this);
		return new ArrayList<Actor>(temp);
	}

	/* (non-Javadoc)
	 * @see info.gridworld.actor.Critter#processActors(java.util.ArrayList)
	 */
	@Override
	public void processActors(ArrayList<Actor> actors) {
		// TODO Auto-generated method stub
		super.processActors(actors);
		if(countCritters(actors) < courage)
			brighten();
		else
			darken();
	}

	/**
     * Brightens the color of the <code>BlusterCritter</code> by the specified darkening factor of one half.
     */
    private void brighten(){
    	Color c = getColor();
        int red = (int) ((c.getRed() + 2) * (1 + DARKENING_FACTOR));
        int green = (int) ((c.getGreen() + 2) * (1 + DARKENING_FACTOR));
        int blue = (int) ((c.getBlue() + 2) * (1 + DARKENING_FACTOR));
        if(red > 255)
        	red = 255;
        if(green > 255)
        	green = 255;
        if(blue > 255)
        	blue = 255;
        setColor(new Color(red, green, blue));
    }

	/**
     * Darkens the color of the <code>BlusterCritter</code> by the specified darkening factor of one half.
     */
    private void darken(){
    	Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
    }
    
    /**
     * This method counts Critters in an arraylist.
     * @param actors - an array list of actors
     * @return an integer count of the critters in the inputted arraylist
     */
    private int countCritters(ArrayList<Actor> actors){
    	int count=0;
    	Iterator<Actor> itr = actors.iterator();
    	while(itr.hasNext())
    		if(itr.next() instanceof Critter)
    			count++;
    	return count;
    }

}
