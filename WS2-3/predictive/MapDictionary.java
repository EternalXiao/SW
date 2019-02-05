package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MapDictionary implements Dictionary{
	private Map<String,Set<String>> dict = new HashMap<>();
	public MapDictionary(String path) {
		try {
			Scanner in = new Scanner(new File(path));
			String word;
			while (in.hasNextLine()) {
				word = in.nextLine();
				//System.out.println(word);
				if (!dict.containsKey(wordToSignature(word))) {
					dict.put(wordToSignature(word), new HashSet<String>());
				}
				dict.get(wordToSignature(word)).add(word.toLowerCase());
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Set<String> signatureToWords(String signature) {
		return dict.get(signature);
	}
	
	public String wordToSignature(String word) {
		return PredictivePrototype.wordToSignature(word);
	}
	
}
