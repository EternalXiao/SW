import java.util.*;
public class Sudoku {
	private int[][] array;

	public Sudoku(int[][] array) {
		this.array = array;
	}
	
	public int[][] getArray(){
		return this.array;
	}
	public String toString() {
		StringBuilder str = new StringBuilder("");
		for(int i=0;i<9;i++) {
			if(i%3==0) str.append("++===+===+===++===+===+===++===+===+===++");
			else str.append("++---+---+---++---+---+---++---+---+---++");
			for(int j=0;j<9;j++) {
				if(j%3==0) str.append("||");
				else str.append("|");
				str.append(String.format(" %d ", this.getArray()[i][j]));
			}
			str.append("||");
		}
		str.append("++===+===+===++===+===+===++===+===+===++");
		return str.toString();
	}
	public static void main(String[] args) {
		
	}
}
