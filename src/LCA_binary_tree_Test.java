import static org.junit.Assert.*;

import org.junit.Test;

public class LCA_binary_tree_Test {

	@Test
	public void testLCA_binary_tree() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7);
		
		int expectedResult = 1;
		assertEquals("LCA(7,4)", expectedResult, tree.findLCA(7, 4).data);
	}

}
