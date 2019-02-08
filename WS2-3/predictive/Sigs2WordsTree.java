package predictive;

public class Sigs2WordsTree {
	public static void main(String[] args) {
		long st;
		st=System.currentTimeMillis();
		Dictionary ld = new TreeDictionary("words");
		for(String s:args) {
			System.out.println(s+" : " + ld.signatureToWords(s));
		}
		System.out.println(System.currentTimeMillis()-st);
		//922
	}
}
