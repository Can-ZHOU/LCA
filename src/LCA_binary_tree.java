/**
 *  As the permission mentioned in class, I found the solution in Internet.
 * 
 * !!! Important !!!
 * After fixed some bugs in original solution, there still has few bug in the code which is hard to deal with.
 * As you suggest, I leave it and more focus on test code.
 * So, it should have tests cannot be passed in unit test.
 * I have labeled them in the test code.
 * 
 * Reference: https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */

import java.util.ArrayList;
import java.util.List;
class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class LCA_binary_tree
{ 
	Node root;
	private List<Integer> path1 = new ArrayList<>();
	private List<Integer> path2 = new ArrayList<>();

	public int findLCA(int v, int w) {
		path1.clear();
		path2.clear();
		return findLCA(root, v, w);
	}

	private int findLCA(Node root, int v, int w) {
		if (!findPath(root, v, path1) || !findPath(root, w, path2)) {
			return -1;
		}
		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i)))
				break;
		}
		return path1.get(i-1);
	}

	private boolean findPath(Node root, int n, List<Integer> path)
	{
		if(n<0){
			return false;
		}
		if (root == null) {
			return false;
		}
		path.add(root.data);
		if (root.data == n) {
			return true;
		}
		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}
		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}
		path.remove(path.size()-1);
		return false;
	}


} 
