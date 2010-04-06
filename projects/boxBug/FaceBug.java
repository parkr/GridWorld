import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.SeasonalFlower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/** Name: Parker Moore
 *  Class: AP CS
 *	Teacher: Mr. Klus
 *	Program: Gridworld
 *  Description: This <code>FaceBug</code> draws a face with Flowers on an unbounded grid.
 */

public class FaceBug extends Bug {
	
	private String filename;
	protected Face face;
	private int steps = 0;
	private int rowsTraveled = 0;
	private int rowOffset = 0, colOffset = 0;
	
	public FaceBug(){
		setDirection(Location.EAST);
		this.filename = "face.jpg";
		init();
	}
	
	public FaceBug(String filename){
		setDirection(Location.EAST);
		this.filename = filename;
		init();
	}
	
	/**
	 * This method is used in the setup of bugs, regardless of the filename, so it is included in this method.
	 */
	private void init(){
		rowOffset = getLocation().getRow();
		colOffset = getLocation().getCol();
		double[][] face = convertGray.convert(filename);
		this.face = new Face(face);
	}
	
	/**
	 * This method places the next part of the face by evaluating the next pixel.
	 */
	public void act(){
		if(rowsTraveled < face.getHeight()){
			if (steps < face.getWidth() && canMove())
	        {
	            move();
	            steps++;
	        }
	        else
	        {
	        	if(this.getDirection() == Location.EAST){
	        		setDirection(Location.SOUTH);
	        		move();
	        		setDirection(Location.WEST);
	        		steps = 0;
	        	}else{
	        		setDirection(Location.SOUTH);
	        		move();
	        		setDirection(Location.EAST);
	        		steps = 0;
	        	}
	        	rowsTraveled++;
	        }
		}
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
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        if(loc.getRow() < face.getHeight() && loc.getCol() < face.getWidth() && !face.getValue(loc.getRow()-rowOffset, loc.getCol()-colOffset)){
	        Flower flower = new SeasonalFlower(getColor());
	        flower.putSelfInGrid(gr, loc);
        }
    }

	/**
	 * @return the rowsTraveled
	 */
	protected int getRowsTraveled() {
		return rowsTraveled;
	}

	/**
	 * @param rowsTraveled the rowsTraveled to set
	 */
	protected void setRowsTraveled(int rowsTraveled) {
		this.rowsTraveled = rowsTraveled;
	}

	/**
	 * @return the rowOffset
	 */
	protected int getRowOffset() {
		return rowOffset;
	}

	/**
	 * @param rowOffset the rowOffset to set
	 */
	protected int getColOffset() {
		return colOffset;
	}
	
}
