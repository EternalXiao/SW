/**
 * This class is the implementation of a tree node for the TreeDictionary
 * Each node has three field variables: words, children and parent.
 */
package predictive;
import java.util.*;
public class TreeNode {
	private Set<String> words;
	private TreeNode[] children;
	private TreeNode parent;
	/**
	 * Constructor for TreeNode
	 * @param parent the parent node of this node
	 */
	public TreeNode(TreeNode parent) {
		this.words = new HashSet<>();
		this.children = new TreeNode[8];
		this.parent=parent;
	}
	/**
	 * Getter method for words
	 * @return a set of words (or prefixes of words) with the signature from the root to this node 
	 */
	public Set<String> getWords() {
		return words;
	}
	/**
	 * Getter method for children
	 * @return an array containing eight child nodes
	 */
	public TreeNode[] getChildren() {
		return children;
	}
	/**
	 * Getter method for parent
	 * @return the parent node
	 */
	public TreeNode getParent() {
		return parent;
	}
}
