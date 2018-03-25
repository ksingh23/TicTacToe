package TicTacToe;

import java.awt.Font;
import java.awt.Graphics;

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
	
	public void drawO (Graphics page){
		page.setFont(font);
		page.drawString(input, x, y);
	}
}
