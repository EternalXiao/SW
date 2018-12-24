import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		SudokuRead s = new SudokuRead();
		for (boolean[] e : SudokuCheck.check(s.readSudoku("sudoku.txt"))) {
			System.out.println(Arrays.toString(e));
		}
	}
}
