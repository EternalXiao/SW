/**
 * This is a command line program that takes a list of strings(signatures) and
 * converts them into corresponding sets of words with the MapDictionary algorithm
 * 
 * Time consumption test:
 * number of strings      time (ms)
 *         1               892
 *         2               911
 *         3               883
 *         4               900
 *         5               908
 *         6               894
 */
package predictive;

import java.util.Set;

public class Sigs2WordsMap {
	public static void main(String[] args) {
		long st;
		st=System.currentTimeMillis();
		Dictionary md = new MapDictionary("words");
		for(String s:args) {
			Set<String> words = md.signatureToWords(s);
			System.out.print(s+" : ");
			for(String word:words) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
		System.out.println(System.currentTimeMillis()-st);
	}
}
