/**
 * This is a command line program that takes a list of strings(signatures) and
 * converts them into corresponding sets of words (or prefix of words) with the 
 * TreeDictionary algorithm
 * 
 * Time consumption test:
 * number of strings      time (ns)        data used (signatures)
 *         1              420400           222
 *         5              539458           222 223 224 225 226
 *         10             938510           222 223 224 225 226 227 228 229 232 233 
 *         20             1003376          222 223 224 225 226 227 228 229 232 233 234 235 236 237 238 239 242 243 244 245
 *         30             1649167          222 223 224 225 226 227 228 229 232 233 234 235 236 237 238 239 242 243 244 245 246 247 248 249 252 253 254 255 256 257
 *         
 * number of strings      time (ns)    
 *         1              529605         
 *         5              854759    
 *         10             1445535       
 *         20             2450964        
 *         30             2883270 
 *         
 * We can notice that the time difference grow dramatically as the input becomes larger
 */
package predictive;

public class Sigs2WordsTree {
	public static void main(String[] args) {
		long st;
		Dictionary ld = new TreeDictionary("words");
		st=System.nanoTime();
		for(String s:args) {
			System.out.println(s+" : " + ld.signatureToWords(s));
		}
		System.out.println(System.nanoTime()-st);
	}
}
