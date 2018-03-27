package TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class Board extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int [][] board = {{0,0,0},{0,0,0},{0,0,0}};			//Initializes 2D Array for board
	private int [] lastRow = new int [9];
	private int [] lastCol = new int [9];					//Utility arrays for erase last move function
	private int [] lastXCoor = new int [9];	
	private int [] lastYCoor = new int [9];
	
	private DrawStuff draw;		//Graphics class Object
	
	private JButton reset;				//GUI Components
	private JButton previousMove;
	
	private JLabel xScoreLabel;
	private JLabel oScoreLabel;
	private JLabel winner;
	
	private JPanel sidePanel;
	private JPanel boardPanel;
	private JPanel scorePanel;
	private JPanel buttonPanel;
	private JPanel buttonPanel2;
	private JPanel winnerPanel;
	
	private int turn;
	private int gridWidth;			//Global variables for the turn, height/width of grid, x and yCoor
	private int gridHeight;
	private int xCoor;
	private int yCoor;
	private int xScore;			//Score vars 
	private int oScore;
	
	private DrawX x;			//Objects of the drawing classes that draw the X's and O's
	private DrawO o;
	private CheckWinner win;
	
	private ArrayList <DrawX> xList;		//ArrayList of type DrawX or O to store all the moves played
	private ArrayList <DrawO> oList;
	
	private Font font;			//Font for the strings drawn
	
	
	public Board() {
		reset = new JButton("Clear the board");
		previousMove = new JButton ("Reverse last move");
		reset.addActionListener (new ButtonListener ());			
		previousMove.addActionListener(new PreviousListener());
		turn = 0;
		xScore = 0;
		oScore = 0;
		xScoreLabel = new JLabel("X: " + xScore);
		oScoreLabel = new JLabel("Y: " + oScore);
		winner = new JLabel ("");
		winnerPanel = new JPanel ();
		winnerPanel.add(winner);
		sidePanel = new JPanel(new GridLayout(4, 1));
		scorePanel = new JPanel(new GridLayout(2, 1));
		boardPanel = new JPanel();
		buttonPanel = new JPanel(new BorderLayout());
		buttonPanel2 = new JPanel(new BorderLayout());
		buttonPanel.add(reset);
		buttonPanel2.add(previousMove);
		scorePanel.add(xScoreLabel);
		scorePanel.add(oScoreLabel);
		sidePanel.add(scorePanel);
		add(sidePanel);
		sidePanel.add(buttonPanel);
		sidePanel.add(buttonPanel2);
		sidePanel.add(winnerPanel);
		add(boardPanel);
		draw = new DrawStuff();
		add(draw);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, draw);			//Splits the side panel with score/buttons and the game board
		setLayout(new BorderLayout());
		add(split);					
		draw.addMouseListener(new ClickListener());			//ClickListener checks which box is clicked and draws X or O
		xList = new ArrayList<DrawX>();		//Arraylists containing the X's and O's initialized
		oList = new ArrayList<DrawO>();
	}

	private class DrawStuff extends JPanel {
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics page) {
			super.paintComponent(page);
			setBackground(Color.WHITE);			//Background of board set to white
			gridWidth = (int) (this.getSize().getWidth() / (3.0));
			gridHeight = (int) (this.getSize().getHeight() / (3.0));			//Each square's width is the size of the blank space divided by 3 (it's 3x3)
			for (int i = 1; i < 4; i++) {
				page.drawLine(0, gridHeight * i, (int) (getSize().getWidth()), gridHeight * i);		//Draws lines at gridHeight, gridHeight * 2, to make the grid
				page.drawLine(gridWidth * i, 0, gridWidth * i, (int) (getSize().getHeight()));
			}

			for (int j = 0; j < xList.size(); j++) {
				x = (DrawX) (xList.get(j));				//Reads from the arraylist of X and O and draws their components at their respective locations
				x.drawX(page);
			}

			for (int k = 0; k < oList.size(); k++) {
				o = (DrawO) (oList.get(k));
				o.drawO(page);
			}
		}
	}

	public class ClickListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			win = new CheckWinner (board);
			Point pt = e.getPoint();
			xCoor = pt.x;			//Gives the x and y coordinates of the location clicked
			yCoor = pt.y;
			int rowPos = 0;
			int colPos = 0;
			if (xCoor > 0 && xCoor < gridWidth){		//If x is in the first column
				xCoor = gridWidth/10;						
				rowPos = 0;
				if (yCoor > 0 && yCoor < gridHeight){					//If y falls between 0 and the height of one square, it sets the yCoor to the appropriate spot
					yCoor = gridHeight - 20;
					colPos = 0;					
				}
				
				else if (yCoor > gridHeight && yCoor < 2* gridHeight){		//Does the same for the other possible locations
					yCoor = 2 * gridHeight - 20;
					colPos = 1;
				}
				
				else if (yCoor > 2 * gridHeight && yCoor < 3 * gridHeight){
					yCoor = 3 * gridHeight - 20;
					colPos = 2;
				}
			}
			
			else if (xCoor > gridWidth && xCoor < 2 * gridWidth){			//If x is in the second column, does the same operation as above
				xCoor = gridWidth/10 + gridWidth;
				rowPos = 1;
				if (yCoor > 0 && yCoor < gridHeight){
					yCoor = gridHeight - 20;
					colPos = 0;
				}
				
				else if (yCoor > gridHeight && yCoor < 2* gridHeight){
					yCoor = 2 * gridHeight - 20;
					colPos = 1;
				}
				
				else if (yCoor > 2 * gridHeight && yCoor < 3 * gridHeight){
					yCoor = 3 * gridHeight - 20;
					colPos = 2;
				}
			}
			
			else if (xCoor > 2 * gridWidth && xCoor < 3 * gridWidth){
				xCoor = gridWidth/10 + 2 * gridWidth;
				rowPos = 2;
				if (yCoor > 0 && yCoor < gridHeight){
					yCoor = gridHeight - 20;
					colPos = 0;
				}
				
				else if (yCoor > gridHeight && yCoor < 2* gridHeight){
					yCoor = 2 * gridHeight - 20;
					colPos = 1;
				}
				
				else if (yCoor > 2 * gridHeight && yCoor < 3 * gridHeight){
					yCoor = 3 * gridHeight - 20;
					colPos = 2;
				}
			}
			
			font  = new Font ("Courier New", 1, gridHeight);
			if (win.oWinner() == false && win.xWinner() == false) {		//If condition only allows you to edit board if game is in session 
				turn++;						//Increments turn each time a valid move (i.e. when no winner yet declared)
				if (turn % 2 == 0){			//If second turn, then it is O's move, otherwise it is X
					o = new DrawO(xCoor, yCoor, "O", font);
					if (board [rowPos][colPos] == 0) {			//Only draws 0 if the index is set to 0 (it is blank)
						oList.add(o);
						board [rowPos][colPos] = 1;				//1 means that an O is in that index, 2 for an X
						lastRow [turn - 1] = rowPos;			//Fills the arrays with the x and y coordinates, and the location so it can be reversed if needed
						lastCol [turn - 1] = colPos;
						lastXCoor [turn - 1] = xCoor;
						lastYCoor [turn - 1] = yCoor;
					}
				}
				
				
				else{
					x = new DrawX (xCoor, yCoor, "X", font);			//Initializes x to be drawn based on coordinates chosen
					if (board [rowPos][colPos] == 0) {
						xList.add(x);
						board [rowPos][colPos] = 2;
						lastRow [turn - 1] = rowPos;
						lastCol [turn - 1] = colPos;		
						lastXCoor [turn - 1] = xCoor;
						lastYCoor [turn - 1] = yCoor;
					}
				}
			}
			
			if (turn < 9){							//Checks if a winner is found after each turn, done in CheckWinner class
				if (win.oWinner()){
					winner.setText("O WINS");
				}
			
				else if (win.xWinner()){
					winner.setText("X WINS");			//Set label text to whoever wins
				}
			
			}
			
			else if (turn == 9){
				if (win.oWinner()) {			//If game uses all turns, then check for winner or if none is found, sets to a tie
					winner.setText("O WINS");
				}
				
				else if (win.xWinner()) {
					winner.setText("X WINS");
				}
				
				else {
					winner.setText("IT'S A TIE");
				}
				
			}
			repaint();			//Repaint redraws the board every time a square is clicked/move made
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
		
		}

		public void mouseEntered(MouseEvent e) {
	
		}

		public void mouseExited(MouseEvent e) {

		}

	}
	
	private class ButtonListener implements ActionListener{		//Button to clear the board
		public void actionPerformed(ActionEvent e) {
			if (win.xWinner()) {							//Checks who wins, and adds to their score once board is cleared
				xScore++;
				xScoreLabel .setText("X: " + xScore);
			}
			
			else if (win.oWinner()) {
				oScore++;
				oScoreLabel .setText("O: " + oScore);
			}
			oList.clear();
			xList.clear();
			turn = 0;
			for (int i = 0; i < board.length; i++){
				for (int j = 0; j < board[i].length; j++){			//Resets the board to all 0
					board[i][j] = 0;
				}
			}
			winner.setText("");				//Blanks out the winner to start again
			repaint ();
		}
	}
	
	private class PreviousListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (turn >= 1) {				//Runs if turn = 1, otherwise would try to access negative indexes of following arrays
				int rowToRemove = lastRow[turn - 1];
				int colToRemove = lastCol[turn - 1];			//Assigns the positions and coordinates stored in the array to variables
				int xCoorToRemove = lastXCoor [turn - 1];
				int yCoorToRemove = lastYCoor [turn - 1];
				if (board [rowToRemove][colToRemove] == 1) {
					for (int i = 0; i < oList.size(); i++) {				//Iterates through either x or o list to see which element has the x,y coordinates stored
						o = (DrawO)(oList.get(i));
						if (o.getXCoor() == xCoorToRemove && o.getYCoor() == yCoorToRemove) {
							oList.remove(o);			//If one is found with matching y coordinates, then removes from list
						}
					}
				}
				
				else if (board [rowToRemove][colToRemove] == 2) {
					for (int j = 0; j < xList.size(); j++) {
						x = (DrawX)(xList.get(j));
						if (x.getXCoor() == xCoorToRemove && x.getYCoor() == yCoorToRemove) {
							xList.remove(x);
						}
					}
				}
				board [rowToRemove][colToRemove] = 0;		//Sets the board array location to 0 so another move can be played
			
				turn--;		//Decrements turn variable
				repaint ();			
			}	
		}
		
	}
}
