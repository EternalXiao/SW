/**
 * This interface declares a method that each dictionary implementation 
 * should implement
 */
package predictive;
import java.util.*;
public interface Dictionary {
	public Set<String> signatureToWords(String signature);
}
