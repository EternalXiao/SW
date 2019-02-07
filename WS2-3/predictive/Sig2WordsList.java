package predictive;

public class Sig2WordsList {
	public static void main(String[] args) {
		long st;
		st=System.currentTimeMillis();
		Dictionary ld = new ListDictionary("words");
		for(String s:args) {
			System.out.println(s+" : " + ld.signatureToWords(s));
		}
		System.out.println(System.currentTimeMillis()-st);
		//783699
	}
}