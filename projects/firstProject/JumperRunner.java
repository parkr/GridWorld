import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Jumper;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

/** Name: Parker Moore
 *  Class: AP CS
 *	Teacher: Mr. Klus
 *	Program: GridWorld
 *  Description: This class creates a jumper and successfully tests the jumper.
 */

/**
 * @author pmoore78
 *
 */
public class JumperRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
        Jumper bob = new Jumper(Color.ORANGE);
        world.add(new Location(0, 0), bob);
        world.add(new Location(0,2), new Rock());
        world.show();
	}

}
