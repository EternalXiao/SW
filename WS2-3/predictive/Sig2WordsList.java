/**
 * This is a command line program that takes a list of strings(signatures) and
 * converts them into corresponding sets of words with the ListDictionary algorithm
 * 
 * Time consumption test:
 * number of strings      time (ms)
 *         1               1371
 *         2               1414
 *         3               1408
 *         4               1388
 *         5               1396
 *         6               1411
 */
package predictive;

import java.util.Set;

public class Sig2WordsList {
	public static void main(String[] args) {
		long st;
		st=System.currentTimeMillis();
		Dictionary ld = new ListDictionary("words");
		for(String s:args) {
			Set<String> words = ld.signatureToWords(s);
			System.out.print(s+" : ");
			for(String word:words) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
		System.out.println(System.currentTimeMillis()-st);
	}
}
