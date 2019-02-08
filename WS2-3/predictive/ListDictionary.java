package predictive;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ListDictionary implements Dictionary{
	private List<WordSig> dict = new ArrayList<>();
	public ListDictionary(String path) {
		try {
			Scanner in = new Scanner(new File(path));
			String word;
			while(in.hasNextLine()) {
				word = in.nextLine().toLowerCase().trim();
				if(!PredictivePrototype.isValidWord(word))
					continue;
				WordSig ws = new WordSig(word,PredictivePrototype.wordToSignature(word));
				if(!dict.contains(ws))
					dict.add(ws);
			}
			System.out.println("Dict loaded");
			Collections.sort(dict);
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Set<String> signatureToWords(String sig){
		int idx = Collections.binarySearch(dict,new WordSig("",sig));
		Set<String> res = new HashSet<>();
		res.add(dict.get(idx).getWord());
		while(dict.get(++idx).getSig().equals(sig)) {
			res.add(dict.get(idx).getWord());
		}
		return res;
	}
	public String wordsToSignature(String word) {
		return PredictivePrototype.wordToSignature(word);
	}
}
