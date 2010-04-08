import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: 
 * Description: 
 */

/**
 * @author parkermoore
 *
 */
public class DavidBowieBugRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
        Bug bob = new DavidBowieBug();
        bob.setDirection(Location.EAST);
        world.add(new Location(0, 0), bob);
        world.add(new Location(2, 1), new Rock());
        world.show();
	}

}
