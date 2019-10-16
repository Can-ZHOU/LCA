import static org.junit.Assert.*;

import org.junit.Test;

public class LCA_binary_tree_Test {
	
//~ LCA_binary_tree class--------------------------------------------------------------------------
	
	//~ Querying a node that does not exist in the binary tree-------------------------------------
	/**
	 * Testing the empty binary tree. It is expected to return -1.
	 */
	@Test
	public void testEmpty() {
		LCA_binary_tree tree = new LCA_binary_tree();
		assertEquals("Empty binary tree", -1, tree.findLCA(1, 2));
	}		

	/**
	 * Testing the binary tree which two nodes do not exist in the graph. It is expected to return -1.
	 * 
	 * ****** Visualization ******
	 *             1
	 *            / \
	 *          2     3
	 *         / \   / \
	 *        4   5 6   7
	 * ***************************
	 */
	@Test
	public void testNoAnswer() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1);
		assertEquals("There is no answer.", -1, tree.findLCA(10, 11));
	}
	
	/**
	 * Testing the binary tree which only has one node. It is expected to return -1.
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
		assertEquals("One element binary tree", -1, tree.findLCA(1, 2));
	}
	
	
	//~ Querying two nodes that exist in the binary tree-------------------------------------
	/**
	 * Testing the common binary tree -- case one.
	 * 
	 * ****** Visualization ******
	 *             1
	 *            / \
	 *          2     3
	 *         / \   / \
	 *        4   5 6   7
	 * ***************************
	 */
	@Test
	public void testCommon_case_one() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		assertEquals("When their parents (upper level) are their ancestors.", 2, tree.findLCA(4, 5));
		assertEquals("When one of the nodes is their common ancestor", 2, tree.findLCA(4, 2));
		assertEquals("When their common ancestors before the previous level_case one", 1, tree.findLCA(4, 6));
		assertEquals("When their common ancestors before the previous level_case two", 1, tree.findLCA(4, 3));
		assertEquals("When their common ancestor is themselves", 4, tree.findLCA(4, 4));

	}
	
	/**
	 * Testing the common binary tree -- case two.
	 * 
	 * ****** Visualization ******
	 *             1
	 *            / \
	 *           2   3
	 *          / \   
	 *         4   5
	 *        / \   \
	 *       6   7   8
	 * ***************************
	 */
	@Test
	public void testCommon_case_two() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.right = new Node(7);
		tree.root.left.right.right = new Node(8);
		
		assertEquals("When their parents (upper level) are their ancestors.", 2, tree.findLCA(4, 5));
		assertEquals("When one of the nodes is their common ancestor", 2, tree.findLCA(4, 2));
		assertEquals("When their common ancestors before the previous level_case one", 1, tree.findLCA(3, 6));
		assertEquals("When their common ancestors before the previous level_case two", 2, tree.findLCA(6, 8));
		assertEquals("When their common ancestor is themselves", 4, tree.findLCA(4, 4));

	}
	
	/**
	 * Testing the linear binary tree.
	 * 
	 * ****** Visualization ******
	 *             1
	 *              \
	 *               2
	 *                \
	 *                 3
	 *                  \ 
	 *                   4
	 * ***************************
	 */
	@Test
	public void testLinear() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1);
		tree.root.right = new Node(2);
		tree.root.right.right = new Node(3);
		tree.root.right.right.right = new Node(4);
		
		assertEquals("When one of the nodes is their common ancestor_case one", 2, tree.findLCA(4, 2));
		assertEquals("When one of the nodes is their common ancestor_case two", 3, tree.findLCA(4, 3));
		assertEquals("When their common ancestor is themselves", 4, tree.findLCA(4, 4));

	}
	
	
	//~ Querying the wrong binary tree-------------------------------------------------------------
	/**
	 * Testing the the wrong binary tree -- a tree with duplicated nodes.
	 * 
	 * !!!!!!BUG CANNOT FIX!!!!!!!
	 * There has duplicated node
	 * -- 2 in tree.
	 * so, for instance, LCA(6,2) 
	 * should has two answers 1 or 3.
	 * Therefore, it should not
	 * pass all the test.
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * ****** Visualization ******
	 *             1
	 *            / \
	 *          2     3
	 *         / \   / \
	 *        4   5 6   2
	 * ***************************
	 */
	@Test
	public void testWrong_tree_duplicated_nodes() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(2);
		
		assertEquals("When their parents (upper level) are their ancestors.", 2, tree.findLCA(4, 5));
		assertEquals("When one of the nodes is their common ancestor", 3, tree.findLCA(3, 6));
		assertEquals("When their common ancestors before the previous level_case one", 1, tree.findLCA(4, 6));
		assertEquals("When their common ancestors before the previous level_case two", 1, tree.findLCA(4, 3));
		assertEquals("When their common ancestor is themselves", 4, tree.findLCA(4, 4));
		
		//This test cannot be passed, which should has two answers 1 or 3.
		assertEquals("When their common ancestor is themselves", -1, tree.findLCA(6, 2));
	}
	
	/**
	 * Testing the wrong binary tree -- a tree with node has two parents.
	 * 
	 * !!!!!!BUG CANNOT FIX!!!!!!!
	 * The node 5 has two parents
	 * So, the LCA(4,5) has two
	 * answers -- 2 or 1.
	 * The code should not pass
	 * all tests.
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * ****** Visualization ******
	 *              1
	 *             / \
	 *            2   3
	 *           / \ / \
	 *          4   5   6
	 *         / \
	 *        7   8
	 * ***************************
	 */
	@Test
	public void testWrong_tree_two_parents() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = tree.root.left.right;
		tree.root.right.right = new Node(6);
		tree.root.left.left.left = new Node(7);
		tree.root.left.left.right = new Node(8);
		
		assertEquals("When their parents (upper level) are their ancestors.", 4, tree.findLCA(7, 8));
		assertEquals("When one of the nodes is their common ancestor", 4, tree.findLCA(4, 7));
		assertEquals("When their common ancestors before the previous level_case one", 2, tree.findLCA(7, 5));
		assertEquals("When their common ancestors before the previous level_case two", 1, tree.findLCA(7, 3));
		assertEquals("When their common ancestor is themselves", 4, tree.findLCA(4, 4));
		
		//This test cannot be passed, which should has two answers 1 or 2.
		assertEquals("When one node has two parents_answer two", -1, tree.findLCA(4, 5));
	}
	
	/**
	 * Testing the wrong binary tree -- a tree which has a loop.
	 * 
	 * !!!!!!BUG CANNOT FIX!!!!!!!
	 * This test should have not
	 * result.
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * ****** Visualization ******
	 *             1
	 *            / \
	 *           2 - 3 
	 * ***************************
	 */
	@Test
	public void testWrong_tree_has_loop() {
		LCA_binary_tree tree = new LCA_binary_tree(); 
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = tree.root.right;
		tree.root.right.left = tree.root.left;
		
		//This test cannot be passed.
		assertEquals("The test result should fail.", -1, tree.findLCA(2, 3));
	}
	

	
	
	
//~ Node class-------------------------------------------------------------------------------------
	
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
}
