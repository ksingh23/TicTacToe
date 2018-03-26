package TicTacToe;

import java.awt.Font;
import java.awt.Graphics;

public class DrawBlank {
	private int x;
	private int y;
	private String input;
	private Font font;
	public DrawBlank (int x1, int y1, String input1, Font font1){
		x = x1;
		y = y1;
		input = input1;
		font = font1;
	}
	
	public void drawBlank (Graphics page){
		page.setFont(font);
		page.drawString(input, x, y);
	}
}
