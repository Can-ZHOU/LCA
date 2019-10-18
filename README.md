## CS3012 Software Engineering Assignment 1&2:
Written by  
Can ZHOU (19324118)  
If there has any confusion, Please email me: zhouc@tcd.ie  

### I have visualized the test cases. More details please go to this GitHub repository: https://github.com/Can-ZHOU/Graph_Visualization


## Assignment one: LCA with binary tree [In **Master** branch]
- **LCA binary tree Solution and its test code are in the src folder**
- LCA_binary_tree.java is the source code for solving the LCA problem in a Directed Acyclic Graph.

- LCA_binary_tree_Test.java is the JUnit test code for the methods LCA_binary_tree.java

### Visualization of the test cases in LCA_binary_tree_Test.java
- This is to make the tests I did for LCA_binary_tree look clearer.
- LCA_binary_tree with a node that does not exist in the graph.
  - DAG-0: Empty binary tree
  - ![Alt text](https://github.com/Can-ZHOU/Graph_Visualization/blob/master/BT-1%262.png)
- LCA_binary_tree with two nodes exist in the tree.  
  - ![Alt text](https://github.com/Can-ZHOU/Graph_Visualization/blob/master/BT-3%264%265.png)
- LCA_binary_tree with wrong binary trees
  - ![Alt text](https://github.com/Can-ZHOU/Graph_Visualization/blob/master/BT-6%267%268.png)  

## Assignment two: LCA with DAG [In **DAG** branch]

- **DAG Solution and its test code are in the src folder**
- LCA_DAG.java is the source code for solving the LCA problem in a Directed Acyclic Graph.

- LCA_DAG_Test.java is the JUnit test code for the methods in LCA_DAG.java
  
### Visualization of the test cases in LCA_DAG_Test.java
- This is to make the tests I did for DAG look clearer.
- LCA_DAG with a node that does not exist in the graph.
  - DAG-0: Empty DAG
  - ![Alt text](https://github.com/Can-ZHOU/Graph_Visualization/blob/master/DAG-1%262.png)
- LCA_DAG with two nodes exist in the graph.  
  - ![Alt text](https://github.com/Can-ZHOU/Graph_Visualization/blob/master/DAG-3%264%265%266.png)
- LCA_DAG with wrong DAG
  - ![Alt text](https://github.com/Can-ZHOU/Graph_Visualization/blob/master/DAG-7%268.png)
  

## How to run the code:
- After download, it should can be directly opened and run in Eclipse.
- However if you cannot open it, Please follow these instructions:
  - Create a new Java Project.
  - Import the above LCA_DAG.java into the project.
  - Create a new jUnit test named LCA_DAG_Test.java.
  - Replace the contents of LCA_DAG_Test.java created in Eclipse with the contents of the LCA_DAG_Test.java in src folder.
  - Do the same things to LCA_binary_tree.
- If still cannot run them, please email to me: zhouc@tcd.ie