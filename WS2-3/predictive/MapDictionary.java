package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MapDictionary implements Dictionary{
	private Map<String,Set<String>> dict = new HashMap<>();
	/**
	 * Constructor for MapDictionary
	 * When instantiate a MapDictionary object, the dictionary will be
	 * read from the provided path to the HashMap whose keys are signatures
	 * and values are sets of words corresponding to the keys
	 * @param path the path of the dictionary
	 */
	public MapDictionary(String path) {
		try {
			Scanner in = new Scanner(new File(path));
			String word;
			while (in.hasNextLine()) {
				word = in.nextLine().toLowerCase().trim();
				if(!PredictivePrototype.isValidWord(word))
					continue;
				if (!dict.containsKey(wordToSignature(word))) {
					dict.put(wordToSignature(word), new HashSet<String>());
				}
				dict.get(wordToSignature(word)).add(word);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method takes a signature and return a set of words corresponding
	 * to this signature
	 * @param signature the given signature
	 * @return a set of words with the given signature
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		return dict.get(signature);
	}
	
	/**
	 * This method converts a given word to signature by calling the method
	 * in prototype
	 * @param word the given word
	 * @return the signature of the word
	 */
	public String wordToSignature(String word) {
		return PredictivePrototype.wordToSignature(word);
	}
	
}
