/**
 * This class has two field variable words and signature
 * which is a word-signature pair.
 */
package predictive;
public class WordSig implements Comparable<WordSig>{
	private String words;
	private String signature;
	/**
	 * Constructor for WordSig
	 * @param words a word in dictionary
	 * @param signature the corresponding signature of the word
	 */
	public WordSig(String words, String signature) {
		this.words = words;
		this.signature = signature;
	}
	/**
	 * Getter method for words
	 * @return the word of the WordSig object
	 */
	public String getWord() {
		return this.words;
	}
	/**
	 * Getter method for signature
	 * @return the signature of the WordSig object
	 */
	public String getSig() {
		return this.signature;
	}
	/**
	 * Override method to determine how to compare two WordSig object 
	 */
	@Override
	public int compareTo(WordSig ws) {
		return this.getSig().compareTo(ws.getSig());
	}

}
