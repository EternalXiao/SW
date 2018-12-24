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
			if(i%3==0) str.append("++===+===+===++===+===+===++===+===+===++\n");
			else str.append("++---+---+---++---+---+---++---+---+---++\n");
			for(int j=0;j<9;j++) {
				if(j%3==0) str.append("||");
				else str.append("|");
				str.append(String.format(" %d ", this.getArray()[i][j]));
			}
			str.append("||\n");
		}
		str.append("++===+===+===++===+===+===++===+===+===++\n");
		return str.toString();
	}
	public boolean isFilled() {
		for(int[] elements:this.getArray()) {
			for(int element:elements) {
				if(element==0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Sudoku s = new Sudoku(new int[][] {{1,1,1,1,1,1,1,1,1},
											{1,1,1,1,1,1,1,1,1},
											{1,1,1,1,1,1,1,1,1},
											{1,1,1,1,1,1,1,1,1},
											{1,1,1,1,1,1,1,1,1},
											{1,1,1,1,1,1,1,1,1},
											{1,1,1,1,1,1,1,1,1},
											{1,1,1,1,1,1,1,1,1},
											{1,1,1,1,1,1,1,1,1}});
		System.out.println(s);
	}
}
