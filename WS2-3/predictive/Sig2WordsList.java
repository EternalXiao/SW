/**
 * This is a command line program that takes a list of strings(signatures) and
 * converts them into corresponding sets of words with the ListDictionary algorithm
 * 
 * Time consumption test:
 * number of strings      time (ns)        data used (signatures)
 *         1              580103           222
 *         5              1316213          222 223 224 225 226
 *         10             2566328          222 223 224 225 226 227 228 229 232 233 
 *         20             4283645          222 223 224 225 226 227 228 229 232 233 234 235 236 237 238 239 242 243 244 245
 *         30             4012274          222 223 224 225 226 227 228 229 232 233 234 235 236 237 238 239 242 243 244 245 246 247 248 249 252 253 254 255 256 257
 * Comparison to prototype:
 * number of strings      time (ns)         
 *         1              620953240          
 *         5              2594002897      
 *         10             4376045252       
 *         20             8582072818       
 *         30             12825337387
 * 
 * The time difference between prototype and ListDictionary becomes larger and larger as the inputs grows
 */
package predictive;

import java.util.Set;

public class Sig2WordsList {
	public static void main(String[] args) {
		long st;
		Dictionary ld = new ListDictionary("words");
		st=System.nanoTime();
		for(String s:args) {
			Set<String> words = ld.signatureToWords(s);
			System.out.print(s+" : ");
			for(String word:words) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
		System.out.println(System.nanoTime()-st);
	}
}
