import info.gridworld.actor.Bug;
import helpers.ArrayActions;
/** Name: Parker Moore
 *  Class: AP CS
 *	Teacher: Mr. Klus
 *	Program: GridWorld
 *  Description: This dancing bug has several constructors, allowing input for a specified array or a randomly generated array. It also has the generic act method.
 */

/**
 * @author pmoore78
 *
 */
public class DancingBug extends Bug{

	private int hasTurned = 0;
	private int[] turns;
	
	public DancingBug(int[] turns){
		this.turns = turns;
	}
	
	public DancingBug(int numturns){
		turns = ArrayActions.randomArray(numturns);
	}
	
	/**
     * Moves to the next location of the dance, according to the <code>turns</code> array.
     */
    public void act()
    {
        if(hasTurned < turns.length && canMove())
        {
        	for(int i=0; i<turns[hasTurned]; i++)
        		turn();
            move();
            hasTurned++;
        }else{
        	hasTurned = 0;
        }
    }
	
}
