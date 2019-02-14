package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TreeDictionary implements Dictionary{
	private TreeNode root;
	/**
	 * Constructor of TreeDictionary
	 * When instantiate a TreeDictionary object, the dictionary will
	 * be read from the provided path to the tree. For each node, it
	 * stores a set of words whose signature is from the root to the
	 * current node
	 * @param path the path of the dictionary
	 */
	public TreeDictionary(String path) {
		root = new TreeNode(null);
		try {
			Scanner in = new Scanner(new File(path));
			String word;
			while (in.hasNextLine()) {
				word = in.nextLine().toLowerCase();
				int len = word.length();
				if(!PredictivePrototype.isValidWord(word))
					continue;
				String sig = wordToSignature(word);
				TreeNode currentNode = this.getRoot();
				for(int i=0;i<len;i++) {
					int idx = Character.getNumericValue(sig.charAt(i))-2;
					if(currentNode.getChildren()[idx]==null) {
						currentNode.getChildren()[idx] = new TreeNode(currentNode);
					}
					currentNode = currentNode.getChildren()[idx];
					currentNode.getWords().add(word.substring(0, i+1));
				}
				currentNode.getWords().add(word);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getter method to get the root of the tree
	 * @return the root of the tree
	 */
	public TreeNode getRoot() {
		return this.root;
	}
	
	/**
	 * This method converts a given word to signature by calling the method
	 * in prototype
	 * @param word the given word
	 * @return the signature of the word
	 */
	public String wordToSignature(String word) {
		return PredictivePrototype.wordToSignature(word);
	}
	
	/**
	 * This method takes a signature and return a set of words
	 * which have the signature and the prefixes of words have
	 * the signature
	 * @param signature the given signature
	 * @return a set of words (and prefixes of words) with the signature and 
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		if(signature.length()==0)
			throw new IllegalArgumentException();
		TreeNode cur = this.getRoot();
		for(char c:signature.toCharArray()) {
			if(cur.getChildren()[Character.getNumericValue(c)-2]==null)
				return new HashSet<>();
			else
				cur = cur.getChildren()[Character.getNumericValue(c)-2];
		}
		return cur.getWords();
	}
	
	public static void main(String[] args) {
		TreeDictionary TD = new TreeDictionary("words");
		for(String word:TD.signatureToWords("4663")) {
			System.out.println(word);
		}
	}
}
