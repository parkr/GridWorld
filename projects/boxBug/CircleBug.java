/** Name: Parker Moore
 *  Class: AP CS
 *	Teacher: Mr. Klus
 *	Program: GridWorld
 *  Description: This bug draws a circle with the flowers it drops.
 */

/**
 * @author pmoore78
 *
 */
public class CircleBug extends BoxBug {

	public CircleBug(int length) {
		super(length);
	}
	
	/**
     * Moves to the next location of the circle.
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
            steps = 0;
        }
    }

}
