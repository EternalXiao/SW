package predictive;
import java.util.*;
public class TreeNode {
	private Set<String> words;
	private TreeNode[] children;
	private TreeNode parent;
	
	public TreeNode(TreeNode parent) {
		this.words = new HashSet<>();
		this.children = new TreeNode[8];
		this.parent=parent;
	}

	public Set<String> getWords() {
		return words;
	}

	public TreeNode[] getChildren() {
		return children;
	}

	public TreeNode getParent() {
		return parent;
	}
}
