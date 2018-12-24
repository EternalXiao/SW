import java.io.*;

public class SudokuRead {
	public Sudoku readSudoku(String filename) throws IllegalArgumentException,IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		int[][] arr = new int[9][9];
		for(int i=0;i<9;i++) {
			String s = in.readLine();
			for(int j=0;j<9;j++) {
				int e = 0;
				if((e=Character.getNumericValue(s.charAt(j)))>=0) {
					if(e>0&&e<10) arr[i][j]=e;
					else throw new IllegalArgumentException();
				}
				else if(s.charAt(j)==' ') arr[i][j]=0;
				else throw new IllegalArgumentException();
			}
		}
		in.close();
		return new Sudoku(arr);
	}
}
