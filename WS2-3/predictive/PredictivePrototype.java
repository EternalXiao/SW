package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PredictivePrototype {
	
	/**
	 * This method is to convert a given word to its corresponding
	 * signature
	 * @param word the given word
	 * @return the signature of the given word
	 */
	public static String wordToSignature(String word) {
		// Here I am using StringBuffer to store the signature of a word character by character rather than
		// string for the reason that string is immutable and the StringBuffer is mutable. So if we use string,
		// every time we modify it, it will create a new object which is very inefficient and memory waste.
		StringBuffer Sig = new StringBuffer();
		for (char c : word.toLowerCase().toCharArray()) {
			if (Character.isAlphabetic(c)) {
				if (97 <= c && c <= 99)
					Sig.append("2");
				else if (100 <= c && c <= 102)
					Sig.append("3");
				else if (103 <= c && c <= 105)
					Sig.append("4");
				else if (106 <= c && c <= 108)
					Sig.append("5");
				else if (109 <= c && c <= 111)
					Sig.append("6");
				else if (112 <= c && c <= 115)
					Sig.append("7");
				else if (116 <= c && c <= 118)
					Sig.append("8");
				else
					Sig.append("9");

			} else
				Sig.append(" ");
		}
		return Sig.toString();
	}
	
	/**
	 * This method takes a signature and checks the words in the
	 * dictionary that has this signature and return all of them as
	 * a set
	 * @param signature the given signature
	 * @return a set of words with the signature
	 */
	public static Set<String> signatureToWords(String signature) {
		// This implement is inefficient due to the fact that every time we want to
		// convert a signature into a set of words, this method will scan the whole
		// dictionary to find the desired words.
		Set<String> res = new HashSet<>();
		try {
			Scanner in = new Scanner(new File("words"));
			String word;
			while (in.hasNextLine()) {
				word = in.nextLine().toLowerCase().trim();
				if(!PredictivePrototype.isValidWord(word))
					continue;
				if(wordToSignature(word).equals(signature))
					res.add(word);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * This method check whether a given word is a valid
	 * word (not containing non-alphabetic characters)
	 * @param word the given word
	 * @return true if the word is valid, else false
	 */
	public static boolean isValidWord(String word) {
		for(char c:word.toCharArray()) {
			if(!Character.isAlphabetic(c))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		long st;
		st=System.currentTimeMillis();
		System.out.println(signatureToWords("4663"));
		System.out.println(System.currentTimeMillis()-st);
	}
}
