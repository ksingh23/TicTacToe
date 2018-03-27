package TicTacToe;

import java.awt.Font;
import java.awt.Graphics;

/*
 * This class draws the O's using the drawString method and coordinates
 * determined in the ClickListener class
 */
public class DrawO {
	private int x;
	private int y;
	private String input;
	private Font font;
	public DrawO (int x1, int y1, String input1, Font font1){
		x = x1;
		y = y1;
		input = input1;
		font = font1;
	}
	
	public int getXCoor () {		//Getter methods to get the x and y coordinate values for use in the reverse last move arrays
		return x;
	}
	
	public int getYCoor () {
		return y;
	}
	
	public void drawO (Graphics page){
		page.setFont(font);
		page.drawString(input, x, y);			//Draws a string "O"
	}
}
