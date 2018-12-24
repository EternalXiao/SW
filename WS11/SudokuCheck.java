import java.util.*;
public class SudokuCheck {
	public static boolean[][] check(Sudoku sudoku){
		boolean[][] res = new boolean[3][9];
		for(int i=0;i<9;i++) {
			ArrayList<Integer> record = new ArrayList<>();
			boolean correct = true;
			for(int j=0;j<9;j++) {
				if(sudoku.getArray()[i][j]==0||record.contains(sudoku.getArray()[i][j])) {
					correct=false;
					break;
				}
				else record.add(sudoku.getArray()[i][j]);
			}
			res[0][i]=correct;
		}
		for(int i=0;i<9;i++) {
			ArrayList<Integer> record = new ArrayList<>();
			boolean correct = true;
			for(int j=0;j<9;j++) {
				if(sudoku.getArray()[i][j]==0||record.contains(sudoku.getArray()[j][i])) {
					correct=false;
					break;
				}
				else record.add(sudoku.getArray()[j][i]);
			}
			res[1][i]=correct;
		}
		for(int i=0;i<9;i++) {
			ArrayList<Integer> record = new ArrayList<>();
			boolean correct = true;
			for(int j=0;j<9;j++) {
				if(sudoku.getArray()[(i/3)*3+j/3][(i%3)*3+j%3]==0||record.contains(sudoku.getArray()[(i/3)*3+j/3][(i%3)*3+j%3])) {
					correct=false;
					break;
				}
				else record.add(sudoku.getArray()[(i/3)*3+j/3][(i%3)*3+j%3]);
			}
			res[2][i]=correct;
		}
		return res;
	}
}
