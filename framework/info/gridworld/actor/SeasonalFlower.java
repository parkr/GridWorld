/** Name: Parker Moore
  * Class: AP Computer Science
  * Teacher: Mr. Klus
  * Program: 
  * Description: 
  */

/**
 * 
 */
package info.gridworld.actor;

import java.awt.Color;

/**
 * @author parkermoore
 *
 */
public class SeasonalFlower extends Flower {

	/**
	 * 
	 */
	public SeasonalFlower() {
		super();
	}

	/**
	 * @param initialColor
	 */
	public SeasonalFlower(Color initialColor) {
		super(initialColor);
	}

	/* (non-Javadoc)
	 * @see info.gridworld.actor.Flower#act()
	 */
	@Override
	public void act() {
		Color c = getColor();
		int red = (int) c.getRed(), green = (int) c.getGreen(), blue = (int) c.getBlue();
        if(red == 0 && green == 0 && blue == 0){
        	red *= (1 + DARKENING_FACTOR);
            green *= (1 + DARKENING_FACTOR);
            blue *= (1 + DARKENING_FACTOR);
        }else{
        	red *= (1 - DARKENING_FACTOR);
            green *= (1 - DARKENING_FACTOR);
            blue *= (1 - DARKENING_FACTOR);
        }
        setColor(new Color(red, green, blue));
	}

}
