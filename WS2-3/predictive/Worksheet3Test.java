package predictive;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class Worksheet3Test {
	private Dictionary ld, md, td;

	// Test for prototype
	@Test
	public void test1() {
		// wordTosignature testing
		String actualSig1 = PredictivePrototype.wordToSignature("name");
		String actualSig2 = PredictivePrototype.wordToSignature("Friend");
		String expectedSig1 = "6263";
		String expectedSig2 = "374363";
		assertEquals(actualSig1, expectedSig1);
		assertEquals(actualSig2, expectedSig2);

		// sigantureToWords testing
		Set<String> actualWords1 = PredictivePrototype.signatureToWords("26746");
		Set<String> actualWords2 = PredictivePrototype.signatureToWords("56582");
		Set<String> expectedWords1 = new HashSet<>();
		Set<String> expectedWords2 = new HashSet<>();
		expectedWords1.add("cosin");
		expectedWords1.add("corin");
		expectedWords2.add("kolva");
		assertEquals(actualWords1, expectedWords1);
		assertEquals(actualWords2, expectedWords2);

		// isValidWord testing
		assertTrue(PredictivePrototype.isValidWord("name"));
		assertFalse(PredictivePrototype.isValidWord("name_"));
		assertTrue(PredictivePrototype.isValidWord("Name"));
		assertFalse(PredictivePrototype.isValidWord("_name"));
	}

	// Test for ListDictionary
	@Test
	public void test2() {
		ld = new ListDictionary("words");
		Set<String> actualWords1 = ld.signatureToWords("26746");
		Set<String> actualWords2 = ld.signatureToWords("56582");
		Set<String> expectedWords1 = new HashSet<>();
		Set<String> expectedWords2 = new HashSet<>();
		expectedWords1.add("cosin");
		expectedWords1.add("corin");
		expectedWords2.add("kolva");
		assertEquals(actualWords1, expectedWords1);
		assertEquals(actualWords2, expectedWords2);
	}

	// Test for MapDictionary
	@Test
	public void test3() {
		md = new MapDictionary("words");
		Set<String> actualWords1 = md.signatureToWords("26746");
		Set<String> actualWords2 = md.signatureToWords("56582");
		Set<String> expectedWords1 = new HashSet<>();
		Set<String> expectedWords2 = new HashSet<>();
		expectedWords1.add("cosin");
		expectedWords1.add("corin");
		expectedWords2.add("kolva");
		assertEquals(actualWords1, expectedWords1);
		assertEquals(actualWords2, expectedWords2);
	}

	// Test for TreeDictionary
	@Test
	public void test4() {
		td = new TreeDictionary("words");
		Set<String> actualWords1 = td.signatureToWords("26746");
		Set<String> actualWords2 = td.signatureToWords("56582");
		Set<String> expectedWords1 = new HashSet<>();
		Set<String> expectedWords2 = new HashSet<>();
		expectedWords1.add("cosin");
		expectedWords1.add("corin");
		expectedWords1.add("ampho");
		expectedWords1.add("borin");
		expectedWords1.add("cosho");
		expectedWords1.add("copho");
		expectedWords1.add("corio");
		expectedWords1.add("cosim");
		expectedWords1.add("copio");
		expectedWords1.add("corim");
		expectedWords1.add("copin");
		expectedWords2.add("kolva");
		expectedWords2.add("kokta");
		expectedWords2.add("jokta");
		assertEquals(actualWords1, expectedWords1);
		assertEquals(actualWords2, expectedWords2);
	}

}
