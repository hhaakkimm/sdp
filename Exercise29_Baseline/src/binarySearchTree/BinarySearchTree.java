package binarySearchTree;

/**
 * <p>
 * Title: BinarySearchTree Class - A component of the binarySearchTree package
 * </p>
 *
 * <p>
 * Description: A controller object class that implements a binary search tree
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2012
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1.01
 */
public class BinarySearchTree <T extends Comparable<T>>{
	/**
	 * The binary search tree is implemented in a generic way.  It does not really
	 * know anything about the objects in the tree, but it does know that each
	 * of these tree entries can be compared, so it is possible to know if
	 * one tree node is the same as another, or it is less than or greater
	 * than another.  This is what the <T extends Comparable<T>> is about!
	 */

	/**
	 * This inner class implements a binary search tree node which is used to
	 * structure the data in the tree.  The nodes consists of three parts, a link to
	 * the left and right children and a reference to an object that holds
	 * the data for the node.  All we know about that data object is that it is
	 * comparable (see above).
	 */
	private static class Node<T> {  // A nested list node Class
		protected Node<T> left;		// The left child
		protected Node<T> right;	// The right child
		protected T data;			// The node's data value

		// The constructor for this nested ListNode Class
		public Node(T value, Node<T>leftLink, Node<T>rightLink){
			data = value;
			left = leftLink;
			right = rightLink;
		}

		// If one asks to see a node, all we will show is the String associated with
		// the data portion of the node.
		public String toString(){return data.toString();}
	}

	private Node<T> root;      		// The root of the BST
	private int treeSize;           // The number of nodes in the BST


	/**********
	 * Add a new node with the specified value into the tree.
	 * We will always add a node, even if it ends up replacing
	 * a duplicate node.  (The tree will never have two nodes
	 * that are the same.)
	 *
	 * @param d  The value for the new node to be added
	 * @return   A reference to the newly constructed node
	 */
	public Node<T> add(T d){
		if (this.root==null) {
			this.root = new Node(d, null, null);
			this.treeSize = 1;
			return this.root;
		}
		Node<T> t = add(this.root, new Node(d, null, null));
		if (t!=null) {
			this.treeSize++;
		}
		return t;
	}

	/**********
	 * This is a private method that is used to facilitate adding nodes to the tree.
	 * The first parameter, p, is the root of the subtree to which we are adding a node.
	 * If that subtree is empty, just return the new node as the subtree.  (We assume
	 * the new node's two children are null.)  If the root is not null, we compare the
	 * node to be added against this root and determine whether it should be added to
	 * the left or the right, recursively.  When the recursive call returns, we replace
	 * the link we passed in with what was returned.  This is how we add to the tree.
	 *
	 * Be advised that this naive implementation of a BST does not ensure the tree is
	 * balanced!
	 *
	 * @param d  The value for the new node to be added
	 * @return   A reference to the newly constructed node
	 */
	private Node<T> add(Node<T> p, Node<T> d){
		if (d.data.compareTo(p.data)==1) {
			if (p.right==null) {
				p.right = d;
				return d;
			}
			return add(p.right, d);
		}
		if (d.data.compareTo(p.data)==-1) {
			if (p.left==null) {
				p.left = d;
				return d;
			}
			return add(p.left, d);
		}
		return null;
	}

	/**********
	 * Return a String that shows all of the elements in the list in order
	 *
	 * @return	the String with the values in it
	 */
	public String toStringDefinitions(){
		return "Size: " + treeSize + inorderToString(root);
	}

	private String inorderToString(Node<T> r){
		if (r == null) return "";
		return inorderToString(r.left) + "\n   " + r.data + inorderToString(r.right);
	}

	public String toString() {
		return "Size: " + getSize(root) + "; Height: " + getHeight(root) + ";\n" + preOrderTraverse(root, 0, "Root:  ");
	}

	private String preOrderTraverse(Node<T> node, int depth, String side) {
		String result = "";
		for (int d = 1; d < depth; d++) result += "   ";
		result += side;
		if (node == null)
			result += "null\n";
		else {
			result += node.toString() + "\n";
			result += preOrderTraverse(node.left,  depth+1, "Left:  ");
			result += preOrderTraverse(node.right, depth+1, "Right: ");
		}
		return result;
	}

	/**********
	 * Get the data of generic type T from the dictionary tree for a node that
	 * compares the same.  Since we really do not know how these nodes are
	 * implemented, we must assume that there is something about them that
	 * distinguishes one from another.  (e.g. a variable dictionary entry
	 * has both a identifier and a value.  The identifier is used to
	 * distinguish one entry from another.)
	 *
	 * If we want to find an instance of something in the dictionary we must
	 * have a data object of type T so we can search for it... so this value
	 * of type T that is used for the search probably only has one of the
	 * attributes of type T filled in, the one that distinguishes one element
	 * from another.  What is returned is the matching dictionary entry which
	 * has *all* of the attributes filled in.
	 *
	 * @param v		The search value of type T (with just the distinguishing
	 * 					attribute specified)
	 * @return		The matching object of type T with all of the attributes
	 * 					specified
	 */
	public T get(T v){
		return null;
	}

	/**********
	 * This is a private recursive get routine to find the node if it is not
	 * at the root of the tree.
	 *
	 * @param r		The root of the subtree
	 * @param v		The search value of type T (with just the distinguishing
	 * 					attribute specified)
	 * @return		The matching object of type T with all of the attributes
	 * 					specified
	 */
	private T get(Node<T> r, T v){
		return null;
	}

	/**********
	 * Set the value of type T in the dictionary.  If there is a matching
	 * value already in the dictionary, this one will replace it.  If not, then
	 * this value will be added to the dictionary.
	 *
	 * @param v		The new value to replace the previous one or to be added if
	 * 					it is not already in the dictionary
	 */
	public void set(T v){
		Node<T> node = nodeGet(root, v);// Starting at this root, get a node with
		if (node != null)					// the matching identifier
			node.data = v;					// If you find one, up date the value field
		else								// If you don't get one, then add this node
			add(v);							// to the tree as the new definition
	}

	private Node<T> nodeGet(Node<T> r, T v){
		if (r==null)						// If the recursive root is empty, return null
			return null;					// signaling the desired value is not in the tree
		int delta = r.data.compareTo(v);	// If there is a node, compare the identifiers
		if (delta == 0) {					// If they are the same, return that node as
			return r;						// the result
		}
		if (delta < 0)						// If there is not a match, do the binary search
			return nodeGet(r.right, v);		// to the right or the left based on the delta
		else
			return nodeGet(r.left, v);
	}

	public int getSize(Node<T> r) {
		if (r == null)
			return 0;
		else
			return 1 + getSize(r.left) + getSize(r.right);
	}

	public int getHeight(Node<T> r) {
		if (r == null)
			return 0;
		else {
			int leftHeight = getHeight(r.left);
			int rightHeight = getHeight(r.right);
			if (leftHeight > rightHeight)
				return 1 + leftHeight;
			else
				return 1 + rightHeight;

		}
	}

}
