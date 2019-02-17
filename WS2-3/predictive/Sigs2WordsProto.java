/**
 * This is a command line program that takes a list of strings(signatures) and
 * converts them into corresponding sets of words with the prototype algorithm
 *  
 * Time consumption test:
 * number of strings      time (ns)         data used (signatures)
 *         1              620953240          222
 *         5              2594002897         222 223 224 225 226
 *         10             4376045252         222 223 224 225 226 227 228 229 232 233 
 *         20             8582072818         222 223 224 225 226 227 228 229 232 233 234 235 236 237 238 239 242 243 244 245
 *         30             12825337387        222 223 224 225 226 227 228 229 232 233 234 235 236 237 238 239 242 243 244 245 246 247 248 249 252 253 254 255 256 257
 */
package predictive;
import java.util.*;
public class Sigs2WordsProto {
	public static void main(String[] args) {
		long st;
		st = System.nanoTime();
		for(String s:args) {
			Set<String> words = PredictivePrototype.signatureToWords(s);
			System.out.print(s+" : ");
			for(String word:words) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
		System.out.println(System.nanoTime()-st);
	}
}
