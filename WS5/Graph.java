import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph implements GraphInterface{
	private int numberOfNodes;
	private int[][] adjacencyMatrix;
	
	public Graph(int numberOfNodes, int[][] adjacencyMatrix) {
		this.numberOfNodes = numberOfNodes;
		this.adjacencyMatrix = adjacencyMatrix;
	}
	
	public Graph(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			this.numberOfNodes = in.nextInt();
			adjacencyMatrix = new int[this.numberOfNodes][this.numberOfNodes];
			for (int i = 0; i < adjacencyMatrix.length; i++) {
				for (int j = 0; j < adjacencyMatrix[i].length; j++) {
					adjacencyMatrix[i][j] = in.nextInt();
				}
			}
			in.close();
		}
		catch(Exception e) {
			System.out.println("Input file not found");
		}
	}
	
	public boolean connected() {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> nodeTraversed = new ArrayList<>();
		list.add(0);
		while(list.size()!=0) {
			int currentNode = list.remove(0);
			nodeTraversed.add(currentNode);
			for (int i= 0; i < adjacencyMatrix[currentNode].length; i++) {
				if (adjacencyMatrix[currentNode][i] > 0 && !nodeTraversed.contains(i) && !list.contains(i)) {
					list.add(i);
				}
			}
		}
		return nodeTraversed.size() == this.numberOfNodes;
	}
	
	public int totalLength() {
		int total = 0;
		for (int i = 0; i < this.numberOfNodes; i++) {
			for (int j = i; j < this.numberOfNodes; j++) {
				if (adjacencyMatrix[i][j] > 0) {
					total += adjacencyMatrix[i][j];
				}
			}
		}
		return total;
	}
	public static void main(String[] args) {
		Graph g = new Graph("test.txt");
		System.out.println(g.totalLength());
	}
}
