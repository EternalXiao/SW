/**
 * This class implement the dictionary with a more efficient approach
 * The word-signature pair for each word is stored in a WordSig object
 * This class uses arrayList to store the WordSig object 
 */
package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ListDictionary implements Dictionary {
	private List<WordSig> dict = new ArrayList<>();

	/**
	 * Constructor for ListDictionary When instantiate a ListDictionary object, the
	 * dictionary will be read from the provided path to the arraylist
	 * 
	 * @param path the path of the dictionary
	 */
	public ListDictionary(String path) {
		try {
			Scanner in = new Scanner(new File(path));
			String word;
			while (in.hasNextLine()) {
				word = in.nextLine().toLowerCase().trim();
				if (!PredictivePrototype.isValidWord(word))
					continue;
				WordSig ws = new WordSig(word, PredictivePrototype.wordToSignature(word));
				dict.add(ws);
			}
			in.close();
			Collections.sort(dict);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method reads a given signature and utilise a binary search to find the
	 * stored words with the corresponding signature
	 * 
	 * @param sig the given signature
	 * @return the corresponding set of words with the signature
	 */
	public Set<String> signatureToWords(String sig) {
		int idx = Collections.binarySearch(dict, new WordSig("", sig));
		int idx1 = idx;
		Set<String> res = new HashSet<>();
		res.add(dict.get(idx).getWord());
		while (dict.get(++idx).getSig().equals(sig)) {
			res.add(dict.get(idx).getWord());
		}
		while (dict.get(--idx1).getSig().equals(sig)) {
			res.add(dict.get(idx1).getWord());
		}
		return res;
	}

	/**
	 * This method converts a given word to signature by calling the method in
	 * prototype
	 * 
	 * @param word the given word
	 * @return the signature of the word
	 */
	public String wordsToSignature(String word) {
		return PredictivePrototype.wordToSignature(word);
	}
}
