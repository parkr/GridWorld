import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: GridWorld
 * Description: This <code>RockHound</code> acts the same way as a Critter, but it "eats" every actor, except for other Critters.
 */

public class RockHound extends Critter {

	/**
	 * 
	 */
	public RockHound() {
		super();
	}
	
	public RockHound(Color c){
		setColor(c);
	}

	/* (non-Javadoc)
	 * @see info.gridworld.actor.Critter#processActors(java.util.ArrayList)
	 */
	@Override
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors)
        {
            if (!(a instanceof Critter))
                a.removeSelfFromGrid();
        }
	}

}
