package predictive;
import java.math.BigInteger;
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
		BigInteger sig1 = new BigInteger(this.getSig());
		BigInteger sig2 = new BigInteger(ws.getSig());
		if(sig1.compareTo(sig2)>0) return 1;
		else if(sig1.compareTo(sig2)==0) return 0;
		else return -1;
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
