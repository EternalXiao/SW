/**
 * PPMImage is a class containing attributes of a coloured picture with PPM format of type P3
 * we define five field variables:
 * <pre>
 *  width, the total pixels of the width of picture
 *  height, the total pixels of the height of picture
 *  maxShade, the max shade value of the picture
 *  typeOfFile, format type of the picture
 *  pixels, a three dimensional array holds the RGB value of each pixel
 * </pre>
 */

import java.io.*;
import java.util.Scanner;

public class PPMImage {
	private int width;
	private int height;
	private int maxShade;
	private String typeOfFile;
	private short[][][] pixels;
	
	/**
	 * The PPMImage constructor
	 * @param filename the file name of the input file to be considered
	 */
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
	
	/**
	 * Getter method for the width
	 * @return the width of the picture
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Getter method for the height
	 * @return the height of the picture
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Getter method for the max shade
	 * @return the max shade of the picture
	 */
	public int getMaxShade() {
		return this.maxShade;
	}
	
	/**
	 * Getter method for the file type
	 * @return the format type of the image
	 */
	public String getTypeOfFile() {
		return this.typeOfFile;
	}
	
	/**
	 * Getter method for the RGB value of each pixel
	 * @return a three dimensional array of the RGB value in each pixel
	 */
	public short[][][] getPixels(){
		return this.pixels;
	}
	
	/**
	 * Setter method for width
	 * @param width new image width to be set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Setter method for height
	 * @param height new image height to be set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Setter method for max shade
	 * @param maxShade new max shade value to be set
	 */
	public void setMaxShade(int maxShade) {
		this.maxShade = maxShade;
	}
	
	/**
	 * Setter method for format type of the image
	 * @param typeOfFile the new format type
	 */
	public void setTypeOfFile(String typeOfFile) {
		this.typeOfFile = typeOfFile;
	}
	
	/**
	 * Setter method for the RGB in each pixel
	 * @param pixels new RGB value to be set for the image
	 */
	public void setPixels(short[][][] pixels) {
		this.pixels = pixels;
	}
	
	/**
	 * A method to convert the P3 type coloured image to corresponding P2 type image
	 * @param filename output file name of PGM image
	 * @return a two dimensional array with the corresponding grey value in each pixel
	 */
	public short[][] makeGrey(String filename){
		short[][] grey = new short[getHeight()][getWidth()];
		int pgmMaxShade = 0;
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				//compute the corresponding grey value which is the rounded value of the three colour
				grey[i][j] = (short)Math.round((getPixels()[i][j][0]+getPixels()[i][j][1]+getPixels()[i][j][2])/3.0);
				if (grey[i][j] > pgmMaxShade) {
					pgmMaxShade = grey[i][j];
				}
			}
		}
		if (filename != null) { 
			try{
				BufferedWriter out = new BufferedWriter(new FileWriter(filename));
				out.write("P2\n");
				out.write(getWidth()+" "+getHeight()+"\n");
				out.write(pgmMaxShade+"\n");
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
