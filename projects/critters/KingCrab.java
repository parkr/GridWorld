import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: GridWorld
 * Description: This KingCrab acts the same way as the CrabCritter, except it moves actors away in its "eating" proximity instead of eating them, unless the to-be-eaten actor cannot move away.
 */

public class KingCrab extends CrabCritter {

	/**
	 * The default color is red. 
	 */
	public KingCrab() {
		setColor(Color.RED);
	}

	/* (non-Javadoc)
	 * @see info.gridworld.actor.Critter#processActors(java.util.ArrayList)
	 */
	@Override
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors)
        {
			Location aLoc = a.getLocation();
			Location aMoveTo = aLoc.getAdjacentLocation(getLocation().getDirectionToward(aLoc));
			if(getGrid().isValid(aMoveTo))
				a.moveTo(aMoveTo);
			else
				a.removeSelfFromGrid();
        }
	}
	
	

}
