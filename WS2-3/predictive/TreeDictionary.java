package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TreeDictionary implements Dictionary{
	private TreeNode root;
	
	public TreeDictionary(String path) {
		root = new TreeNode(null);
		try {
			Scanner in = new Scanner(new File(path));
			String word;
			while (in.hasNextLine()) {
				word = in.nextLine().toLowerCase();
				if(!PredictivePrototype.isValidWord(word))
					continue;
				//System.out.println(word);
				String sig = PredictivePrototype.wordToSignature(word);
				TreeNode currentNode = this.getRoot();
				for(char c:sig.toCharArray()) {
					int idx = Character.getNumericValue(c)-2;
					if(currentNode.getChildren()[idx]==null) {
						currentNode.getChildren()[idx] = new TreeNode(currentNode);
					}
					currentNode = currentNode.getChildren()[idx];
				}
				currentNode.getWords().add(word);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public TreeNode getRoot() {
		return this.root;
	}

	@Override
	public Set<String> signatureToWords(String signature) {
		Set<String> res = new HashSet<>();
		this.getPredictiveWords();
		return null;
	}
	
	public void getPredictiveWords(TreeNode cur,Set<String> res,String sig) {
		
	}
	
}
