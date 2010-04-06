/** Name: Parker Moore
 *  Class: AP CS
 *	Teacher: Mr. Klus
 *	Program: GridWorld
 *  Description: This class converts a color image into a greyscale image.
 *  Code acquired from: http://forums.sun.com/thread.jspa?threadID=5319982
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class convertGray {
	
	public static double[][] convert(String filename){
		String path  = filename;
		String path1 = filename+"_greyscale.jpg";
		 
		BufferedImage old_img = null;   
		 
		try{
			old_img = ImageIO.read(new File(path));
		}catch (Exception e){
			e.printStackTrace(); 
		}  
		 
		 
		BufferedImage new_img = new BufferedImage( old_img.getWidth(),
							 old_img.getHeight(), 
							 BufferedImage.TYPE_BYTE_GRAY);
		 
		Graphics gr = new_img.getGraphics();
		 
		gr.drawImage(old_img, 0, 0, null);
		gr.dispose();
		 
		try {   
		        ImageIO.write(new_img, "jpg", new File(path1));   
		    } 
		catch (IOException e)   { e.printStackTrace(); }  
		 
		byte pix[] = new byte[1];
		int n = new_img.getWidth();
		int m = new_img.getHeight();
		double[][] matrix = new double[n][m];
		 
		     //swips the rows
		     for (int row = 0; row < n; ++row) {
			//swips the columns
		         for (int col = 0; col < m; ++col) {
		        	 //matrix[row][col] = new_img.getRGB(row, col);
		        	 new_img.getRaster().getDataElements(row, col, pix);
		        	 matrix[row][col] = pix[0];
		        	 //System.out.println("row " + row + " col " + col + " pixel " + matrix[row][col]);                     
		         }
		     }
		     return matrix;
	}
}
