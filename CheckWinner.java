package TicTacToe;

public class CheckWinner {
	private int [][] board;
	
	public CheckWinner (int [][] board1){			//Constructor to get the board info from the driver class
		board = board1;
	}
	public boolean oWinner (){
		boolean win = false;				//Method to check if O is winner
		if (board[0][0] == 1 && board [1][0] == 1 && board [2][0] == 1){				//Each if statement contains all the possible ways that O could win, checks if any of these cases are true
			win = true;
		}
		
		else if (board[0][1] == 1 && board [1][1] == 1 && board [2][1] == 1){
			win = true;
		}
		
		else if (board[0][2] == 1 && board [1][2] == 1 && board [2][2] == 1){		//Note previously that when O added, board[i][j] = 1, so checks cols,rows,and diag
			win = true;
		}
		
		else if (board[0][0] == 1 && board [0][1] == 1 && board [0][2] == 1){
			win = true;
		}
		
		else if (board[1][0] == 1 && board [1][1] == 1 && board [1][2] == 1){
			win = true;
		}
		
		else if (board[2][0] == 1 && board [2][1] == 1 && board [2][2] == 1){
			win = true;
		}
		
		else if (board[1][0] == 1 && board [1][1] == 1 && board [1][2] == 1){
			win = true;
		}
		
		else if (board[2][0] == 1 && board [2][1] == 1 && board [2][2] == 1){
			win = true;
		}
		
		else if (board[0][0] == 1 && board [1][1] == 1 && board [2][2] == 1){
			win = true;
		}
		
		else if (board[2][0] == 1 && board [1][1] == 1 && board [0][2] == 1){
			win = true;
		}
		
		
		return win;
	}
	
	public boolean xWinner (){
		boolean win = false;					//Same, but for X, note how board[i][j] = 2 instead of 1
		if (board[0][0] == 2 && board [1][0] == 2 && board [2][0] == 2){
			win = true;
		}
		
		else if (board[0][1] == 2 && board [1][1] == 2 && board [2][1] == 2){
			win = true;
		}
		
		else if (board[0][2] == 2 && board [1][2] == 2 && board [2][2] == 2){
			win = true;
		}
		
		else if (board[0][0] == 2 && board [0][1] == 2 && board [0][2] == 2){
			win = true;
		}
		
		else if (board[1][0] == 2 && board [1][1] == 2 && board [1][2] == 2){
			win = true;
		}
		
		else if (board[2][0] == 2 && board [2][1] == 2 && board [2][2] == 2){
			win = true;
		}
		
		else if (board[1][0] == 2 && board [1][1] == 2 && board [1][2] == 2){
			win = true;
		}
		
		else if (board[2][0] == 2 && board [2][1] == 2 && board [2][2] == 2){
			win = true;
		}
		
		else if (board[0][0] == 2 && board [1][1] == 2 && board [2][2] == 2){
			win = true;
		}
		
		else if (board[2][0] == 2 && board [1][1] == 2 && board [0][2] == 2){
			win = true;
		}
		
		return win;
	}
	
}
