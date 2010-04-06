import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Glitter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: 
 * Description: 
 */

public class DavidBowieBug extends Bug {

	/* (non-Javadoc)
	 * @see info.gridworld.actor.Bug#move()
	 */
	@Override
	public void move() {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Glitter glitter = new Glitter();
        glitter.putSelfInGrid(gr, loc);
	}

	
	
}
