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
			e.printStackTrace();
		}
	}
	public TreeNode getRoot() {
		return this.root;
	}

	@Override
	public Set<String> signatureToWords(String signature) {
		if(signature.length()==0)
			throw new IllegalArgumentException();
		Set<String> res = new HashSet<>();
		TreeNode cur = this.getRoot();
		for(char c:signature.toCharArray()) {
			if(cur.getChildren()[Character.getNumericValue(c)-2]==null)
				return res;
			else
				cur = cur.getChildren()[Character.getNumericValue(c)-2];
		}
		this.getPredictiveWords(cur,res);
		return res;
	}
	
	public void getPredictiveWords(TreeNode cur,Set<String> res) {
		if(cur==null)
			return;
		res.addAll(cur.getWords());
		for(int i=0;i<8;i++) {
			this.getPredictiveWords(cur.getChildren()[i], res);
		}
	}
	
	public static void main(String[] args) {
		TreeDictionary TD = new TreeDictionary("words");
		System.out.println(TD.signatureToWords("2"));
	}
}
