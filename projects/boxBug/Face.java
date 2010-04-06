import info.gridworld.grid.Location;

/** Name: Parker Moore
 * Class: AP Computer Science
 * Teacher: Mr. Klus
 * Program: GridWorld
 * Description: For use with the <code>FaceBug</code> that draws a face on the grid. This class contains useful methods to convert the face into a boolean matrix and holds convenient variables.
 */

public class Face {

	private int height;
	private int width;
	private boolean[][] face;
	
	public Face(double[][] greyscale){
		face = new boolean[greyscale.length][greyscale[0].length];
		convert(greyscale);
		height = face.length;
		width = face[0].length;
		//System.out.println("height: "+height+" width: "+width);
	}
	
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * 
	 * @param row - integer representing row value
	 * @param col - integer representing column value
	 * @return returns the value of the boolean matrix at the row,col location if it exists, and returns true if it does not exist.
	 */
	public boolean getValue(int row, int col){
		if(row <= face.length && col < face[0].length){
			System.out.println("["+row+"]["+col+"] = "+face[row][col]);
			return face[row][col];
		}else
			return true;
	}
	
	/**
     * <code>convert</code> sets the private boolean matrix to correspond to the values in the inputted array
     * @param pixelface - double matrix of rastered photo color values
     */
	private void convert(double[][] pixelface){
		for(int r=0; r<pixelface.length; r++){
			for(int c=0; c<pixelface[0].length; c++){
				face[r][c] = (pixelface[r][c] <= -15.0);
				//System.out.println("row "+r+" col "+c+" val "+face[r][c]);
			}
		}
		rotate();
	}
	
	/**
	 * Prints the boolean array in a string form.
	 */
	public String toString(){
		String output = "";
		for(int r=0; r<face.length; r++){
			for(int c=0; c<face[0].length; c++)
				output += face[r][c]+" ";
			output += "\n";
		}
		return output;
	}
	
	/**
	 * Rotates the boolean array ninety degrees clockwise.
	 */
	private void rotate(){
		boolean[][] newface = new boolean[face[0].length][face.length];
		for(int r=0; r<face.length; r++){
			for(int c=0; c<face[0].length; c++)
				newface[c][face.length-1-r] = face[r][c];
		}
		face = newface;
	}
	
	/**
	 * @param loc
	 * @param direction
	 * @return
	 */
	public Location getNext(Location loc, int direction){
		Location next = loc.getAdjacentLocation(direction);
		while(next.getCol() > 0 && next.getCol() < width && !this.face[next.getRow()][next.getCol()])
			next = next.getAdjacentLocation(direction);
		return next;
	}
}
