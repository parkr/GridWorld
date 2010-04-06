import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: 
 * Description: 
 */

public class QuickFaceBug extends FaceBug {

	public QuickFaceBug(){
		super("face.jpg");
	}
	
	public QuickFaceBug(String filename){
		super(filename);
	}
	
	/**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = face.getNext(loc, getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        if(loc.getRow() < face.getHeight() && loc.getCol() < face.getWidth() && !face.getValue(loc.getRow()-super.getRowOffset(), loc.getCol()-super.getColOffset())){
	        Flower flower = new Flower(getColor());
	        flower.putSelfInGrid(gr, loc);
        }
    }
}
