import java.io.*;
import java.util.Scanner;

public class PPMImage {
	private int width;
	private int height;
	private int maxShade;
	private String typeOfFile;
	private short[][][] pixels;
	
	public PPMImage(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			this.typeOfFile = in.nextLine();
			this.width = in.nextInt();
			this.height = in.nextInt();
			this.maxShade = in.nextInt();
			pixels = new short[height][width][3];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					for (int k = 0; k < 3; k++) {
						pixels[i][j][k] = (short) in.nextInt();
					}
				}
			}
			in.close();
		}
		catch (IOException e) {
			System.out.println("Input file not found.");
		}
		
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getMaxShade() {
		return this.maxShade;
	}
	
	public String getTypeOfFile() {
		return this.typeOfFile;
	}
	
	public short[][][] getPixels(){
		return this.pixels;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setMaxShade(int maxShade) {
		this.maxShade = maxShade;
	}
	
	public void setTypeOfFile(String typeOfFile) {
		this.typeOfFile = typeOfFile;
	}
	
	public void setPixels(short[][][] pixels) {
		this.pixels = pixels;
	}
	
	public short[][] makeGrey(String filename){
		short[][] grey = new short[getHeight()][getWidth()];
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				grey[i][j] = (short)Math.round((getPixels()[i][j][0]+getPixels()[i][j][1]+getPixels()[i][j][2])/3.0);
			}
		}
		if (!filename.equals("")) { 
			try{
				BufferedWriter out = new BufferedWriter(new FileWriter(filename));
				out.write("P2\n");
				out.write(getWidth()+" "+getHeight()+"\n");
				out.write(getMaxShade()+"\n");
				for (int i = 0; i < getHeight(); i++) {
					for (int j = 0; j < getWidth(); j++) {
						out.write(grey[i][j]+"\n");
					}
				}
				out.close();
			}
			catch (IOException e) {
				System.out.println("Output file not found.");
			}
		}
		return grey;
	}
	
	public static void main(String[] args) {
		PPMImage c = new PPMImage("ComputerScienceBig.ppm");
		c.makeGrey("ComputerScienceBig.pgm");
		short[][][] d = c.getPixels();
		System.out.println(c.getTypeOfFile()+" "+c.getHeight()+" "+c.getWidth()+" "+d[0][0][0]);
	}
}
