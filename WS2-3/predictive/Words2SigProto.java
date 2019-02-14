/**
 * This is a command line program that takes a list of strings(words) and
 * converts them into corresponding signatures
 */
package predictive;

public class Words2SigProto {
	public static void main(String[] args) {
		for(String s:args) {
			if(PredictivePrototype.isValidWord(s))
				System.out.println(s+ " : "+PredictivePrototype.wordToSignature(s));
		}
	}
}
