/**
 * This is a command line program that takes a list of strings(signatures) and
 * converts them into corresponding sets of words with the prototype algorithm
 * 4663 328 5465 8567 26746 56582 
 * Time consumption test:
 * number of strings      time (ms)
 *         1               507
 *         2               856
 *         3               1180
 *         4               1558
 *         5               1875
 *         6               2206
 */
package predictive;
import java.util.*;
public class Sigs2WordsProto {
	public static void main(String[] args) {
		long st;
		st = System.currentTimeMillis();
		for(String s:args) {
			Set<String> words = PredictivePrototype.signatureToWords(s);
			System.out.print(s+" : ");
			for(String word:words) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
		System.out.println(System.currentTimeMillis()-st);
	}
}
