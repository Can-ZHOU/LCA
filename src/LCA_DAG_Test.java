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
}
