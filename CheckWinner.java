package TicTacToe;

public class CheckWinner {
	private int [][] board;
	
	public CheckWinner (int [][] board1){
		board = board1;
	}
	public boolean oWinner (){
		boolean win = false;
		if (board[0][0] == 1 && board [1][0] == 1 && board [2][0] == 1){
			win = true;
		}
		
		else if (board[0][1] == 1 && board [1][1] == 1 && board [2][1] == 1){
			win = true;
		}
		
		else if (board[0][2] == 1 && board [1][2] == 1 && board [2][2] == 1){
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
		boolean win = false;
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
