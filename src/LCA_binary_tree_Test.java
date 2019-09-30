import static org.junit.Assert.*;

import org.junit.Test;

public class LCA_binary_tree_Test {
	
	/**
	 * Testing the node class.
	 */
	@Test
	public void testNode() {
		Node node = new Node(1);
		assertEquals("Node(1)-data", 1, node.data);
		assertNull("Node(1)-left_node", node.left);
		assertNull("Node(1)-right_node", node.right);
	}

	/**
	 * Testing the empty binary tree.
	 * 
	 * !!!! There has a bug, as the data without valuation is 0.
	 * 
	 */
	@Test
	public void testEmpty() {
		LCA_binary_tree tree = new LCA_binary_tree();
		assertNull("Empty binary tree", tree.findLCA(1, 2).data);
	}		

	/**
	 * Testing the binary tree which only has one node.
	 * 
	 * ****** Visualization ******
	 *             1
	 *            / \
	 *        null   null  
	 * ***************************
	 */
	@Test
	public void testOneElement() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1);
		assertNull("Empty binary tree", tree.findLCA(1, 2).data);
	}

}
