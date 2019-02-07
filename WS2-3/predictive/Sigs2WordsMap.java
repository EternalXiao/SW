package predictive;

public class Sigs2WordsMap {
	public static void main(String[] args) {
		long st;
		st=System.currentTimeMillis();
		Dictionary ld = new MapDictionary("words");
		for(String s:args) {
			System.out.println(s+" : " + ld.signatureToWords(s));
		}
		System.out.println(System.currentTimeMillis()-st);
		//940
	}
}
