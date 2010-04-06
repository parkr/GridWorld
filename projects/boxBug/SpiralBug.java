/** Name: Parker Moore
 *  Class: AP CS
 *	Teacher: Mr. Klus
 *	Program: GridWorld
 *  Description: This spiral bug creates a spiral with the flowers that it drops with each move.
 */

/**
 * @author pmoore78
 *
 */
public class SpiralBug extends BoxBug{

	public SpiralBug(int length) {
		super(length);
	}

	/**
     * Moves to the next location of the spiral.
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
            turn();
            turn();
            steps = 0;
            sideLength++;
        }
    }

}
