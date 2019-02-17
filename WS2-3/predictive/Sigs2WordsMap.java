/**
 * This is a command line program that takes a list of strings(signatures) and
 * converts them into corresponding sets of words with the MapDictionary algorithm
 * 
 * Time consumption test:
* number of strings      time (ns)        data used (signatures)
 *         1              529605           222
 *         5              854759          222 223 224 225 226
 *         10             1445535          222 223 224 225 226 227 228 229 232 233 
 *         20             2450964          222 223 224 225 226 227 228 229 232 233 234 235 236 237 238 239 242 243 244 245
 *         30             2883270          222 223 224 225 226 227 228 229 232 233 234 235 236 237 238 239 242 243 244 245 246 247 248 249 252 253 254 255 256 257
 */
package predictive;

import java.util.Set;

public class Sigs2WordsMap {
	public static void main(String[] args) {
		long st;
		Dictionary md = new MapDictionary("words");
		st=System.nanoTime();
		for(String s:args) {
			Set<String> words = md.signatureToWords(s);
			System.out.print(s+" : ");
			for(String word:words) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
		System.out.println(System.nanoTime()-st);
	}
}
