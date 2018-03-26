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
	
	private int [][] board = {{0,0,0},{0,0,0},{0,0,0}};
	private int [] lastRow = new int [9];
	private int [] lastCol = new int [9];
	
	private DrawStuff draw;
	
	private JButton reset;
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
	private int gridWidth;
	private int gridHeight;
	private int xCoor;
	private int yCoor;
	private int xScore;
	private int oScore;
	
	private DrawX x;
	private DrawO o;
	private CheckWinner win;
	
	private ArrayList <DrawX> xList;
	private ArrayList <DrawO> oList;
	
	private Font font;
	
	
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
		//sidePanel.add(buttonPanel2);
		sidePanel.add(winnerPanel);
		add(boardPanel);
		draw = new DrawStuff();
		add(draw);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, draw);
		setLayout(new BorderLayout());
		add(split);
		draw.addMouseListener(new ClickListener());
		xList = new ArrayList<DrawX>();
		oList = new ArrayList<DrawO>();
	}

	private class DrawStuff extends JPanel {
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics page) {
			super.paintComponent(page);
			setBackground(Color.WHITE);
			gridWidth = (int) (this.getSize().getWidth() / (3.0));
			gridHeight = (int) (this.getSize().getHeight() / (3.0));
			for (int i = 1; i < 4; i++) {
				page.drawLine(0, gridHeight * i, (int) (getSize().getWidth()), gridHeight * i);
				page.drawLine(gridWidth * i, 0, gridWidth * i, (int) (getSize().getHeight()));
			}

			for (int j = 0; j < xList.size(); j++) {
				x = (DrawX) (xList.get(j));
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
			turn++;
			win = new CheckWinner (board);
			Point pt = e.getPoint();
			xCoor = pt.x;
			yCoor = pt.y;
			int rowPos = 0;
			int colPos = 0;
			if (xCoor > 0 && xCoor < gridWidth){
				xCoor = gridWidth/10;
				rowPos = 0;
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
			
			else if (xCoor > gridWidth && xCoor < 2 * gridWidth){
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
			if (win.oWinner() == false && win.xWinner() == false) {
				if (turn % 2 == 0){
					o = new DrawO(xCoor, yCoor, "O", font);
					if (board [rowPos][colPos] == 0) {
						oList.add(o);
						board [rowPos][colPos] = 1;
						lastRow [turn - 1] = rowPos;
						lastCol [turn - 1] = colPos;
					}
				}
				
				
				else{
					x = new DrawX (xCoor, yCoor, "X", font);
					if (board [rowPos][colPos] == 0) {
						xList.add(x);
						board [rowPos][colPos] = 2;
						lastRow [turn - 1] = rowPos;
						lastCol [turn - 1] = colPos;
					}
				}
			}
			
			if (turn < 9){
				if (win.oWinner()){
					winner.setText("O WINS");
				}
			
				else if (win.xWinner()){
					winner.setText("X WINS");
				}
			
			}
			
			else if (turn == 9){
				if (win.oWinner()) {
					winner.setText("O WINS");
				}
				
				else if (win.xWinner()) {
					winner.setText("X WINS");
				}
				
				else {
					winner.setText("IT'S A TIE");
				}
				
			}
			repaint();
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
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (win.xWinner()) {
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
				for (int j = 0; j < board[i].length; j++){
					board[i][j] = 0;
				}
			}
			winner.setText("");
			repaint ();
		}
	}
	
	private class PreviousListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (turn >= 1) {
				int rowToRemove = lastRow[turn - 1];
				int colToRemove = lastCol[turn - 1];
				board [rowToRemove][colToRemove] = 0;
				turn--;	
				repaint ();
			}	
		}
		
	}
}
