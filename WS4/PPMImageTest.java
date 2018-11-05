import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PPMImageTest {
	
	private PPMImage test1;
	
	@Before
	public void setup() {
		test1 = new PPMImage("Test1.ppm");
	}
	
	//Test for getters
	@Test
	public void test1() {
		String expectedTypeOfFile = "P3";
		int expectedWidth = 3;
		int expectedHeight = 3;
		int expectedMaxShade = 255;
		short[][][] expectedPixels = {{{0,0,0},{100,100,100},{255,255,255}},{{100,150,200},{200,250,225},{50,50,50}},{{0,0,0},{255,254,253},{200,200,200}}};

		assertEquals(expectedTypeOfFile, test1.getTypeOfFile());
		assertEquals(expectedWidth, test1.getWidth());
		assertEquals(expectedHeight, test1.getHeight());
		assertEquals(expectedMaxShade, test1.getMaxShade());
		assertArrayEquals(expectedPixels,test1.getPixels());
	}
	
	//Test for setters
	@Test
	public void test2() {
		String expectedTypeOfFile = "P4";
		int expectedWidth = 2;
		int expectedHeight = 2;
		int expectedMaxShade = 254;
		short[][][] expectedPixels = {{{0,0,0},{100,100,100}},{{100,150,200},{200,250,225}},{{0,0,0},{255,254,253}}};
		test1.setTypeOfFile("P4");
		test1.setWidth(2);
		test1.setHeight(2);
		test1.setMaxShade(254);
		test1.setPixels(new short[][][] {{{0,0,0},{100,100,100}},{{100,150,200},{200,250,225}},{{0,0,0},{255,254,253}}});
		
		assertEquals(expectedTypeOfFile, test1.getTypeOfFile());
		assertEquals(expectedWidth, test1.getWidth());
		assertEquals(expectedHeight, test1.getHeight());
		assertEquals(expectedMaxShade, test1.getMaxShade());
		assertArrayEquals(expectedPixels,test1.getPixels());
	}
	
	//Test for makeGrey with output file
	@Test
	public void test3() {
		test1.makeGrey("Test1.pgm");
		PGMImage expected = new PGMImage("Test1-expected.pgm");
		PGMImage actual = new PGMImage("Test1.pgm");
		
		assertTrue(actual.equals(expected));
	}
	
	//Test for makeGrey with return array
	@Test
	public void test4() {
		short[][] actual = test1.makeGrey("Test1.pgm");
		short[][] expected = {{0,100,255},{150,225,50},{0,254,200}};
		
		assertArrayEquals(actual,expected);
	}
}
