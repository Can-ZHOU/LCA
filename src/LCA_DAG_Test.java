import static org.junit.Assert.*;

import org.junit.Test;

public class LCA_DAG_Test {

//~ LCA_DAG class----------------------------------------------------------------------------------
	
	//~ Querying a node that does not exist in the graph-------------------------------------------
	/**
	 * Testing the empty DAG. It is expected to return -1.
	 */
	@Test
	public void testEmpty() {
		LCA_DAG graph = new LCA_DAG(0);
		assertEquals("Empty DAG", -1, graph.findLCA(0, 0));
	}
	
	/**
	 * Testing the DAG which is two nodes do not exist in the graph. It is expected to return -1.
	 * 
	 * ****** Visualization ******
	 *              1
	 *            / | \
	 *           2  3  4
	 * ***************************
	 */
	@Test
	public void testNoAnswer() {
		LCA_DAG graph = new LCA_DAG(8);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		
		assertEquals("There is no answer", -1, graph.findLCA(10, 11));
	}
	
	/**
	 * Testing the DAG which is only one element exist in graph. It is expected to return -1.
	 * 
	 * ****** Visualization ******
	 *             1
	 * ***************************
	 */
	@Test
	public void testOneElement()  {
		LCA_DAG graph = new LCA_DAG(1);
		
		assertEquals("One element DAG", -1, graph.findLCA(1, 2));
	}
	
	
	//~ Querying two nodes that exist in DAG-------------------------------------------------------
	/**
	 * Testing the common DAG -- case one
	 * 
	 * ****** Visualization ******
	 *             1
	 *           /   \
	 *          2     3
	 *          |     |
	 *          4-----5
	 *           \   /
	 *             0
	 * ***************************
	 */
	@Test
	public void testCommon_case_one() {
		LCA_DAG graph = new LCA_DAG(6);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 0);
		graph.addEdge(4, 5);
		graph.addEdge(5, 0);
		
		assertEquals("When their parents (upper levels) are their ancestors -- case one", 1, graph.findLCA(2, 3));
		assertEquals("When their parents (upper levels) are their ancestors -- case two", 1, graph.findLCA(3, 4));
		assertEquals("When the relationships between two nodes are both sibling and parent-children.", 4, graph.findLCA(4, 5));
		assertEquals("When one of node is their LCA.", 4, graph.findLCA(4, 0));
		assertEquals("When their common ancestor is themselves", 2, graph.findLCA(2, 2));
	}
	
	
	/**
	 * Testing the common DAG -- case two
	 * 
	 * ****** Visualization ******
	 *             1  
	 *         /    \   \
	 *        2      3   0
	 *       / \    / \  /
	 *      4---5  6   7
	 * ***************************
	 */
	@Test
	public void testCommon_case_two() {
		LCA_DAG graph = new LCA_DAG(8);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 0);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 6);
		graph.addEdge(3, 7);
		graph.addEdge(4, 5);
		graph.addEdge(0, 7);
		
		assertEquals("When their parents (upper levels) are their ancestors -- case one", 1, graph.findLCA(2, 3));
		assertEquals("When their parents (upper levels) are their ancestors -- case two", 1, graph.findLCA(7, 2));
		assertEquals("When the relationships between two nodes are both sibling and parent-children.", 4, graph.findLCA(4, 5));
		assertEquals("When one of node is their LCA.", 3, graph.findLCA(6, 3));
		assertEquals("When their common ancestor is themselves", 2, graph.findLCA(2, 2));
	}
}
