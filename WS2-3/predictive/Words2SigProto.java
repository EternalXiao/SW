package predictive;

public class Words2SigProto {
	public static void main(String[] args) {
		for(String s:args) {
			if(PredictivePrototype.isValidWord(s))
				System.out.println(PredictivePrototype.wordToSignature(s));
		}
	}
}
