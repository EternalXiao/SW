package predictive;

public class WordSig implements Comparable<WordSig>{
	private String words;
	private String signature;
	public WordSig(String words, String signature) {
		this.words = words;
		this.signature = signature;
	}
	public String getWord() {
		return this.words;
	}
	public String getSig() {
		return this.signature;
	}
	public int compareTo(WordSig ws) {
		if(this.signature.compareTo(ws.signature)==0) return 0;
		else if(this.signature.compareTo(ws.signature)<0) return -1;
		else return 1;
	}
	@Override
	public boolean equals(Object o) {
		if(o==null || !(o instanceof WordSig))
			return false;
		else if(o == this) return true;
		WordSig ws = (WordSig)o;
		return ws.words.equals(this.words);
	}
}
