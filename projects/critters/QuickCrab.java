import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: GridWorld
 * Description: This <code>QuickCrab</code> functions the same way as a CrabCritter, except it moves two spaces instead of one. It must, therefore, consider the validity of the possible locations to which it can move, which is accomplished in the below method.
 */

public class QuickCrab extends CrabCritter {

	/**
	 * Default color is Magenta.
	 */
	public QuickCrab() {
		setColor(Color.MAGENTA);
	}
	
	/**
	 * Allows the user to set a color.
	 */
	public QuickCrab(Color c){
		setColor(c);
	}

	/* (non-Javadoc)
	 * @see CrabCritter#getLocationsInDirections(int[])
	 */
	@Override
	/**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions, extended two places.
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            Location moveToLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc) && gr.isValid(moveToLoc) && gr.get(neighborLoc) == null && gr.get(moveToLoc) == null)
                locs.add(moveToLoc);
        }
        if(locs.size() == 0)
        	return super.getLocationsInDirections(directions);
        else
        	return locs;
    }
	
	

}
