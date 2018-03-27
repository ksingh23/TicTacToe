package TicTacToe;

/*
 * This class draws the X's using the drawString method and coordinates
 * determined in the ClickListener class
 */
import java.awt.Font;
import java.awt.Graphics;

public class DrawX {
	private int x;
	private int y;
	private String input;
	private Font font;

	public DrawX(int x1, int y1, String input1, Font font1) {
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

	public void drawX(Graphics page) {			//Draws a string "X"
		page.setFont(font);
		page.drawString (input, x, y);
	}
}
