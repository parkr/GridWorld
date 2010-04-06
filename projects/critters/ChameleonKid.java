import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Iterator;

/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: GridWorld
 * Description: This <code>ChameleonKid</code> acts the same way as ChameleonCritter, but only changes its color to those in front or behind it, or, if there aren't other critters in those two locations, the ChameleonKid darkens like a ChameleonCritter.
 */

/**
 * @author parkermoore
 *
 */
public class ChameleonKid extends ChameleonCritter {

	/**
	 * 
	 */
	public ChameleonKid() {
		super();
	}

	/* (non-Javadoc)
	 * @see info.gridworld.actor.Critter#getActors()
	 */
	@Override
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = super.getActors();
		Iterator<Actor> itr = actors.iterator();
		int dir = 12;
		while(itr.hasNext()){
			dir = getLocation().getDirectionToward(itr.next().getLocation());
			if(dir != Location.NORTH || dir != Location.SOUTH)
				itr.remove();
		}
		return actors;
	}

	
	
}
