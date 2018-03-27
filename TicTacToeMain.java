package TicTacToe;

import javax.swing.*;

public class TicTacToeMain extends JApplet {
	private static final long serialVersionUID = 1L;
	
	public void init (){
		Board board = new Board ();		//Object of board class created
		getContentPane().add (board);			//Added to applet
		setSize (500,500);
		setVisible (true);
	}
}
