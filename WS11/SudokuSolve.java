import java.util.*;
public class SudokuSolve {
	public static void solve(Sudoku sudoku) {
		solveSudoku(sudoku.getArray());
	}
	public static boolean solveSudoku(int[][] board) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]==0) {
					for(int c=1;c<=9;c++) {
						if(checkValid(board,i,j,c)) {
							board[i][j]=c;
							if(solveSudoku(board))
								return true;
							else 
								board[i][j]=0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	public static boolean checkValid(int[][] board,int row,int col,int c) {
		for(int i=0;i<9;i++) {
			if(board[row][i]==c) return false;
			if(board[i][col]==c) return false;
			if(board[row/3*3+i/3][col/3*3+i%3]==c) return false;
		}
		return true;
	}
}
