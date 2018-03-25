package TicTacToe;

import javax.swing.JApplet;

public class Applet extends JApplet {
	private static final long serialVersionUID = 1L;
	
	public void init (){
		Board board = new Board ();
		getContentPane().add (board);
		setSize (500,500);
		setVisible (true);
	}
}
