package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PredictivePrototype {

	public static String wordToSignature(String word) {
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

	public static Set<String> signatureToWords(String signature) {
		Map<String, Set<String>> dict = new HashMap<>();
		try {
			Scanner in = new Scanner(new File("words"));
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
			e.printStackTrace();
		}
		return dict.get(signature);
	}
	
	public static boolean isValidWord(String word) {
		for(char c:word.toCharArray()) {
			if(!Character.isAlphabetic(c))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(signatureToWords("4663"));
	}
}