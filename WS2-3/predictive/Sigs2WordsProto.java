package predictive;

public class Sigs2WordsProto {
	public static void main(String[] args) {
		for(String s:args) {
			System.out.println(s+" : " + PredictivePrototype.signatureToWords(s));
		}
	}
}
