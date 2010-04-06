import info.gridworld.grid.Location;

/** Name: Parker Moore
 *  Class: AP CS
 *	Teacher: Mr. Klus
 *	Program: GridWorld
 *  Description: This bug creates a "Z" and retraces it with a length specified or the default, 5.
 */

/**
 * @author pmoore78
 *
 */
public class ZBug extends BoxBug{
	
	private int legs = 0;
	
	public ZBug(){
		super(5);
		setDirection(getDirection() + Location.RIGHT);
	}
	
	public ZBug(int length){
		super(length);
		setDirection(getDirection() + Location.RIGHT);
	}
	
	/**
     * Moves to the next location of the Z.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
        	switch(legs){
        	case 0: turn();
		            turn();
		            turn();
		            steps = 0;
		            legs++;
		            break;
        	case 1: turn();
		        	turn();
		        	turn();
		        	turn();
		        	turn();
		        	steps = 0;
		        	legs++;
		        	break;
        	case 2: turn();
		        	turn();
		        	turn();
		        	turn();
		        	steps = 0;
		        	legs = 0;
		        	break;
        	}
        }
    }
}
