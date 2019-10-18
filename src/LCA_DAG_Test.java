import static org.junit.Assert.*;

import org.junit.Test;

public class LCA_DAG_Test {

//~ FindLCA method---------------------------------------------------------------------------------
	
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
	 * Testing the common DAG -- case one.
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
	 * Testing the common DAG -- case two.
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
	
	/**
	 * Testing the complex DAG.
	 * 
	 * ****** Visualization ******
	 *             0
	 *           /   \
	 *          1     2
	 *         /     /
	 *        3     4 
	 *       /     / \
	 *      5     6   7
	 *            |    
	 *            8
	 *          / | \
	 *         9 10  11
	 *                \
	 *                 12
	 *                  \
	 *                   13  
	 * ***************************
	 */
	@Test
	public void testCcomplex() {
		LCA_DAG graph = new LCA_DAG(14);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		graph.addEdge(6, 8);
		graph.addEdge(8, 9);
		graph.addEdge(8, 10);
		graph.addEdge(8, 11);
		graph.addEdge(11, 12);
		graph.addEdge(12, 13);
		
		assertEquals("When their parents (upper levels) are their ancestors -- case one", 0, graph.findLCA(2, 1));
		assertEquals("When their parents (upper levels) are their ancestors -- case two", 0, graph.findLCA(3, 2));
		assertEquals("When one of node is their LCA.", 4, graph.findLCA(4, 6));
		assertEquals("When their common ancestor is themselves", 2, graph.findLCA(2, 2));
	}
	
	/**
	 * Testing the linear DAG.
	 * 
	 * ****** Visualization ******
	 *             0
	 *             |
	 *             1
	 *             |
	 *             2
	 *             |
	 *             3
	 *             |
	 *             4
	 *             |
	 *             5
	 * ***************************
	 */
	@Test
	public void testLiner() {
		LCA_DAG graph = new LCA_DAG(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		
		assertEquals("When one of the nodes is their common ancestor_case one", 2, graph.findLCA(4, 2));
		assertEquals("When one of the nodes is their common ancestor_case two", 3, graph.findLCA(4, 3));
		assertEquals("When their common ancestor is themselves", 4, graph.findLCA(4, 4));
	}
	
	
	//~ Querying the wrong binary tree-------------------------------------------------------------
		/**
		 * Testing the the wrong DAG -- a DAG with duplicated nodes.
		 * 
		 * !!!!!!BUG CANNOT FIX!!!!!!!
		 * There has duplicated node
		 * -- 2 in DAG.
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
	public void testWrong_DAG_duplicated_nodes() {
		LCA_DAG graph = new LCA_DAG(7);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 2);
		graph.addEdge(3, 6);
		graph.addEdge(2, 5);
		
		assertEquals("When their parents (upper level) are their ancestors.", 2, graph.findLCA(4, 5));
		assertEquals("When one of the nodes is their common ancestor", 3, graph.findLCA(3, 6));
		assertEquals("When their common ancestors before the previous level_case one", 1, graph.findLCA(4, 6));
		assertEquals("When their common ancestors before the previous level_case two", 1, graph.findLCA(4, 3));
		assertEquals("When their common ancestor is themselves", 4, graph.findLCA(4, 4));
		
		//This test cannot be passed, which should has two answers 1 or 3.
		assertEquals("When their common ancestor is themselves", -1, graph.findLCA(6, 2));
	}
	
	/**
	 * Testing the wrong DAG which has a cycle. It is expected to return -1.
	 * 
	 * ****** Visualization ******
	 *             0
	 *            / \
	 *           2 - 1
	 * ***************************
	 */
	@Test
	public void testWrong_DAG_has_loop() {
		LCA_DAG graph = new LCA_DAG(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		
		assertEquals("When there is a cycle in DAG", -1, graph.findLCA(3, 2));
	}
	
	
	
	
	
//~ other methods----------------------------------------------------------------------------------
	/**
	 * Expected = Exception.class
	 * Can't make a directed graph with less than 0 vertices
	 */
	@Test
	public void exceptionTest(){
		// There will have an error.
		LCA_DAG graph = new LCA_DAG(-10);
	}
	
	/**
	 * As negative, will print a system error and not addEdge.
	 * The index of node cannot out of bound.
	 */
	@Test
	public void addEdge()
	{
		LCA_DAG graph = new LCA_DAG(10);
		
		graph.addEdge(1,2);
		
		// When nodes' indexes are negative.
		graph.addEdge(-1, -6);
		
		//This won't addEdge as 115 > 2
		graph.addEdge(2, 115);
	}
	
	/**
	 * Test the number of directed edges to vertex v.
	 */
	@Test
	public void testIndegree()
	{
		LCA_DAG graph = new LCA_DAG(6);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		
		assertEquals(0, graph.indegree(3));
	}
	
	/**
	 * Test the number of directed edges from vertex v.
	 */
	@Test
	public void testOutdegree()
	{
		LCA_DAG graph = new LCA_DAG(7);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		
		assertEquals(1, graph.outdegree(3));
	}
	
	/**
	 * Test the number V.
	 */
	@Test 
	public void testV()
	{
		LCA_DAG graph = new LCA_DAG(10);
		
		assertEquals(10, graph.V());
	}
	
	/**
	 * Test the number E.
	 */
	@Test
	public void testE(){
		
		LCA_DAG graph = new LCA_DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		
		assertEquals(2, graph.E());
	}
	
	/**
	 * Test the adjacent vertices to v.
	 */
	@Test
	public void testAdj()
	{
		LCA_DAG graph = new LCA_DAG(10);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(4, 3);
		
		String adj = "[4]";
		assertEquals(adj, graph.adj(2).toString());
	}
	
	/**
	 * Test whether there has cycle in DAG.
	 */
	@Test
	public void testforCycle()
	{
		LCA_DAG graph = new LCA_DAG(3);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		
		graph.findCycle(0);
		
		assertTrue(graph.hasCycle());
	}
}
