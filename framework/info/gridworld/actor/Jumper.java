/** Name: Parker Moore
 *  Class: AP CS
 *	Teacher: Mr. Klus
 *	Program: Grid World
 *  Description: This creature jumps 2 spaces and can eat anything except for rocks. 
 */
package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * @author pmoore78
 *
 */
public class Jumper extends Actor {

	public Jumper(){
		setColor(Color.YELLOW);
	}
	
	public Jumper(Color color){
		setColor(color);
	}
	
	/**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }

    /**
     * Turns the jumper 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the jumper forward 2 spaces
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location adj = loc.getAdjacentLocation(getDirection());
        Location next = adj.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    /**
     * Tests whether this jumper can move forward into a location that is empty or
     * contains anything but a rock.
     * @return true if this jumper can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location adj = loc.getAdjacentLocation(getDirection());
        Location next = adj.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || !(neighbor instanceof Rock);
        // OK to move into empty location or onto anything except for a rock
    }
}
